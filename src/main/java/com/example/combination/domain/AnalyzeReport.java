package com.example.combination.domain;

import com.sun.source.tree.Tree;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
public class AnalyzeReport {

    private Map<Integer, List<IntersectionInfo>> subSetsByElementCount = new HashMap<>();

    public void add(IntersectionInfo intersectionInfo) {

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
            return new ArrayList<>();
        }
        return subSetsByElementCount.get(count);
    }

    public TreeSet<Integer> getElementCounts() {
        return new TreeSet<>(subSetsByElementCount.keySet());
    }
}
