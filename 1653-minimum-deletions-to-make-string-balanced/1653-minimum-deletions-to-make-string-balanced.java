class Solution {
    public int minimumDeletions(String s) {
        int countB = 0;
        int dlt = 0;

        for(char c : s.toCharArray()) {
            if(c == 'a') {
                dlt = Math.min(dlt + 1, countB);
            } else {
                countB++;
            }
        }

        return dlt;
    }
}