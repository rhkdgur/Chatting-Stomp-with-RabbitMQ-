package com.rabbitmq.pratice.rabbitmq.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

    @Value("${rabbitmq.routing.key}")
    private String routingkey;

    private final RabbitTemplate rabbitTemplate;

    /**
     * Queue로 메세지를 발행
     * @param messageDto
     */
    public void sendMessage(MessageDto messageDto){
        log.info("send message  : {}",messageDto.toString());
        rabbitTemplate.convertAndSend(exchangeName,routingkey,messageDto);
    }

    /**
     * Queue 에서 메세지를 구독
     * sendMessage한 메세지들이 들어있는 Queue에 대한 정보를 보여줌
     * @param messageDto
     */
    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void receiveMessage(MessageDto messageDto) {
        log.info("receive message : {}",messageDto.toString());
    }
}
