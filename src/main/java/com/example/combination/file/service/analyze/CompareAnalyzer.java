package com.example.combination.file.service.analyze;

import com.example.combination.domain.CompareAdapter;
import com.example.combination.domain.GameInfo;

import java.util.List;

public interface CompareAnalyzer {
    void analyze(CompareAdapter compareAdapter);

    void report();

    void compareEachGroup(List<GameInfo> controlNumberSetGroup, List<GameInfo> experimentalNumberSetGroup);

    void reportByElement(int count);
}
