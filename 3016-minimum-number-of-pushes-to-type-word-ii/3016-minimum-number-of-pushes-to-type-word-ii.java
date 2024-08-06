class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        Arrays.sort(freq);
        int result = 0;
        
        for (int i = 0; i < 26; ++i) {
            int occ = freq[26 - i - 1];
            int press = i/8 + 1;
            result += press * occ;
        }
        return result;
    }
}