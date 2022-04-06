package com.leetcode.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindSubstring {
    public static void main(String[] args) {
        System.out.println(new FindSubstring().findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo", "barr", "wing", "ding", "wing"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int targetLength = words.length;
        int wordLength = words[1].length();
        List<String> splitList = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\w{" + wordLength + "}").matcher(s);
        while (matcher.find()) {
            splitList.add(matcher.group());
        }
        int splitListLength = splitList.size();
        if (targetLength > splitListLength) {
            return Collections.emptyList();
        }
        if (targetLength == splitListLength && isEqual(splitList, words)) {
            return Collections.singletonList(0);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= splitListLength - targetLength; i++) {
            List<String> source = new ArrayList<>(splitList).subList(i, i + targetLength);
            if (isEqual(source, words)) {
                result.add(i * wordLength);
            }
        }
        return result;
    }

    public boolean isEqual(List<String> source, String[] target) {
        for (String targetStr : target) {
            if (source.contains(targetStr)) {
                source.remove(targetStr);
            } else {
                return false;
            }
        }
        return true;
    }
}
