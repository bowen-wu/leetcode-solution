package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/longest-absolute-file-path/
 * 388. 文件的最长绝对路径
 */
public class LengthLongestPath {
    public static void main(String[] args) {
        System.out.println(new LengthLongestPath().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }

    // 时间复杂度：
    // 空间复杂度：
    public int lengthLongestPath(String input) {
        int result = 0;
        String rootDir = "";
        List<String> filePathList = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '\n') {
                path.append(input.charAt(i));
            }
            if (input.charAt(i) == '\n' || i == input.length() - 1) {
                String pathStr = path.toString();
                if (isRootDir(pathStr)) {
                    rootDir = pathStr;
                    filePathList = new ArrayList<>();
                } else {
                    // 上一个是文件夹 && 当前是文件夹 => 当前文件夹层级替换至同一级别
                    // 当前文件夹层级 => \t\tbb
                    // 上一个文件夹层级 => \t\t\t\td
                    // filePathList = [\ta, \t\tb, \t\t\tc, \t\t\t\td]
                    // => filePathList =>[\ta, \t\tbb]
                    if (filePathList.size() > 0) {
                        int pathLevel = getLevelDir(pathStr);
                        int lastPathLevelInList = getLevelDir(filePathList.get(filePathList.size() - 1));
                        if (lastPathLevelInList >= pathLevel) {
                            filePathList = filePathList.subList(0, Math.max(pathLevel - 1, 0));
                        }
                    }
                    if (isFile(pathStr)) {
                        int currentLength = rootDir.length();
                        for (String s : filePathList) {
                            String currentStr = deleteTabulator(s);
                            currentLength = currentLength == 0 ? currentStr.length() : (currentLength + 1 + currentStr.length());
                        }
                        String str = deleteTabulator(pathStr);
                        currentLength = currentLength == 0 ? str.length() : (currentLength + 1 + str.length());
                        result = Math.max(result, currentLength);
                    } else {
                        // 文件夹
                        filePathList.add(pathStr);
                    }
                }

                path = new StringBuilder();
            }
        }

        return result;
    }

    public String deleteTabulator(String str) {
        while (str.startsWith("        ")) {
            str = str.substring(4);
            return str;
        }
        while (str.startsWith("    ")) {
            str = str.trim();
            return str;
        }
        while (str.startsWith("\t")) {
            str = str.substring(1);
        }

        return str;
    }

    public boolean isRootDir(String path) {
        return path.indexOf('.') < 0 && !path.startsWith("\t");
    }

    public int getLevelDir(String path) {
        if (path.startsWith("\t")) {
            return 1 + getLevelDir(path.substring(1));
        } else {
            return 0;
        }
    }

    public boolean isFile(String path) {
        return path.indexOf('.') >= 0 && path.charAt(0) != '.' && path.charAt(path.length() - 1) != '.';
    }
}
