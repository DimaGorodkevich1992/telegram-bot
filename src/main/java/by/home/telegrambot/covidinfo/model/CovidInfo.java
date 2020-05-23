package by.home.telegrambot.covidinfo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * The type Covid info.
 */
@Getter
@Setter
public class CovidInfo {
    private String country;
    private String countryCode;
    private Double lat;
    private Double lon;
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;
    private Integer active;
    private LocalDate date;

    @JsonCreator
    public CovidInfo(@JsonProperty("Country") final String country,
                     @JsonProperty("CountryCode") final String countryCode,
                     @JsonProperty("Lat") final Double lat,
                     @JsonProperty("Lon") final Double lon,
                     @JsonProperty("Confirmed") final Integer confirmed,
                     @JsonProperty("Deaths") final Integer deaths,
                     @JsonProperty("Recovered") final Integer recovered,
                     @JsonProperty("Active") final Integer active,
                     @JsonProperty("Date") final LocalDate date) {
        this.country = country;
        this.countryCode = countryCode;
        this.lat = lat;
        this.lon = lon;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
        this.active = active;
        this.date = date;
    }
}
