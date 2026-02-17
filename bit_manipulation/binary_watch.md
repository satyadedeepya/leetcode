# Binary Watch

**LeetCode Problem:** https://leetcode.com/problems/binary-watch/

---

## Problem Summary

A binary watch has:

- 4 LEDs for hours (0–11)
- 6 LEDs for minutes (0–59)

Each LED represents a power of 2.

Given an integer `turnedOn`, return all possible valid times
where exactly `turnedOn` LEDs are lit.

---

## Approach

Since:

- Hours range from 0 to 11
- Minutes range from 0 to 59

We brute-force all possible combinations.

For each (hour, minute):
1. Count number of set bits using `Integer.bitCount()`
2. If total bits equal `turnedOn`, add formatted time

We ensure minutes are formatted with leading zero if needed.

---

## Code (Java)

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int hour = 0; hour < 12; hour++) {
            for (int min = 0; min < 60; min++) {
                int totalBits = Integer.bitCount(hour) + Integer.bitCount(min);

                if (totalBits == turnedOn) {
                    String time = hour + ":" + (min < 10 ? "0" + min : min);
                    result.add(time);
                }
            }
        }

        return result;
    }
}
```
## Complexity Analysis
Time Complexity: O(12 × 60) ≈ O(1)

Space Complexity: O(k) (for valid results)

## Key Insight
Instead of generating combinations of LEDs,
we iterate through valid time ranges and use
Integer.bitCount() to count active LEDs efficiently.