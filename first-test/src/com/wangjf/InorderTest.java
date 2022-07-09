package com.wangjf;

import java.util.*;

public class InorderTest {
    ArrayList<TreeNode> arrayList = new ArrayList<>();
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        TreeNode root = new TreeNode(2);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(5);
        root.left = root1;
        root.right = root2;
        root2.right = root3;
        InorderTest t = new InorderTest();
        t.inOrder(root);
        System.out.println(t.arrayList);
    }
    void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        arrayList.add(root);
        inOrder(root.right);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}