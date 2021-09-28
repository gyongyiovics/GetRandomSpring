package com.example.demo.progmatic.backend.GetRandomMember.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigReader {
    @Getter
    @Value("${custom.random.resource}")
    private String resource;

    @Getter
    @Value("${custom.random.prefix.comment}")
    private String commentPrefix;

    @Getter
    @Value("${custom.random.prefix.presented}")
    private String presentedPrefix;
}
