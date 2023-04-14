package com.example.combination.file.service.analyze;

import com.example.combination.domain.AnalyzeInfo;
import com.example.combination.domain.GameInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Slf4j
@Component
public class SelfCompareAnalyzer extends CompareAnalyzerAbstract {

    private static final int MINIMUM_INTERSECTION_COUNT = 2;

    public void compare(List<GameInfo> controlNumberSetGroup, List<GameInfo> experimentalNumberSetGroup) {
        for (int i = 0; i < controlNumberSetGroup.size(); i++) {
            GameInfo controlNumberSet = controlNumberSetGroup.get(i);

            for (int j = i + 1; j < experimentalNumberSetGroup.size(); j++) {
                GameInfo experimentalNumberSet = experimentalNumberSetGroup.get(j);

                compareEachNumberSets(controlNumberSet, experimentalNumberSet, MINIMUM_INTERSECTION_COUNT);
            }
        }
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
