package com.example.workshop2.Services;

import com.example.workshop2.Entity.TaoDetailEntity;
import com.example.workshop2.Entity.TaoHeaderEntity;
import com.example.workshop2.Model.PDFRequestDTO;
import com.example.workshop2.Model.TaoDetailRequestModel;
import com.example.workshop2.Repository.TaoDetailRepository;
import com.example.workshop2.Repository.TaoHeaderRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.*;

@Service
public class AllService {
    @Autowired
    private TaoHeaderRepository taoHeaderRepository;
    @Autowired
    private TaoDetailRepository taoDetailRepository;

    // Create
    public TaoHeaderEntity createHeader(List<TaoDetailRequestModel> request) {
        TaoHeaderEntity header = new TaoHeaderEntity();
        header.setCreateBy("Tao");
        header.setCreateDate(new Date());
        header.setVdtDate(new Date());
        List<TaoDetailEntity> details = new ArrayList<>();

        for (TaoDetailRequestModel model : request) {
            TaoDetailEntity detail = new TaoDetailEntity();

            detail.setBookNo(model.getBookNo());
            detail.setTransactionNo(model.getTransactionNo());
            detail.setCreateBy("Tao");

            detail.setCreateDate(model.getCreateDate() != null ? model.getCreateDate() : new Date());
            detail.setUpdateBy("Tao");

            detail.setUpdateDate(model.getUpdateDate() != null ? model.getUpdateDate() : new Date());
            detail.setTotalPurchase(model.getTotalPurchase());
            detail.setEstablishment(model.getEstablishment());
            detail.setBranch(model.getBranch());
            detail.setPayerIdentification(model.getPayerIdentification());
            detail.setVatBackAgent(model.getVatBackAgent());
            detail.setVatBackRevenue(model.getVatBackRevenue());
            detail.setVatBackTotal(model.getVatBackTotal());
            detail.setVatSeven(model.getVatSeven());

            detail.setHeader(header);

            details.add(detail);
        }
        header.setTaoDetailEntityList(details);

        return taoHeaderRepository.save(header);
    }

    // Update
    public TaoHeaderEntity updateHeader(Integer headerId, List<TaoDetailRequestModel> request) {

        TaoHeaderEntity header = taoHeaderRepository.findById(headerId)
                .orElseThrow(() -> new RuntimeException("Header not found id=" + headerId));

        header.setVdtDate(new Date());
        header.setCreateBy("Tao");
        header.setCreateDate(new Date());

        List<TaoDetailEntity> existingDetails = header.getTaoDetailEntityList();
        List<TaoDetailEntity> updatedDetails = new ArrayList<>();

        for (TaoDetailRequestModel model : request) {
            TaoDetailEntity detail;

            if (model.getId() != null && model.getId() != 0) {
                detail = existingDetails.stream()
                        .filter(d -> d.getId().equals(model.getId()))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Detail not found id=" + model.getId()));
            } else {
                detail = new TaoDetailEntity();
                detail.setHeader(header); // Set FK
                detail.setCreateBy("Tao");
                detail.setCreateDate(model.getCreateDate() != null ? model.getCreateDate() : new Date());
            }

            detail.setBookNo(model.getBookNo());
            detail.setTransactionNo(model.getTransactionNo());
            detail.setUpdateBy("Tao");
            detail.setUpdateDate(model.getUpdateDate() != null ? model.getUpdateDate() : new Date());
            detail.setTotalPurchase(model.getTotalPurchase());
            detail.setEstablishment(model.getEstablishment());
            detail.setBranch(model.getBranch());
            detail.setPayerIdentification(model.getPayerIdentification());
            detail.setVatBackAgent(model.getVatBackAgent());
            detail.setVatBackRevenue(model.getVatBackRevenue());
            detail.setVatBackTotal(model.getVatBackTotal());
            detail.setVatSeven(model.getVatSeven());

            updatedDetails.add(detail);
        }

        header.getTaoDetailEntityList().clear();
        header.getTaoDetailEntityList().addAll(updatedDetails);

        return taoHeaderRepository.save(header);
    }

    // Search
    public List<TaoHeaderEntity> searchHeader(Integer vdtNo, Date createDate) {
        boolean hasVdtNo = (vdtNo != null && vdtNo != 0);
        boolean hasCreateDate = (createDate != null);

        if (hasVdtNo && hasCreateDate) {
            return taoHeaderRepository.findByVdtNoAndCreateDate(vdtNo, createDate);
        } else if (hasVdtNo) {
            return taoHeaderRepository.findByVdtNo(vdtNo);
        } else if (hasCreateDate) {
            return taoHeaderRepository.findByCreateDate(createDate);
        } else {
            return new ArrayList<>();
        }
    }

    // Delete
    public void deleteDetail(Integer detailId) {
        TaoDetailEntity detail = taoDetailRepository.findById(detailId)
                .orElseThrow(() -> new RuntimeException("Detail not found id=" + detailId));

        TaoHeaderEntity header = detail.getHeader();

        if (header != null) {
            header.getTaoDetailEntityList().remove(detail);
            taoHeaderRepository.save(header);
        }

        taoDetailRepository.delete(detail);
    }

    @Transactional
    public byte[] generatePdf(PDFRequestDTO header) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("vdtNo", header.getVdtNo());
            params.put("vdtDate", header.getVdtDate());
            params.put("printDate", new Date());

            JRBeanCollectionDataSource ds =
                    new JRBeanCollectionDataSource(header.getDetailList());

            InputStream reportInput = getClass().getClassLoader()
                    .getResourceAsStream("report/Report.jrxml");

            JasperReport jasperReport =
                    JasperCompileManager.compileReport(reportInput);

            JasperPrint jasperPrint =
                    JasperFillManager.fillReport(jasperReport, params, ds);

            return JasperExportManager.exportReportToPdf(jasperPrint);

        } catch (Exception e) {
            throw new RuntimeException("Error generating PDF", e);
        }
    }
}
