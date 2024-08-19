class Solution {
    public int minSteps(int n) {
        if (n == 1)
            return 0;
        
        
        if (n == 2)
            return 2;
        
        int[] t = new int[n + 1];
        
        t[0] = 0; 
        t[1] = 0;
        t[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            int factor = i / 2;
            while (factor >= 1) {
                if (i % factor == 0) {
                    
                    int steps_to_reach_factor = t[factor];
                    int copy_that_first = 1;
                    int paste_frequency = (i / factor) - 1;
                    
                    t[i] = t[factor] + copy_that_first + paste_frequency;
                    break;
                }
                factor--;
            }
        }
        return t[n];
    }
}