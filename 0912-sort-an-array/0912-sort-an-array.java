class Solution {
    public int[] sortArray(int[] nums) {
        int minE = Integer.MAX_VALUE;
        int maxE = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < minE) {
                minE = num;
            }
            if (num > maxE) {
                maxE = num;
            }
        }

        // Frequency array for range [minE, maxE]
        int[] frequency = new int[maxE - minE + 1];

        // Count the frequency of each number
        for (int num : nums) {
            frequency[num - minE]++;
        }

        // Reconstruct the sorted array
        int index = 0;
        for (int num = minE; num <= maxE; num++) {
            while (frequency[num - minE] > 0) {
                nums[index++] = num;
                frequency[num - minE]--;
            }
        }

        return nums;
    }
}