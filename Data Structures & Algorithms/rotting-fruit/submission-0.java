class Solution {
    public int orangesRotting(int[][] grid) {
        //The intuition for this question:
        /* 
        
        The way we approach this question can be similar to the previous question
        that we just had:   "Shortest way to gates"

        Where we will perform BFS onto the 'rotten fruits'

        and Each iteration of BFS will be considered as 1 minute

        Stop the iteration when there are no adjacent cell with 'fresh fruit'
        (or empty the queue in the term of BFS)


        Algorithm:
        - Loop through all the position of the grid, store all the location 
        WHERE the initial rotten fruits are located at
            -> Add those rotten location into a queue
        - Each round, pop all the rotten location in the queue
            -> Find for adjacent fresh fruit
            -> Rot the fresh fruits
            -> Add the newly rotten fruits into the queue
            -> After each round, add 1 minute onto the timer count
        - Stop when the queue is empty

        Return -1 if there's still a fresh fruit in the grid
        Else return the timer count
        */

        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;
        
        //iterating through all the positions inside the grid
        for (int i = 0, n = grid.length; i < n; i++) {
            for (int j = 0, m = grid[0].length; j < m; j++) {
                //check if the position have the 'rotten fruit'
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {

            boolean isAdded = false;

            //performing one iteration
            for (int i = 0, n = queue.size(); i < n; i++) {
                int[] pos = queue.poll();
                List<int[]> fruits = getFreshFruits(grid, pos[0], pos[1]);
                for (int[] fruit : fruits) {
                    if (!queue.contains(fruit)) {
                        queue.offer(fruit);
                        grid[fruit[0]][fruit[1]] = 2;
                        fresh--;
                    }
                    isAdded = true;
                }
            }

            if (isAdded) count++;
        }

        if (fresh > 0) return -1;
        return count;

    }

    public List<int[]> getFreshFruits(int[][] grid, int row, int col) {
        List<int[]> pos = new ArrayList<>();

        //check for upper fruit
        if (row > 0 && grid[row - 1][col] == 1) {
            pos.add(new int[]{row - 1, col});
        }

        //check for lower fruit
        if (row + 1 < grid.length && grid[row + 1][col] == 1) {
            pos.add(new int[]{row + 1, col});
        }

        //check for left fruit 
        if (col > 0 && grid[row][col - 1] == 1) {
            pos.add(new int[]{row, col - 1});
        }

        //check for right fruit
        if (col + 1 < grid[0].length && grid[row][col + 1] == 1) {
            pos.add(new int[]{row, col + 1});
        }

        return pos;
    }
}
