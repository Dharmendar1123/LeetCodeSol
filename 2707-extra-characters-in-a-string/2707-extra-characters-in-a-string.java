class Solution {
    
    int[] t = new int[51];
    
    public int solve(int i, String s, Set<String> st, int n) {
        if (i >= n) {
            return 0;
        }

        if (t[i] != -1) {
            return t[i];
        }

        int result = 1 + solve(i + 1, s, st, n); // skipping the ith character

        for (int j = i; j < n; j++) {
            String curr = s.substring(i, j + 1);
            if (st.contains(curr)) {
                // valid substring
                result = Math.min(result, solve(j + 1, s, st, n));
            }
        }

        return t[i] = result;
    }
    
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Arrays.fill(t, -1);
        
        Set<String> st = new HashSet<>();
        for (String dict : dictionary) {
            st.add(dict);
        }
        
        return solve(0, s, st, n);
    }
}