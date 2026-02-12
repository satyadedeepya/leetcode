## Problem Summary

A subarray is considered **balanced** if:

- The number of **distinct even numbers**
- Equals the number of **distinct odd numbers**

Given an integer array `nums`, return the length of the longest balanced subarray.

---

## Approach

Since `n ≤ 1500`, we can safely use a **brute-force approach**.

For every starting index:
1. Maintain two sets:
   - One for distinct even numbers
   - One for distinct odd numbers
2. Expand the subarray.
3. If both sets have equal size, update the maximum length.

Using sets ensures we only count **distinct values**.

---

## Code (Java)

```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();

            for (int j = i; j < n; j++) {
                int x = nums[j];

                if ((x & 1) == 0) {
                    even.add(x);
                } else {
                    odd.add(x);
                }

                if (even.size() == odd.size()) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }
}
```
## Complexity Analysis
Time Complexity: O(n²)

Space Complexity: O(n) (for the sets)

## Key Insight
We only care about the number of distinct even and odd values,
not their frequency.

Using sets simplifies distinct counting while keeping the solution clear and correct.