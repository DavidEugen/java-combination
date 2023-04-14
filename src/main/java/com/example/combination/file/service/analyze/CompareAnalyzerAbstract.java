package com.example.combination.file.service.analyze;

import com.example.combination.domain.AnalyzeInfo;
import com.example.combination.domain.CompareAdapter;
import com.example.combination.domain.GameInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class CompareAnalyzerAbstract implements CompareAnalyzer{

    protected List<AnalyzeInfo> results = new ArrayList<>();
    public void analyze(CompareAdapter compareAdapter) {
        List<GameInfo> controlNumberSetGroup = compareAdapter.getControlNumberSetGroup();
        List<GameInfo> experimentalNumberSetGroup = compareAdapter.getExperimentalNumberSetGroup();

        compare(controlNumberSetGroup, experimentalNumberSetGroup);
    }

    protected Set<Integer> getIntersection(GameInfo controlNumbersInfo, GameInfo comparingNumbersInfo) {
        //교집합 비교 실행
        Set<Integer> comparedNumbers = new TreeSet<>(comparingNumbersInfo.getNumbers());
        comparedNumbers.retainAll(controlNumbersInfo.getNumbers());

        return comparedNumbers;
    }

    protected void compareEachNumberSets(GameInfo controlNumberSet, GameInfo experimentalNumberSet, int compareMinimumCount) {
        AnalyzeInfo analyzeInfo = new AnalyzeInfo(controlNumberSet, experimentalNumberSet);
        Set<Integer> intersection = getIntersection(controlNumberSet, experimentalNumberSet);
        if (intersection.size() >= compareMinimumCount ) {
            analyzeInfo.setIntersection(intersection);
            results.add(analyzeInfo);
        }
    }

}
