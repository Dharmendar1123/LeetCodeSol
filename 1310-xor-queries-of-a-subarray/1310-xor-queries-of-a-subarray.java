class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        
        for (int i = 1; i < arr.length; ++i) {
            prefix[i] = arr[i] ^ prefix[i-1];
        }
        
        int i = 0;
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            
            if (left == 0) {
                result[i] = prefix[right];
            }else {
                result[i] = prefix[right] ^ prefix[left-1];
            }
            i++;
        }
        return result;
    }
}