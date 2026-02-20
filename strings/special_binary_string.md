# Special Binary String

**LeetCode Problem:** https://leetcode.com/problems/special-binary-string/

---

## Problem Summary

A binary string is called **special** if:

1. The number of `0`s equals the number of `1`s.
2. Every prefix has at least as many `1`s as `0`s.

You are allowed to swap two consecutive special substrings.

Return the lexicographically largest string possible.

---

## Key Insight

A special string behaves like a valid parentheses string:
- `1` → opening bracket
- `0` → closing bracket

We:
1. Split the string into valid special substrings.
2. Recursively process the inner substring.
3. Wrap it with `"1"` and `"0"`.
4. Sort all substrings in descending order.
5. Concatenate them.

Sorting in reverse lexicographic order ensures the largest result.

---

## Approach

- Traverse the string using a counter.
- When counter becomes 0, we found one special substring.
- Recursively optimize the inner part.
- Store each block.
- Sort blocks in descending order.
- Join them.

---

## Code (Java)

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String makeLargestSpecial(String s) {
        List<String> list = new ArrayList<>();
        int count = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                String inner = makeLargestSpecial(s.substring(start + 1, i));
                list.add("1" + inner + "0");
                start = i + 1;
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        StringBuilder result = new StringBuilder();
        for (String str : list) {
            result.append(str);
        }

        return result.toString();
    }
}
```
## Complexity Analysis

Time Complexity: O(n² log n)
(due to recursion + sorting + substring creation)

Space Complexity: O(n)

## Key Insight

Treat the binary string like parentheses:

Extract balanced blocks

Recursively maximize inside

Sort blocks in reverse lexicographic order