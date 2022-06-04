package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/unique-email-addresses/
 * 929. 独特的电子邮件地址
 */
public class NumUniqueEmails {
    public static void main(String[] args) {
        System.out.println(new NumUniqueEmails().numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
        System.out.println(new NumUniqueEmails().numUniqueEmails(new String[]{"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"}));
    }

    // 时间复杂度：O(n * m) => n 是 emails 的长度，m 是其中每个 email 的长度
    // 空间复杂度：O(n)
    public int numUniqueEmails(String[] emails) {
        Map<String, Integer> emailMap = new HashMap<>();
        for (String currentEmail : emails) {
            StringBuilder emailBuilder = new StringBuilder();
            boolean isHost = false;
            boolean isLost = false;
            for (int j = 0; j < currentEmail.length(); j++) {
                char currentChar = currentEmail.charAt(j);
                if (currentChar == '@') {
                    isHost = true;
                    isLost = false;
                    emailBuilder.append(currentChar);
                } else if (currentChar == '.') {
                    if (isHost) {
                        emailBuilder.append(currentChar);
                    }
                } else if (currentChar == '+') {
                    if (!isHost) {
                        isLost = true;
                    }
                } else {
                    if (isLost) {
                        continue;
                    }
                    emailBuilder.append(currentChar);
                }
            }
            emailMap.putIfAbsent(emailBuilder.toString(), 1);
        }
        return emailMap.size();
    }
}
