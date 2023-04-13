package com.example.combination.test;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MethodExecutionTimeAspectTest {

    @Autowired
    private ExampleService exampleService;

    @Test
    public void testExecutionTime() {
        long executionTime = exampleService.longRunningMethod();
        assertTrue(executionTime > 1000);
    }
}