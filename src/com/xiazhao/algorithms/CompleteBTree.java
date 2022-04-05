package com.xiazhao.algorithms;

import java.util.LinkedList;
import java.util.List;

public class CompleteBTree {
    public static boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        boolean flag = true;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tn = queue.poll();
            TreeNode left = tn.left;
            TreeNode right = tn.right;
            if (flag) {
                if (left == null)
                    flag = false;
                else
                    queue.add(left);
            } else {
                if (left != null)
                    return false;
            }
            if (flag) {
                if (right == null)
                    flag = false;
                else
                    queue.add(right);
            } else {
                if (right != null)
                    return false;
            }
        }
        return true;
    }

    public static boolean compareTree(TreeNode root1, TreeNode root2) {
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null))
            return false;
        else if (root1 == null && root2 == null)
            return true;
        if (root1.val == root2.val) {
            return compareTree(root1.left, root2.left) && compareTree(root1.right, root2.right);
        } else {
            return false;
        }
    }

    public static int isBalanced(TreeNode root) {
        if (root == null)
            return 0;
        int lh = isBalanced(root.left);
        int rh = isBalanced(root.right);
        if (Math.abs(lh-rh) <= 1) {
            return Math.max(lh, rh)+1;
        } else
            return -1;
    }

    public static TreeNode constructPreAndIn(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length)
            return null;
        return constructPreAndIn(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }
    public static TreeNode constructPreAndIn(int[] preOrder, int pl, int pr, int[] inOrder, int il, int ir){
        if (pl > pr){
            return null;
        }
        TreeNode root = new TreeNode(preOrder[pl]);
        int pos = il;
        for (; pos <= ir; pos++) {
            if (inOrder[pos] == root.val)
                break;
        }
        root.left = constructPreAndIn(preOrder, pl + 1, pl + pos - il, inOrder, il, pos - 1);
        root.right = constructPreAndIn(preOrder, pl + pos - il + 1, pr, inOrder, pos + 1, ir);
        return root;
    }

    public static TreeNode constructPostAndIn(int[] postOrder, int[] inOrder) {
        if (postOrder == null || inOrder == null || postOrder.length != inOrder.length)
            return null;
        return constructPostAndIn(postOrder, 0, postOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }
    public static TreeNode constructPostAndIn(int[] postOrder, int pl, int pr, int[] inOrder, int il, int ir){
        if (pl > pr){
            return null;
        }
        TreeNode root = new TreeNode(postOrder[pr]);
        int pos = il;
        for (; pos <= ir; pos++) {
            if (inOrder[pos] == root.val)
                break;
        }
        root.left = constructPostAndIn(postOrder, pl, pl + pos - il - 1, inOrder, il, pos - 1);
        root.right = constructPostAndIn(postOrder, pr - (ir - pos), pr - 1, inOrder, pos + 1, ir);
        return root;
    }
}
