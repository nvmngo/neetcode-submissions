class Solution {
    public void rotate(int[][] matrix) {
        // The intuition for this question
        /* 
            FIRST ROW -> LAST COLUMN
            LAST COLUMN -> LAST ROW
            LAST ROW -> FIRST COLUMN
            FIRST COLUMN -> FIRST ROW
        */

        for (int i = 0, n = matrix.length / 2; i < n; i++) {
            helper(matrix, i);
        }
    }

    public void helper(int[][] matrix, int pos) {
        // Iterating through the different swapping position
        for (int i = pos, n = matrix.length - pos - 1; i < n; i++) {
            // swapping each of the element
            int temp = matrix[i][n];    // n - 1 indicating the final col in the row
            matrix[i][n] = matrix[pos][i];  // pos - indicates the first row 

            int temp2 = matrix[n][matrix.length - i - 1];
            matrix[n][matrix.length - i - 1] = temp;

            temp = matrix[matrix.length - i - 1][pos];
            matrix[matrix.length - i - 1][pos] = temp2;

            matrix[pos][i] = temp;
        }
    }
}
