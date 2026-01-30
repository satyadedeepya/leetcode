# Container With Most Water

**LeetCode Link:** https://leetcode.com/problems/container-with-most-water/

## Problem Summary
Given an integer array `height` where each element represents the height
of a vertical line, find two lines that together with the x-axis form a
container that holds the maximum amount of water.

The container cannot be slanted.

## Approach
This problem is solved optimally using a **two-pointer technique**.

- Start with one pointer at the beginning and one at the end of the array.
- The width of the container is the distance between the two pointers.
- The height of the container is determined by the shorter line.
- Calculate the area and update the maximum found so far.
- Move the pointer that points to the shorter line inward, since moving
  the taller line cannot increase the area.

This approach ensures all optimal pairs are considered efficiently.

## Code (Java)
```java
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int currHeight = Math.min(height[left], height[right]);
            int area = width * currHeight;
            maxArea = Math.max(maxArea, area);

            // Move the pointer at the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
```
## Complexity

Time Complexity: O(n) — single pass using two pointers

Space Complexity: O(1) — constant extra space

## Key Insight

The area is limited by the shorter of the two lines. Moving the pointer
at the taller line cannot increase the area, so only the shorter line
pointer is moved to explore better possibilities.