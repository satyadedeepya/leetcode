# Add Two Numbers

**LeetCode Problem:** https://leetcode.com/problems/add-two-numbers/

---

## Problem Summary

You are given two non-empty linked lists representing two non-negative integers.

- Digits are stored in reverse order.
- Each node contains a single digit.
- Add the two numbers and return the result as a linked list.

---

## Approach

We simulate addition exactly like elementary math:

1. Traverse both linked lists simultaneously.
2. Add corresponding digits.
3. Maintain a carry.
4. Create new nodes for the result.
5. Continue while either list has nodes or carry exists.

We use a dummy node to simplify list construction.

---

## Code (Java)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode it = ans;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            it.next = new ListNode(sum % 10);
            carry = sum / 10;
            it = it.next;
        }

        return ans.next;
    }
}
```
## Complexity Analysis

Time Complexity: O(max(n, m))

Space Complexity: O(max(n, m))

Where n and m are the lengths of the two lists.

## Key Insight

Use a dummy head to simplify list construction.

Continue the loop while:

Either list has nodes

OR carry is non-zero

This ensures final carry is handled correctly.