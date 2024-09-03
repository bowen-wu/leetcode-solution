package com.leetcode.solution.doublePointer.maximizeTheConfusionOfAnExam.first;

import com.leetcode.solution.doublePointer.maximizeTheConfusionOfAnExam.MaximizeTheConfusionOfAnExamTemplate;

public class MaximizeTheConfusionOfAnExam extends MaximizeTheConfusionOfAnExamTemplate {
    @Override
    public int maxConsecutiveAnswers(String answerKey, int k) {
        if (answerKey == null || answerKey.length() == 0) {
            return 0;
        }

        return Math.max(maxConsecutiveChar(answerKey, k, 'T'), maxConsecutiveChar(answerKey, k, 'F'));
    }

    private int maxConsecutiveChar(String answerKey, int k, char ch) {
        int len = answerKey.length();
        int changed = 0;
        int j = 0;
        int result = 0;

        for (int i = 0; i < len; i++) {
            while (j < len) {
                if (answerKey.charAt(j) == ch || changed < k) {
                    if (answerKey.charAt(j) != ch) {
                        changed++;
                    }

                    j++;
                } else {
                    break;
                }
            }

            result = Math.max(result, j - i);
            if (answerKey.charAt(i) != ch) {
                changed--;
            }
        }

        return result;
    }
}
