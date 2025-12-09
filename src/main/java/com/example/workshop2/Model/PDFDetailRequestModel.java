package com.example.workshop2.Model;

import java.math.BigDecimal;
import java.util.Date;

public class PDFDetailRequestModel {

    private String bookNo;
    private String transactionNo;
    private Date createDate;
    private Date updateDate; // Added missing field
    private BigDecimal totalPurchase;
    private String establishment;
    private String branch;
    private String payerIdentification;
    private BigDecimal vatBackAgent;
    private BigDecimal vatBackRevenue;
    private BigDecimal vatBackTotal;
    private BigDecimal vatSeven;

    // Getters and Setters

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public BigDecimal getTotalPurchase() {
        return totalPurchase;
    }

    public void setTotalPurchase(BigDecimal totalPurchase) {
        this.totalPurchase = totalPurchase;
    }

    public String getEstablishment() {
        return establishment;
    }

    public void setEstablishment(String establishment) {
        this.establishment = establishment;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPayerIdentification() {
        return payerIdentification;
    }

    public void setPayerIdentification(String payerIdentification) {
        this.payerIdentification = payerIdentification;
    }

    public BigDecimal getVatBackAgent() {
        return vatBackAgent;
    }

    public void setVatBackAgent(BigDecimal vatBackAgent) {
        this.vatBackAgent = vatBackAgent;
    }

    public BigDecimal getVatBackRevenue() {
        return vatBackRevenue;
    }

    public void setVatBackRevenue(BigDecimal vatBackRevenue) {
        this.vatBackRevenue = vatBackRevenue;
    }

    public BigDecimal getVatBackTotal() {
        return vatBackTotal;
    }

    public void setVatBackTotal(BigDecimal vatBackTotal) {
        this.vatBackTotal = vatBackTotal;
    }

    public BigDecimal getVatSeven() {
        return vatSeven;
    }

    public void setVatSeven(BigDecimal vatSeven) {
        this.vatSeven = vatSeven;
    }
}
