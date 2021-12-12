package ru.otus.spring3springboot.config;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "locale")
@Setter
public class LocalePropertiesConfig {

    private Map<String, String> data;

    public Map<String, String> getFilenames() {
        return data;
    }
}
