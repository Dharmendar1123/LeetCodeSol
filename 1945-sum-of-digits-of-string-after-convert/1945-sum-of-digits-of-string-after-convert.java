class Solution {
    public int getLucky(String s, int k) {
        StringBuilder num = new StringBuilder();
        
        // Convert each character in the string to its corresponding number (a: 1, b: 2, ..., z: 26)
        for (char ch : s.toCharArray()) {
            int charInt = ch - 'a' + 1;
            num.append(charInt);
        }

        // Initialize sum
        int sum = 0;

        // Repeat the process k times
        while (k-- > 0) {
            sum = 0;
            // Calculate the sum of digits
            for (char ch : num.toString().toCharArray()) {
                sum += ch - '0';
            }

            // Convert the sum back to a string
            num = new StringBuilder(Integer.toString(sum));
        }

        // Return the final result as an integer
        return Integer.parseInt(num.toString());
    }
}