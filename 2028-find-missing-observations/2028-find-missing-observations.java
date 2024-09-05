class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length; 
        int totalSum = mean * (m + n);
        
        int missingSum = totalSum - Arrays.stream(rolls).sum();
        
        //missingSum / n > 6
        if (missingSum > 6 * n || missingSum < n) {
            return new int[0];
        }
        
        int distributeMean = missingSum / n;
        int ExtraRemaining = missingSum % n;
        int[] result = new int[n];
        Arrays.fill(result, distributeMean);
        
        for (int i = 0; i < ExtraRemaining; ++i) { 
            result[i]++;
        }
        
        return result;
    }
}