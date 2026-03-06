Check If Binary String Has at Most One Segment of Ones

LeetCode Link: https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/

Problem Summary

Given a binary string s consisting only of '0' and '1', determine whether the string contains at most one contiguous segment of 1s.

Return true if there is only one segment of 1s, otherwise return false.

A valid string may look like:

111000
111
1

An invalid string contains multiple segments of 1s, such as:

101
110011
1001
Approach

We traverse the string once while tracking whether a 0 has already appeared.

Algorithm:

Maintain a boolean variable seenZero.

Iterate through each character in the string.

If a 0 is encountered, mark seenZero = true.

If a 1 appears after a 0 has already been seen, it means a second segment of ones has started, so return false.

If the traversal completes without detecting this pattern, return true.

This effectively checks whether the pattern

1 ... 0 ... 1

exists in the string.

Code 
```java
class Solution {
    public boolean checkOnesSegment(String s) {

        boolean seenZero = false;

        for (char c : s.toCharArray()) {

            if (c == '0') {
                seenZero = true;
            }
            else if (seenZero && c == '1') {
                return false;
            }
        }

        return true;
    }
}
```
## Complexity

Time Complexity: O(n) — single traversal of the string

Space Complexity: O(1) — constant extra space

## Key Insight

A binary string has more than one segment of ones if a 1 appears after a 0 has already been encountered.
Tracking this condition with a simple boolean flag allows the problem to be solved efficiently in a single pass without extra memory.