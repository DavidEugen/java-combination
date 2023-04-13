package com.example.combination.file.service;

import com.example.combination.domain.AnalyzeInfo;
import com.example.combination.domain.CompareAdapter;
import com.example.combination.domain.GameInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
public class SelfCompareAnalyzer implements CompareAnalyzer{

    private static final int MINIMUM_INTER_SECTION_COUNT = 2;
    List<AnalyzeInfo> compareInforms = new ArrayList<>();

    public SelfCompareAnalyzer() {
    }

    public void compare(CompareAdapter compareAdapter) {

        List<GameInfo> controlSetList = compareAdapter.getControlSetList();
        List<GameInfo> compareSetList = compareAdapter.getCompareSetList();

        for (int i = 0; i < controlSetList.size(); i++) {
            GameInfo controlNumbersInfo = controlSetList.get(i);

            for (int j = i + 1; j < compareSetList.size(); j++) {
                GameInfo comparingNumbersInfo = compareSetList.get(j);

                compareHandler(controlNumbersInfo, comparingNumbersInfo);

            }

        }
    }

    private void compareHandler(GameInfo controlNumbersInfo, GameInfo comparingNumbersInfo) {
        AnalyzeInfo analyzeInfo = new AnalyzeInfo(controlNumbersInfo, comparingNumbersInfo);

        //교집합 실행
        Set<Integer> comparedNumbers = new HashSet<>(comparingNumbersInfo.getNumbers());
        comparedNumbers.retainAll(controlNumbersInfo.getNumbers());

        if (comparedNumbers.size() > MINIMUM_INTER_SECTION_COUNT-1) {
            analyzeInfo.setIntersectionSet(comparedNumbers);
            analyzeInfo.setMaxDuplicateCount(comparedNumbers.size());
            compareInforms.add(analyzeInfo);
        }
    }

    public void analyze() {
        log.debug("======\t{}\t///SelfCompare///TotalCount======",compareInforms.size());
        for (AnalyzeInfo analyzeInfo : compareInforms) {
            log.debug("[{} vs {}]\t\t{}\t\t{}\t\t{}\t\t\t{}"
                    ,analyzeInfo.getControlNumbersInfo().getDrawing()
                    ,analyzeInfo.getComparingNumbersInfo().getDrawing()
                    ,analyzeInfo.getMaxDuplicateCount()
                    ,analyzeInfo.getIntersectionSet()
                    ,analyzeInfo.getControlNumbersInfo().getNumbers()
                    ,analyzeInfo.getComparingNumbersInfo().getNumbers()
            );

        }
    }


}
