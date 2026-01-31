# Find Smallest Letter Greater Than Target

**LeetCode Link:** https://leetcode.com/problems/find-smallest-letter-greater-than-target/

## Problem Summary
Given a sorted array of characters `letters` and a target character,
return the smallest character in the array that is strictly greater
than the target.

The array wraps around, meaning if no character is greater than the
target, return the first character in the array.

## Approach
Because the array is sorted, we can apply **binary search** to efficiently
find the smallest character greater than the target.

We maintain a candidate answer initialized to the first character to
handle the wrap-around case. During binary search:
- If `letters[mid]` is greater than the target, it becomes a potential
  answer and we continue searching the left half.
- Otherwise, we search the right half.

This ensures we find the smallest valid character in logarithmic time.

## Code (Java)
```java
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        char ans = letters[0]; // default for wrap-around

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] > target) {
                ans = letters[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
```
## Complexity

Time Complexity: O(log n) — binary search

Space Complexity: O(1) — constant extra space

## Key Insight

Initializing the answer to the first character handles the wrap-around
case naturally. Binary search allows us to efficiently find the smallest
character strictly greater than the target.