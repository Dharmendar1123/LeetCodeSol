class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        
        long sum = 0;
        for (int val : chalk) {
            sum += val;
        }
        
        int idx = 0;
        k = (int)(k % sum);
        
        for (int i = 0; i < n; ++i) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        return -1;
    }
}