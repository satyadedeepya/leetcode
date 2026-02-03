# Trionic Array I

**LeetCode Link:** https://leetcode.com/problems/trionic-array-i/

## Problem Summary
An array is called **trionic** if there exist indices `0 < p < q < n - 1`
such that:

- `nums[0...p]` is strictly increasing
- `nums[p...q]` is strictly decreasing
- `nums[q...n-1]` is strictly increasing

Return `true` if the array is trionic, otherwise return `false`.

## Approach
We traverse the array in **three phases** using a single pointer:

1. **Strictly increasing phase**
2. **Strictly decreasing phase**
3. **Strictly increasing phase**

At each phase, we ensure:
- The segment has at least one valid transition
- Boundaries `p` and `q` are valid
- The traversal ends exactly at the last index

If all three phases are satisfied, the array is trionic.

## Code (Java)
```java
class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return false;

        int i = 0;

        // First increasing part
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == 0 || i == n - 1) return false;

        int p = i;

        // Decreasing part
        while (i + 1 < n && nums[i] > nums[i + 1]) {
            i++;
        }
        if (i == p || i == n - 1) return false;

        // Second increasing part
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }

        return i == n - 1;
    }
}
```
## Complexity

Time Complexity: O(n) — single traversal

Space Complexity: O(1) — constant extra space

## Key Insight

A trionic array is defined by exactly three monotonic segments.
A single-pass pointer traversal is sufficient to validate all conditions
without extra memory.