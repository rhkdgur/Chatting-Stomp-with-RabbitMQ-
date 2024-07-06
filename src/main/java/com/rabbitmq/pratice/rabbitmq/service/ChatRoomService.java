package com.rabbitmq.pratice.rabbitmq.service;

import com.rabbitmq.pratice.rabbitmq.domain.ChatMessage;
import com.rabbitmq.pratice.rabbitmq.domain.ChatRoom;
import com.rabbitmq.pratice.rabbitmq.repository.ChatMsRepository;
import com.rabbitmq.pratice.rabbitmq.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * packageName    : com.rabbitmq.pratice.rabbitmq.service
 * fileName       : ChatService
 * author         : rhkdg
 * date           : 2024-07-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-04        rhkdg       최초 생성
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    private final ChatMsRepository chatMsRepository;

    /***
     * 채팅 룸 목록 조회
     * @return
     * @throws Exception
     */
    public List<ChatRoom> selectChatRoomList() throws Exception {
        return chatRoomRepository.findAll();
    }

    /**
     * 채팅 룸 조회
     * @param roomId
     * @return
     * @throws Exception
     */
    public ChatRoom selectChatRoom(String roomId) throws Exception {
        return chatRoomRepository.findChatRoomById(roomId);
    }

    /**
     * 방 생성
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Transactional
    public ChatRoom insertChatRoom(String name) throws Exception {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setName(name);
        return chatRoomRepository.insert(chatRoom);
    }


    public List<ChatMessage> selectChatMessageList(String roomId) throws  Exception {
        return chatMsRepository.findChatMessageByRoomId(roomId);
    }
    
}
