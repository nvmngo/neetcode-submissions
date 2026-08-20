class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        //the intuition:
        /* 
        Check through every island, and get the maximum area for each of the island
        */

        for (int i = 0, n = grid.length; i < n; i++) {
            for (int j = 0, m = grid[0].length; j < m; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, getIslandArea(grid, new int[]{i, j}));
                }
            }
        }

        return max;
    }

    public int getIslandArea(int[][] grid, int[] pos) {
        int area = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(pos);
        grid[pos[0]][pos[1]] = 2;

        while (!queue.isEmpty()) {
            int[] land = queue.poll();
            area++;

            List<int[]> lands = getLands(grid, land);
            for (int i = 0, n = lands.size(); i < n; i++) {
                queue.offer(lands.get(i));
                grid[lands.get(i)[0]][lands.get(i)[1]] = 2;
            }
        }

        return area;
    }

    public List<int[]> getLands(int[][] grid, int[] pos) {
        List<int[]> lands = new ArrayList<>();
        
        int row = pos[0];
        int col = pos[1];

        //check for upper land
        if (row > 0 && grid[row - 1][col] == 1) {
            lands.add(new int[]{row - 1, col});
        }

        //check for lower land 
        if (row + 1 < grid.length && grid[row + 1][col] == 1) {
            lands.add(new int[]{row + 1, col});
        }

        //check for left land
        if (col > 0 && grid[row][col - 1] == 1) {
            lands.add(new int[]{row, col - 1});
        }

        //check for right land
        if (col + 1 < grid[0].length && grid[row][col + 1] == 1) {
            lands.add(new int[]{row, col + 1});
        }

        return lands;
    }
}
