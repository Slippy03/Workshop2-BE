package com.example.workshop2.Model;

import java.util.Date;
import java.util.List;

public class PDFRequestDTO {

    private Integer vdtNo;
    private Date vdtDate;
    private List<PDFDetailRequestModel> detailList;

    public Integer getVdtNo() { return vdtNo; }
    public void setVdtNo(Integer vdtNo) { this.vdtNo = vdtNo; }

    public Date getVdtDate() { return vdtDate; }
    public void setVdtDate(Date vdtDate) { this.vdtDate = vdtDate; }

    public List<PDFDetailRequestModel> getDetailList() { return detailList; }
    public void setDetailList(List<PDFDetailRequestModel> detailList) { this.detailList = detailList; }
}
