class Solution {
    public int[] frequencySort(int[] nums) {
        int[] count = new int[201];

        for (int num : nums) {
            count[num + 100]++;
        }

        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }

        Comparator<Integer> comparator = (a, b) -> {
            int freqCompare = Integer.compare(count[a + 100], count[b + 100]);
            if (freqCompare == 0) {
                return Integer.compare(b, a);
            } else {
                return freqCompare;
            }
        };

        numList.sort(comparator);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = numList.get(i);
        }

        return nums;
    }
}