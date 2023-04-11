package com.example.combination.file.service;

import com.example.combination.domain.CompareAdapter;
import com.example.combination.domain.GameInfo;

import java.util.List;

public interface CompareAnalyzer {
    void analyze();

    void compare(CompareAdapter compareAdapter);
}
