package com.example.combination.domain;

import com.example.combination.file.service.analyze.CompareAnalyzer;
import com.example.combination.file.service.analyze.SelfCompareAnalyzer;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class SelfSubSetInfos {

    protected Map<Integer, Map<Set<Integer>, Integer>> subSets = new HashMap<>();

    SelfCompareAnalyzer selfCompareAnalyzer;

    public SelfSubSetInfos(SelfCompareAnalyzer selfCompareAnalyzer) {
        this.selfCompareAnalyzer = selfCompareAnalyzer;
    }

    public void getDuplicateSetCount() {
        Iterator<Integer> elementsCountGroup = selfCompareAnalyzer.getElementCounts().iterator();

        while (elementsCountGroup.hasNext()) {
            Integer elementsCount = elementsCountGroup.next();
            setSameElementCountGroup(elementsCount);
        }
    }

    private void setSameElementCountGroup(Integer elementsCount) {
        List<IntersectionInfo> intersectionInfos = selfCompareAnalyzer.getIntersectionStatistics().get(elementsCount);
        for (IntersectionInfo intersectionInfo : intersectionInfos) {
            putSingleIntersection(intersectionInfo);
        }
    }

    private void putSingleIntersection(IntersectionInfo intersectionInfo) {
        Set<Integer> intersection = intersectionInfo.getIntersection();
        int elementCount = intersection.size();

        Map<Set<Integer>, Integer> singleSubset;

        if (!subSets.containsKey(elementCount)) {
            singleSubset = new HashMap<>();
            singleSubset.put(intersection, 1);

        } else {
            singleSubset = subSets.get(elementCount);
            if (!singleSubset.containsKey(intersection)) {
                singleSubset.put(intersection, 1);
            } else {
                singleSubset.put(intersection, singleSubset.get(intersection) + 1);
            }

        }

        subSets.put(elementCount, singleSubset);
    }

    public void reportStatics() {
        Set<Integer> elementCounts = subSets.keySet();

        for (int elementCount :elementCounts) {
            int totalCount = 0;
            log.debug("ElementCount : {}",elementCount);
            Map<Set<Integer>, Integer> setIntegerMap = subSets.get(elementCount);
            Set<Set<Integer>> subset = setIntegerMap.keySet();
            for (Set<Integer> subsetNumbers :subset) {
                Integer singleSubsetCount = setIntegerMap.get(subsetNumbers);
                log.debug("{} : {}", subsetNumbers, singleSubsetCount);
                totalCount += singleSubsetCount;
            }
            log.debug("ElementCount : {}, total count : {}",elementCount,totalCount);
        }

    }

}
