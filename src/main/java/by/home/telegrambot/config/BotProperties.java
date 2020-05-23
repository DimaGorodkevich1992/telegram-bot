package by.home.telegrambot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * The Bot properties.
 */
@Validated
@ConfigurationProperties(prefix = "bot")
@Getter
@Setter
public class BotProperties {
    @NotEmpty
    private String token;
    @NotEmpty
    private String name;
}
