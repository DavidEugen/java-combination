package com.example.combination.domain;

import lombok.Data;

import java.util.Set;

@Data
public class AnalyzeInfo {
    private GameInfo controlNumbersInfo;
    private GameInfo comparingNumbersInfo;
    private int maxDuplicateCount;
    private Set<Integer> intersectionSet;

    public AnalyzeInfo(GameInfo controlNumbersInfo, GameInfo comparingNumbersInfo) {
        this.controlNumbersInfo = controlNumbersInfo;
        this.comparingNumbersInfo = comparingNumbersInfo;
    }
}
