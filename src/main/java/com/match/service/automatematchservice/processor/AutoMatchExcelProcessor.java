package com.match.service.automatematchservice.processor;

import com.match.service.automatematchservice.contract.ExcelDataContract;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class AutoMatchExcelProcessor {
    public List<ExcelDataContract> readExcelFile(String fileName) throws Exception {
        Path jarDir = Paths.get(System.getProperty("user.dir"));  // Get the directory where the JAR file is located
        File excelFile = new File(jarDir.toFile(), fileName);      // Excel file path relative to the JAR

        try (InputStream fileStream = new FileInputStream(excelFile);
             Workbook workbook = new XSSFWorkbook(fileStream)) {

            List<ExcelDataContract> dataRows = new ArrayList<>();
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                ExcelDataContract dataRow = new ExcelDataContract();
                dataRow.setAni(row.getCell(0).getStringCellValue());
                dataRow.setAccountNumber(row.getCell(1).getStringCellValue());
                dataRow.setSys(row.getCell(2).getStringCellValue());
                dataRow.setPrn(row.getCell(3).getStringCellValue());
                dataRow.setAgent(row.getCell(4).getStringCellValue());
                dataRows.add(dataRow);
            }

            return dataRows;
        }
    }
}
