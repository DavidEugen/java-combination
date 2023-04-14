package com.example.combination.domain;

import com.example.combination.file.service.analyze.CompareAnalyzer;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;



@Slf4j
@Component
@NoArgsConstructor
public class AnalyzeReport {

    CompareAnalyzer compareAnalyzer;

    public AnalyzeReport(CompareAnalyzer compareAnalyzer) {
        this.compareAnalyzer = compareAnalyzer;
    }

    public void report(String analyzerName) {
        Iterator<Integer> elementsCountGroup = compareAnalyzer.getElementCounts().iterator();
        while (elementsCountGroup.hasNext()) {
            Integer elementsCount = elementsCountGroup.next();
            reportByElement(analyzerName, elementsCount);
        }
    }

    public void reportByElement(String analyzerName, int count) {
        List<IntersectionInfo> intersections = compareAnalyzer.getIntersectionByElementCount(count);

        log.debug("======[[[{}]]] \t{} Combination\t TotalCount: \t{}\t======", analyzerName, count, intersections.size());
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
