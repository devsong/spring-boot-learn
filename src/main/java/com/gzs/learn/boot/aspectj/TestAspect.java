package com.gzs.learn.boot.aspectj;

import org.springframework.stereotype.Component;

@Component
public class TestAspect {
    @AspBefore(isCheck = true)
    public void test() {
        System.out.println("test");
    }
}
