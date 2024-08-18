class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        
        dp[1] = 1;
        
        int i2 = 1;
        int i3 = 1;
        int i5 = 1;
        
        for (int i = 2; i <= n; ++i) {
            int i2Ugly = dp[i2] * 2;
            int i3Ugly = dp[i3] * 3;
            int i5Ugly = dp[i5] * 5;
            
            dp[i] = Math.min(i2Ugly, Math.min(i3Ugly, i5Ugly));
            
            if (i2Ugly == dp[i]) {
                i2++;
            }
            
            if (i3Ugly == dp[i]) {
                i3++;
            }
            
            if (i5Ugly == dp[i]) {
                i5++;
            }
        }
        return dp[n];
    }
}