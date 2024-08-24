class Solution {
    
    private long getPalindrome(long leftPart, boolean even) {
        long result = leftPart;
        if (!even) {
            leftPart /= 10;
        }
        
        while (leftPart > 0) {
            result = (result * 10) + (leftPart % 10);
            leftPart /= 10;
        }
        return result;
    }
    
    public String nearestPalindromic(String n) {
        int len = n.length();
        int index = len / 2;
        
        boolean even = len % 2 == 0;
        if (even) {
            index -= 1;
        }
        
        long leftPart = Long.parseLong(n.substring(0, index + 1));
        
        List<Long> cases = new ArrayList<>();
        cases.add(getPalindrome(leftPart, even));
        cases.add(getPalindrome(leftPart + 1, even));
        cases.add(getPalindrome(leftPart - 1, even));
        cases.add((long)Math.pow(10, len - 1) - 1);
        cases.add((long)Math.pow(10, len) + 1);
        
        long result = 0, diff = Integer.MAX_VALUE, num = Long.parseLong(n);
        
        for (long ca : cases) {
            if (ca == num) {
                continue;
            }
            
            long curr = Math.abs(num - ca);
            if (diff > curr) {
                result = ca;
                diff = curr;
            }else if (diff == curr) {
                result = Math.min(result, ca);
            }
        }
        return String.valueOf(result);
    }
}