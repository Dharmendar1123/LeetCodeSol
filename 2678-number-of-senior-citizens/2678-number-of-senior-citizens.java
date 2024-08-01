class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String str : details) {
            int c1 = str.charAt(11) - '0';
            int c2 = str.charAt(12) - '0';
            int age = (c1 * 10) + c2;
        
            if (age > 60) {
                count++;
            }
        }
        return count;
    }
}