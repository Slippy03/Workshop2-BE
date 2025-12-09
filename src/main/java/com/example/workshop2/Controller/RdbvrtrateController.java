package com.example.workshop2.Controller;

import com.example.workshop2.Entity.RdbvrtrateEntity;
import com.example.workshop2.Services.RdbvrtrateService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/rdbvrtrate")
@CrossOrigin(origins = "http://localhost:4200")

public class RdbvrtrateController {
    private final RdbvrtrateService service;

    public RdbvrtrateController(RdbvrtrateService service) {
        this.service = service;
    }

    @GetMapping("get-all")
    public List<RdbvrtrateEntity> getAll() {
        return service.getAll();
    }
    @GetMapping("/get-by-amount/{amount}")
    public RdbvrtrateEntity findByAmount(@PathVariable BigDecimal amount) {
        return service.findByAmount(amount);
    }



}
