class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        
        Map<String, Integer> map = new HashMap<>();
        String currState = "00000";
        map.put(currState, -1);
        
        int[] state = new int[5];
        int result = 0;
        
        for (int i = 0; i < n; ++i) {
            
            if (s.charAt(i) == 'a') {
                state[0] = (state[0] + 1) % 2;
            }else if (s.charAt(i) == 'e') {
                state[1] = (state[1] + 1) % 2;
            }else if (s.charAt(i) == 'i') {
                state[2] = (state[2] + 1) % 2;
            }else if (s.charAt(i) == 'o') {
                state[3] = (state[3] + 1) % 2;
            }else if (s.charAt(i) == 'u') {
                state[4] = (state[4] + 1) % 2;
            }
            
            currState = "";
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 5; ++j) {
                sb.append(state[j]);
            }
            currState = sb.toString();
            
            if (map.containsKey(currState)) {
                result = Math.max(result, i - map.get(currState));
            }else {
                map.put(currState, i);
            }
        }
        return result;
    }
}