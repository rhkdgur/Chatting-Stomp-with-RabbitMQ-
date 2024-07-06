package com.rabbitmq.pratice.rabbitmq.repository;

import com.rabbitmq.pratice.rabbitmq.domain.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName    : com.rabbitmq.pratice.rabbitmq.repository
 * fileName       : ChatRepository
 * author         : rhkdg
 * date           : 2024-07-04
 * description    : 채팅 룸 repository
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-04        rhkdg       최초 생성
 */
@Repository
public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {

    /**
     * 방 상세 정보 가져오기
     * @param id
     * @return
     */
    ChatRoom findChatRoomById(String id);
}
