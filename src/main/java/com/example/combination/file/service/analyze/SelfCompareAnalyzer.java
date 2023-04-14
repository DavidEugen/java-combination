package com.example.combination.file.service.analyze;

import com.example.combination.domain.IntersectionInfo;
import com.example.combination.domain.GameInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class SelfCompareAnalyzer extends CompareAnalyzerAbstract {

    private static final int MINIMUM_INTERSECTION_COUNT = 3;

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
        List<IntersectionInfo> intersections = analyzeReport.getIntersections();

        log.debug("======\t{}\t///SelfCompare///TotalCount======", intersections.size());
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
