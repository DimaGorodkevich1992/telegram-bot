package by.home.telegrambot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("resttemplate")
@Getter
@Setter
public class RestTemplateProperties {
    private int connectionTimeout;
}
