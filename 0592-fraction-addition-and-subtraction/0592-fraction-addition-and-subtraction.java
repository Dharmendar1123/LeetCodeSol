class Solution {
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
    
    public String fractionAddition(String expr) {
        int nume = 0;
        int deno = 1;
        
        int i = 0;
        int n = expr.length();
        
        char[] exp = expr.toCharArray();
        
        while (i < n) {
            int currNume = 0;
            int currDeno = 0;
            
            boolean isNeg = (exp[i] == '-');
            
            if (exp[i] == '+' || exp[i] == '-') {
                i++;
            }
            
            while (i < n && Character.isDigit(exp[i])) {
                int val = exp[i] - '0';
                currNume = (currNume * 10) + val;
                i++;
            }
            
            i++;
            
            if (isNeg) {
                currNume *= -1;
            }
            
            while (i < n && Character.isDigit(exp[i])) {
                int val = exp[i] - '0';
                currDeno = (currDeno * 10) + val;
                i++;
            }
            
            nume = nume * currDeno  + currNume * deno;
            deno = deno * currDeno;
        }
        
        int gcd = gcd(Math.abs(nume), deno);
        
        nume /= gcd;
        deno /= gcd;
        
        return nume + "/" + deno;
    }
}