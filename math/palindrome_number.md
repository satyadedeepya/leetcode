# Palindrome Number

**LeetCode Link:** https://leetcode.com/problems/palindrome-number/

## Problem Summary
Given an integer `x`, determine whether it is a palindrome.
An integer is a palindrome when it reads the same backward as forward.

Negative numbers are not palindromes.

## Approach
Instead of converting the number to a string, we reverse the integer
mathematically and compare it with the original value.

Key observations:
- Negative numbers are not palindromes.
- Numbers ending with `0` (except `0` itself) cannot be palindromes.

We extract digits one by one, build the reversed number, and finally
check whether it equals the original input.

## Code (Java)
```java
class Solution {
    public boolean isPalindrome(int x) {
        int num = x;
        int reversed = 0;

        if (num < 0 || (num % 10 == 0 && num != 0)) {
            return false;
        }

        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }

        return x == reversed;
    }
}
```
## Complexity

Time Complexity: O(log₁₀ n) — number of digits in the integer

Space Complexity: O(1) — constant extra space

## Key Insight

Reversing an integer digit by digit allows us to check for palindromes
without converting the number to a string, keeping the solution efficient
and space-optimal.