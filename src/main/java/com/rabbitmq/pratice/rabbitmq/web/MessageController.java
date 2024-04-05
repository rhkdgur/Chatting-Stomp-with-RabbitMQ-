package com.rabbitmq.pratice.rabbitmq.web;

import com.rabbitmq.pratice.rabbitmq.service.MessageDto;
import com.rabbitmq.pratice.rabbitmq.service.RabbitMqService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequiredArgsConstructor
public class MessageController {

    private final RabbitMqService rabbitMqService;

    @PostMapping("/send/message")
    public ResponseEntity<?> sendMessage(final @RequestBody MessageDto messageDto) {
        rabbitMqService.sendMessage(messageDto);
        return ResponseEntity.ok("Message send to Ok");
    }
}
