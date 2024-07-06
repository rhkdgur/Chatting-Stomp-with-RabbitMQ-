package com.rabbitmq.pratice.rabbitmq.web;

import com.rabbitmq.pratice.rabbitmq.domain.ChatMessage;
import com.rabbitmq.pratice.rabbitmq.service.RabbitMqService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * packageName    : com.rabbitmq.pratice.rabbitmq.web
 * fileName       : MessageController
 * author         : GAMJA
 * date           : 2024/04/06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/04/06        GAMJA       최초 생성
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class MessageController {

    private final RabbitMqService rabbitMqService;

    @MessageMapping("chat.enter.{roomId}")
    public void sendEnter(final @RequestBody ChatMessage messageDto, @DestinationVariable String roomId) {
        messageDto.setRoomId(roomId);
        messageDto.setMessage("입장하셨습니다.");
        rabbitMqService.sendMessage(messageDto);
    }

    @MessageMapping("chat.message.{roomId}")
    public void sendMessage(final @RequestBody ChatMessage messageDto,@DestinationVariable String roomId) {
        messageDto.setRoomId(roomId);
        rabbitMqService.sendMessage(messageDto);
    }
}
