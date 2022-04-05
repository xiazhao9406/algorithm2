package com.xiazhao.algorithms;

import java.util.*;

public class BinaryTreeTraversal {
    /**
     * lc112. Path Sum: https://leetcode.com/submissions/detail/672561492/
     */
    public static void preOrder(TreeNode node, Visitor visitor) {
        if (node == null) return;
        visitor.visit(node);
        preOrder(node.left, visitor);
        preOrder(node.right, visitor);
    }

    /**
     * lc112. Path Sum: https://leetcode.com/submissions/detail/672566440/
     */
    public static void preOrderNonRecursive(TreeNode node, Visitor visitor) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()) {
            TreeNode treeNode = stack.pop();
            visitor.visit(treeNode);
            if (treeNode.right != null) stack.push(treeNode.right);
            if (treeNode.left != null) stack.push(treeNode.left);
        }
    }

    public static void inOrder(TreeNode node, Visitor visitor) {
        if (node == null) return;
        inOrder(node.left, visitor);
        visitor.visit(node);
        inOrder(node.right, visitor);
    }

    public static void inOrderNonRecursive(TreeNode node, Visitor visitor) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = node;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                visitor.visit(treeNode);
                treeNode = treeNode.right;
            }
        }
    }

    public static void postOrder(TreeNode node, Visitor visitor) {
        if (node == null) return;
        postOrder(node.left, visitor);
        postOrder(node.right, visitor);
        visitor.visit(node);
    }

    public static void postOrderNonRecursive(TreeNode node, Visitor visitor) {
        if (node == null) return;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(node);
        while (!s1.isEmpty()) {
            TreeNode treeNode = s1.pop();
            s2.push(treeNode);
            if (treeNode.left != null) s1.push(treeNode.left);
            if (treeNode.right != null) s1.push(treeNode.right);
        }
        while (!s2.isEmpty()) visitor.visit(s2.pop());
    }

    public static List<List<Integer>> levelOrder(TreeNode root, Visitor visitor) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                visitor.visit(node);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(subList);
        }
        return res;
    }

    public interface Visitor {
        void visit(TreeNode treeNode);
    }
}
