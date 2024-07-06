package com.rabbitmq.pratice.rabbitmq.domain;

import jdk.jfr.Frequency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.amqp.ImmediateAcknowledgeAmqpException;
import org.springframework.context.annotation.Profile;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * packageName    : com.rabbitmq.pratice.rabbitmq.service
 * fileName       : MessageDto
 * author         : GAMJA
 * date           : 2024/04/06
 * description    : 메세지 Dto
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/04/06        GAMJA       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "chat_message")
public class ChatMessage {

    @Id
    private String id;

    @Field(name = "roomId")
    private String roomId;

    @Field(name="room_info")
    private String roomInfo;

    /**
     * 제목
     */
    @Field(name = "writer")
    private String writer;

    /**
     * 내용
     */
    @Field(name = "message")
    private String message;

    @Field(name = "gubun")
    private String gubun;

}
