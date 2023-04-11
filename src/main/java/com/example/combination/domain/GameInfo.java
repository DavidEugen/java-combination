package com.example.combination.domain;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class GameInfo {
    private int drawing;
    private Set<Integer> numbers;

    public GameInfo(int drawing) {
        this.drawing = drawing;
        numbers = new HashSet<>();
    }

    public GameInfo(int drawing, Set<Integer> numbers) {
        this.drawing = drawing;
        this.numbers = numbers;
    }

    public void add(int number) {
        numbers.add(number);
    }
}
