package com.example.fuelprices.controller;

import com.example.fuelprices.model.Fuel;
import com.example.fuelprices.service.FuelService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/fuel")
public class FuelController {
    private static final Logger logger = LogManager.getLogger(FuelController.class);

    private final FuelService service;

    public FuelController(FuelService service) {
        this.service = service;
    }

    @GetMapping()
    public Flux<Fuel> listAll() {
        logger.info("Getting list of all fuel details");
        return service.listFuel();
    }

    @GetMapping("/after/{date}")
    public Flux<Fuel> getFuelAfter(@PathVariable String date) {
        logger.info("Getting list of all fuel after {}", date);
        return service.getFuelAfter(date);
    }

    @GetMapping("/before/{date}")
    public Flux<Fuel> getFuelBefore(@PathVariable String date) {
        logger.info("Getting list of all fuel before {}", date);
        return service.getFuelBefore(date);
    }

    @GetMapping("/just/{date}")
    public Flux<Fuel> getFuelByDate(@PathVariable String date) {
        logger.info("Getting list of all fuel on {}", date);
        return service.getFuelByDate(date);
    }




}
