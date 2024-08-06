class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        Arrays.sort(freq);
        
        for (int i = 0, j = freq.length - 1, tmp; i < j; i++, j--) {
            tmp = freq[i];
            freq[i] = freq[j];
            freq[j] = tmp;
        }
        int result = 0;
        
        for (int i = 0; i < 26; ++i) {
            int occ = freq[i];
            int press = i/8 + 1;
            result += press * occ;
        }
        return result;
    }
}