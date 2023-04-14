package com.example.combination.domain;

import lombok.Data;

import java.util.List;

@Data
public class CompareAdapter {
    List<GameInfo> controlNumberSetGroup;
    List<GameInfo> experimentalNumberSetGroup;

    public CompareAdapter(List<GameInfo> controlNumberSetGroup, List<GameInfo> experimentalNumberSetGroup) {
        this.controlNumberSetGroup = controlNumberSetGroup;
        this.experimentalNumberSetGroup = experimentalNumberSetGroup;
    }
}
