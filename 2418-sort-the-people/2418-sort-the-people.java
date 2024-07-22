class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < n; ++i) {
            map.put(heights[i], names[i]);
        }
        String[] ans = new String[n];
        int i = 0;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            ans[i] = entry.getValue();
            i++;
        }
        return ans;
    }
}