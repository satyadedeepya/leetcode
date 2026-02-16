# Reverse Bits

**LeetCode Problem:** https://leetcode.com/problems/reverse-bits/

---

## Problem Summary

Reverse the bits of a given 32-bit unsigned integer.

Return the reversed bit representation as an integer.

---

## Approach

We iterate exactly **32 times** (since an integer has 32 bits).

At each step:

1. Left-shift the result.
2. Extract the least significant bit from `n`.
3. Add that bit to the result.
4. Unsigned right shift `n`.

We use `>>>` (unsigned right shift) to avoid sign extension.

---

## Code (Java)

```java
public class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>>= 1;
        }

        return result;
    }
}
```
## Complexity Analysis
Time Complexity: O(1)
(Always 32 iterations)

Space Complexity: O(1)

## Key Insight
Bit-by-bit extraction and reconstruction allows us
to reverse the 32-bit representation efficiently.

Unsigned right shift (>>>) is critical to prevent sign propagation.

