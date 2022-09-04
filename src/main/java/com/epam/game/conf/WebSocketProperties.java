package com.epam.game.conf;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties("websocket")
@ConstructorBinding
@RequiredArgsConstructor
@Getter
public class WebSocketProperties {
    private final int port;
}
