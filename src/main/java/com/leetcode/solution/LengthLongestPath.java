package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/longest-absolute-file-path/
 * 388. 文件的最长绝对路径
 */
public class LengthLongestPath {
    public static void main(String[] args) {
        System.out.println(new LengthLongestPath().lengthLongestPath("a\n\tb\n\t\tc\n\t\t\td\n\t\t\t\te.txt\n\t\t\t\talsdkjf.txt\n\t\tskdjfl.txtlsdkjflsdjflsajdflkjasklfjkasljfklas\n\tlskdjflkajsflj.txt"));
    }

    public int lengthLongestPath(String input) {
        int result = 0;
        String rootDir = "";
        List<String> filePathList = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '\n') {
                if (isRootDir(path.toString())) {
                    rootDir = path.toString();
                    filePathList = new ArrayList<>();
                } else if (isFile(path.toString())) {
                    // 拼接现有的路径
                    result = getResult(rootDir, filePathList, path, result);
                } else {
                    // 文件夹
                    int size = filePathList.size();
                    if (size > 0) {
                        // 上一个是文件夹 && 当前是文件夹 => 当前文件夹层级替换至同一级别
                        // 当前文件夹层级 => \t\tbb
                        // 上一个文件夹层级 => \t\t\t\td
                        // filePathList = [\ta, \t\tb, \t\t\tc, \t\t\t\td]
                        // => filePathList =>[\ta, \t\tbb]
                        int pathLevel = getLevelDir(path.toString());
                        int lastPathLevelInList = getLevelDir(filePathList.get(size - 1));
                        if (lastPathLevelInList >= pathLevel) {
                            filePathList = filePathList.subList(0, Math.max(pathLevel - 1, 0));
                        }
                    }
                    filePathList.add(path.toString());
                }
                path = new StringBuilder();
            } else {
                path.append(input.charAt(i));
            }
        }

        String str = path.toString();
        if (isFile(str)) {
            // 拼接现有的路径
            result = getResult(rootDir, filePathList, path, result);
        }

        return result;
    }

    private int getResult(String rootDir, List<String> filePathList, StringBuilder path, int result) {
        if (filePathList.size() > 0) {
            int pathLevel = getLevelDir(path.toString());
            int lastPathLevelInList = getLevelDir(filePathList.get(filePathList.size() - 1));
            if (lastPathLevelInList >= pathLevel) {
                filePathList = filePathList.subList(0, Math.max(pathLevel - 1, 0));
            }
        }
        int currentLength = rootDir.length();
        for (String s : filePathList) {
            String currentStr = deleteTabulator(s);
            currentLength = currentLength == 0 ? currentStr.length() : (currentLength + 1 + currentStr.length());
        }
        String str = deleteTabulator(path.toString());
        currentLength = currentLength == 0 ? str.length() : (currentLength + 1 + str.length());
        return Math.max(result, currentLength);
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
        return isDir(path) && !path.startsWith("\t");
    }

    public int getLevelDir(String path) {
        if (path.startsWith("\t")) {
            return 1 + getLevelDir(path.substring(1));
        } else {
            return 0;
        }
    }

    public boolean isDir(String path) {
        return path.indexOf('.') < 0;
    }

    public boolean isFile(String path) {
        return path.indexOf('.') >= 0 && path.charAt(0) != '.' && path.charAt(path.length() - 1) != '.';
    }
}
