class Solution {
    public void computeLPS(String needle, int[] lps, int m) {
        
        int len = 0;
        lps[0] = 0;
        
        int i = 1;
        
        while (i < m) {
            
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }else {
                if (len != 0) {
                    len = lps[len - 1];
                }else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
    
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        
        int result = -1;
        
        int[] lps = new int[m];
        computeLPS(needle, lps, m);
        
        int i = 0;
        int j = 0;
        
        while (i < n) {
            
            if (j < m && haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            
            if (j == m) {
                return i - j;
            }else if (i < n && (j == 0 || haystack.charAt(i) != needle.charAt(j))) {
                if (j != 0) {
                    j = lps[j - 1];
                }else {
                    i++;
                }
            }
        }
        
        return result;
    }
}