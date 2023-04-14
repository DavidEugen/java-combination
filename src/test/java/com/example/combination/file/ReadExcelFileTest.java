package com.example.combination.file;

import com.example.combination.domain.CompareAdapter;
import com.example.combination.domain.GameInfo;
import com.example.combination.file.service.analyze.CompareAnalyzer;
import com.example.combination.file.service.ExcelFileReader;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class ReadExcelFileTest {

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

        ExcelFileReader excelFileReader = new ExcelFileReader(filePath + fileName);

        List<GameInfo> winList = excelFileReader.getSetList("winOnly");
        List<GameInfo> myList = excelFileReader.getSetList("MYEDIT");

        selfCompareAnalyzer.compare(new CompareAdapter(myList,myList));
        selfCompareAnalyzer.analyze();

        eachCompareAnalyzer.compare(new CompareAdapter(winList,myList));
        eachCompareAnalyzer.analyze();


    }
}