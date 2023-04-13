package com.example.combination.file;

import com.example.combination.domain.CompareAdapter;
import com.example.combination.domain.GameInfo;
import com.example.combination.file.service.CompareAnalyzer;
import com.example.combination.file.service.EachCompareAnalyzer;
import com.example.combination.file.service.ExcelFileReader;
import com.example.combination.file.service.SelfCompareAnalyzer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ReadExcelFileTest {

    @Test
    public void test() {
        //given
//        String filePath = "./upload-dir/";
        String filePath = "/Users/davideugen/Downloads/";
        String fileName = "example.xlsx";

        ExcelFileReader excelFileReader = new ExcelFileReader(filePath + fileName);

        List<GameInfo> winList = excelFileReader.getSetList("winOnly");
        List<GameInfo> myList = excelFileReader.getSetList("MYEDIT");

        CompareAnalyzer selfCompareAnalyzer = new SelfCompareAnalyzer();
        selfCompareAnalyzer.compare(new CompareAdapter(myList,myList));
        selfCompareAnalyzer.analyze();

        CompareAnalyzer eachCompareAnalyzer = new EachCompareAnalyzer();
        eachCompareAnalyzer.compare(new CompareAdapter(winList,myList));
        eachCompareAnalyzer.analyze();


    }
}