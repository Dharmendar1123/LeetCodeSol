class Solution {
    
    class TrieNode {
        int countP = 0;
        TrieNode[] children = new TrieNode[26];
        
        public TrieNode() {
            for (int i = 0; i < 26; ++i) {
                children[i] = null;
            }
            countP = 0;
        }
    }
    
    private TrieNode getTrieNode() {
        return new TrieNode();
    }
    
    private void insert(String word, TrieNode root) {
        TrieNode crawl = root;
        
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            
            if (crawl.children[idx] == null) {
                crawl.children[idx] = getTrieNode();
            }
            
            crawl.children[idx].countP += 1;
            crawl = crawl.children[idx];
        }
    }
    
    private int getScore(String word, TrieNode root) {
        TrieNode crawl = root;
        int score = 0;
        
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            score += crawl.children[idx].countP;
            crawl = crawl.children[idx];
        }
        return score;
    }
    
    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        TrieNode root = getTrieNode();
        
        for (String word : words) {
            insert(word, root);
        }
        
        int[] result = new int[n];
        
        for (int i = 0; i < n; ++i) {
            result[i] = getScore(words[i], root);
        }
        
        return result;
    }
}