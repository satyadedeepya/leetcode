Minimum Number of Flips to Make the Binary String Alternating

LeetCode Link: https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/

Problem Summary

Given a binary string s, you are allowed to perform two types of operations:

Rotate the string (move the first character to the end).

Flip a character (0 → 1 or 1 → 0).

Return the minimum number of flips required to make the string alternating.

An alternating string is one where:

characters alternate between 0 and 1

examples: "0101", "1010"

Intuition

A binary alternating string can have two possible patterns:

Pattern 1: 010101...
Pattern 2: 101010...

Since rotations are allowed, the string can start from any position.

To simulate all rotations efficiently, we duplicate the string:

t = s + s

Then we use a sliding window of size n (original string length).
Each window represents a possible rotation of the string.

For every window, we calculate the number of mismatches with:

Pattern 0101...

Pattern 1010...

The minimum mismatch across all windows gives the minimum flips required.

Approach

Let n be the length of the string.

Create a new string t = s + s to simulate rotations.

Maintain two mismatch counters:

alt1 → mismatches with "010101..."

alt2 → mismatches with "101010..."

Use a sliding window of size n:

Expand window using right

Shrink window using left

Update mismatch counts when characters enter or leave the window.

When window size becomes n, compute the minimum flips.

Code
```java
class Solution {
    public int minFlips(String s) {

        int n = s.length();
        String t = s + s;

        int alt1 = 0;
        int alt2 = 0;

        int ans = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < t.length(); right++) {

            char p1 = (right % 2 == 0) ? '0' : '1';
            char p2 = (right % 2 == 0) ? '1' : '0';

            if (t.charAt(right) != p1) alt1++;
            if (t.charAt(right) != p2) alt2++;

            if (right - left + 1 > n) {

                char lp1 = (left % 2 == 0) ? '0' : '1';
                char lp2 = (left % 2 == 0) ? '1' : '0';

                if (t.charAt(left) != lp1) alt1--;
                if (t.charAt(left) != lp2) alt2--;

                left++;
            }

            if (right - left + 1 == n) {
                ans = Math.min(ans, Math.min(alt1, alt2));
            }
        }

        return ans;
    }
}
```
## Complexity

Time Complexity:
O(n) — The sliding window traverses the doubled string once.

Space Complexity:
O(n) — Due to the duplicated string s + s.

## Key Insight

Rotations can be simulated by doubling the string and using a sliding window.
By comparing each window with both alternating patterns (0101... and 1010...), we efficiently compute the minimum number of flips required.