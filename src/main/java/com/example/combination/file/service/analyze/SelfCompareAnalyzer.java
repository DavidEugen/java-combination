package com.example.combination.file.service.analyze;

import com.example.combination.domain.GameInfo;
import com.example.combination.domain.IntersectionInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class SelfCompareAnalyzer extends CompareAnalyzerAbstract {

    public void compareEachGroup(List<GameInfo> controlNumberSetGroup, List<GameInfo> experimentalNumberSetGroup) {
        for (int i = 0; i < controlNumberSetGroup.size(); i++) {
            GameInfo controlNumberSet = controlNumberSetGroup.get(i);

            for (int j = i + 1; j < experimentalNumberSetGroup.size(); j++) {
                GameInfo experimentalNumberSet = experimentalNumberSetGroup.get(j);

                compareEachNumberSets(controlNumberSet, experimentalNumberSet);
            }
        }
    }

    public void reportByElement(int count) {
        List<IntersectionInfo> intersections = analyzeReport.getIntersectionByElementCount(count);

        log.debug("======[[[SelfCompare]]] \t{}\t TotalCount: \t{}\t======", count, intersections.size());
        for (IntersectionInfo intersectionInfo : intersections) {
            log.debug("[{} vs {}]\t\t{}\t\t{}\t\t{}\t\t\t{}"
                    , intersectionInfo.getControlNumberSet().getDrawing()
                    , intersectionInfo.getExperimentalNumberSet().getDrawing()
                    , intersectionInfo.getIntersection().size()
                    , intersectionInfo.getIntersection()
                    , intersectionInfo.getControlNumberSet().getNumbers()
                    , intersectionInfo.getExperimentalNumberSet().getNumbers()
            );
        }
    }
}
