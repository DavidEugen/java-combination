package com.example.combination.file.service;

import com.example.combination.domain.CompareAdapter;

public interface CompareAnalyzer {
    void analyze();

    void compare(CompareAdapter compareAdapter);
}
