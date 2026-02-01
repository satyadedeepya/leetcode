# Increasing Triplet Subsequence

**LeetCode Link:** https://leetcode.com/problems/increasing-triplet-subsequence/

## Problem Summary
Given an integer array `nums`, determine whether there exist indices
`i < j < k` such that: 
Return `true` if such a triplet exists, otherwise return `false`.

## Approach
This problem is solved using a **greedy single-pass approach**.

We track two values:
- `first`: the smallest value seen so far
- `second`: the smallest value greater than `first`

While iterating through the array:
- If the current number is smaller than or equal to `first`, update `first`
- Else if it is smaller than or equal to `second`, update `second`
- Else, we have found a number greater than both `first` and `second`,
  which guarantees an increasing triplet

The moment this condition is met, we return `true`.

## Code (Java)
```java
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }
}



Return `true` if such a triplet exists, otherwise return `false`.

## Approach
This problem is solved using a **greedy single-pass approach**.

We track two values:
- `first`: the smallest value seen so far
- `second`: the smallest value greater than `first`

While iterating through the array:
- If the current number is smaller than or equal to `first`, update `first`
- Else if it is smaller than or equal to `second`, update `second`
- Else, we have found a number greater than both `first` and `second`,
  which guarantees an increasing triplet

The moment this condition is met, we return `true`.

## Code (Java)
```java
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
```
## Complexity

Time Complexity: O(n) — single traversal

Space Complexity: O(1) — constant extra space

## Key Insight

We do not need to store the actual triplet. Maintaining only the smallest
and second-smallest values is sufficient to detect the existence of an
increasing triplet.