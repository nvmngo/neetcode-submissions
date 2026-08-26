class Solution {
    public void setZeroes(int[][] matrix) {
        int[] cols = new int[matrix[0].length];
        int[] rows = new int[matrix.length];

        for (int i = 0, n = matrix.length; i < n; i++) {
            for (int j = 0, m = matrix[0].length; j < m; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for (int i = 0, n = rows.length; i < n; i++) {
            if (rows[i] == 1) {
                Arrays.fill(matrix[i], 0); 
            }
        }

        for (int j = 0, n = cols.length; j < n; j++) {
            if (cols[j] == 1) {
                for (int i = 0, m = matrix.length; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
