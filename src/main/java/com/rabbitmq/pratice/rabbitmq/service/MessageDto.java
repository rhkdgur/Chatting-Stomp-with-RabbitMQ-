package com.rabbitmq.pratice.rabbitmq.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
public class MessageDto {
    /**
     * 제목
     */
    private String title;

    /**
     * 내용
     */
    private String content;

}
