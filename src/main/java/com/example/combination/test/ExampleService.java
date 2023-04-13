package com.example.combination.test;

import org.springframework.stereotype.Component;

@Component
public class ExampleService {
    public long longRunningMethod() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 2000;
    }
}
