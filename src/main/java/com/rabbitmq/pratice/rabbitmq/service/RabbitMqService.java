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
        // 기존에 잘 모르고 exchange에 해당하는 값을 수신하는 것이 아닌 queueName을 새로 지정한것으로 처리함
        // 이유는 내가 잘 몰랐어서...
        // 모르고 exchange에 대한 수신하는 queue에 대하여 규칙을 application.yml 에 선언된   queue.name의 값을 선언해 두어
        // 위의 convertAndSend된 값을 제대로 받지 못하는 현상 발생
        // 그래서 아래와 같이 명칭을 지정하여 다시 한번 send하는 불필요함을 진행... 이거는 정말 문제다...
        // 그래도 다시 공부하니 좀 괜춘하네
//        if(messageDto.getGubun().equals("message")) {
//            //Listner에 담기 위함
//            rabbitTemplate.convertAndSend(queueName, messageDto);
//        }
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
//    application.yml에 선언된 queue name을 따라간다는 것
//    @RabbitListener(queues = "${rabbitmq.queue.name}")
    // #{chatQueue.name}은 RabbitMQConfig.java에 선언된 chatQueue라는 Queue 명칭의 제목을 따라가는 것
    // TopicExchange 타입의 Exchange를 이용하여 Routing key가 chat.room.#로 chat.room. 다음에 오는 모든 값에 대하여 receive 하겠다는 의미를 가짐
    @RabbitListener(queues = "#{chatQueue.name}")
    public void receiveMessage(ChatMessage messageDto) throws Exception {
        log.info("### send message receive : {}",messageDto);
        if(messageDto.getGubun().equals("message")){
            chatMsRepository.insert(messageDto);
        }
    }
}
