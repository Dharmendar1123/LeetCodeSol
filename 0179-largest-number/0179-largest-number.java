class Solution {
    
    private int compare(String a, String b) {
        int i = 0;
        int j = 0;
        int l1 = a.length();
        int l2 = b.length();
        
        while (i < l1 || j < l2) {
            i = i % l1;
            j = j % l2;
            
            if (a.charAt(i) > b.charAt(j)) {
                return -1;
            }
            if (a.charAt(i) < b.charAt(j)) {
                return 1;
            }
            i++;
            j++;
        }
        return 0;
    }
    
    private boolean allZeros(String s) {
        for (char ch : s.toCharArray()) {
            if (ch != '0') {
                return false;
            }
        }
        return true;
    }
    
    public String largestNumber(int[] nums) {
        // List<String> list = new ArrayList<>();
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            // list.add(String.valueOf(i));
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, (a, b) -> compare(a, b));
        String ans = String.join("", str);
        if (allZeros(ans)) {
            return "0";
        }
        return ans;
    }
}