# Find Kth Bit in Nth Binary String

**LeetCode Problem:** https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/

---

## Problem Summary

The binary string Sₙ is defined recursively:

- S₁ = "0"
- Sᵢ = Sᵢ₋₁ + "1" + reverse(invert(Sᵢ₋₁))

Given `n` and `k`, return the k-th bit (1-indexed) in Sₙ.

---

## Approach (Iterative Construction)

We build the string from S₁ up to Sₙ using the given rule:

1. Append previous string.
2. Append "1".
3. Append reversed + inverted previous string.

Finally, return the (k - 1) indexed character.

This works because constraints allow building the full string.

---

## Code (Java)

```java
class Solution {
    public char findKthBit(int n, int k) {
        String s = "0";   // S1
        
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            
            // Part 1: previous string
            sb.append(s);
            
            // Part 2: add "1"
            sb.append("1");
            
            // Part 3: reverse and invert previous string
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s.charAt(j) == '0') {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }
            
            s = sb.toString();
        }
        
        return s.charAt(k - 1);  // k is 1-based
    }
}
```
## Complexity Analysis

Time Complexity: O(2ⁿ)

Space Complexity: O(2ⁿ)

Since string length doubles each iteration.

## Key Insight

The string is constructed symmetrically:
Sₙ = Left + "1" + reverse(invert(Left))

Because constraints are small (n ≤ 20),
full construction is acceptable.