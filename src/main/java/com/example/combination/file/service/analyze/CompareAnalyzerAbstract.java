package com.example.combination.file.service.analyze;

import com.example.combination.domain.IntersectionInfo;
import com.example.combination.domain.AnalyzeReport;
import com.example.combination.domain.CompareAdapter;
import com.example.combination.domain.GameInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public abstract class CompareAnalyzerAbstract implements CompareAnalyzer{

    protected AnalyzeReport analyzeReport;

    public CompareAnalyzerAbstract() {
        analyzeReport = new AnalyzeReport();
    }

    private static final int MINIMUM_INTERSECTION_COUNT = 3; //유의미한 교집합 원소 개수

    public void analyze(CompareAdapter compareAdapter) {
        List<GameInfo> controlNumberSetGroup = compareAdapter.getControlNumberSetGroup();
        List<GameInfo> experimentalNumberSetGroup = compareAdapter.getExperimentalNumberSetGroup();

        compare(controlNumberSetGroup, experimentalNumberSetGroup);
    }

    protected Set<Integer> getIntersection(GameInfo controlNumbersInfo, GameInfo experimentalNumberSet) {
        //교집합 비교 실행
        Set<Integer> intersection = new HashSet<>(experimentalNumberSet.getNumbers());
        intersection.retainAll(controlNumbersInfo.getNumbers());

        return intersection;
    }

    protected void compareEachNumberSets(GameInfo controlNumberSet, GameInfo experimentalNumberSet) {
        IntersectionInfo intersectionInfo = new IntersectionInfo(controlNumberSet, experimentalNumberSet);
        Set<Integer> intersection = getIntersection(controlNumberSet, experimentalNumberSet);
        if (intersection.size() >= MINIMUM_INTERSECTION_COUNT ) {
            intersectionInfo.setIntersection(intersection);
            analyzeReport.add(intersectionInfo);
        }
    }

    public void report() {
        Iterator<Integer> elementsCountGroup = analyzeReport.getElementCounts().iterator();
        while (elementsCountGroup.hasNext()) {
            Integer elementsCount = elementsCountGroup.next();
            reportByElement(elementsCount);
        }
    }
}
