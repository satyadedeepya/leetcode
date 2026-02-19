# Count Binary Substrings

**LeetCode Problem:** https://leetcode.com/problems/count-binary-substrings/

---

## Problem Summary

Given a binary string `s`, return the number of non-empty substrings that:

- Contain the same number of `0`s and `1`s
- Have all `0`s grouped consecutively
- Have all `1`s grouped consecutively

Substrings that occur multiple times are counted separately.

---

## Approach (Group Counting)

Instead of checking all substrings, we observe:

Valid substrings occur when:
- A group of `0`s is followed by a group of `1`s (or vice versa)
- The number of valid substrings between two groups equals:
  
min(size_of_previous_group, size_of_current_group)


We:
1. Track the size of the previous group
2. Track the size of the current group
3. When the character changes, add `min(prevGroup, currGroup)` to result

This runs in linear time.

---

## Code (Java)

```java
class Solution {
    public int countBinarySubstrings(String s) {
        int prevGroup = 0;
        int currGroup = 1;
        int result = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currGroup++;
            } else {
                result += Math.min(prevGroup, currGroup);
                prevGroup = currGroup;
                currGroup = 1;
            }
        }

        result += Math.min(prevGroup, currGroup);

        return result;
    }
}
```
## Complexity Analysis
Time Complexity: O(n)

Space Complexity: O(1)

## Key Insight
Balanced substrings only occur between adjacent groups
of 0s and 1s.