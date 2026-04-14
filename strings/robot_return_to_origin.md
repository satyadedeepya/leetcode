# Robot Return to Origin

**LeetCode Problem:** https://leetcode.com/problems/robot-return-to-origin/

---

## Problem Summary

Given a string `moves` consisting of characters:
- `'U'` (up)
- `'D'` (down)
- `'L'` (left)
- `'R'` (right)

Each move represents a step taken by a robot starting at the origin `(0, 0)`.

Determine whether the robot returns to the origin after executing all moves.

---

## Approach (Simulation using Counters)

We simulate the robot's movement using two variables:

- `vertical` → tracks up/down movement  
- `horizontal` → tracks left/right movement  

Steps:
- Traverse each character in the string
- Update:
  - `'U'` → `vertical++`
  - `'D'` → `vertical--`
  - `'L'` → `horizontal++`
  - `'R'` → `horizontal--`
- At the end:
  - If both `vertical == 0` and `horizontal == 0`, robot returns to origin

---

## Code (Java)

```java
class Solution {
    public boolean judgeCircle(String moves) {
        int vertical = 0;
        int horizontal = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'U') vertical++;
            else if (c == 'D') vertical--;
            else if (c == 'L') horizontal++;
            else if (c == 'R') horizontal--;
        }

        return vertical == 0 && horizontal == 0;
    }
}
```
## Complexity Analysis

Time Complexity: O(n)
Single traversal of the string

Space Complexity: O(1)
Only two variables used