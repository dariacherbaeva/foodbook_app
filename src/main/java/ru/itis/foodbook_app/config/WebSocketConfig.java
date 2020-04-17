package ru.itis.foodbook_app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import ru.itis.foodbook_app.handlers.WebSocketHandler;

@Configuration
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    WebSocketHandler handler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(handler, "/support");
    }
}
