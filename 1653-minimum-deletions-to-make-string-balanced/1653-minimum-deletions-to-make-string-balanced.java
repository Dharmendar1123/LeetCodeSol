class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        
        int[] rightA = new int[n];
        
        int countA = 0;
        for (int i = n-1; i >= 0; --i) {
            rightA[i] = countA;
            if (s.charAt(i) == 'a') {
                countA++;
            }
        }
        
        int count = Integer.MAX_VALUE;
        int countB = 0;
        for(int i = 0; i < n; ++i) {
            count = Math.min(count, countB + rightA[i]);
            if (s.charAt(i) == 'b') {
                countB++;
            }
        }
        
        return count;
    }
}