class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        
        Map<Integer, Integer> map = new HashMap<>();
        int mask = 0;
        map.put(mask, -1);
        
        int[] state = new int[5];
        int result = 0;
        
        for (int i = 0; i < n; ++i) {
            
            if (s.charAt(i) == 'a') {
                mask = (mask ^ (1 << 0));
            }else if (s.charAt(i) == 'e') {
                mask = (mask ^ (1 << 1));
            }else if (s.charAt(i) == 'i') {
                mask = (mask ^ (1 << 2));
            }else if (s.charAt(i) == 'o') {
                mask = (mask ^ (1 << 3));
            }else if (s.charAt(i) == 'u') {
                mask = (mask ^ (1 << 4));
            }
            
            if (map.containsKey(mask)) {
                result = Math.max(result, i - map.get(mask));
            }else {
                map.put(mask, i);
            }
        }
        return result;
    }
}