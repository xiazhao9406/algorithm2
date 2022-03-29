package com.xiazhao.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.engine.TestDescriptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTraversalTest {

    private TreeNode root;
    private List<Integer> result;
    private BinaryTreeTraversal.Visitor visitor;

    @BeforeEach
    void prepareData() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        result = new ArrayList<>();
        visitor = new BinaryTreeTraversal.Visitor() {
            @Override
            public void visit(TreeNode treeNode) {
                result.add(treeNode.val);
            }
        };
    }

    @org.junit.jupiter.api.Test
    void preOrder() {
        BinaryTreeTraversal.preOrder(root, visitor);
        assertArrayEquals(new Integer[] {1, 2, 4, 5, 3, 6, 7,}, result.toArray());
    }

    @org.junit.jupiter.api.Test
    void preOrderNonRecursive() {
        BinaryTreeTraversal.preOrderNonRecursive(root, visitor);
        assertArrayEquals(new Integer[] {1, 2, 4, 5, 3, 6, 7,}, result.toArray());
    }

    @org.junit.jupiter.api.Test
    void inOrder() {
        BinaryTreeTraversal.inOrder(root, visitor);
        assertArrayEquals(new Integer[] {4, 2, 5, 1, 6, 3, 7,}, result.toArray());
    }

    @org.junit.jupiter.api.Test
    void inOrderNonRecursive() {
        BinaryTreeTraversal.inOrderNonRecursive(root, visitor);
        assertArrayEquals(new Integer[] {4, 2, 5, 1, 6, 3, 7,}, result.toArray());
    }

    @org.junit.jupiter.api.Test
    void postOrder() {
        BinaryTreeTraversal.postOrder(root, visitor);
        assertArrayEquals(new Integer[] {4, 5, 2, 6, 7, 3, 1,}, result.toArray());
    }

    @org.junit.jupiter.api.Test
    void postOrderNonRecursive() {
        BinaryTreeTraversal.postOrderNonRecursive(root, visitor);
        assertArrayEquals(new Integer[] {4, 5, 2, 6, 7, 3, 1,}, result.toArray());
    }

    @org.junit.jupiter.api.Test
    void levelOrder() {
        BinaryTreeTraversal.levelOrder(root, visitor);
        assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 6, 7,}, result.toArray());
    }
}