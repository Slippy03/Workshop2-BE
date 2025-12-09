package com.example.workshop2.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "rdbvrtrate")
public class RdbvrtrateEntity {

    @Id
    @NotNull
    @Column(name = "SALEFROM")
    private BigDecimal saleFrom;

    @Column(name = "SALETO")
    private BigDecimal saleTo;


    @Column(name = "VRTRATE")
    private BigDecimal vrtRate;

    @Column(name = "VRTRATEAG")
    private BigDecimal vrtRateAg;

    public BigDecimal getSaleFrom() {
        return saleFrom;
    }

    public BigDecimal getSaleTo() {
        return saleTo;
    }

    public BigDecimal getVrtRate() {
        return vrtRate;
    }

    public BigDecimal getVrtRateAg() {
        return vrtRateAg;
    }
}