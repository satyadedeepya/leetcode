# Minimum Cost to Convert String

**LeetCode Link:** https://leetcode.com/problems/minimum-cost-to-convert-string/

## Problem Summary
Given two strings `source` and `target` of equal length, and a set of
allowed character transformations with associated costs, determine the
minimum total cost required to convert `source` into `target`.

Each character can be transformed multiple times through intermediate
characters. If it is impossible to convert `source` to `target`, return `-1`.

## Approach
This problem can be modeled as a **graph shortest-path problem**.

Each character from `'a'` to `'z'` is treated as a node in a directed graph.
Each allowed transformation represents a directed edge with a given cost.

Since transformations can be chained through intermediate characters,
we need the **minimum cost between all pairs of characters**.
Because the graph size is fixed (26 nodes), we use the **Floyd–Warshall
algorithm** to compute all-pairs shortest paths.

After preprocessing:
- For each position `i`, we convert `source[i]` to `target[i]`
- If any conversion is impossible, return `-1`
- Otherwise, sum all individual conversion costs

## Code (Java)
```java
class Solution {
    public long minimumCost(String source, String target,
                            char[] original, char[] changed, int[] cost) {

        final long INF = (long) 1e18;
        long[][] dist = new long[26][26];

        // Initialize distance matrix
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                dist[i][j] = (i == j) ? 0 : INF;
            }
        }

        // Direct transformation costs
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // Floyd–Warshall algorithm
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < 26; j++) {
                    if (dist[k][j] == INF) continue;
                    long nd = dist[i][k] + dist[k][j];
                    if (nd < dist[i][j]) {
                        dist[i][j] = nd;
                    }
                }
            }
        }

        // Compute total cost
        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';
            if (dist[s][t] == INF) {
                return -1;
            }
            ans += dist[s][t];
        }

        return ans;
    }
}
```
## Complexity

Time Complexity: O(26³ + n) ≈ O(n)
Floyd–Warshall runs on a constant-size graph.

Space Complexity: O(26²) — distance matrix

## Key Insight

Because the number of characters is fixed (26), computing all-pairs
shortest paths is efficient and allows chained transformations to be
handled correctly.