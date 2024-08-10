class Solution {
    
    public void numberOfIslandDFS(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 1) {
            return;
        }
        
        matrix[i][j] = 1;
        
        numberOfIslandDFS(matrix, i+1, j);
        numberOfIslandDFS(matrix, i-1, j);
        numberOfIslandDFS(matrix, i, j+1);
        numberOfIslandDFS(matrix, i, j-1);
    }
    
    public int regionsBySlashes(String[] grid) {
        int row = grid.length;
        int col = grid[0].length();
        
        int[][] matrix = new int[row * 3][col * 3];
        
        int region = 0;
        
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i].charAt(j) == '/') {
                    matrix[i * 3][j * 3 + 2] = 1;
                    matrix[i * 3 + 1][j * 3 + 1] = 1;
                    matrix[i * 3 + 2][j * 3] = 1;
                }else if (grid[i].charAt(j) == '\\') {
                    matrix[i * 3][j * 3] = 1;
                    matrix[i * 3 + 1][j * 3 + 1] = 1;
                    matrix[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    numberOfIslandDFS(matrix, i, j);
                    region++;
                }
            }
        }
        return region;
    }
}