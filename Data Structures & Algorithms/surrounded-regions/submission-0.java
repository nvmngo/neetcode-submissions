class Solution {
    public void solve(char[][] board) {
        //The intuition for this question:
        /* 
        The requirement for this program is that you need to capture every region
        of the 'O' cell where the region does not have any cell landed on the border
        of the board

        This is the approach:
        - Iterate through every cell of the board
        - WHEN see a 'O' cell that is not visited
            -> Indicating there is a unconsidered region
            -> Take the 'O' cell into consideration
        - Traverse through all the cell in that region (BFS)
            - Mark the considered cell as visited
            - Complete traversing the whole region
            -> If there is a cell that lies on the border
                -> Skip to next iteration
            -> If not, capture the region
        */

        //creating a board to keep track of visited position
        int[][] visited = new int[board.length][board[0].length]; 
        //queue for BFS
        Queue<int[]> queue = new LinkedList<>();

        //looping through each cell
        for (int i = 0, n = board.length; i < n; i++) {
            for (int j = 0, m = board[0].length; j < m; j++) {
                //check whether if the current cell is 'O' and 'unvisited'
                if (board[i][j] == 'O' && visited[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = 1;

                    boolean isValid = false;

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();

                        if (curr[0] == 0 || curr[0] == board.length - 1 || curr[1] == 0 || curr[1] == board[0].length - 1) {
                            isValid = true;
                        }

                        List<int[]> regions = getRegion(board, visited, curr[0], curr[1]);

                        for (int[] region : regions) {
                            queue.offer(region);
                            visited[region[0]][region[1]] = 1;
                        }
                    }

                    //if the region is not valid
                    if (!isValid) {
                        //traverse the whole way back to mark it as 'X'
                        capture(board, i, j);
                    }
                }
            }   
        }
    }

    public void capture(char[][] board, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        board[row][col] = 'X';

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            List<int[]> regions = getCapturedRegion(board, curr[0], curr[1]);

            for (int[] region : regions) {
                queue.offer(region);
                board[region[0]][region[1]] = 'X';
            }
        }
    }


    public List<int[]> getCapturedRegion(char[][] board, int row, int col) {
        List<int[]> paths = new ArrayList<>();

        //check for upper region
        if (row > 0 && board[row - 1][col] == 'O') {
            paths.add(new int[]{row - 1, col});
        }

        //check for lower region
        if (row + 1 < board.length && board[row + 1][col] == 'O') {
            paths.add(new int[]{row + 1, col});
        }

        //check for left region
        if (col > 0 && board[row][col - 1] == 'O') {
            paths.add(new int[]{row, col - 1});
        }

        //check for right region
        if (col + 1 < board[0].length && board[row][col + 1] == 'O') {
            paths.add(new int[]{row, col + 1});
        }

        return paths;
    }



    public List<int[]> getRegion(char[][] board, int[][] visited, int row, int col) {
        List<int[]> paths = new ArrayList<>();

        //check for upper region
        if (row > 0 && board[row - 1][col] == 'O' && visited[row - 1][col] == 0) {
            paths.add(new int[]{row - 1, col});
        }

        //check for lower region
        if (row + 1 < board.length && board[row + 1][col] == 'O' && visited[row + 1][col] == 0) {
            paths.add(new int[]{row + 1, col});
        }

        //check for left region
        if (col > 0 && board[row][col - 1] == 'O' && visited[row][col - 1] == 0) {
            paths.add(new int[]{row, col - 1});
        }

        //check for right region
        if (col + 1 < board[0].length && board[row][col + 1] == 'O' && visited[row][col + 1] == 0) {
            paths.add(new int[]{row, col + 1});
        }

        return paths;
    }
}
