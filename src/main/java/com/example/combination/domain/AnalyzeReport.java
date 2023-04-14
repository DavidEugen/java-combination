package com.example.combination.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
public class AnalyzeReport {
    private List<IntersectionInfo> intersections = new LinkedList<>();

    public void add(IntersectionInfo intersectionInfo) {
        intersections.add(intersectionInfo);
    }

    public void getSubSet() {
        for (IntersectionInfo intersection :intersections) {

        }
    }
}
