package com.example.combination.file.service.analyze;

import com.example.combination.domain.CompareAdapter;

public interface CompareAnalyzer {
    void analyze(CompareAdapter compareAdapter);

    void report();
}
