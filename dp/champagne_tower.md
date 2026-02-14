# Champagne Tower

**LeetCode Problem:** https://leetcode.com/problems/champagne-tower/

---

## Problem Summary

Champagne is poured into the top glass of a pyramid.

Each glass holds **1 cup**.  
If a glass overflows, the excess is split equally between the two glasses below it.

Given:
- `poured`
- `query_row`
- `query_glass`

Return how full the specified glass is.

---

## Approach (Dynamic Programming Simulation)

We simulate the pouring process row by row.

1. Create a 2D array `dp[101][101]`.
2. Set `dp[0][0] = poured`.
3. For each glass:
   - If it contains more than 1 cup:
     - Calculate overflow: `(dp[i][j] - 1) / 2`
     - Distribute to the next row.
4. Return `min(1, dp[query_row][query_glass])`.

We only simulate up to the required row.

---

## Code (Java)

```java
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];
        dp[0][0] = poured;

        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] > 1) {
                    double overflow = (dp[i][j] - 1) / 2.0;
                    dp[i + 1][j] += overflow;
                    dp[i + 1][j + 1] += overflow;
                }
            }
        }

        return Math.min(1, dp[query_row][query_glass]);
    }
}
```
## Complexity Analysis
Time Complexity: O(row²) ≤ O(100²)

Space Complexity: O(100²)

## Key Insight
We only need to simulate up to the required row.
Overflow flows downward and splits evenly.
Each glass can hold at most 1 cup.