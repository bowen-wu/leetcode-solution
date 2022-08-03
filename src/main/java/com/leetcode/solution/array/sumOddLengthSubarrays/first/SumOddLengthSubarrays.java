package com.leetcode.solution.array.sumOddLengthSubarrays.first;

import com.leetcode.solution.array.sumOddLengthSubarrays.SumOddLengthSubarraysTemplate;

public class SumOddLengthSubarrays extends SumOddLengthSubarraysTemplate {
    public static void main(String[] args) {
        System.out.println(new SumOddLengthSubarrays().sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
    }

    @Override
    public int sumOddLengthSubarrays(int[] arr) {
        // 时间复杂度：O(n^2)
        // 空间复杂度：O(n)
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[] prefixSum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int len = 1; i + len <= arr.length; len += 2) {
                result += prefixSum[i + len] - prefixSum[i];
            }
        }

        return result;
    }

    public int sumOddLengthSubarraysBefore(int[] arr) {
        // 时间复杂度：O(n^2)
        // 空间复杂度：O(n)
        int[] prefixSum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        int currentOdd = 3;
        int result = prefixSum[arr.length];
        while (currentOdd <= arr.length) {
            int start = 0;
            int end = start + currentOdd - 1;
            while ((start + currentOdd) <= arr.length) {
                result += (prefixSum[end - 1] - prefixSum[start]);
                start++;
            }
            currentOdd += 2;
        }

        return result;
    }


    public int sumOddLengthSubarraysBruteForce(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            // 此处可以取到最后一位。eg. length = 5, i = 0, len = 5
            for (int len = 1; i + len <= arr.length; len = len + 2) {
                for (int j = i; j < i + len; j++) {
                    result += arr[j];
                }
            }
        }

        return result;
    }
}
