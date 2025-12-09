package com.example.workshop2.Controller;
import com.example.workshop2.Entity.RdbvrtrateEntity;
import com.example.workshop2.Entity.TaoHeaderEntity;
import com.example.workshop2.Model.PDFRequestDTO;
import com.example.workshop2.Model.TaoDetailRequestModel;
import com.example.workshop2.Repository.TaoHeaderRepository;
import com.example.workshop2.Services.AllService;
import com.example.workshop2.Services.RdbvrtrateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/all")
@CrossOrigin(origins = "http://localhost:4200")
public class AllController {

    @Autowired
    private AllService allService;

    @PostMapping("/create")
    public TaoHeaderEntity createHeader(@RequestBody List<TaoDetailRequestModel> request) {
        return allService.createHeader(request);
    }

    @PutMapping("/update/{headerId}")
    public TaoHeaderEntity update(
            @PathVariable Integer headerId,
            @RequestBody List<TaoDetailRequestModel> request
    ) {
        return allService.updateHeader(headerId, request);
    }

    // ====================== Search with BE/C.E. handling ======================
    @GetMapping("/search")
    public List<TaoHeaderEntity> search(
            @RequestParam(required = false) Integer vdtNo,
            @RequestParam(required = false) String createDate
    ) {
        Date createDateCE = null;

        if (createDate != null && !createDate.isEmpty()) {
            try {
                String[] parts = createDate.split("-");
                if (parts.length != 3) throw new RuntimeException("Invalid date format");

                int year = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int day = Integer.parseInt(parts[2]);

                if (year > 2500) year -= 543;

                Calendar cal = Calendar.getInstance();
                cal.set(year, month - 1, day, 0, 0, 0);
                cal.set(Calendar.MILLISECOND, 0);

                createDateCE = cal.getTime();
            } catch (Exception e) {
                throw new RuntimeException("Invalid date format. Use yyyy-MM-dd");
            }
        }

        return allService.searchHeader(vdtNo, createDateCE);
    }

    @DeleteMapping("/delete/{detailId}")
    public String deleteDetail(@PathVariable Integer detailId) {
        allService.deleteDetail(detailId);
        return "Detail deleted id=" + detailId;
    }
    @PostMapping("/pdf-base64")
    public String generatePdfBase64(@RequestBody PDFRequestDTO header) {
        try {
            byte[] pdfBytes = allService.generatePdf(header);
            return Base64.getEncoder().encodeToString(pdfBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
