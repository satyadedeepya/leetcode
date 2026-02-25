# Subsets

**LeetCode Problem:** https://leetcode.com/problems/subsets/

---

## Problem Summary

Given an array of unique integers `nums`, return all possible subsets (the power set).

The solution set must not contain duplicate subsets.

---

## Approach (Backtracking)

This is a classic **backtracking / recursion** problem.

At each step:
- Add the current subset to the result.
- Try including each remaining element.
- Recurse.
- Backtrack (remove last element).

This ensures all possible combinations are generated.

---

## Code (Java)

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerset = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), powerset);
        return powerset;
    }

    private void backtrack(int[] nums, int start,
                           List<Integer> current,
                           List<List<Integer>> powerset) {

        powerset.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, powerset);
            current.remove(current.size() - 1);
        }
    }
}
```
## Complexity Analysis

Time Complexity: O(n × 2ⁿ)

Space Complexity: O(n) (recursion depth)

There are 2ⁿ subsets, and each subset copy takes O(n).

## Key Insight

Backtracking template:

Add current state to result.

Iterate choices.

Choose.

Recurse.

Undo choice.

This pattern is reusable for:

Combinations

Permutations

Combination Sum

Subsets II