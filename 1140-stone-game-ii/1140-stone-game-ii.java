class Solution {
    int n;
    int[][][] dp = new int[2][101][101];
    
    private int solve(int[] piles, int person, int i, int m) {
        if (i >= n) {
            return 0;
        }
        
        if (dp[person][i][m] != -1) {
            return dp[person][i][m];
        }
        
        int result = (person == 1) ? -1 : Integer.MAX_VALUE;
        int stones = 0;
        
        for (int x = 1; x <= Math.min(2 * m, n - i); ++x) {
            
            stones += piles[i + x - 1];
            
            if (person == 1) {
                result = Math.max(result, stones + solve(piles, 0, i + x, Math.max(m, x)));
            }else {
                result = Math.min(result, solve(piles, 1, i + x, Math.max(m, x)));
            }
        }
        return dp[person][i][m] = result;
    }
    
    public int stoneGameII(int[] piles) {
        n = piles.length;
        
        for (int[][] arr2D : dp) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }
        
        return solve(piles, 1, 0, 1);
    }
}