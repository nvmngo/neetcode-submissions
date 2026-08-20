class Solution {
    public void islandsAndTreasure(int[][] grid) {        
        //The intuition for this question:
        /*
        Loop through all the positions of the grid
        
        - Ignore all the non-treasure lands
        - When we reach a treasure land
            - Start exploring all paths of the islands
            - At each stop on a land from a certain path
                - Store the number of steps that took the treasure to the land
        - Keep doing this until we loop through all of the island 
        */

        
        //looping through the grid
        for (int i = 0, n = grid.length; i < n; i++) {
            for (int j = 0, m = grid[0].length; j < m; j++) {
                // whether this a treasure land
                if (grid[i][j] == 0) {
                    traverse(grid, i, j, 0);
                }
            }
        }
    }

    public void traverse(int[][] grid, int row, int col, int count) {
        
        if (count != 0 && grid[row][col] <= count) {
            return;
        }

        if (count != 0) {
            grid[row][col] = count;
        }

        List<int[]> paths = getPossiblePaths(grid, row, col);

        for (int[] path : paths) {
            traverse(grid, path[0], path[1], count + 1);
        }
    }

    /*------------------------------------------------------------------------*/

    public List<int[]> getPossiblePaths(int[][] grid, int row, int col) {
        List<int[]> paths = new ArrayList<>();

        //check for upper land
        if (row > 0 && !(grid[row - 1][col] == -1 || grid[row - 1][col] == 0)) {
            paths.add(new int[]{row - 1, col});
        }

        //check for lower land
        if (row + 1 < grid.length && !(grid[row + 1][col] == -1 || grid[row + 1][col] == 0)) {
            paths.add(new int[]{row + 1, col});
        }

        //check for left land
        if (col > 0 && !(grid[row][col - 1] == -1 || grid[row][col - 1] == 0)) {
            paths.add(new int[]{row, col - 1});
        }

        //check for right land
        if (col + 1 < grid[0].length && !(grid[row][col + 1] == -1 || grid[row][col + 1] == 0)) {
            paths.add(new int[]{row, col + 1});
        }

        return paths;
    }
}
