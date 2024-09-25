class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[n] = 0;
        
        for (int i = n - 1; i >= 0; --i) {
            for (String word : dictionary) {
                if (s.startsWith(word, i)) {
                    dp[i] = Math.min(dp[i], dp[i + word.length()]);
                }
            }
            dp[i] = Math.min(dp[i], 1 + dp[i + 1]);
        }
        return dp[0];
    }
}