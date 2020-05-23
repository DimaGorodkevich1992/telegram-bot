package by.home.telegrambot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * The Bot properties.
 */
@Validated
@ConfigurationProperties(prefix = "bot")
@Getter
@Setter
public class BotProperties {
    private String token;
    private String name;
}
