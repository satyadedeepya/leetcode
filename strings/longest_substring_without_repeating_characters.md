Longest Substring Without Repeating Characters

LeetCode Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

Problem Summary

Given a string s, find the length of the longest substring without repeating characters.

A substring must contain unique characters only, meaning no character appears more than once in that substring.

Intuition

To solve this efficiently, we use the Sliding Window technique.

The idea is to maintain a window [j, i] representing a substring with unique characters.

If the current character has not appeared in the window, we expand the window.

If the character already exists, we shrink the window from the left until the duplicate is removed.

A frequency array is used to track characters currently inside the window.

Approach

Initialize:

j → left pointer of the sliding window

count → maximum substring length

freq[] → frequency array to track characters

Traverse the string using pointer i.

If the current character has not appeared in the window, mark it in freq.

If it already exists, move the left pointer j forward until the duplicate character is removed.

Update the maximum window length:

window length = i - j + 1

Keep track of the maximum length found.

Code
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count = 0;
        int n = s.length();
        int j = 0;

        int[] freq = new int[255];

        for(int i = 0; i < n; i++){
            if(freq[s.charAt(i)] == 0){
                freq[s.charAt(i)] = 1;
            }
            else{
                while(s.charAt(j) != s.charAt(i)){
                    freq[s.charAt(j)] = 0;
                    j++;
                }
                j += 1;
            }

            count = Math.max(count, i - j + 1);
        }

        return count;
    }
}
```
## Complexity

Time Complexity

O(n)

Each character is processed at most twice by the sliding window.

Space Complexity

O(1)

The frequency array size is constant.

## Key Insight

The sliding window technique allows us to efficiently maintain a substring with unique characters by expanding and shrinking the window dynamically.

Instead of checking all substrings (O(n²)), we maintain a valid window in linear time.