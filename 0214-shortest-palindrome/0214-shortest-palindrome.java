class Solution {
    public void computeLPS(String pattern, int[] lps) {
        int M = pattern.length();
        int len = 0;

        lps[0] = 0;

        int i = 1;
        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString(); 

        String temp = s + "-" + rev;

        int[] LPS = new int[temp.length()]; 
        computeLPS(temp, LPS); 

        int longestLPSLength = LPS[temp.length() - 1]; 

        String culprit = rev.substring(0, s.length() - longestLPSLength);

        return culprit + s;
    }
}