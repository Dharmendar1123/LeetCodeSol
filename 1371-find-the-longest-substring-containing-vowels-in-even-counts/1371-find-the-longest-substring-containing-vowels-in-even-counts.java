class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        
        Map<Integer, Integer> map = new HashMap<>();
        int mask = 0;
        map.put(mask, -1);
        
        int[] state = new int[5];
        int result = 0;
        
        for (int i = 0; i < n; ++i) {
            
            switch (chars[i]) {
                case 'a': 
                    mask = (mask ^ (1 << 0));
                    break;
                case 'e':
                    mask = (mask ^ (1 << 1));
                    break;
                case 'i':
                    mask = (mask ^ (1 << 2));
                    break;
                case 'o':
                    mask = (mask ^ (1 << 3));
                    break;
                case 'u':
                    mask = (mask ^ (1 << 4));
                    break;
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