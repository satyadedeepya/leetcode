# Product of Array Except Self

**LeetCode Link:** https://leetcode.com/problems/product-of-array-except-self/

## Problem Summary
Given an integer array `nums`, return an array `answer` such that
`answer[i]` is the product of all elements in `nums` except `nums[i]`.
The solution must run in O(n) time and cannot use division.

## Approach
Using division is not allowed, so we compute the result using prefix
and suffix products.

First, we build a prefix product array where each index stores the
product of all elements to the left of it.

Then, we traverse the array from the right while maintaining a suffix
product that represents the product of all elements to the right.
By multiplying the prefix and suffix values, we obtain the final result
for each index.

This approach avoids division and runs in linear time.

## Code (Java)
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // Prefix product
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Suffix product
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= suffix;
            suffix *= nums[i];
        }

        return ans;
    }
}
```

## Complexity

Time Complexity: O(n) — two linear passes through the array

Space Complexity: O(1) extra space (excluding the output array)

## Key Insight

Each element’s result is the product of all elements to its left and all
elements to its right. By computing prefix and suffix products separately,
we avoid division while achieving optimal time complexity.