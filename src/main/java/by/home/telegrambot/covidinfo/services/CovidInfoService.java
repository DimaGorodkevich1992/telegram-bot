package by.home.telegrambot.covidinfo.services;

import by.home.telegrambot.covidinfo.model.CovidInfo;

import java.time.LocalDate;
import java.util.List;

public interface CovidInfoService {
    List<CovidInfo> getAllDataByCountry(String country);
    List<CovidInfo> getAllDataByCountryAndAfterDate(String country, LocalDate startDate);
}
