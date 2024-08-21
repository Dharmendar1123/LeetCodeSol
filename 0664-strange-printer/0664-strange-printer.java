class Solution {
    int n;
    int[][] dp;
    
    private int solve(int l, int r, char[] ch) {
        
        if (l == r) {
            return 1;
        }
        
        if (l > r) {
            return 0;
        }
        
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        
        int i = l + 1;
        while (i <= r && ch[i] == ch[l]) {
            i++;
        }
        
        if (i == r + 1) {
            return 1;
        }
        
        int basic = 1 + solve(i, r, ch);
        
        int optimize = Integer.MAX_VALUE;
        
        for (int j = i; j <= r; ++j) {
            if (ch[j] == ch[l]) {
                int ans = solve(i, j - 1, ch) + solve(j, r, ch);
                
                optimize = Math.min(optimize, ans);
            }
        }
        
        return dp[l][r] = Math.min(basic, optimize);
    }
    
    public int strangePrinter(String s) {
        n = s.length();
        dp = new int[n+1][n+1];
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        char[] ch = s.toCharArray();
        
        return solve(0, n-1, ch);
    }
}