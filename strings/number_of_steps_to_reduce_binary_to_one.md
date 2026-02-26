# Number of Steps to Reduce a Number in Binary Representation to One

**LeetCode Problem:** https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/

---

## Problem Summary

Given a binary string `s`, reduce it to `"1"` using:

- If even → divide by 2
- If odd → add 1

Return the number of steps required.

---

## Key Insight

Instead of converting the binary string to a large integer,
we simulate the process from right to left.

Observations:

- Dividing by 2 → move left (one step)
- Adding 1 → creates a carry if bit is 1
- We maintain a `carry` variable to simulate addition

We iterate from the least significant bit to the most significant bit.

---

## Approach

For each bit (from right to left):

- Compute `bit + carry`
- If result is 1 → odd case:
  - Add 2 steps (add 1 + divide)
  - Set carry = 1
- Else → even case:
  - Add 1 step (divide only)

Finally, add remaining carry if any.

---

## Code (Java)

```java
class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            int bit = s.charAt(i) - '0';
            int sum = bit + carry;

            if (sum == 1) {
                steps += 2;
                carry = 1;
            } else {
                steps += 1;
            }
        }

        return steps + carry;
    }
}
```
## Complexity Analysis

Time Complexity: O(n)

Space Complexity: O(1)

Why This Works

We simulate binary addition using carry.

Avoid converting to BigInteger.

Handle up to length 500 efficiently.

## Key Insight

Odd number → add 1 (creates carry)
Even number → divide by 2

Binary carry simulation makes the solution linear.