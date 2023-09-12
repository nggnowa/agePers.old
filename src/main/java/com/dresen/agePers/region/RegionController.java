package com.dresen.agePers.region;

import com.dresen.agePers.email.EmailService;
import com.dresen.agePers.export.ExcelGenerator;
import com.dresen.agePers.export.PDFGenerator;
import com.itextpdf.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/regions")
public class RegionController {

    private final RegionService service;
    private final EmailService  emailService;

    @PostMapping
    public ResponseEntity<RegionDto> createRegion(@RequestBody @Valid RegionDto toCreate) {

        RegionDto savedRedion = service.createRegion(toCreate);
        return new ResponseEntity<>(savedRedion, CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RegionDto>> getAllRegions() {

        List<RegionDto> regions = service.getAllRegions();
        return ResponseEntity.ok(regions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegionDto> getRegionById(@PathVariable Long id) {

        RegionDto region = service.getRegionById(id);
        //emailService.envoyer(new EmailDetails("no-reply@mgn-consulting.org", "ngorba@gmail.com", "Test email Service", "Je teste mon service"));
        return ResponseEntity.ok(region);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegionDto> updateRegion(@PathVariable Long id, @RequestBody @Valid RegionDto toUpdate) {

        RegionDto region = service.updateRegion(id, toUpdate);
        return ResponseEntity.ok(region);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRegion(@PathVariable Long id) {

        service.deleteRegion(id);
        return ResponseEntity.ok(String.format("%s with id '%s' successfully deleted.", Region.class.getSimpleName(), id));
    }

    @GetMapping("/export/pdf")
    public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException {

        response.setContentType("application/pdf");
        DateFormat dateFormat      = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
        String     currentDateTime = dateFormat.format(new Date());

        String headerkey   = "Content-Disposition";
        String headervalue = "attachment; filename=regions" + currentDateTime + ".pdf";
        response.setHeader(headerkey, headervalue);

        List<RegionDto> regionDtoList = service.getAllRegions();
        PDFGenerator    generator     = new PDFGenerator();
        generator.generate(regionDtoList, response);
    }

    @GetMapping("/export/excel")
    public void exportIntoExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");
        DateFormat dateFormatter   = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
        String     currentDateTime = dateFormatter.format(new Date());

        String headerKey   = "Content-Disposition";
        String headerValue = "attachment; filename=regions" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<RegionDto> regionDtoList = service.getAllRegions();
        ExcelGenerator  generator     = new ExcelGenerator(regionDtoList);
        generator.generate(response);
    }

}
