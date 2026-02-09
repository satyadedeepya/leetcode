# Balance a Binary Search Tree

**LeetCode Problem:** https://leetcode.com/problems/balance-a-binary-search-tree/

---

## Problem Summary

Given the root of a binary search tree (BST), return a **balanced** BST
containing the same node values.

A BST is considered balanced if for every node, the depth difference
between its left and right subtrees is **at most 1**.

Multiple valid balanced trees are acceptable.

---

## Approach

1. **Inorder Traversal**
   - Perform an inorder traversal of the BST.
   - Since it is a BST, inorder traversal produces a **sorted list** of values.

2. **Build Balanced BST**
   - Use the sorted list to construct a balanced BST.
   - Pick the middle element as the root.
   - Recursively build left and right subtrees.

This guarantees a height-balanced BST.

---

## Code (Java)

```java
class Solution {

    List<Integer> values = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return build(0, values.size() - 1);
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);
        values.add(node.val);
        inorder(node.right);
    }

    private TreeNode build(int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(values.get(mid));

        node.left = build(start, mid - 1);
        node.right = build(mid + 1, end);

        return node;
    }
}
```

## Complexity Analysis
Time Complexity: O(n)

Inorder traversal + tree construction

## Space Complexity: O(n)

Extra list to store node values.