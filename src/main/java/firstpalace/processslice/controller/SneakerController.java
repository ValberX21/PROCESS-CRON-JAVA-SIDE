package firstpalace.processslice.controller;

import firstpalace.processslice.Service.SneakerService;
import firstpalace.processslice.model.Sneaker;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/report/sneaker")
public class SneakerController {

    private final SneakerService _sneakerService;

    public SneakerController(SneakerService sneakerService){
        this._sneakerService = sneakerService;
    }

    @GetMapping("/markSneaker")
    public ResponseEntity<byte[]> downloadExcelReport() {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Products");

            Row headerRow = sheet.createRow(0);
            String[] headers = {"ID", "Model Name", "SKU", "Material", "Price"};

            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

           List<Sneaker> sneakers = _sneakerService.listAllSneaker();

            int rowIdx = 1;

            for (Sneaker s : sneakers) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(s.getId());
                row.createCell(1).setCellValue(s.getModelName());
                row.createCell(2).setCellValue(s.getSku());
                row.createCell(3).setCellValue(s.getMaterial());
                row.createCell(4).setCellValue(s.getPrice());
            }

            workbook.write(out);

            HttpHeaders headersExcel = new HttpHeaders();
            headersExcel.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=products_report.xlsx");

            return ResponseEntity.ok()
                    .headers(headersExcel)
                    .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                    .body(out.toByteArray());


        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
