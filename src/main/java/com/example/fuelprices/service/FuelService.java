package com.example.fuelprices.service;

import com.example.fuelprices.model.Fuel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class FuelService {
    private static final Logger logger = LogManager.getLogger(FuelService.class);

    @Value("${file}")
    String fileLocation;


    private final CsvProcessor csvProcessor;

    public FuelService(CsvProcessor csvProcessor) {
        this.csvProcessor = csvProcessor;
    }

    //get all
    public Flux<Fuel> listFuel() {

        return csvProcessor.readFuelCsv(fileLocation);
    }


    //get after date
    public Flux<Fuel> getFuelAfter(String date) {

        Flux<Fuel> fuelFlux = csvProcessor.readFuelCsv(fileLocation);

        LocalDate dateFormat = LocalDate.parse(date.trim(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        Flux<Fuel> filteredFuelFlux = fuelFlux.filter(f -> LocalDate
                .parse(f.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .isAfter(dateFormat));

        return filteredFuelFlux;
    }

    //get before date
    public Flux<Fuel> getFuelBefore(String date) {

        Flux<Fuel> fuelFlux = csvProcessor.readFuelCsv(fileLocation);

        LocalDate dateFormat = LocalDate.parse(date.trim(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        Flux<Fuel> filteredFuelFlux = fuelFlux.filter(f -> LocalDate
                .parse(f.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .isBefore(dateFormat));

        return filteredFuelFlux;
    }

    //get One date
    public Flux<Fuel> getFuelByDate(String date) {

        Flux<Fuel> fuelFlux = csvProcessor.readFuelCsv(fileLocation);

        LocalDate dateFormat = LocalDate.parse(date.trim(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        Flux<Fuel> filteredFuelFlux = fuelFlux.filter(f -> LocalDate
                .parse(f.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .isEqual(dateFormat));

        return filteredFuelFlux;
    }

}
