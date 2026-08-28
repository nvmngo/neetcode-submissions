class Solution {
    public boolean isValidSudoku(char[][] board) {
        // The intuition for this question:
        /* 
            Brute Force:
            - Check every rows & cols of the board
            - Then check every sub-boxes
        */

        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();  // setting up entries of the elements in each rows of the board
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();  // setting up entries of the elements in each cols of the board
        HashMap<Integer, HashSet<Character>[]> blocks = new HashMap<>();  // setting up entries of the elements in each blocks in the board

        // setting up the hashMap
        for (int i = 0; i < 9; i++) {   
            rows.put(i, new HashSet<Character>());
            cols.put(i, new HashSet<Character>());
        }

        for (int i = 0; i < 3; i++) {
            HashSet<Character>[] blockRow = (HashSet<Character>[]) new HashSet[3];

            for (int j = 0; j < 3; j++) {
                blockRow[j] = new HashSet<>();
            }
            
            blocks.put(i, blockRow);
        }

        // i is representing the index of (rows & cols) -> moving along the diagonal
        for (int i = 0; i < 9; i++) {
            // TODO:
            if (!checker(i, board, rows, cols, blocks)) { return false; }
        }

        return true;
    }

    public boolean checker(
        int index, 
        char[][] board,
        HashMap<Integer, HashSet<Character>> rows,
        HashMap<Integer, HashSet<Character>> cols,
        HashMap<Integer, HashSet<Character>[]> blocks
    ) {

        // expanding row and col
        for (int i = index; i < 9; i++) {

            char row = board[index][i];
            char col = board[i][index];

            if (index == i && row != '.') { 
                if (rows.get(index).contains(row) || cols.get(index).contains(col)) {
                    return false;
                }    

                rows.get(index).add(row);
                cols.get(index).add(col);
                
                // evaluating element in blocks along the row
                if (blocks.get(index / 3)[i / 3].contains(row)) {
                    return false;
                }
                
                blocks.get(index / 3)[i / 3].add(row);

                continue;
            }
            
            // handling elements on the same row
            if (row != '.') {
                if (rows.get(index).contains(row) || cols.get(i).contains(row)) {
                    return false;
                }

                rows.get(index).add(row);
                cols.get(i).add(row);
                
                // evaluating element in blocks along the row
                if (blocks.get(index / 3)[i / 3].contains(row)) {
                    return false;
                }
                
                blocks.get(index / 3)[i / 3].add(row);
            }

            // handling elements on the same col
            if (col != '.') {
                if (cols.get(index).contains(col) || rows.get(i).contains(col)) {
                    return false;
                }

                cols.get(index).add(col);
                rows.get(i).add(col);

                // evaluating element in blocks along the col
                if (blocks.get(i / 3)[index / 3].contains(col)) {
                    return false;
                }

                blocks.get(i / 3)[index / 3].add(col); 
            }
        }

        return true;
    }
}
