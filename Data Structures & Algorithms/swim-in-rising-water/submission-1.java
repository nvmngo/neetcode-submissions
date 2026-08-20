class Solution {
    public int swimInWater(int[][] grid) {
        //  The intuition for this question:
        /* 
            Approach the problem with a BFS solution
        */

        Integer[][] temp = new Integer[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        temp[0][0] = grid[0][0];

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            List<int[]> paths = getPaths(curr[0], curr[1], grid);

            for (int[] path : paths) {
                int val = Math.max(temp[curr[0]][curr[1]], grid[path[0]][path[1]]);
                if (temp[path[0]][path[1]] == null || temp[path[0]][path[1]] > val) {
                    temp[path[0]][path[1]] = val;
                    queue.offer(path);
                }
            }
        }

        return temp[grid.length -1][grid[0].length -1];
    }

    public List<int[]> getPaths(int row, int col, int[][] grid) {
        List<int[]> paths = new ArrayList<>();
        
        if (row + 1 < grid.length) {
            paths.add(new int[]{row + 1, col});
        }

        if (col + 1 < grid[0].length) {
            paths.add(new int[]{row, col + 1});
        }

        if (row > 0) {
            paths.add(new int[]{row - 1, col});
        }

        if (col > 0) {
            paths.add(new int[]{row, col - 1});
        }

        return paths;
    }
}
