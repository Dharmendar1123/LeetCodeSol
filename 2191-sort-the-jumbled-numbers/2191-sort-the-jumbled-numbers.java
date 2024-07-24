class Solution {
    
    private static class Pair {
        int mappedNum;
        int originalIdx;
        
        Pair(int mappedNum,int originalIdx) {
            this.mappedNum = mappedNum;
            this.originalIdx = originalIdx;
        }
    }
    
    private int getMappedNum(int num, int[] mapping) {
        if (num < 10) {
            return mapping[num];
        }
        
        int mappedNum = 0;
        int placeValue = 1;
        
        while (num > 0) {
            int lastDigit = num % 10;
            int mappedDigit = mapping[lastDigit];
            mappedNum += placeValue * mappedDigit;
            
            placeValue *= 10;
            num /= 10;
        }
        
        return mappedNum;
    }
    
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        List<Pair> vec = new ArrayList<>();
        
        for (int i = 0; i < n; ++i) {
            int mappedNum = getMappedNum(nums[i], mapping);
            vec.add(new Pair(mappedNum, i));
        }
        
        Collections.sort(vec, (a, b) -> Integer.compare(a.mappedNum, b.mappedNum));
        int[] result = new int[n];
        
        for (int i = 0; i < n; ++i) {
            int originalNumIdx = vec.get(i).originalIdx;
            result[i] = nums[originalNumIdx];
        }
        
        return result;
    }
}