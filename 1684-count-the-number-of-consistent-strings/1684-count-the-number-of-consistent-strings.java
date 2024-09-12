class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int mask = 0;;
        
        for (char ch : allowed.toCharArray()) {
            mask |= (1 << (ch - 'a'));
        }
        
        int count = 0;
        
        for (String word : words) {
            
            boolean allowedChar = true;;
            
            for (char ch : word.toCharArray()) {
                
                if (((mask >> (ch - 'a')) & 1) == 0) {
                    allowedChar = false;
                    break;
                }
            }
            
            if (allowedChar) {
                count++;
            }
        }
        return count;
    }
}