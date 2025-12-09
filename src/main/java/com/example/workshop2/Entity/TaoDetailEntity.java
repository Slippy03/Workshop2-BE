package com.example.workshop2.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "taoDetail")
public class TaoDetailEntity {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id ;

    @ManyToOne
    @JoinColumn(name = "vdt_no")
    @JsonIgnore
    private TaoHeaderEntity header;


    @Column(name = "bookNo")
    private String bookNo;


    @Column(name = "transactionNo")
    private String transactionNo;

    @Column(name = "createBy")
    private String createBy;

    @Column(name = "createDate")
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Column(name = "updateBy")
    private String updateBy;

    @Column(name = "updateDate")
    @Temporal(TemporalType.DATE)
    private Date updateDate;

    @Column(name = "total_purchase")
    private BigDecimal totalPurchase;

    @Column(name = "establishment")
    private String establishment;

    @Column(name = "branch")
    private String branch;

    @Column(name = "payerIdentification")
    private String payerIdentification;

    @Column(name = "vat_back_agent")
    private BigDecimal vatBackAgent;

    @Column(name = "vat_back_revenue")
    private BigDecimal vatBackRevenue;

    @Column(name = "vat_back_total")
    private BigDecimal vatBackTotal;

    @Column(name = "vatSeven")
    private BigDecimal vatSeven;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
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

    public TaoHeaderEntity getHeader() {
        return header;
    }

    public void setHeader(TaoHeaderEntity header) {
        this.header = header;
    }
}