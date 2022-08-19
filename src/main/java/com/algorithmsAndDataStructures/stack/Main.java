package com.algorithmsAndDataStructures.stack;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        lambdaTest();
    }

    public static void lambdaTest() {
        List<Integer> nums = Arrays.asList(1, 2, 3);
        nums.forEach(num -> System.out.println(num));
    }

}
