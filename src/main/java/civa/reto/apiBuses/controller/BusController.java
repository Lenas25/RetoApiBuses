package civa.reto.apiBuses.controller;


import civa.reto.apiBuses.Service.BusService;
import civa.reto.apiBuses.dto.BusData;
import civa.reto.apiBuses.model.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController {
    @Autowired
    private BusService service;

    @GetMapping
    public Page<BusData> getAllBus(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public BusData getBus(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Bus addBus(@RequestBody Bus bus) {
        return service.saveBus(bus);
    }

}
