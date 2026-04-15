LeetCode Link: https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/

Problem Summary

You are given a circular array words and a string target.

From a given startIndex, you can move:

Right → (i + 1) % n
Left → (i - 1 + n) % n

Each move costs 1 step.

Return the minimum steps required to reach any index where words[i] == target.
If target does not exist → return -1.

Approach

Brute force—but done intelligently.

Instead of simulating movement in both directions (which invites bugs), we:

Traverse all indices i
If words[i] == target, compute:
Direct distance: |i - startIndex|
Circular distance: n - |i - startIndex|
Take the minimum of both
Track the global minimum

This works because in a circular array, the shortest path is either:

Direct path
Wrap-around path
Code (Java)
```java
class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int diff = Math.abs(i - startIndex);
                int dist = Math.min(diff, n - diff);
                minDist = Math.min(minDist, dist);
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
```
Test Cases
Test Case 1
Input:
words = ["hello","i","am","leetcode","hello"]
target = "hello"
startIndex = 1

Output:
1
Test Case 2
Input:
words = ["a","b","leetcode"]
target = "leetcode"
startIndex = 0

Output:
1
Test Case 3
Input:
words = ["i","eat","leetcode"]
target = "ate"
startIndex = 0

Output:
-1

## Complexity Analysis
Time Complexity: O(n)
Single traversal
Space Complexity: O(1)
No extra space used

## Key Insight

Circular distance is not linear.

The real trick is:

min(|i - startIndex|, n - |i - startIndex|)

This formula eliminates the need to simulate movement entirely.