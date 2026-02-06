# Minimum Removals to Balance Array

**LeetCode Link:** https://leetcode.com/problems/minimum-removals-to-balance-array/

## Problem Summary
You are given an integer array `nums` and an integer `k`.

An array is considered **balanced** if:

max(nums) <= k * min(nums)


You may remove any number of elements (but not all).  
Return the **minimum number of removals** required to make the array balanced.

A single-element array is always balanced.

## Approach
To minimize removals, we want to keep the **largest possible subset**
that satisfies the balance condition.

Steps:
1. **Sort** the array.
2. Use a **sliding window (two pointers)** to find the largest subarray
   where:
nums[right] <= k * nums[left]

3. Track the maximum valid window size.
4. The answer is:
total elements - maximum valid window size


Sorting allows us to efficiently check the balance condition using
two pointers.

## Code (Java)
```java
import java.util.Arrays;

class Solution {
 public int minRemoval(int[] nums, int k) {
     int n = nums.length;
     if (n == 1) return 0;

     Arrays.sort(nums);

     int left = 0;
     int maxWindow = 1;

     for (int right = 0; right < n; right++) {
         while ((long) nums[right] > (long) k * nums[left]) {
             left++;
         }
         maxWindow = Math.max(maxWindow, right - left + 1);
     }

     return n - maxWindow;
 }
}
```
## Complexity
Time Complexity: O(n log n) — sorting + linear scan

Space Complexity: O(1) — extra space (ignoring sort internals)

## Key Insight
Instead of removing elements individually, maximize the size of a
balanced subarray. Sliding window on a sorted array efficiently finds
the largest valid subset.