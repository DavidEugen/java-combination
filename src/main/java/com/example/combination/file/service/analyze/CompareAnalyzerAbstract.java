package com.example.combination.file.service.analyze;

import com.example.combination.domain.CompareAdapter;
import com.example.combination.domain.GameInfo;
import com.example.combination.domain.IntersectionInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public abstract class CompareAnalyzerAbstract implements CompareAnalyzer{

    private static final int MINIMUM_INTERSECTION_COUNT = 2; //유의미한 교집합 원소 개수

    protected Map<Integer, List<IntersectionInfo>> intersectionByElementCount = new HashMap<>();

    public void analyze(CompareAdapter compareAdapter) {
        List<GameInfo> controlNumberSetGroup = compareAdapter.getControlNumberSetGroup();
        List<GameInfo> experimentalNumberSetGroup = compareAdapter.getExperimentalNumberSetGroup();

        compareEachGroup(controlNumberSetGroup, experimentalNumberSetGroup);
    }

    protected void compareEachNumberSets(GameInfo controlNumberSet, GameInfo experimentalNumberSet) {
        IntersectionInfo intersectionInfo = new IntersectionInfo(controlNumberSet, experimentalNumberSet);
        Set<Integer> intersection = getIntersection(controlNumberSet, experimentalNumberSet);
        if (intersection.size() >= MINIMUM_INTERSECTION_COUNT ) {
            intersectionInfo.setIntersection(intersection);
            add(intersectionInfo);
        }
    }

    protected Set<Integer> getIntersection(GameInfo controlNumbersInfo, GameInfo experimentalNumberSet) {
        //교집합 비교 실행
        Set<Integer> intersection = new HashSet<>(experimentalNumberSet.getNumbers());
        intersection.retainAll(controlNumbersInfo.getNumbers());

        return intersection;
    }

    protected void add(IntersectionInfo intersectionInfo) {
        int size = intersectionInfo.size();
        if (!intersectionByElementCount.containsKey(size)) {
            ArrayList<IntersectionInfo> infos = new ArrayList<>();
            infos.add(intersectionInfo);
            intersectionByElementCount.put(size, infos);
        } else {
            intersectionByElementCount.get(size).add(intersectionInfo);
        }
    }

    public List<IntersectionInfo> getIntersectionByElementCount(int count) {
        // 해당 메소드 개별로 호출시 validation,
        // MINIMUM_INTERSECTION_COUNT 에 따라 없는 경우도 있음
        if (!intersectionByElementCount.containsKey(count)) {
            return new ArrayList<>();
        }
        return intersectionByElementCount.get(count);
    }

    public TreeSet<Integer> getElementCounts() {
        return new TreeSet<>(intersectionByElementCount.keySet());
    }



}
