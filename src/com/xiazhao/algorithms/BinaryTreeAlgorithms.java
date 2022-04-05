package com.xiazhao.algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeAlgorithms {
    /**
     * lc236. Lowest Common Ancestor of a Binary Tree: https://leetcode.com/submissions/detail/672575342/
     */
    public TreeNode lcaNoRecursive(TreeNode root, TreeNode p, TreeNode q) {
        // Create parent pointer map
        // find p's parent set
        // walk through q's parent route and get the lca
        return null;
    }

    /**
     * lc236. Lowest Common Ancestor of a Binary Tree: https://leetcode.com/submissions/detail/672574823/
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    /**
     * lc104 https://leetcode.com/submissions/detail/673962163/
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * lc104 top to bottom
     */
    int answer;
    public void maxDepthTopToBottom(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            answer = Math.max(answer, depth);
        }
        maxDepthTopToBottom(node.left, depth + 1);
        maxDepthTopToBottom(node.right, depth + 1);
    }

    /**
     * lc104  https://leetcode.com/submissions/detail/674055600/
     * @param node
     * @return
     */
    public int maxDepthBFS(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }

    /**
     * lc111 Minimum Depth of Binary Tree https://leetcode.com/submissions/detail/674070456/
     * @param node
     * @return
     */
    public int maxDepthDFS(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int maxDepth = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();

        stack.push(node);
        depthStack.push(1);

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            int depth = depthStack.pop();
            maxDepth = Math.max(maxDepth, depth);

            if (treeNode.right != null) {
                stack.push(treeNode.right);
                depthStack.push(depth + 1);
            }

            if (treeNode.left != null) {
                stack.push(treeNode.left);
                depthStack.push(depth + 1);
            }
        }
        return maxDepth;
    }

    /**
     * lc297 Serialize and Deserialize Binary Tree
     * https://leetcode.com/submissions/detail/673962163/
     * @param root
     * @return
     */
    public String serializeBFS(TreeNode root) {
        if (root == null)
            return "#";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        queue.add(root);
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node == null) {
                res.append("#,");
                continue;
            }

            res.append(node.val + ",");
            queue.add(node.left);
            queue.add(node.right);
        }
        return res.toString();
    }

    /**
     * lc297 Serialize and Deserialize Binary Tree
     * https://leetcode.com/submissions/detail/673962163/
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        if (data == "#")
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();
            if (!"#".equals(values[i])) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            if (!"#".equals(values[++i])) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }


}
