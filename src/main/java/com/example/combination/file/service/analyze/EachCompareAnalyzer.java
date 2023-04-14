package com.example.combination.file.service.analyze;

import com.example.combination.domain.IntersectionInfo;
import com.example.combination.domain.GameInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class EachCompareAnalyzer extends CompareAnalyzerAbstract {

    public void compareEachGroup(List<GameInfo> controlNumberSetGroup, List<GameInfo> experimentalNumberSetGroup) {
        for (GameInfo controlNumberSet : controlNumberSetGroup) {

            for (GameInfo experimentalNumberSet : experimentalNumberSetGroup) {

                compareEachNumberSets(controlNumberSet, experimentalNumberSet);
            }
        }
    }

    public void reportByElement(int count) {
        List<IntersectionInfo> intersections = analyzeReport.getIntersectionByElementCount(count);

        log.debug("======[[[EachCompare]]] \t{}\t TotalCount: \t{}\t======", count, intersections.size());
        for (IntersectionInfo intersectionInfo : intersections) {
            log.debug("[Win{} vs My{}]\t\t{}\t\t{}\t\t{}\t\t\t{}"
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
