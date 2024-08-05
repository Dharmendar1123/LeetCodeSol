class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        int n = arr.length;
        int i = 0;
        while (i < n) {
            if (map.get(arr[i]) == 1) {
                if (k == 1) {
                    return arr[i];
                }else {
                    k--;
                }
            }
            i++;
        }
        return "";
    }
}