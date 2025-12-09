package com.example.workshop2.Services;

import com.example.workshop2.Entity.RdbvrtrateEntity;
import com.example.workshop2.Entity.TaoDetailEntity;
import com.example.workshop2.Repository.RdbvrtrateRepository;
import com.example.workshop2.Repository.TaoDetailRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RdbvrtrateService {

    private final RdbvrtrateRepository repository;

    public RdbvrtrateService(RdbvrtrateRepository repository) {
        this.repository = repository;
    }

    public List<RdbvrtrateEntity> getAll() {
        return repository.findAll();
    }
    public RdbvrtrateEntity findByAmount(BigDecimal amount) {
        return repository.findByAmount(amount);
    }

}
