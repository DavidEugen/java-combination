package com.example.combination.common.util;

import com.example.combination.domain.GameInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcelFileReader {

    File excelFile;

    public ExcelFileReader(String fileName) {
        excelFile = new File(fileName);
    }

    public Sheet getSheet(String sheetName) {
        Sheet sheet;
        try (Workbook workbook = new XSSFWorkbook(excelFile)) {
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }

        return sheet;
    }

    public List<GameInfo> getSetList(Sheet sheet) {
        List<GameInfo> setList = new ArrayList<GameInfo>();

        int numberOfMax = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < numberOfMax; i++) {
            Row row = sheet.getRow(i);

            GameInfo gameInfo = new GameInfo((int) row.getCell(0).getNumericCellValue());
            for (int j = 1; j < 7; j++) {
                gameInfo.add((int) row.getCell(j).getNumericCellValue());
            }
            log.trace("{} : {}", (int) row.getCell(0).getNumericCellValue(), gameInfo.getNumbers());

            setList.add(gameInfo);
        }

        return setList;
    }

}
