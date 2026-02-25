# Subsets (Bitmask Approach)

**LeetCode Problem:** https://leetcode.com/problems/subsets/

---

## Problem Summary

Given an array of unique integers `nums`,
return all possible subsets (the power set).

The solution must not contain duplicate subsets.

---

## Approach (Bitmasking)

For an array of size `n`, there are:


2^n subsets


Each subset can be represented by a binary mask of length `n`.

- If the ith bit is set → include `nums[i]`
- If not → exclude it

We iterate from:


0 to (2^n - 1)


Each number represents one subset.

---

## Code (Java)

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int total = 1 << n;   // 2^n

        for (int mask = 0; mask < total; mask++) {
            List<Integer> subset = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }

            result.add(subset);
        }

        return result;
    }
}
```
## Complexity Analysis

Time Complexity: O(n × 2ⁿ)

Space Complexity: O(n)

There are 2ⁿ subsets,
and building each subset takes up to n operations.

## Key Insight

Each subset corresponds to a unique binary number
between 0 and 2^n - 1.

Bitmasking converts subset generation
into a simple binary enumeration problem.