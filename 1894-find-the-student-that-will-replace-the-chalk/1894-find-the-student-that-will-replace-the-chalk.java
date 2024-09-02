class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        
        while (true) {
            for (int i = 0; i < n; ++i) {
                if (k < chalk[i]) {
                    return i;
                }
                k -= chalk[i];
            }
        }
    }
}