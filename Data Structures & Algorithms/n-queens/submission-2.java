class Solution {
    public List<List<String>> solveNQueens(int n) {
        //intuition:
        /* 

        Going through each of the position of the chess board:
        -> Place the first queen onto every position of the chess board
        -> For each queen placement,  that would be one scenario of the board
        -> Continue to loop through the different position ofthe chess board
            -> Place the next queen onto the next possible position (opening a new branch of scenario)
    
        */ 

        //declaring the initial board
        char[][] board = createBoard(n);
        int[][] attacked = new int[n][n];

        List<char[][]> res = new ArrayList<>();

        helper(board, attacked, 0, n, 0, 0, res);

        List<List<String>> result = new ArrayList<>();

        for (char[][] ele : res) {
            List<String> eleBoard = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = "";
                for (int j = 0; j < n; j++) {
                    s += ele[i][j];
                }
                eleBoard.add(s);
            }
            result.add(eleBoard);
        }

        return result;

    }

    //implement a helper function:  adding the queen
    public void helper(char[][] board, int[][] attacked, int count, int n, int row, int col, List<char[][]> res) {
        
        //base case

        if (count == n) {
            res.add(copyMatrixChar(board));
            return;
        }

        if (row == board.length) {
            return;
        }
        
        //CASE 1: position is valid to place a queen
        if (attacked[row][col] == 0) {
            //CHOICE 1: place the queen
            board[row][col] = 'Q';
            int[][] current = attacked;
            attacked = updateAttacked(attacked, row, col);
            helper(board, attacked, count + 1, n, (col + 1 < n) ? row : row + 1, (col + 1 < n) ? col + 1 : 0, res);
            
            board[row][col] = '.';
            attacked = current;
            //CHOICE 2: skip the queen
            helper(board, attacked, count, n, (col + 1 < n) ? row : row + 1, (col + 1 < n) ? col + 1 : 0, res);
        }

        //CASE 2: position is not valid to place a queen
        if (attacked[row][col] == 1) {
            //skip the position, move to the next
            helper(board, attacked, count, n, (col + 1 < n) ? row : row + 1, (col + 1 < n) ? col + 1 : 0, res);
        }
    }

    public int[][] updateAttacked(int[][] attacked, int row, int col) {
        
        int[][] newAttacked = copyMatrix(attacked);
        
        for (int i = 0, n = attacked[0].length; i < n; i++) {
            //for all the horizontal
            newAttacked[row][i] = 1;
            //for all the vertical
            newAttacked[i][col] = 1;
        }

        int i = row + 1;
        int j = col + 1;
        while (i < attacked.length && j < attacked.length) {
            newAttacked[i][j] = 1;
            i++;
            j++;
        }

        i = row + 1;
        j = col - 1;
        while (i < attacked.length && j >= 0) {
            newAttacked[i][j] = 1;
            i++;
            j--;
        }

        i = row - 1;
        j = col - 1;
        while (i >= 0 && j >= 0) {
            newAttacked[i][j] = 1;
            i--;
            j--;
        }

        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < attacked.length) {
            newAttacked[i][j] = 1;
            i--;
            j++;
        }

        return newAttacked;
    }

    //create board as an array
    public char[][] createBoard(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        return board;
    }

    public int[][] copyMatrix(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            copy[i] = matrix[i].clone();
        }

        return copy;
    }

    public char[][] copyMatrixChar(char[][] matrix) {
        char[][] copy = new char[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            copy[i] = matrix[i].clone();
        }

        return copy;
    }
}


