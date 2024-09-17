class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        
        String[] word1 = s1.split(" ");
        for (String word : word1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        String[] word2 = s2.split(" ");
        for (String word : word2) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        
        return result.toArray(new String[result.size()]);
    }
}