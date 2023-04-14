package com.example.combination.file.service.analyze;

import com.example.combination.domain.AnalyzeInfo;
import com.example.combination.domain.GameInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class EachCompareAnalyzer extends CompareAnalyzerAbstract {

    private static final int MINIMUM_INTERSECTION_COUNT = 4;

    public void compare(List<GameInfo> controlNumberSetGroup, List<GameInfo> experimentalNumberSetGroup) {
        for (GameInfo controlNumberSet : controlNumberSetGroup) {

            for (GameInfo experimentalNumberSet : experimentalNumberSetGroup) {

                compareEachNumberSets(controlNumberSet, experimentalNumberSet, MINIMUM_INTERSECTION_COUNT);
            }
        }
    }

    public void report() {
        log.debug("======\t{}\t///EachCompare///TotalCount======", results.size());
        for (AnalyzeInfo analyzeInfo : results) {
            log.debug("[Win{} vs My{}]\t\t{}\t\t{}\t\t{}\t\t\t{}"
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
