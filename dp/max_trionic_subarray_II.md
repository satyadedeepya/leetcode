# Maximum Sum Trionic Subarray

## Problem Summary
Given an integer array `nums`, find the **maximum possible sum** of a
subarray that follows a **trionic pattern**:

1. Strictly increasing
2. Strictly decreasing
3. Strictly increasing

The subarray must contain all three phases in order.
If no such subarray exists, return the maximum achievable value according
to the problem constraints.

## Approach
This problem is solved using **Dynamic Programming** with three states:

- `dp0[i]`: maximum sum of a **strictly increasing** subarray ending at index `i`
- `dp1[i]`: maximum sum of an **increasing → decreasing** subarray ending at `i`
- `dp2[i]`: maximum sum of an **increasing → decreasing → increasing**
  subarray ending at `i`

Each state transitions only if the strict inequality condition is met.
Invalid states are initialized with a very small value (`NEG`) to prevent
illegal transitions.

The final answer is the maximum value in `dp2`.

## Code (Java)
```java
class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long NEG = -(1L << 60);

        long[] dp0 = new long[n]; // increasing
        long[] dp1 = new long[n]; // inc -> dec
        long[] dp2 = new long[n]; // inc -> dec -> inc

        // initialize all as invalid
        for (int i = 0; i < n; i++) {
            dp0[i] = dp1[i] = dp2[i] = NEG;
        }

        for (int i = 1; i < n; i++) {

            // phase 1: increasing
            if (nums[i - 1] < nums[i]) {
                dp0[i] = nums[i - 1] + nums[i];
                if (dp0[i - 1] != NEG)
                    dp0[i] = Math.max(dp0[i], dp0[i - 1] + nums[i]);
            }

            // phase 2: decreasing
            if (nums[i - 1] > nums[i]) {
                if (dp0[i - 1] != NEG)
                    dp1[i] = dp0[i - 1] + nums[i];
                if (dp1[i - 1] != NEG)
                    dp1[i] = Math.max(dp1[i], dp1[i - 1] + nums[i]);
            }

            // phase 3: increasing again
            if (nums[i - 1] < nums[i]) {
                if (dp1[i - 1] != NEG)
                    dp2[i] = dp1[i - 1] + nums[i];
                if (dp2[i - 1] != NEG)
                    dp2[i] = Math.max(dp2[i], dp2[i - 1] + nums[i]);
            }
        }

        long ans = NEG;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp2[i]);
        }

        return ans;
    }
}
```
## Complexity
Time Complexity: O(n) — single pass with constant transitions

## Space Complexity: O(n) — three DP arrays

Key Insight
A trionic subarray requires three ordered monotonic phases.
Separating these phases into DP states allows us to enforce ordering
while maximizing the sum efficiently.