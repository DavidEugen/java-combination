package com.example.combination.domain;

import java.util.*;

public class Combination {
    public static Set<Set<Integer>> getCombinationsRecursive(int n, int r) {
        Set<Set<Integer>> combinations = new HashSet<>();

        if (n < r) {
            return combinations;
        }

        if (r == 0) {
            combinations.add(new HashSet<>());
            return combinations;
        }

        if (n == r) {
            Set<Integer> combination = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                combination.add(i);
            }
            combinations.add(combination);
            return combinations;
        }

        Set<Set<Integer>> subsets = getCombinationsRecursive(n - 1, r - 1);

        for (Set<Integer> subset : subsets) {
            subset.add(n);
            combinations.add(subset);
        }

        combinations.addAll(getCombinationsRecursive(n - 1, r));

        return combinations;
    }

    public static Set<Set<Integer>> getCombinationsLoop(int n, int r) {
        Set<Set<Integer>> combinations = new HashSet<>();

        if (n < r) {
            return combinations;
        }

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

        boolean[] select = new boolean[n];
        Arrays.fill(select, false);
        for (int i = 0; i < r; i++) {
            select[i] = true;
        }

        do {
            Set<Integer> combination = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (select[i]) {
                    combination.add(numbers[i]);
                }
            }
            combinations.add(combination);
        } while (nextCombination(select));

        return combinations;
    }

    public static boolean nextCombination(boolean[] select) {
        int i = select.length - 1;
        while (i >= 0 && select[i]) {
            i--;
        }
        if (i < 0) {
            return false;
        }

        select[i] = true;
        for (int j = i + 1; j < select.length; j++) {
            select[j] = false;
        }

        return true;
    }
}
