# Balanced Binary Tree

**LeetCode Link:** https://leetcode.com/problems/balanced-binary-tree/

## Problem Summary
Given a binary tree, determine whether it is **height-balanced**.

A binary tree is height-balanced if for every node, the absolute
difference between the heights of its left and right subtrees is at
most `1`.

## Approach
We use a **post-order DFS traversal** to compute the height of each
subtree while simultaneously checking balance.

Key idea:
- If a subtree is unbalanced, return `-1` immediately.
- Otherwise, return the height of the subtree.
- If at any node the height difference exceeds `1`, propagate `-1`
  upward to signal imbalance.

This avoids recomputing heights and ensures optimal performance.

## Code (Java)
```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        if (left == -1) return -1;

        int right = dfs(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}
```

## Complexity
Time Complexity: O(n) — each node is visited once

Space Complexity: O(h) — recursion stack, where h is tree height

## Key Insight
By combining height calculation and balance checking into a single DFS,
we avoid redundant work and detect imbalance as early as possible