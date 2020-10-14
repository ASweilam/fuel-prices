package com.example.fuelprices.service;

import com.example.fuelprices.model.Fuel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class CsvProcessor {

    private static final Logger logger = LogManager.getLogger(CsvProcessor.class);

    public Flux<Fuel> readFuelCsv(String fileLocation) {

        Flux<Fuel> fuelFlux = Flux.using(
                () -> Files.lines(Paths.get(fileLocation)).skip(1),
                s -> Flux.fromStream(s),
                stringStream -> stringStream.close())
                .map(line -> line.split(","))
                .map(x -> {
                    Fuel fuel = new Fuel(
                            x[0],
                            Double.parseDouble(x[1].trim()),
                            Double.parseDouble(x[2].trim()),
                            Double.parseDouble(x[3].trim()),
                            Double.parseDouble(x[4].trim()),
                            Double.parseDouble(x[5].trim()),
                            Double.parseDouble(x[6].trim())
                    );
                    return fuel;
                });

        return fuelFlux;
    }
}
