package com.xiazhao.algorithms;

import java.util.*;

public class BinaryTreeTraversal {
    //recursion
    public void preOrder(TreeNode node) {
        if (node == null)
            return;
        System.out.println();
        preOrder(node.left);
        preOrder(node.right);
    }
    /* If need to return a list, add a parameter list to helper function.
    eg. public List<> preOrder(node)
        public void helper(node, list)
     */

    //non recursion
    public void preOrder2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);//压栈
        while (!stack.empty()) {
            TreeNode t1 = stack.pop();//出栈
            System.out.println(t1.val);
            if (t1.right != null) {
                stack.push(t1.right);
            }
            if (t1.left != null) {
                stack.push(t1.left);
            }
        }
    }

    //recursion
    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    //no recursion using a stack
    public void inOrder2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node.val);
                node = node.right;
            }
        }
    }

    //recursion
    public void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }

    //no recursion
    public void postOrder2(TreeNode node) {
        if (node != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(node);
            while (!s1.isEmpty()) {
                node = s1.pop();
                s2.push(node);
                if (node.left != null) {
                    s1.push(node.left);
                }

                if (node.right != null) {
                    s1.push(node.right);
                }
            }

            while (!s2.isEmpty()) {
                System.out.println(s2.pop().val);
            }
        }
    }

    //tree level traversal
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {

            int levelNum = queue.size();

            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            res.add(subList);
        }
        return res;
    }
}
