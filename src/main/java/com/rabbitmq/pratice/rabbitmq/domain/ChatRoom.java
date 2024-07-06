package com.rabbitmq.pratice.rabbitmq.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Profile;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * packageName    : com.rabbitmq.pratice.rabbitmq.domain
 * fileName       : ChatRoom
 * author         : rhkdg
 * date           : 2024-07-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-04        rhkdg       최초 생성
 */
@Document(collection = "chat_room")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoom {

    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @CreatedDate
    private LocalDateTime createDate;

}
