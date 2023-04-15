package com.example.combination.file.service.analyze;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Slf4j
class SelfCompareAnalyzerTest {

    @Test
    void mapSetEqualTest() {
        //given
        Set<Integer> set1 = new TreeSet<>();
        set1.add(3);
        set1.add(2);
        set1.add(1);

        Set<Integer> set2 = new TreeSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);

        Set<Integer> set3 = new TreeSet<>();
        set3.add(4);
        set3.add(2);
        set3.add(3);

        //when
        HashMap<Set<Integer>, String> mapSets = new HashMap<>();
        mapSets.put(set2, "Second");
        mapSets.put(set1, "First");
        mapSets.put(set3, "Third");


        //then
        log.debug("{}",mapSets);
    }

}