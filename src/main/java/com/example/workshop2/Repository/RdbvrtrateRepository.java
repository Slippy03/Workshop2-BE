package com.example.workshop2.Repository;

import com.example.workshop2.Entity.RdbvrtrateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface
RdbvrtrateRepository extends JpaRepository<RdbvrtrateEntity, BigDecimal> {
    @Query("SELECT r FROM RdbvrtrateEntity r WHERE :amount BETWEEN r.saleFrom AND r.saleTo")
    RdbvrtrateEntity findByAmount(@Param("amount") BigDecimal amount);
}



