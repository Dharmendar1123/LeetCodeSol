class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = (int)1e9 + 7;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        for (int i = 0; i < n; ++i) {
            pq.offer(new int[] {nums[i], i});
        }
        
        int result = 0;
        for (int i = 1; i <= right; ++i) {
            int[] curr = pq.poll();
            
            if (i >= left) {
                result = (result + curr[0]) % mod;
            }
            
            if (curr[1] < n - 1) {
                pq.offer(new int[] {curr[0] + nums[curr[1] + 1], curr[1] + 1});
            }
        }
        return result;
    }
}