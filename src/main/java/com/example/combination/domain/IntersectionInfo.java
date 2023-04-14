package com.example.combination.domain;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class IntersectionInfo {

    //대조군
    private GameInfo controlNumberSet;
    //실험군
    private GameInfo experimentalNumberSet;

    //교집합
    private Set<Integer> intersection = new HashSet<>();

    public IntersectionInfo(GameInfo controlNumberSet, GameInfo experimentalNumberSet) {
        this.controlNumberSet = controlNumberSet;
        this.experimentalNumberSet = experimentalNumberSet;
    }

    public int size() {
        return intersection.size();
    }
}
