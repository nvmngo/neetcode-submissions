class Solution {
    
    enum Movement {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }

    private Movement[] movement = new Movement[]{
        Movement.RIGHT, 
        Movement.DOWN, 
        Movement.LEFT, 
        Movement.UP
    };

    public List<Integer> spiralOrder(int[][] matrix) {
        // return list
        List<Integer> res = new ArrayList<>();
        // visited matrix
        int[][] visited = new int[matrix.length][matrix[0].length];
        // current position
        int[] pos = new int[]{0, 0};
        // movement index
        int i = 0;  

        res.add(matrix[0][0]);
        visited[0][0] = 1;

        while (res.size() < matrix.length * matrix[0].length) {

            if (nextMove(visited, pos, movement[i]) == null) {
                i = (i + 1) % 4;
                continue;
            } 

            pos = nextMove(visited, pos, movement[i]);

            res.add(matrix[pos[0]][pos[1]]);
            visited[pos[0]][pos[1]] = 1;
        }

        return res; 
    }

    public int[] nextMove(int[][] visited, int[] pos, Movement movement) {
        if (movement == Movement.RIGHT) {
            int nextRow = pos[0];
            int nextCol = pos[1] + 1;

            if (nextCol < visited[0].length && visited[nextRow][nextCol] == 0) {
                return new int[]{nextRow, nextCol};
            } 
        }

        else if (movement == Movement.LEFT) {
            int nextRow = pos[0];
            int nextCol = pos[1] - 1;

            if (nextCol >= 0 && visited[nextRow][nextCol] == 0) {
                return new int[]{nextRow, nextCol};
            }
        }

        else if (movement == Movement.UP) {
            int nextRow = pos[0] - 1;
            int nextCol = pos[1];

            if (nextRow >= 0 && visited[nextRow][nextCol] == 0) {
                return new int[]{nextRow, nextCol}; 
            }
        }

        else {
            int nextRow = pos[0] + 1;
            int nextCol = pos[1];

            if (nextRow < visited.length && visited[nextRow][nextCol] == 0) {
                return new int[]{nextRow, nextCol};
            }
        }

        return null;
    }
}
