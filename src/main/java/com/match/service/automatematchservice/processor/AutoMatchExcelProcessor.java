package com.match.service.automatematchservice.processor;

import com.match.service.automatematchservice.contract.ExcelDataContract;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class AutoMatchExcelProcessor {
    public List<ExcelDataContract> readExcelFile(File excelFile) throws Exception {
        List<ExcelDataContract> dataContracts = new ArrayList<>();
        try (InputStream fileStream = new FileInputStream(excelFile);
             Workbook workbook = new XSSFWorkbook(fileStream)) {

            List<String> headers = new ArrayList<>();
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row currentRow = sheet.getRow(i);

                // If it's the first row, extract headers
                if (i == 0) {
                    for (Cell cell : currentRow) {
                        headers.add(cell.getStringCellValue());
                    }
                } else {
                    ExcelDataContract dataContract = new ExcelDataContract();

                    for (Cell cell : currentRow) {
                        int columnIndex = cell.getColumnIndex();
                        String cellValue = ((XSSFCell) cell).getRawValue();

                        switch (headers.get(columnIndex)) {
                            case "ANI":
                                dataContract.setAni(cellValue);
                                break;
                            case "Account Number":
                                dataContract.setAccountNumber(cellValue);
                                break;
                            case "Sys":
                                dataContract.setSys(cellValue);
                                break;
                            case "PRN":
                                dataContract.setPrn(cellValue);
                                break;
                            case "Agent":
                                dataContract.setAgent(cellValue);
                                break;
                        }
                    }
                    dataContracts.add(dataContract);
                }


            }
        }
        return dataContracts;
    }
}
