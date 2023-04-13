package com.example.combination.domain;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Data
public class GameInfo {
    private int drawing;
    private Set<Integer> numbers;

    public GameInfo(int drawing) {
        this.drawing = drawing;
        numbers = new TreeSet<>();
    }

    public GameInfo(int drawing, Set<Integer> numbers) {
        this.drawing = drawing;
        this.numbers = numbers;
    }

    public void add(int number) {
        numbers.add(number);
    }
}
