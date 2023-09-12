package com.dresen.agePers.export;

import com.dresen.agePers.region.RegionDto;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

public class ExcelGenerator {

    private List<RegionDto> regionList;
    private XSSFWorkbook    workbook;
    private XSSFSheet       sheet;

    public ExcelGenerator(List<RegionDto> regionList) {

        this.regionList = regionList;
        workbook = new XSSFWorkbook();
    }

    private void writeHeader() {

        sheet = workbook.createSheet("Liste des regions");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont  font  = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "ID", style);
        createCell(row, 1, "Nom", style);
        createCell(row, 2, "Code", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {

        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void write() {

        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont  font  = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (RegionDto regionDto : regionList) {
            Row row         = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, regionDto.id(), style);
            createCell(row, columnCount++, regionDto.nom(), style);
            createCell(row, columnCount++, regionDto.code(), style);

        }
    }

    public void generate(HttpServletResponse response) throws IOException {

        writeHeader();
        write();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }

}
