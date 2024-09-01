class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        
        if (len != m*n) {
            return new int[][]{};
        }
        
        int[][] result = new int[m][n];
        
        int i = 0;
        int j = 0;
        
        for (int val : original) {
            
            if (j >= n) {
                j = 0;
                i++;
            }
            
            result[i][j] = val;
            j++;
        }
        
        return result;
    }
}