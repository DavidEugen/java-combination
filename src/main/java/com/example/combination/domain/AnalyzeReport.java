package com.example.combination.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
public class AnalyzeReport {

    private Map<Integer, List<IntersectionInfo>> intersectionByElementCount = new HashMap<>();

    public void add(IntersectionInfo intersectionInfo) {
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
        if (!intersectionByElementCount.containsKey(count)) {
            return new ArrayList<>();
        }
        return intersectionByElementCount.get(count);
    }

    public TreeSet<Integer> getElementCounts() {
        return new TreeSet<>(intersectionByElementCount.keySet());
    }
}
