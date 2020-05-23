package by.home.telegrambot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("covid.api")
@Getter
@Setter
public class CovidApiProperties {
    private String url;
}
