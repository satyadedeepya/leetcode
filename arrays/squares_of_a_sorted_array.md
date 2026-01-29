# Squares of a Sorted Array

**LeetCode Link:** https://leetcode.com/problems/squares-of-a-sorted-array/

## Problem Summary
Given an integer array `nums` sorted in non-decreasing order, return an
array of the squares of each number, also sorted in non-decreasing order.

## Approach
Although the input array is already sorted, squaring the elements can
disrupt the order because negative numbers become positive.

To handle this efficiently, we use a **two-pointer approach**:
- One pointer starts at the beginning of the array
- The other starts at the end
- The larger square is placed at the end of the result array

By filling the result array from right to left, we ensure the final
array is sorted without needing an extra sort.

This approach runs in linear time.

## Code (Java)
```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int left = 0, right = n - 1;
        int idx = n - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                res[idx--] = leftSquare;
                left++;
            } else {
                res[idx--] = rightSquare;
                right--;
            }
        }
        return res;
    }
}
```
## Complexity
Time Complexity: O(n) — single pass using two pointers

Space Complexity: O(n) — output array

## Key Insight
Even though the array is sorted, negative values can produce larger
squares. Comparing squares from both ends allows us to build the
sorted result efficiently without additional sorting.