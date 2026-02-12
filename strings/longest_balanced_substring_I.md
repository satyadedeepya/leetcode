# Longest Balanced Substring I

**LeetCode Problem:** https://leetcode.com/problems/longest-balanced-substring-i/

---

## Problem Summary

A substring is considered **balanced** if all distinct characters
within the substring appear the **same number of times**.

Given a string `s`, return the length of the longest balanced substring.

---

## Approach

Since `n ≤ 1000`, we can check all substrings efficiently.

For each starting index:
- Maintain a frequency array of size 26.
- Track:
  - Number of distinct characters
  - Minimum frequency among them
  - Maximum frequency among them

A substring is balanced if:

maxFreq == minFreq


We update the maximum length whenever the condition holds.

---

## Code (Java)

```java
class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int minFreq = Integer.MAX_VALUE;
                int maxFreq = 0;
                int distinct = 0;

                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        distinct++;
                        minFreq = Math.min(minFreq, freq[k]);
                        maxFreq = Math.max(maxFreq, freq[k]);
                    }
                }

                if (distinct > 0 && minFreq == maxFreq) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
}
```
## Complexity Analysis
Time Complexity: O(26 * n²) ≈ O(n²)

Space Complexity: O(1) (fixed 26 array)

## Key Insight
A substring is balanced when the minimum and maximum
frequencies among distinct characters are equal.

Since the alphabet size is fixed (26), checking frequency
balance is constant time.