class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        int idx = 0;
        
        while (true) {
            if (k < chalk[idx]) {
                break;
            }
            
            k -= chalk[idx];
            idx++;
            
            if (idx >= n) {
                idx = 0;
            }
        }
        return idx;
    }
}