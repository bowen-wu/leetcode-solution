package com.leetcode.solution.depthFirstSearch.someTree.third;

import com.leetcode.solution.depthFirstSearch.TreeNode;
import com.leetcode.solution.depthFirstSearch.someTree.IsSameTreeTemplate;

public class IsSameTree extends IsSameTreeTemplate {
    @Override
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Ideas: divide and conquer
        // 		分治问题 => 两棵树是否相同
        //		子问题和原问题关系 => 原问题 = 子问题 left + 子问题 right + p.val == q.val
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
