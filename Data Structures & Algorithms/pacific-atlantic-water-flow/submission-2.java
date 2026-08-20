class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //The intuition for this question
        /* 
        First thought algorithm:     Using simple BFS
        - Iterate through each of the cell
            - Perform BFS
            - Explore all the possible paths
            - A path will be stopped when that path lead to 'one' or 'both' of the ocean
            - Evaluate the path and add the cell
        
        Second though algorithm:     Use backtracking   
        (With the intuition of if a cell is valid, then any other cell that is
        'adjacent' to it, and 'taller', will also be valid)

        */

        List<List<Integer>> res = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        //Iterating through every cell of the island
        for (int i = 0, n = heights.length; i < n; i++) {
            for (int j = 0, m = heights[0].length; j < m; j++) {
                int[][] visited = new int[heights.length][heights[0].length];
                
                boolean pacific = false;
                boolean atlantic = false;

                queue.offer(new int[]{i, j});

                while (!queue.isEmpty()) {
                    int[] pos = queue.poll();
                    
                    //check for pacific
                    if (pos[0] == 0 || pos[1] == 0) {
                        pacific = true;
                    }

                    //check for atlantic
                    if (pos[0] == heights.length - 1 || pos[1] == heights[0].length - 1) {
                        atlantic = true;
                    }

                    if (pacific && atlantic) {
                        List l = new ArrayList<Integer>();
                        l.add(i);
                        l.add(j);
                        res.add(l);
                        queue.clear();
                        break;
                    }

                    List<int[]> paths = getPaths(heights, pos[0], pos[1], visited);
                    for (int[] path : paths) {
                        queue.offer(path);
                        visited[path[0]][path[1]] = 1;
                    }
                }
            }
        }

        return res;
    }

    public List<int[]> getPaths(int[][] heights, int row, int col, int[][] visited) {
        int height = heights[row][col];
        List<int[]> paths = new ArrayList<>();

        //check upper path
        if (row > 0 && heights[row - 1][col] <= height && visited[row - 1][col] == 0) {
            paths.add(new int[]{row - 1, col});
        }

        //check lower path
        if (row + 1 < heights.length && heights[row + 1][col] <= height && visited[row + 1][col] == 0) {
            paths.add(new int[]{row + 1, col});
        }

        //check left path
        if (col > 0 && heights[row][col - 1] <= height && visited[row][col - 1] == 0) {
            paths.add(new int[]{row, col - 1});
        }

        //check right path 
        if (col + 1 < heights[0].length && heights[row][col + 1] <= height && visited[row][col + 1] == 0) {
            paths.add(new int[]{row, col + 1});
        }

        return paths;
    }
}
