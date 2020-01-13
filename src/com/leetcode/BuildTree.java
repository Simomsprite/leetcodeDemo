/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BuildTree
 * Author:   王小手
 * Date:     2019/12/9 18:33
 * Description: 从前序与中序遍历序列构造二叉树
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;


/**
 * 〈一句话功能简述〉<br> 
 * 〈从前序与中序遍历序列构造二叉树〉
 *前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @author
 * @create 2019/12/9
 * @since 1.0.0
 */
public class BuildTree {

    public static void main(String[] args) {
        BuildTree bTree = new BuildTree();
        int[] preorder={3,9,20,15,7};
        int[] inorder={9,3,15,20,7};
        System.out.println(bTree.buildTree(preorder,inorder));
    }

    public  TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen) {
            throw new RuntimeException("Incorrect input data.");
        }
        return buildTree(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
    }


    /**
     * 使用数组 preorder 在索引区间 [preLeft, preRight] 中的所有元素
     * 和数组 inorder 在索引区间 [inLeft, inRight] 中的所有元素构造二叉树
     *
     * @param preorder 二叉树前序遍历结果
     * @param preLeft  二叉树前序遍历结果的左边界
     * @param preRight 二叉树前序遍历结果的右边界
     * @param inorder  二叉树后序遍历结果
     * @param inLeft   二叉树后序遍历结果的左边界
     * @param inRight  二叉树后序遍历结果的右边界
     * @return 二叉树的根结点
     */
    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               int[] inorder, int inLeft, int inRight) {
        // 因为是递归调用的方法，按照国际惯例，先写递归终止条件
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        // 先序遍历的起点元素很重要
        int pivot = preorder[preLeft];
        TreeNode root = new TreeNode(pivot);
        int pivotIndex = inLeft;
        // 严格上说还要做数组下标是否越界的判断 pivotIndex < inRight
        while (inorder[pivotIndex] != pivot) {
            pivotIndex++;
        }
        root.left = buildTree(preorder, preLeft + 1, pivotIndex - inLeft + preLeft,
                inorder, inLeft, pivotIndex - 1);
        root.right = buildTree(preorder, pivotIndex - inLeft + preLeft + 1, preRight,
                inorder, pivotIndex + 1, inRight);
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
}
