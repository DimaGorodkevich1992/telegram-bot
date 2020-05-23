package by.home.telegrambot.covidinfo.services.impl;

import by.home.telegrambot.config.CovidApiProperties;
import by.home.telegrambot.covidinfo.model.CovidInfo;
import by.home.telegrambot.covidinfo.services.CovidInfoService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.constraints.NotEmpty;
import java.net.URI;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * The  Documenter getpostman com service. See <a href="https://api.covid19api.com</a>
 */
@Service
public class DocumenterGetpostmanComImpl implements CovidInfoService {

    private final RestTemplate restTemplate;
    private final CovidApiProperties covidApiProperties;

    public DocumenterGetpostmanComImpl(final RestTemplate restTemplate, final CovidApiProperties covidApiProperties) {
        this.restTemplate = restTemplate;
        this.covidApiProperties = covidApiProperties;
    }

    @Override
    public List<CovidInfo> getAllDataByCountry(final @NotEmpty(message = "Country must not be null") String country) {
        return getAllDataByCountryAndAfterDate(country, LocalDate.of(2020, 3, 1));
    }

    @Override
    public List<CovidInfo> getAllDataByCountryAndAfterDate(final @NotEmpty(message = "Country must not be null") String country,
                                                           final LocalDate startDate) {
        String url = covidApiProperties.getUrl() + "/{country}?from={from}&to={to}";
        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("country", country);
        uriParams.put("from", startDate.toString());
        uriParams.put("to", LocalDate.now().toString());

        URI preparedURI = UriComponentsBuilder
                .fromUriString(url)
                .buildAndExpand(uriParams)
                .toUri();

        return Arrays.asList(Objects.requireNonNull(restTemplate.getForEntity(preparedURI, CovidInfo[].class).getBody()));
    }
}
