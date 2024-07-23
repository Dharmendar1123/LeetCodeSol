class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        Comparator<Integer> comparator = (a, b) -> {
            int freqCompare = Integer.compare(map.get(a), map.get(b));
            if (freqCompare == 0) {
                return Integer.compare(b, a);
            } else {
                return freqCompare;
            }
        };
        
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        
        numList.sort(comparator);
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numList.get(i);
        }
        
        return nums;
    }
}