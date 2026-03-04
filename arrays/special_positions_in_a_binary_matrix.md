Special Positions in a Binary Matrix

LeetCode Link: https://leetcode.com/problems/special-positions-in-a-binary-matrix/

Problem Summary

Given an m x n binary matrix mat, return the number of special positions in the matrix.

A position (i, j) is called special if:

mat[i][j] == 1

All other elements in row i are 0

All other elements in column j are 0

Intuition

A cell is special only if its row and column contain exactly one 1.

Instead of checking the entire row and column for every 1, we first count:

How many 1s are in each row

How many 1s are in each column

If a cell (i, j) contains 1 and:

row[i] == 1

col[j] == 1

then it is a special position.

Approach

Determine matrix dimensions m and n.

Create two arrays:

row[m] → stores the number of 1s in each row

col[n] → stores the number of 1s in each column

Traverse the matrix once:

If mat[i][j] == 1, increment row[i] and col[j].

Traverse the matrix again:

If mat[i][j] == 1 and row[i] == 1 and col[j] == 1, increment the count.

Return the final count.

Code
```java
class Solution {
    public int numSpecial(int[][] mat) {
        int count = 0;
        int m = mat.length;
        int n = mat[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1 && row[i] == 1 && col[j] == 1){
                    count++;
                }
            }
        }

        return count;
    }
}
```
## Complexity

Time Complexity: O(m × n)
The matrix is traversed twice.

Space Complexity: O(m + n)
Extra arrays are used to store row and column counts.

## Key Insight

A position is special only when both its row and column contain exactly one 1.
Precomputing row and column counts allows us to check this condition efficiently without repeatedly scanning rows and columns.