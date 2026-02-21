# Prime Number of Set Bits in Binary Representation

**LeetCode Problem:** https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/

---

## Problem Summary

For every number between `left` and `right` (inclusive):

1. Count the number of set bits (1s in binary form).
2. If the count is prime, increment the answer.

Return the total count.

---

## Key Observation

For numbers ≤ 10^6:
- Maximum number of set bits is ≤ 20
- So we only need to check prime numbers up to 20

Instead of computing primality repeatedly,
we precompute a small boolean array of prime numbers.

---

## Approach

1. Create a boolean array `isPrime[21]`
2. Mark prime numbers manually (2, 3, 5, 7, 11, 13, 17, 19)
3. For each number:
   - Use `Integer.bitCount(i)`
   - Check if prime
   - Increment result

---

## Code (Java)

```java
class Solution {
    public int countPrimeSetBits(int left, int right) {

        boolean[] isprime = new boolean[21];
        isprime[2] = true;
        isprime[3] = true;
        isprime[5] = true;
        isprime[7] = true;
        isprime[11] = true;
        isprime[13] = true;
        isprime[17] = true;
        isprime[19] = true;

        int count = 0;

        for (int i = left; i <= right; i++) {
            int bits = Integer.bitCount(i);
            if (isprime[bits]) {
                count++;
            }
        }

        return count;
    }
}
```
## Complexity Analysis

Time Complexity: O(n)

## Space Complexity: O(1)

Key Insight

The number of set bits is bounded by 20,
so we avoid expensive prime checks by using
a precomputed lookup array.