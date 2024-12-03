package com.shutiye.demo.patients.Controller;

import com.shutiye.demo.patients.Services.PatientService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PatientJasperreport {
    private final PatientService patientService;

    public PatientJasperreport(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping("/pdf")
    public ResponseEntity<byte[]> generatePdf() throws FileNotFoundException, JRException {
        JRBeanCollectionDataSource jrBeanCollectionDataSource=new JRBeanCollectionDataSource(patientService.getAllPatients());
//        JasperCompileManager.compileReport(new FileInputStream("src/java/resources/patients.jrxml"));
//
        JasperReport compileReport = JasperCompileManager
                .compileReport(new FileInputStream("src/main/resources/static/patients.jrxml"));

        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("total", "7000");

        JasperPrint report = JasperFillManager.fillReport(compileReport, parameters, jrBeanCollectionDataSource);

        JasperExportManager.exportReportToPdfFile(report,"invoice.pdf");
        byte[] data= JasperExportManager.exportReportToPdf(report);
        System.err.println(data);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);

    }

}
