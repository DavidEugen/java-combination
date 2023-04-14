package com.example.combination.file.service.analyze;

import com.example.combination.domain.IntersectionInfo;
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

                compareEachNumberSets(controlNumberSet, experimentalNumberSet);
            }
        }
    }

    public void report() {
        List<IntersectionInfo> intersections = analyzeReport.getIntersectionCases();

        log.debug("======\t{}\t///EachCompare///TotalCount======", intersections.size());
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

    public void reportByElement(int count) {
        List<IntersectionInfo> intersections = analyzeReport.getSubSetsByElementCount(count);

        log.debug("======\t{}\t///EachCompare///TotalCount======", intersections.size());
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
