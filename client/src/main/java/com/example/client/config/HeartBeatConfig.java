package com.example.client.config;

import com.example.client.vo.CustomProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeartBeatConfig {
    @Value("${channel.id}")
    private long id ;

    @Bean(value = "heartBeat")
    public CustomProtocol heartBeat(){
        return new CustomProtocol(id,"ping") ;
    }
}
