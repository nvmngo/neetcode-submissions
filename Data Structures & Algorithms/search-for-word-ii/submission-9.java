class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        //the intuition is iterating from the list of words, we will check the existence of the word directly onto the table
        //iterating through the rows and cols of the board, start searching once we saw a matching char (which is the starting char of the word)
        //following the possible paths, setting up a method that will return true when we hit the final char of the word.

        List<String> res = new ArrayList<>();

        for (String word : words) {
            char[] letters = word.toCharArray();
            
            //iterating through rows and cols, finding the starting initial
            for (int i = 0, n = board.length; i < n; i++) {
                boolean found = false;
                for (int j = 0, m = board[0].length; j < m; j++) {
                    
                    //starting searching once we're on the right position
                    if (board[i][j] == letters[0]) {

                        //start searching, using DFS approach
                        int[][] visited = new int[board.length][board[0].length];
                        if (findWordsHelper(board, i, j, visited, letters, 0) == true) {
                            res.add(word);
                            found = true;
                            break;
                        }

                    } else {
                        continue;
                    }
                }

                if (found) break;
            }
        }

        return res;
    }

    public boolean findWordsHelper(char[][] board, int row, int col, int[][] visited, char[] letters, int index) {
        
        visited[row][col] = 1;
        if (index == letters.length - 1) {
            //backtrack something
            visited[row][col] = 0;
            return true;
        }

        List<int[]> paths = possiblePaths(row, col, visited, board, letters[index + 1]);

        //case of there will be no more possible paths
        if (paths.size() == 0) {
            visited[row][col] = 0;
            return false;
        }

        boolean res = false;
        for (int[] pos : paths) {
            if (findWordsHelper(board, pos[0], pos[1], visited, letters, index + 1) == true) {
                res = true;
            }
        }
        
        //return statement
        visited[row][col] = 0;
        return res;
    }

    //finding all possible paths at a current position
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

class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    TrieNode() {
        this.children = new TrieNode[26];
        this.isEnd = false;
    }
}
