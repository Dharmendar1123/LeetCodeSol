class Solution {
    private static final String[] belowTen = {
        "", "One", "Two", "Three", "Four", "Five", 
        "Six", "Seven", "Eight", "Nine"
    };

    private static final String[] belowTwenty = {
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", 
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] belowHundred = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", 
        "Sixty", "Seventy", "Eighty", "Ninety"
    };
    
    private void solve(int num, StringBuilder sb) {
        if (num < 10) {
            sb.append(belowTen[num]);
            return;
        }
        
        if (num < 20) {
            sb.append(belowTwenty[num - 10]);
            return;
        }
        
        if (num < 100) {
            sb.append(belowHundred[num / 10]);
            if (num % 10 != 0) {
                sb.append(" ");
                solve(num % 10, sb);
            }
            return;
        }
        
        if (num < 1000) {
            solve(num / 100, sb);
            sb.append(" Hundred");
            if (num % 100 != 0) {
                sb.append(" ");
                solve(num % 100, sb);
            }
            return;
        }
        
        if (num < 1000000) {
            solve(num / 1000, sb);
            sb.append(" Thousand");
            if (num % 1000 != 0) {
                sb.append(" ");
                solve(num % 1000, sb);
            }
            return;
        }
        
        if (num < 1000000000) {
            solve(num / 1000000, sb);
            sb.append(" Million");
            if (num % 1000000 != 0) {
                sb.append(" ");
                solve(num % 1000000, sb);
            }
            return;
        }
        
        solve(num / 1000000000, sb);
        sb.append(" Billion");
        if (num % 1000000000 != 0) {
            sb.append(" ");
            solve(num % 1000000000, sb);
        }
    }
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        StringBuilder sb = new StringBuilder();
        solve(num, sb);
        return sb.toString();
    }
}
