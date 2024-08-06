class Solution {
    public int minimumPushes(String word) {
        int result = 0;
        int[] map = new int[10];
        
        int assignKey = 2;
        
        for (char ch : word.toCharArray()) {
            if (assignKey > 9) {
                assignKey = 2;
            }
            
            map[assignKey]++;
            result += map[assignKey];
            
            assignKey++;
        }
        
        return result;
    }
}