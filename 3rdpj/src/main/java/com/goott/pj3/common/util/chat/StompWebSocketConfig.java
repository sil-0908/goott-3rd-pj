package com.goott.pj3.common.util.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//2023.04.28 길영준 Stomp config
@Configuration
@EnableWebSocketMessageBroker//Stomp를 사용하기 위해 선언
public class StompWebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/stomp/chat") //엔드포인트
                .setAllowedOrigins("http://localhost:8080")
                .withSockJS();
    }

    /*어플리케이션 내부에서 사용할 path를 지정할 수 있음*/
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/pub"); //클라이언트에서 SEND요청을 처리
        registry.enableSimpleBroker("/sub"); //경로에 SimpleBroker를 등록 
                                                            // 해당 경로를 Subscribe하는 client에게 메시지를 전달
        //.enableStompBrokerRelay = SimpleBroker의 기능과 외부 Message Broker( RabbitMQ, ActiveMQ 등 )에 메세지를 전달
    }
}
