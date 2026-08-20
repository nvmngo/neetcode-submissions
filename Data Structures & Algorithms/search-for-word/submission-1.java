class Solution {
    public boolean exist(char[][] board, String word) {
        /*
        The intuition for this question:
        
        - Go through every element of the board, WHERE the letter is that starting letter of the word
        - Go through every possible path of the current position
        - DFS to check if the word exists in the paths
        - return true if yes, else false

        */


        //iterate through every position of the board

        int[][] visited = new int[board.length][board[0].length];
        
        for (int i = 0, n = board.length; i < n; i++) {
            for (int j = 0, m = board[0].length; j < m; j++) {
                
                //check if the current position match the first char
                if (board[i][j] != word.charAt(0)) { continue; }

                if (existHelper(board, word, 1, i, j, visited) == true) {
                    return true;
                }               
            }
        }

        return false;
    }

    //implement a helper function: finding the word
    public boolean existHelper(char[][] board, String word, int index, int row, int col, int[][] visited) {

        //base case
        if (index == word.length()) return true;

        visited[row][col] = 1;
        List<int[]> paths = possiblePaths(row, col, visited, board, word.charAt(index));

        if (paths.size() == 0) {
            visited[row][col] = 0;
            return false; 
        }

        //check through cases in the 
        boolean res = false;
        for (int[] path : paths) {
            if (existHelper(board, word, index + 1, path[0], path[1], visited)) {
                res = true;
            };
        }

        visited[row][col] = 0;
        return res;
    }

    //implement a helper function:  indicating the possible paths
    public List<int[]> possiblePaths(int row, int col, int[][] visited, char[][] board, char c) {
        List<int[]> positions = new ArrayList<>();

        //checking up
        if (row - 1 >= 0) {
            if (visited[row - 1][col] == 0 && board[row - 1][col] == c) {
                positions.add(new int[]{row - 1, col});
            }
        }

        //checking down 
        if (row + 1 < visited.length) {
            if (visited[row + 1][col] == 0 && board[row + 1][col] == c) {
                positions.add(new int[]{row + 1, col});
            }
        }

        //checking left
        if (col - 1 >= 0) {
            if (visited[row][col - 1] == 0 && board[row][col - 1] == c) {
                positions.add(new int[]{row, col - 1});
            }
        }

        //checking right 
        if (col + 1 < visited[0].length) {
            if (visited[row][col + 1] == 0 && board[row][col + 1] == c) {
                positions.add(new int[]{row, col + 1});
            }
        }

        //return the path list
        return positions; 
    }
}
