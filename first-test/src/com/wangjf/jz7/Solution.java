package com.wangjf.jz7;

import java.util.*;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class Solution {
    //新建一个map集合用于存放中序数组
    private HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        for (int i = 0; i < vin.length; i++) {
            map.put(vin[i], i);
        }
        return recursion(pre, 0, pre.length - 1, 0, vin.length - 1);
    }

    //根据分治算法思想，每个子问题都需要前序、中序数组的信息
    private TreeNode recursion(int[] pre, int preLeft, int preRight, int vinLeft, int vinRight) {
        if (preLeft > preRight || vinLeft > vinRight) return null;
        int val = pre[preLeft];
        //首先获得根节点
        TreeNode root = new TreeNode(val);
        //获取根节点在中序数组中的索引，以便划分左右子树
        int rootIndex = map.get(val);
        //开始递归求解左右子树
        //类似的，构建左子树需要前序、中序数组中左子树的信息
        root.left = recursion(pre, preLeft + 1, preLeft + rootIndex - vinLeft, vinLeft, rootIndex - 1);
        //类似的，构建右子树需要前序、中序数组中右子树的信息
        root.right = recursion(pre, preLeft + rootIndex - vinLeft + 1, preRight, rootIndex + 1, vinRight);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
class Test {
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] vin = {4,7,2,1,5,3,8,6};
        Solution solution = new Solution();
        System.out.println(solution.reConstructBinaryTree(pre, vin));
    }
}