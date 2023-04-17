package com.example.combination.domain;

import com.example.combination.file.service.analyze.SelfCompareAnalyzer;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class SelfSubSetInfos {

    protected Map<Integer, Map<Set<Integer>, Integer>> allSubSets = new HashMap<>();

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

        if (!allSubSets.containsKey(elementCount)) {
            singleSubset = new HashMap<>();
            singleSubset.put(intersection, 1);

        } else {
            singleSubset = allSubSets.get(elementCount);
            if (!singleSubset.containsKey(intersection)) {
                singleSubset.put(intersection, 1);
            } else {
                singleSubset.put(intersection, singleSubset.get(intersection) + 1);
            }
        }

        allSubSets.put(elementCount, singleSubset);
    }

    public void reportStatics() {
        Set<Integer> elementCounts = allSubSets.keySet();

        reposrtAllGroupSubset(elementCounts);
    }

    private void reposrtAllGroupSubset(Set<Integer> elementCounts) {
        for (int elementCount : elementCounts) {
            int totalCount = 0;
            log.debug("ElementCount : {}", elementCount);

            Map<Set<Integer>, Integer> sameElementCountGroup = allSubSets.get(elementCount);

            ArrayList<Map.Entry<Set<Integer>, Integer>> sortedList = getSortedList(sameElementCountGroup);

            reportSingleSubset(elementCount, totalCount, sortedList);
        }
    }

    private static void reportSingleSubset(int elementCount, int totalCount, ArrayList<Map.Entry<Set<Integer>, Integer>> sortedList) {
        for (Map.Entry<Set<Integer>, Integer> subset : sortedList) {
            Integer duplicateCount = subset.getValue();
            log.debug("{} : {}", subset.getKey(), duplicateCount);
            totalCount += duplicateCount;
        }
        log.debug("ElementCount : {}, total count : {}", elementCount, totalCount);
    }

    private static ArrayList<Map.Entry<Set<Integer>, Integer>> getSortedList(Map<Set<Integer>, Integer> sameElementCountGroup) {
        Comparator<Map.Entry<Set<Integer>, Integer>> comparator = new Comparator<>() {
            @Override
            public int compare(Map.Entry<Set<Integer>, Integer> o1, Map.Entry<Set<Integer>, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        };

        ArrayList<Map.Entry<Set<Integer>, Integer>> sortedList = new ArrayList<>(sameElementCountGroup.entrySet());
        Collections.sort(sortedList, comparator);
        return sortedList;
    }


}
