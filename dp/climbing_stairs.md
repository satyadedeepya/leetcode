# Climbing Stairs

**LeetCode Problem:** https://leetcode.com/problems/climbing-stairs/

---

## Problem Summary

You are climbing a staircase with `n` steps.
Each time, you can climb either **1 step** or **2 steps**.

Return the total number of **distinct ways** to reach the top.

---

## Approach (Dynamic Programming)

This problem follows the Fibonacci pattern.

Let `dp[i]` be the number of ways to reach step `i`.

- To reach step `i`, you can come from:
  - step `i - 1` (1 step)
  - step `i - 2` (2 steps)

So the recurrence relation is:

dp[i] = dp[i - 1] + dp[i - 2]


### Base Cases
- `dp[1] = 1`
- `dp[2] = 2`

We build the solution bottom-up using a DP array.

---

## Code (Java)

```java
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
```
## Complexity Analysis
Time Complexity: O(n)

Space Complexity: O(n)

## Key Insight
The number of ways to reach a step depends only on the previous two steps.
This makes the problem a classic example of dynamic programming and Fibonacci-style recurrence.