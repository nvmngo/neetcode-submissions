class Solution {
    public int numIslands(char[][] grid) {
        //the intuition for this question:
        /* 
        Loop through the grid:
        - Once we saw an unvisited land
            -> Track all the land the island covers, mark all the land visited
        - Then continue with the loop
            -> Ignore if land is visited
            -> Track when a land is unvisited (marking a new island)
        */

        int count = 0;

        for (int i = 0, n = grid.length; i < n; i++) {
            for (int j = 0, m = grid[0].length; j < m; j++) {
                if (grid[i][j] == '1') {
                    cover(grid, new int[]{i, j});
                    count++;
                }
            }
        }

        return count; 
    }
    
    //helper function:  Tracking all the lands covered by a island
    public void cover(char[][] grid, int[] pos) {
        //use BFS, expand the island as we go
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(pos);

        while (!queue.isEmpty()) {
            int[] land = queue.poll();
            grid[land[0]][land[1]] = '2';

            List<int[]> lands = lands(grid, land);
            
            for (int i = 0, n = lands.size(); i < n; i++) {
                queue.offer(lands.get(i));
            }
        }
    }

    public List<int[]> lands(char[][] grid, int[] pos) {
        
        List<int[]> lands = new ArrayList<>();
        
        int row = pos[0];
        int col = pos[1];

        //check for upper land
        if (row > 0) {
            if (grid[row - 1][col] == '1' ) {
                lands.add(new int[]{row - 1, col});
            }
        }

        //check for lower land
        if (row + 1 < grid.length) {
            if (grid[row + 1][col] == '1') {
                lands.add(new int[]{row + 1, col});
            }
        }

        //check for left land
        if (col > 0) {
            if (grid[row][col - 1] == '1') {
                lands.add(new int[]{row, col - 1});
            }
        }

        //check for right land
        if (col + 1 < grid[0].length) {
            if (grid[row][col + 1] == '1') {
                lands.add(new int[]{row, col + 1});
            }
        }

        return lands;
    }
}
