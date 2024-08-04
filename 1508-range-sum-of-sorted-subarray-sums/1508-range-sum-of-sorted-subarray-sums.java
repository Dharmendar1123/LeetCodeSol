class Solution {
    private static final int M = (int)1e9 + 7;

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> temp = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                temp.add(sum);
            }
        }

        Collections.sort(temp);

        int result = 0;
        for (int i = left - 1; i < right; i++) {
            result = (result + temp.get(i)) % M;
        }

        return result;
    }
}