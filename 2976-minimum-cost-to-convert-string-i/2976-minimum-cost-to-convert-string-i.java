class Solution {
    private void FloydWarshall(long[][] distances, char[] original, char[] changed, int[] cost, int size) {
        for (int i = 0; i < original.length; ++i) {
            int s = original[i] - 'a';
            int t = changed[i] - 'a';
            distances[s][t] = Math.min(distances[s][t], (long) cost[i]);
        }

        for (int k = 0; k < size; ++k) {
            for (int i = 0; i < size; ++i) {
                for (int j = 0; j < size; ++j) {
                    distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                }
            }
        }
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        
        int size = 0;
        for (int i = 0; i < cost.length; i++) {
            size = Math.max(Math.max(size, changed[i] - 'a'), original[i] - 'a');
        }

        size++;
        
        long[][] distances = new long[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
            distances[i][i] = 0;
        }

        FloydWarshall(distances, original, changed, cost, size);

        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            int ch1 = source.charAt(i) - 'a';
            int ch2 = target.charAt(i) - 'a';
            
            if (source.charAt(i) == target.charAt(i)) {
                continue;
            }

            if (ch1 >= size || ch2 >= size || distances[ch1][ch2] == Integer.MAX_VALUE) {
                return -1;
            } else {
                ans += distances[ch1][ch2];
            }
        }

        return ans;
    }
}