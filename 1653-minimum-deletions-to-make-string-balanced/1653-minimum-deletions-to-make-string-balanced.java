class Solution {
    public int minimumDeletions(String s) {
        int count = 0;
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && ch == 'a' && st.peek() == 'b') {
                st.pop();
                count++;
            }else {
                st.push(ch);
            }
        }
        return count;
    }
}