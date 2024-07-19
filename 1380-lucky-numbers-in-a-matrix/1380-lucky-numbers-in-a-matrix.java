class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        List<Integer> result = new ArrayList<>();
        
        int rMinMax = Integer.MIN_VALUE;
        for (int row = 0; row < m; ++row) {
            int minEle = Integer.MAX_VALUE;
            for (int col = 0; col < n; ++col) {
                minEle = Math.min(minEle, matrix[row][col]);
            }
            rMinMax = Math.max(rMinMax, minEle);
        }
        
        int cMaxMin = Integer.MAX_VALUE;
        for (int col = 0; col < n; ++col) {
            int maxEle = Integer.MIN_VALUE;
            for (int row = 0; row < m; ++row) {
                maxEle = Math.max(maxEle, matrix[row][col]);
            }
            cMaxMin = Math.min(cMaxMin, maxEle);
        }
        
        if (cMaxMin == rMinMax) {
            result.add(rMinMax);
        }
        return result;
    }
}