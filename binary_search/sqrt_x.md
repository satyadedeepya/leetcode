# Sqrt(x)

**LeetCode Problem:** https://leetcode.com/problems/sqrtx/

---

## Problem Summary

Given a non-negative integer `x`, return the **integer square root** of `x`
rounded down to the nearest integer.

You must not use any built-in exponent or square root functions.

---

## Approach (Binary Search)

We use **binary search** to find the largest integer `mid` such that:

mid * mid <= x


### Steps:
1. Handle base cases (`x < 2`).
2. Search between `1` and `x / 2`.
3. Use `long` to prevent integer overflow when computing `mid * mid`.
4. Track the last valid `mid` as the answer.

Binary search ensures efficiency even for large values of `x`.

---

## Code (Java)

```java
class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int left = 1, right = x / 2;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sq = (long) mid * mid;

            if (sq <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
```
## Complexity Analysis
Time Complexity: O(log x)

Space Complexity: O(1)

## Key Insight
Binary search efficiently narrows down the largest integer whose square
does not exceed x, while using long avoids overflow errors.