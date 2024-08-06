class Solution {
    public int minimumPushes(String word) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        int assignKey = 2;
        
        for (char ch : word.toCharArray()) {
            if (assignKey > 9) {
                assignKey = 2;
            }
            
            map.put(assignKey, map.getOrDefault(assignKey, 0) + 1);
            
            result += map.get(assignKey);
            
            assignKey++;
        }
        
        return result;
    }
}