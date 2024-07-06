package com.rabbitmq.pratice.rabbitmq.service;

import com.rabbitmq.pratice.rabbitmq.domain.ChatMessage;
import com.rabbitmq.pratice.rabbitmq.repository.ChatMsRepository;
import com.rabbitmq.pratice.rabbitmq.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * packageName    : com.rabbitmq.pratice.rabbitmq.config.service
 * fileName       : RabbitMqService
 * author         : GAMJA
 * date           : 2024/04/06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/04/06        GAMJA       최초 생성
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMqService {

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.queue.name}")
    private String queueName;

    private final RabbitTemplate rabbitTemplate;

    private final ChatMsRepository chatMsRepository;


    /**
     * Queue로 메세지를 발행
     * @param messageDto
     */
    public void sendMessage(ChatMessage messageDto){
        log.info("### send message  : {}",messageDto.toString());
        //stomp 전달하기 위함
        rabbitTemplate.convertAndSend(exchangeName,"chat.room."+messageDto.getRoomId(),messageDto);
        if(messageDto.getGubun().equals("message")) {
            //Listner에 담기 위함
            rabbitTemplate.convertAndSend(queueName, messageDto);
        }
    }

    /**
     * Queue 에서 메세지를 구독
     * sendMessage한 메세지들이 들어있는 Queue에 대한 정보를 보여줌
     * @param messageDto
     */
//    @RabbitListener(bindings = {
//            @QueueBinding(
//                    value =@Queue(value = "${rabbitmq.queue.name}" , durable = "true"),
//                    exchange = @Exchange(value = "${rabbitmq.exchange.name}", type = ExchangeTypes.TOPIC)
//
//            )
//    })
    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void receiveMessage(ChatMessage messageDto) throws Exception {
        log.info("### send message receive : {}",messageDto);
        if(messageDto.getGubun().equals("message")){
            chatMsRepository.insert(messageDto);
        }
    }
}
