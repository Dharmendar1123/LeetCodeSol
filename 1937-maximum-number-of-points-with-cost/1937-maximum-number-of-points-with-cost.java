class Solution {
    public long maxPoints(int[][] points) {
        int cols = points[0].length;
        long[] currRow = new long[cols];
        long[] prevRow = new long[cols];

        for (int[] row : points) {
            long runningMax = 0;

            for (int col = 0; col < cols; ++col) {
                runningMax = Math.max(runningMax - 1, prevRow[col]);
                currRow[col] = runningMax;
            }

            runningMax = 0;
            for (int col = cols - 1; col >= 0; --col) {
                runningMax = Math.max(runningMax - 1, prevRow[col]);
                currRow[col] = Math.max(currRow[col], runningMax) + row[col];
            }
            prevRow = currRow;
        }

        long max = Long.MIN_VALUE;
        for (int col = 0; col < cols; ++col) {
            max = Math.max(max, prevRow[col]);
        }
        return max;
    }
}