package com.example.combination.domain;

import lombok.Data;

import java.util.List;

@Data
public class CompareAdapter {
    List<GameInfo> controlSetList;
    List<GameInfo> compareSetList;

    public CompareAdapter(List<GameInfo> controlSetList, List<GameInfo> compareSetList) {
        this.controlSetList = controlSetList;
        this.compareSetList = compareSetList;
    }
}
