# Plus One

**LeetCode Problem:** https://leetcode.com/problems/plus-one/

---

## Problem Summary

You are given a non-empty array of digits representing a non-negative integer.
The digits are stored such that the most significant digit is at the head of the array.

Increment the integer by one and return the resulting array of digits.

---

## Approach

We simulate the process of adding one starting from the **last digit**.

1. Traverse the array from right to left.
2. If a digit is less than 9, increment it and return the array.
3. If a digit is 9, set it to 0 and continue.
4. If all digits are 9, create a new array with an extra leading `1`.

This mimics elementary addition with carry.

---

## Code (Java)

```java
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
```
## Complexity Analysis
Time Complexity: O(n)

Space Complexity: O(n) (only when all digits are 9)

## Key Insight
Carry propagation only continues while digits are equal to 9.
Once a digit less than 9 is found, the process stops immediately.