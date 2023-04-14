package com.example.combination.common.util;

import com.example.combination.domain.CompareAdapter;
import com.example.combination.domain.GameInfo;
import com.example.combination.file.service.analyze.CompareAnalyzer;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class ExcelFileReaderTest {

    @Autowired
    CompareAnalyzer selfCompareAnalyzer;

    @Autowired
    CompareAnalyzer eachCompareAnalyzer;

    @Test
    public void test() {
        //given
//        String filePath = "./upload-dir/";
        String filePath = "/Users/davideugen/Downloads/";
        String fileName = "example.xlsx";
//        String fileName = "test.xlsx";

        ExcelFileReader excelFileReader = new ExcelFileReader(filePath + fileName);

        Sheet myEditSheet = excelFileReader.getSheet("MYEDIT");
        Sheet winOnlySheet = excelFileReader.getSheet("winOnly");

        List<GameInfo> myList = excelFileReader.getSetList(myEditSheet);
        List<GameInfo> winList = excelFileReader.getSetList(winOnlySheet);

        selfCompareAnalyzer.analyze(new CompareAdapter(myList,myList));
//        selfCompareAnalyzer.report();
        selfCompareAnalyzer.reportByElement(2);

        eachCompareAnalyzer.analyze(new CompareAdapter(winList,myList));
//        eachCompareAnalyzer.report();
        eachCompareAnalyzer.reportByElement(4);

    }
}