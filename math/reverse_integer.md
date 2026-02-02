# Reverse Integer

**LeetCode Link:** https://leetcode.com/problems/reverse-integer/

## Problem Summary
Given a signed 32-bit integer `x`, return `x` with its digits reversed.
If reversing `x` causes the value to go outside the signed 32-bit
integer range `[-2³¹, 2³¹ - 1]`, return `0`.

## Approach
We reverse the integer digit by digit using arithmetic operations.

At each step:
- Extract the last digit using modulo (`% 10`)
- Append it to the reversed number
- Before updating, check for **overflow** to ensure the value stays
  within the 32-bit integer range

If an overflow would occur, return `0`.

## Code (Java)
```java
class Solution {
    public int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            if (reversed > Integer.MAX_VALUE / 10 ||
                reversed < Integer.MIN_VALUE / 10) {
                return 0;
            }

            reversed = reversed * 10 + digit;
        }
        return reversed;
    }
}
```
## Complexity

Time Complexity: O(log₁₀ n) — number of digits in the integer

Space Complexity: O(1) — constant extra space

## Key Insight

Overflow must be checked before multiplying and adding the next digit.
This ensures the reversed integer always stays within valid 32-bit bounds.