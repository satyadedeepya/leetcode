# Roman to Integer

**LeetCode Problem:** https://leetcode.com/problems/roman-to-integer/

---

## Problem Summary

Roman numerals are represented by seven symbols:

| Symbol | Value |
|------|------|
| I | 1 |
| V | 5 |
| X | 10 |
| L | 50 |
| C | 100 |
| D | 500 |
| M | 1000 |

Roman numerals are usually written from left to right in descending order.
However, in certain cases subtraction is used (e.g., `IV = 4`, `IX = 9`).

Given a Roman numeral string `s`, convert it to its integer value.

---

## Approach

We iterate through the string **from right to left**.

- Maintain the value of the previous numeral.
- If the current numeral is **smaller** than the previous one, subtract it.
- Otherwise, add it to the total.

This handles subtraction cases naturally without special conditions.

---

## Code (Java)

```java
class Solution {
    public int romanToInt(String s) {
        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int value = getValue(s.charAt(i));

            if (value < prevValue) {
                total -= value;
            } else {
                total += value;
            }

            prevValue = value;
        }

        return total;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
```
## Complexity Analysis
Time Complexity: O(n)

Space Complexity: O(1)

## Key Insight
By scanning from right to left and comparing each numeral with the previous one,
we can correctly handle all subtraction cases without extra checks or mappings.