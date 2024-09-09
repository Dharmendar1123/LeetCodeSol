class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] result = new int[n][n];
        if (n == 0) {
            return result;
        }
        
        int dir = 0;
        
        int top = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;
        
        int value = 1;
        
        while (top <= down && left <= right) {
            
            if (dir == 0) {
                for (int i = left; i <= right; ++i) {
                    result[top][i] = value;
                    value++;
                }
                top++;
            }
            
            if (dir == 1) {
                for (int i = top; i <= down; ++i) {
                    result[i][right] = value;
                    value++;;
                }
                right--;
            }
            
            if (dir == 2) {
                for (int i = right; i >= left; --i) {
                    result[down][i] = value;
                    value++;
                }
                down--;
            }
            
            if (dir == 3) {
                for (int i = down; i >= top; --i) {
                    result[i][left] = value;
                    value++;
                }
                left++;
            }
            
            dir = (dir + 1) % 4;
        }
        return result;
    }
}