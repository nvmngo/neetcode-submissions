class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        // The intuition for this question:
        /* 
        The very first approach one can come up with is using backtracking:
        - Iterate through each of the possible position of the matrix
            - Explore different branches of a certain starting point
            - Keep track of the branch with maximum length
        
        - For each of the starting position, store the longest length path within
        a 'cache'
            - dp[i][j] = the longest path going from row ith, col jth
        
        - Thus, if we visited a pre-visited position
            -> longest path of adjacent position = 1 + dp[i][j]
        */

        int[][] dp = new int[matrix.length][matrix[0].length];
        int[][] visited = new int[matrix.length][matrix[0].length];

        int max = 0;

        for (int i = 0, n = matrix.length; i < n; i++) {
            for (int j = 0, m = matrix[0].length; j < m; j++) {
                max = Math.max(max, helper(i, j, visited, matrix, dp));
            }
        }

        return max;
    }

    //Implement a helper method - recursive helper method
    public int helper(int row, int col, int[][] visited, int[][] matrix, int[][] dp) {
        //base case
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
 
        List<int[]> paths = getPaths(matrix, visited, row, col);
        if (paths.size() == 0) { return 1; }

        //recursive case
        visited[row][col] = 1;
        
        int max = 0;
        for (int[] path : paths) {
            max = Math.max(max, 1 + helper(path[0], path[1], visited, matrix, dp));
        }

        dp[row][col] = max;
        visited[row][col] = 0;
        return max;
    }



    //Implement a helper method - Finding the possible paths
    //                            a position can go through
    public List<int[]> getPaths(int[][] matrix, int[][] visited, int row, int col) {
        //Declaring the returning output
        List<int[]> paths = new ArrayList<>();

        //Checking for upper path
        if (row > 0 && visited[row - 1][col] == 0 &&
            matrix[row][col] < matrix[row - 1][col]) {
            
            paths.add(new int[]{row - 1, col});
        }

        //Checking for lower path
        if (row + 1 < matrix.length && visited[row + 1][col] == 0) {
            if (matrix[row][col] < matrix[row + 1][col]) {
                paths.add(new int[]{row + 1, col});
            }
        } 

        //Checking for lefter path
        if (col > 0 && visited[row][col - 1] == 0) {
            if (matrix[row][col] < matrix[row][col - 1]) {
                paths.add(new int[]{row, col - 1});
            }
        }

        //Checking for righter path
        if (col + 1 < matrix[0].length && visited[row][col + 1] == 0) {
            if (matrix[row][col] < matrix[row][col + 1]) {
                paths.add(new int[]{row, col + 1});
            }
        }

        //Return paths
        return paths;
    }
}
