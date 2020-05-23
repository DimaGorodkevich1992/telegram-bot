package by.home.telegrambot.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties({BotProperties.class, CovidApiProperties.class, RestTemplateProperties.class})
public class AppConfig {

    private RestTemplateProperties restTemplateProperties;

    public AppConfig(final RestTemplateProperties restTemplateProperties) {
        this.restTemplateProperties = restTemplateProperties;
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(restTemplateProperties.getConnectionTimeout());
        return clientHttpRequestFactory;
    }

    @Bean
    public RestTemplate restTemplate(final ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }
}
