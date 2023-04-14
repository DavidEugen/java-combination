package com.example.combination.file.service.analyze;

import com.example.combination.domain.AnalyzeInfo;
import com.example.combination.domain.CompareAdapter;
import com.example.combination.domain.GameInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
public class SelfCompareAnalyzer implements CompareAnalyzer {

    private static final int MINIMUM_INTERSECTION_COUNT = 2;
    List<AnalyzeInfo> results = new ArrayList<>();

    public void analyze(CompareAdapter compareAdapter) {

        List<GameInfo> controlNumberSetGroup = compareAdapter.getControlNumberSetGroup();
        List<GameInfo> experimentalNumberSetGroup = compareAdapter.getExperimentalNumberSetGroup();

        for (int i = 0; i < controlNumberSetGroup.size(); i++) {
            GameInfo controlNumberSet = controlNumberSetGroup.get(i);

            for (int j = i + 1; j < experimentalNumberSetGroup.size(); j++) {
                GameInfo experimentalNumberSet = experimentalNumberSetGroup.get(j);

                AnalyzeInfo analyzeInfo = new AnalyzeInfo(controlNumberSet, experimentalNumberSet);
                Set<Integer> intersection = getIntersection(controlNumberSet, experimentalNumberSet);
                if (intersection.size() >= MINIMUM_INTERSECTION_COUNT ) {
                    analyzeInfo.setIntersection(intersection);
                    results.add(analyzeInfo);
                }
            }
        }
    }

    private Set<Integer> getIntersection(GameInfo controlNumbersInfo, GameInfo comparingNumbersInfo) {
        //교집합 비교 실행
        Set<Integer> comparedNumbers = new TreeSet<>(comparingNumbersInfo.getNumbers());
        comparedNumbers.retainAll(controlNumbersInfo.getNumbers());
        return comparedNumbers;
    }

    public void report() {
        log.debug("======\t{}\t///SelfCompare///TotalCount======", results.size());
        for (AnalyzeInfo analyzeInfo : results) {
            log.debug("[{} vs {}]\t\t{}\t\t{}\t\t{}\t\t\t{}"
                    , analyzeInfo.getControlNumberSet().getDrawing()
                    , analyzeInfo.getExperimentalNumberSet().getDrawing()
                    , analyzeInfo.getIntersection().size()
                    , analyzeInfo.getIntersection()
                    , analyzeInfo.getControlNumberSet().getNumbers()
                    , analyzeInfo.getExperimentalNumberSet().getNumbers()
            );
        }
    }
}
