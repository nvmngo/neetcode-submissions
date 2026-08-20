class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //a type of binary search, but we will search it through a 2d array, instead of 1d array
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            int row = middle / matrix[0].length;
            int column = middle % matrix[0].length;

            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return false; 
    }
}
