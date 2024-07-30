class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        
        int[] leftB = new int[n];
        int[] rightA = new int[n];
        
        int countB = 0;
        for (int i = 0; i < n; ++i) {
            leftB[i] = countB;
            if (s.charAt(i) == 'b') {
                countB++;
            }
        }
        
        int countA = 0;
        for (int i = n-1; i >= 0; --i) {
            rightA[i] = countA;
            if (s.charAt(i) == 'a') {
                countA++;
            }
        }
        
        int count = Integer.MAX_VALUE;
        for(int i = 0; i < n; ++i) {
            count = Math.min(count, leftB[i] + rightA[i]);
        }
        
        return count;
    }
}