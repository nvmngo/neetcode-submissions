class Solution {
    public int uniquePaths(int m, int n) {
        //The intuition for this question:
        /* 
        For any certain position of [i, j]:
            The number of possible unique paths 
        =   The TOTAL of number of possible unique paths
                COMING FROM the adjacent unvisited position
        
        We can implement a cache, storing the total number of possible paths
        of a certain position

        dp[i][j] = the total number of possible paths at row i^th, column j^th
        */

        int[][] visited = new int[m][n];
        Integer[][] dp = new Integer[m][n];

        return uniquePathsHelper(visited, dp, 0, 0);
    }

    public int uniquePathsHelper(int[][] visited, Integer[][] dp, int row, int col) {
        //base case
        if (dp[row][col] != null) {
            return dp[row][col];
        }

        if (row == visited.length - 1 && col == visited[0].length - 1) {
            dp[row][col] = 1;
            return 1;
        }

        //recursive case
        visited[row][col] = 1;
        List<int[]> paths = getPaths(row, col, visited);

        int sum = 0;
        for (int[] path : paths) {
            sum += uniquePathsHelper(visited, dp, path[0], path[1]);
        }

        dp[row][col] = sum;
        visited[row][col] = 0;
        return sum;
    }

    public List<int[]> getPaths(int row, int col, int[][] visited) {
        List<int[]> paths = new ArrayList<>();

        //checking lower position
        if (row + 1 < visited.length && visited[row + 1][col] != 1) {
            paths.add(new int[]{row + 1, col});
        }

        //checking right position
        if (col + 1 < visited[0].length && visited[row][col + 1] != 1) {
            paths.add(new int[]{row, col + 1});
        }

        return paths;
    }
}
