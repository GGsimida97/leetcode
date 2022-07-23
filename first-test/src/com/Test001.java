package com;

import java.util.*;

public class Test001 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        Solution solution = new Solution();
        boolean symmetrical = solution.isSymmetrical(n1);
        System.out.println(symmetrical);
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

class Solution {
    List<Integer> l = new ArrayList<>();
    List<Integer> r = new ArrayList<>();

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return false;
        recurL(pRoot.left);
        recurR(pRoot.right);
        if (r.size() != l.size()) return false;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) != r.get(i)) {
                return false;
            }
        }
        return true;
    }

    void recurL(TreeNode lR) {
        if (lR == null) return;
        recurL(lR.left);
        l.add(lR.val);
        recurL(lR.right);
    }

    void recurR(TreeNode rR) {
        if (rR == null) return;
        recurR(rR.right);
        r.add(rR.val);
        recurR(rR.left);
    }
}

