class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length; 
        int totalSum = mean * (m + n);
        
        int missingSum = totalSum - Arrays.stream(rolls).sum();
        
        //missingSum / n > 6
        if (missingSum > 6 * n || missingSum < n) {
            return new int[0];
        }
        
        int[] result = new int[n];
        
        for (int i = 0; i < n; ++i) { 
            result[i] = Math.min(6, missingSum - (n - i - 1));
            missingSum -= result[i];
        }
        
        return result;
    }
}