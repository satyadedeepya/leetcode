# Divide an Array Into Subarrays With Minimum Cost I

**LeetCode Link:** https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/

## Problem Summary
Given an integer array `nums`, divide it into **three disjoint contiguous
subarrays**.  
The cost of a subarray is defined as its **first element**.

Return the minimum possible sum of the costs of the three subarrays.

## Approach
The first subarray must always start at index `0`, so its cost is
`nums[0]`.

To minimize the total cost, the remaining two subarrays should start at
positions with the **smallest possible values** among the remaining
elements.

Therefore:
- Fix the first subarray starting at index `0`
- Find the **two smallest values** in `nums[1 … n-1]`
- Add them to `nums[0]`

This greedy approach works because the cost depends only on the starting
elements of each subarray.

## Code (Java)
```java
class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }

        return nums[0] + min1 + min2;
    }
}
```
## Complexity

Time Complexity: O(n) — single pass to find two minimum values

Space Complexity: O(1) — constant extra space

## Key Insight

Since the cost of a subarray depends only on its first element, minimizing
the total cost reduces to selecting the smallest possible starting values
for the remaining subarrays.