package com.example.combination.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class CombinationTest {

    @Test
    void getCombinationSetRecursiveTest() {
        Set<Set<Integer>> combinationsRecursive = Combination.getCombinationsRecursive(4, 2);
        Set<Set<Integer>> combinationsLoop = Combination.getCombinationsLoop(4, 2);
        assertThat(combinationsRecursive).isEqualTo(combinationsLoop);

        log.debug("combinationsRecursive : {}", combinationsRecursive);
        log.debug("combinationsLoop : {}", combinationsLoop);
    }

}