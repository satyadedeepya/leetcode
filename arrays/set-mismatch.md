## Set-Mismatch

**LeetCode Link:** https://leetcode.com/problems/set-mismatch/

## Problem Summary
You are given an integer array `nums` that originally contained all numbers from **1 to n**.  
Due to an error, one number in the set was duplicated, causing another number to be missing.

Your task is to find:
- The number that **appears twice**
- The number that **is missing**

Return them as an array:


[duplicate, missing]


---

## Approach
This solution uses a **HashSet** to track numbers that have already appeared.

1. Traverse the array `nums`.
2. Insert each number into a HashSet.
3. If a number already exists in the set, it is the **duplicate**.
4. After processing the array, iterate from **1 to n**.
5. The number that is **not present in the set** is the **missing number**.

Using a HashSet allows constant-time lookups, making the solution efficient.

---

## Code (Java)

```java
import java.util.HashSet;

class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        HashSet<Integer> set = new HashSet<>();

        int duplicate = -1;
        int missing = -1;

        for(int num : nums){
            if(set.contains(num)){
                duplicate = num;
            } else {
                set.add(num);
            }
        }

        for(int i = 1; i <= n; i++){
            if(!set.contains(i)){
                missing = i;
                break;
            }
        }

        return new int[]{duplicate, missing};
    }
}
```
## Complexity

Time Complexity: O(n) — single pass to detect duplicate and another pass to find missing number.

Space Complexity: O(n) — additional space used by the HashSet.

## Key Insight

The array should contain exactly the numbers from 1 to n.
Using a HashSet makes it easy to detect:

When a number appears more than once (duplicate).

Which number from 1..n never appeared (missing).