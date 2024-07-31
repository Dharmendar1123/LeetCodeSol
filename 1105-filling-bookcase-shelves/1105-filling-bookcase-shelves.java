class Solution {
    int n;
    int WIDTH;
    int[][] dp;
    
    private int solve(int[][] books, int i, int remainW, int maxHt) {
        if (i >= n) {
            return maxHt;
        }
        
        if (dp[i][remainW] != -1) {
            return dp[i][remainW];
        }
        
        int bookW = books[i][0];
        int bookH = books[i][1];
        
        int keep = Integer.MAX_VALUE;
        int skip = Integer.MAX_VALUE;
        
        if (bookW <= remainW) {
            keep = solve(books, i+1, remainW - bookW, Math.max(maxHt, bookH));
        }
        
        skip = maxHt + solve(books, i+1, WIDTH - bookW, bookH);
        
        return dp[i][remainW] = Math.min(keep, skip);
    }
    
    public int minHeightShelves(int[][] books, int shelfWidth) {
        n = books.length;
        WIDTH = shelfWidth;
        dp = new int[1001][1001];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int remainW = shelfWidth;
        return solve(books, 0, remainW, 0);
    }
}