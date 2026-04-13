## Minimum Distance to the Target Element

LeetCode Problem: https://leetcode.com/problems/minimum-distance-to-the-target-element/

## Problem Summary

Given:

An integer array nums
An integer target
An integer start

Find the minimum distance between start index and any index i such that:

nums[i] == target

Distance is defined as:

|i - start|

Return the minimum such distance.

## Approach (Linear Scan)

This is a straightforward single pass traversal.

Initialize ans with a large value (Integer.MAX_VALUE)
Traverse the array from 0 → n-1
For each index:
If nums[i] == target
Compute distance: |i - start|
Update minimum distance
Return the final minimum distance

No extra data structures needed.

## Code 
```java
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                ans = Math.min(ans, Math.abs(i - start));
            }
        }

        return ans;
    }
}
```
## Complexity Analysis

Time Complexity: O(n)
Single traversal of the array

Space Complexity: O(1)
No extra space used

## Key Insight
You don’t need sorting or binary search — a full scan is optimal here
Track only valid target indices and compute distance
This is a classic “closest occurrence” pattern in arrays