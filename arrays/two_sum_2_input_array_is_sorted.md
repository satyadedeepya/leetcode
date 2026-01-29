# Two Sum II – Input Array Is Sorted

**LeetCode Link:** https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

## Problem Summary
Given a 1-indexed integer array `numbers` sorted in non-decreasing order
and an integer `target`, find two numbers such that they add up to the
target.

Return their indices as `[index1, index2]`, where `index1 < index2`.
Exactly one valid solution exists, and the solution must use constant
extra space.

## Approach
Because the array is already sorted, we can use a **two-pointer approach**.

- Initialize one pointer at the start of the array and another at the end.
- Compute the sum of the elements at both pointers.
- If the sum equals the target, return the indices (1-indexed).
- If the sum is smaller than the target, move the left pointer forward.
- If the sum is larger than the target, move the right pointer backward.

This guarantees an optimal solution using constant extra space.

## Code (Java)
```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}
```
## Complexity

Time Complexity: O(n) — single pass using two pointers

Space Complexity: O(1) — constant extra space

## Key Insight

The sorted property of the array allows us to move pointers intelligently
based on whether the current sum is too small or too large, eliminating
the need for hashing or nested loops.