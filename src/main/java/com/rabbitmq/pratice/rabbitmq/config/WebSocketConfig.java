package com.rabbitmq.pratice.rabbitmq.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * packageName    : com.rabbitmq.pratice.rabbitmq.config
 * fileName       : WebSocketConfig
 * author         : rhkdg
 * date           : 2024-07-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-04        rhkdg       최초 생성
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Value("${chat.path}")
	private String path;

    @Value("${spring.rabbitmq.host}")
    private String rabbitmqHost;

    @Value("${spring.rabbitmq.port}")
    private int rabbitmqPort;

    @Value("${spring.rabbitmq.username}")
    private String rabbitmqUsername;

    @Value("${spring.rabbitmq.password}")
    private String rabbitmqPassword;

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		//stomp의 접속주소
		registry.addEndpoint("/stomp/chat").setAllowedOrigins(path).withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//클라이언트의 send요청 url
		registry.setPathMatcher(new AntPathMatcher("."))
				.setApplicationDestinationPrefixes("/pub");

		//sub하는 클라이언트에게 메시지 전달
		registry.enableStompBrokerRelay("/queue", "/topic", "/exchange", "/amq/queue")
                .setClientLogin(rabbitmqUsername)
				.setClientPasscode(rabbitmqPassword)
				.setClientLogin(rabbitmqUsername)
				.setSystemPasscode(rabbitmqPassword);

	}

}
