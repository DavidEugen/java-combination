package com.example.combination.file.service.analyze;

import com.example.combination.domain.CompareAdapter;
import com.example.combination.domain.GameInfo;
import com.example.combination.domain.IntersectionInfo;

import java.util.List;
import java.util.TreeSet;

public interface CompareAnalyzer {
    void analyze(CompareAdapter compareAdapter);

    void compareEachGroup(List<GameInfo> controlNumberSetGroup, List<GameInfo> experimentalNumberSetGroup);

    TreeSet<Integer> getElementCounts();

    List<IntersectionInfo> getIntersectionByElementCount(int count);
}
