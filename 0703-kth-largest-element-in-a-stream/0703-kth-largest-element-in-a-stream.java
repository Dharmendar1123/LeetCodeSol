class KthLargest {

    private PriorityQueue<Integer> pq;
    private int K;
    public KthLargest(int k, int[] nums) {
        K = k;
        pq = new PriorityQueue<>(K);
        
        for (int num : nums) {
            add(num);
        }
        
    }
    
    public int add(int val) {

        if (pq.size() < K) {
            pq.offer(val);
        }else if (pq.peek() < val) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */