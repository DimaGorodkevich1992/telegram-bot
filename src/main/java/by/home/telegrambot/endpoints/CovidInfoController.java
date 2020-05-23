package by.home.telegrambot.endpoints;

import by.home.telegrambot.covidinfo.model.CovidInfo;
import by.home.telegrambot.covidinfo.services.CovidInfoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/covid")
public class CovidInfoController {

    private final CovidInfoService covidInfoService;

    public CovidInfoController(final CovidInfoService covidInfoService) {
        this.covidInfoService = covidInfoService;
    }

    @GetMapping(value = "/info/{country}")
    public ResponseEntity<List<CovidInfo>> getInfoByCountyAndAfterDate(@PathVariable final String country,
                                                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate startDate) {
        return ResponseEntity.ok(covidInfoService.getAllDataByCountryAndAfterDate(country, startDate));
    }
}
