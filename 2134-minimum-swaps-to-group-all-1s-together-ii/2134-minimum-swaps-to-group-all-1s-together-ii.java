class Solution {
    public int minSwaps(int[] nums) {

        int n = nums.length, ones = 0;
        int[] circular = new int[n * 2];
        for(int i = 0; i < n; ++i) {
            circular[i] = circular[i + n] = nums[i];
            ones += nums[i];
        }

        int maxOnes = 0, curOnes = 0, i = 0, j = 0;
        for(j = 0; j < ones; ++j) {
            curOnes += circular[j];
        }

        if(maxOnes < curOnes) {
            maxOnes = curOnes;
        }

        while(j < circular.length) {
            curOnes = curOnes - circular[i] + circular[j];
            if(maxOnes < curOnes) {
                maxOnes = curOnes;
            }
            ++j;
            ++i;
        }

        return ones - maxOnes;
    }
}