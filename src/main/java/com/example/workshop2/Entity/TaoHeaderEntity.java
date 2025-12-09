package com.example.workshop2.Entity;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "taoheader")
public class TaoHeaderEntity {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "vdt_no")
    private Integer vdtNo ;

    @Column(name = "vdt_date")
    @Temporal(TemporalType.DATE)
    private Date vdtDate;

    @Column(name = "createby")
    private String createBy;

    @Column(name = "createdate")
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @OneToMany(mappedBy = "header", cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true)
    private List<TaoDetailEntity> taoDetailEntityList;

    public Integer getVdtNo() {
        return vdtNo;
    }

    public void setVdtNo(Integer vdtNo) {
        this.vdtNo = vdtNo;
    }

    public Date getVdtDate() {
        return vdtDate;
    }

    public void setVdtDate(Date vdtDate) {
        this.vdtDate = vdtDate;
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

    public List<TaoDetailEntity> getTaoDetailEntityList() {
        return taoDetailEntityList;
    }

    public void setTaoDetailEntityList(List<TaoDetailEntity> taoDetailEntityList) {
        this.taoDetailEntityList = taoDetailEntityList;
    }
}
