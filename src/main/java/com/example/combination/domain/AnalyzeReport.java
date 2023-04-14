package com.example.combination.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
public class AnalyzeReport {
    private List<IntersectionInfo> intersectionCases = new LinkedList<>();


    private Map<Integer, List<IntersectionInfo>> subSetsByElementCount = new HashMap<>();

    public void add(IntersectionInfo intersectionInfo) {
        intersectionCases.add(intersectionInfo);

        int size = intersectionInfo.size();
        if (!subSetsByElementCount.containsKey(size)) {
            ArrayList<IntersectionInfo> infos = new ArrayList<>();
            infos.add(intersectionInfo);
            subSetsByElementCount.put(size, infos);
        } else {
            subSetsByElementCount.get(size).add(intersectionInfo);
        }
    }

    public List<IntersectionInfo> getSubSetsByElementCount(int count) {
        if (!subSetsByElementCount.containsKey(count)) {
            return new ArrayList<IntersectionInfo>();
        }
        return subSetsByElementCount.get(count);
    }



}
