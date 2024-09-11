class Solution {
    public int minBitFlips(int start, int goal) {
        int res = 0;
        
        int n = start ^ goal;
        while (n != 0) {
            res += (n & 1);
            n = n >> 1;
        }
        return res;
    }
}