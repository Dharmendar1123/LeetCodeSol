class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        
        Set<String> visited = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        
        que.offer(startGene);
        visited.add(startGene);
        
        int level = 0;
        
        while (!que.isEmpty()) {
            int n = que.size();
            while (n-- > 0) {
                String curr = que.poll();
                
                if (curr.equals(endGene)) {
                    return level;
                }
                
                for (char ch : "ACGT".toCharArray()) {
                    for (int i = 0; i < curr.length(); ++i) {
                        StringBuilder neighbour = new StringBuilder(curr);
                        neighbour.setCharAt(i, ch);
                        String newStr = neighbour.toString();
                        
                        if (!visited.contains(newStr) && bankSet.contains(newStr)) {
                            que.offer(newStr);
                            visited.add(newStr);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}