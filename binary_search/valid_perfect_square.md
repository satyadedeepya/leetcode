# Valid Perfect Square

**LeetCode Link:** https://leetcode.com/problems/valid-perfect-square/

## Problem Summary
Given a positive integer `num`, determine whether it is a perfect square.
A perfect square is an integer that is the square of another integer.
The solution must not use any built-in square root functions.

## Approach
Since the square root function is not allowed, we use binary search
to determine whether an integer square root exists.

We search for an integer `mid` such that `mid * mid == num`.
If `mid * mid` is smaller than `num`, we search the right half.
If it is larger, we search the left half.

Binary search works because the square function is monotonic.

To avoid integer overflow, multiplication is done using `long`.

## Code (Java)
```java
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;

        long left = 1, right = num / 2;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
```

## Complexity

Time Complexity: O(log n)

Space Complexity: O(1)

## Key Insight

Binary search efficiently checks whether an integer square root exists
without using built-in square root functions.