package com.rabbitmq.pratice.rabbitmq.repository;

import com.rabbitmq.pratice.rabbitmq.domain.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName    : com.rabbitmq.pratice.rabbitmq.repository
 * fileName       : ChatMsRepository
 * author         : rhkdg
 * date           : 2024-07-04
 * description    : 채팅 repository
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-04        rhkdg       최초 생성
 */
@Repository
public interface ChatMsRepository extends MongoRepository<ChatMessage, String> {

    List<ChatMessage> findChatMessageByRoomId(String roomId);
}
