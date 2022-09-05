package com.wangjf.qizhi;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int nodeSize = scanner.nextInt(), rootVal = scanner.nextInt();
        TreeNode root = new TreeNode(rootVal);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int fa = scanner.nextInt(), lch = scanner.nextInt(), rch = scanner.nextInt();
            TreeNode nowNode = stack.pop();
            if (rch != 0) {
                TreeNode rightNode = new TreeNode(rch);
                stack.push(rightNode);
                nowNode.right = rightNode;
            }
            if (lch != 0) {
                TreeNode leftNode = new TreeNode(lch);
                stack.push(leftNode);
                nowNode.left = leftNode;
            }
        }
        Main main = new Main();
        main.preOrder(root);
        System.out.println();
        main.inOrder(root);
        System.out.println();
        main.lastOrder(root);
        System.out.println();

    }

    void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    void lastOrder(TreeNode root) {
        if (root == null) return;
        lastOrder(root.left);
        lastOrder(root.right);
        System.out.print(root.val + " ");
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
