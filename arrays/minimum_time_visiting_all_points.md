# Minimum Time Visiting All Points

**LeetCode Problem:** https://leetcode.com/problems/minimum-time-visiting-all-points/

---

## Problem Summary

You are given a list of 2D points.

You can move:
- 1 unit vertically
- 1 unit horizontally
- 1 unit diagonally (counts as 1 second)

Return the minimum time required to visit all points in order.

---

## Key Observation

To move from point A to point B:

Let:
dx = |x2 - x1|
dy = |y2 - y1|


Since diagonal movement covers both x and y in 1 second,
the minimum time required is:

max(dx, dy)


Because:
- We use diagonal moves as long as possible
- Then finish with horizontal or vertical moves

---

## Approach

For every consecutive pair of points:
1. Compute absolute x-difference
2. Compute absolute y-difference
3. Add `max(dx, dy)` to total time

---

## Code (Java)

```java
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;

        for (int i = 1; i < points.length; i++) {
            int dx = Math.abs(points[i][0] - points[i - 1][0]);
            int dy = Math.abs(points[i][1] - points[i - 1][1]);

            time += Math.max(dx, dy);
        }

        return time;
    }
}
```
## Complexity Analysis
Time Complexity: O(n)

Space Complexity: O(1)

## Key Insight
Diagonal movement allows simultaneous change in x and y.
Thus, the minimum time equals the maximum of horizontal and vertical distance.