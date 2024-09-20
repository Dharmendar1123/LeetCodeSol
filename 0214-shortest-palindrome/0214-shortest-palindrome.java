class Solution {
    
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        for (int r = s.length() - 1; r >= 0; --r) {
            if (isPalindrome(s, 0, r)) {
                String suffix = s.substring(r + 1);
                String reverseSuffix = new StringBuilder(suffix).reverse().toString();
                return reverseSuffix + s;
            }
        }
        return s;
    }
}