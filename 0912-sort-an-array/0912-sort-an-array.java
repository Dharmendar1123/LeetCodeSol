class Solution {
    private int[] nums;
    public static void max_heap(int[] nums, int n, int parent) {
        int left = 2*parent + 1;
        int right = 2*parent + 2;
        int large = parent;
        if (left < n && nums[large] < nums[left]) {
            large = left;
        }
        if (right < n && nums[large] < nums[right]) {
            large = right;
        }
        
        if (large != parent) {
            int temp = nums[large];
            nums[large] = nums[parent];
            nums[parent] = temp;
            max_heap(nums, n, large);
        }
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = (n/2)-1; i >= 0; --i) {
            max_heap(nums, n, i);
        }
        
        for (int i = n-1; i >= 0; --i) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            max_heap(nums, i, 0);
        }
        return nums;
    }
}