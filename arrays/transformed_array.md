# Transformed Array

**LeetCode Link:** https://leetcode.com/problems/transformed-array/

## Problem Summary
You are given an integer array `nums` that represents a **circular array**.
Construct a new array `result` of the same length following these rules:

- If `nums[i] > 0`, move `nums[i]` steps to the right (circularly) and set
  `result[i]` to the value at that index.
- If `nums[i] < 0`, move `|nums[i]|` steps to the left (circularly) and set
  `result[i]` to the value at that index.
- If `nums[i] == 0`, set `result[i] = nums[i]`.

## Approach
For each index `i`, we compute the destination index using **modular
arithmetic** to correctly handle circular movement.

To safely handle negative indices, we normalize every computed index using:

((index % n) + n) % n


This guarantees the index always lies within the valid range `[0, n - 1]`.

Each element is processed independently in a single pass.

## Code (Java)
```java
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                int target = ((i + nums[i]) % n + n) % n;
                result[i] = nums[target];
            } 
            else if (nums[i] < 0) {
                int target = ((i - Math.abs(nums[i])) % n + n) % n;
                result[i] = nums[target];
            } 
            else {
                result[i] = nums[i];
            }
        }
        return result;
    }
}
```
## Complexity
Time Complexity: O(n) — single traversal

Space Complexity: O(n) — output array

## Key Insight
Circular indexing with negative movement must be normalized carefully.
Using modular arithmetic ensures correct wrap-around behavior in all cases.