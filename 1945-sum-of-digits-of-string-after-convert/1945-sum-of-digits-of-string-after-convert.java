class Solution {
    public int getLucky(String s, int k) {
        StringBuilder num = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            int charInt = ch -'a' + 1;
            num.append(charInt);
        }

        s = num.toString();

        while (k-- > 0) {
            int sum = 0;
            
            for (char ch : s.toCharArray()) {
                sum += ch - '0';
            }

            s = String.valueOf(sum);
        }

        return Integer.parseInt(s);
    }
}