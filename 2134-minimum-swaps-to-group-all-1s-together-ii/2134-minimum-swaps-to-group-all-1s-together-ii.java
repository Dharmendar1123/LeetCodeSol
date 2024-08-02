class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        int[] temp = new int[2*n];
        for (int i = 0; i < 2*n; ++i) {
            temp[i] = nums[i%n];
        }
        
        int countOnes = Arrays.stream(nums).sum();
        
        int i = 0;
        int j = 0;
        int currCount = 0;
        int maxCount = 0;
        
        while (j < 2*n) {
            if (temp[j] == 1) {
                currCount++;
            }
            
            if (j - i + 1 > countOnes) {
                currCount -= temp[i];
                i++;
            }
            
            maxCount = Math.max(maxCount, currCount);
            j++;
        }
        return countOnes - maxCount;
    }
}