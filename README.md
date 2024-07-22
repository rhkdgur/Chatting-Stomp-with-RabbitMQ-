# ![icons8-채팅-36](https://github.com/rhkdgur/Chatting-Stomp-with-RabbitMQ-/assets/67618667/3509ba75-4eec-4829-9516-4b77a3ff84db) Stomp 와 RabbitMQ를 이용한 채팅방 만들기
채팅(Chatting) 사이드 프로젝트입니다. 

## 채팅방 DEGINE

![image](https://github.com/rhkdgur/Chatting-Stomp-with-RabbitMQ-/assets/67618667/5ff5f5aa-909a-4fea-ac2a-938876768c79)

## ![icons8-채팅-36](https://github.com/rhkdgur/Chatting-Stomp-with-RabbitMQ-/assets/67618667/3509ba75-4eec-4829-9516-4b77a3ff84db) 프로젝트 목표
- `Spring 과 RabbitMQ`를 이용하여 `Message Queue` 실습이 목표
- `WebSocket`과 함께 사용하여 `Message Queue`를 좀 더 활용해보는 것이 목적
- 실습을 통해 `Message Queue`의 특징과 효율성을 확인해보고자 합니다.
- MongoDB 채팅 정보를 등록 구현
- MongoDB @Transactional 이용하여 구현


## ![icons8-채팅-36](https://github.com/rhkdgur/Chatting-Stomp-with-RabbitMQ-/assets/67618667/3509ba75-4eec-4829-9516-4b77a3ff84db) ISSUE
- [RabbitMQ Exchange Type에 대한 지식 부족으로 인한 @RabbitListner 받지 못하는 이슈에 대한 이론 정리(1)](https://ghgo195.tistory.com/63)
- [채팅에서 입력한 값을 `topic exchange`로 설정하여 전달하였지만 `queue 결과값`을 `@RabbitListener`로 받지 못하는 현상](https://github.com/rhkdgur/Chatting-Stomp-with-RabbitMQ-/wiki/Issue(1).--Queue-%EB%A9%94%EC%84%B8%EC%A7%80-%EB%A7%A4%EC%B9%AD-%EC%95%88%EB%90%98%EB%8D%98-%EC%9D%B4%EC%8A%88-%EC%9B%90%EC%9D%B8-%EB%B0%8F-%ED%95%B4%EA%B2%B0)
- [`Direct` message type에서 `topic` message type으로 전환시 오류 발생 이슈](https://github.com/rhkdgur/Chatting-Stomp-with-RabbitMQ-/issues/4)

## ![icons8-채팅-36](https://github.com/rhkdgur/Chatting-Stomp-with-RabbitMQ-/assets/67618667/3509ba75-4eec-4829-9516-4b77a3ff84db) 프로젝트 사용기술
`Spring Boot` `Java 17` `JPA` `MongoDB` `Docker` `Intellij IDEA`


## ![icons8-채팅-36](https://github.com/rhkdgur/Chatting-Stomp-with-RabbitMQ-/assets/67618667/3509ba75-4eec-4829-9516-4b77a3ff84db) 작업 기간
`2024-03-25` ~


## ![icons8-채팅-36](https://github.com/rhkdgur/Chatting-Stomp-with-RabbitMQ-/assets/67618667/3509ba75-4eec-4829-9516-4b77a3ff84db) RabbitMQ 인터페이스
![image](https://github.com/user-attachments/assets/90b50444-043d-4198-8993-c9e3f14fa64c)


## ![icons8-채팅-36](https://github.com/rhkdgur/Chatting-Stomp-with-RabbitMQ-/assets/67618667/3509ba75-4eec-4829-9516-4b77a3ff84db) RabbitMQ Docker 로그
![image](https://github.com/user-attachments/assets/a0a2e097-f5c8-412f-bbf9-ff7b3469a86f)


## ![icons8-채팅-36](https://github.com/rhkdgur/Chatting-Stomp-with-RabbitMQ-/assets/67618667/3509ba75-4eec-4829-9516-4b77a3ff84db) 작업 회고

* [실시간 채팅을 적용하기 위한 기술 정리](https://github.com/rhkdgur/Chatting-Stomp-with-RabbitMQ-/wiki/1.-%EC%8B%A4%EC%8B%9C%EA%B0%84-%EC%8A%A4%ED%8A%B8%EB%A6%BC%EC%97%90%EC%84%9C%EC%9D%98-HTTP%EC%9D%98-%ED%95%9C%EA%B3%84)
* [Message Queue에 대한 이론 정리](https://github.com/rhkdgur/Chatting-Stomp-with-RabbitMQ-/wiki/Message-Queue%EC%97%90-%EB%8C%80%ED%95%9C-%EC%9D%B4%EB%A1%A0-%EC%A0%95%EB%A6%AC)
* [Message Queue을 적용하고자한 이유](https://github.com/rhkdgur/Chatting-Stomp-with-RabbitMQ-/wiki/5.-Message-Queue%EB%A5%BC-%EC%A0%81%EC%9A%A9%ED%95%9C-%EC%9D%B4%EC%9C%A0)
* [RabbitMQ 선택 이유](https://github.com/rhkdgur/Chatting-Stomp-with-RabbitMQ-/wiki/RabbitMQ%EB%A5%BC-%EC%84%A0%ED%83%9D%ED%95%9C-%EC%9D%B4%EC%9C%A0)
* [RabbitMQ(Message Queue) 설정시 어려웠던 점들..](https://github.com/rhkdgur/Chatting-Stomp-with-RabbitMQ-/wiki/RabbitMQ-%EC%84%A4%EC%A0%95%EC%8B%9C-%EC%96%B4%EB%A0%A4%EC%9B%A0%EB%8D%98-%EC%A0%90%EB%93%A4-%ED%9A%8C%EA%B3%A0)
