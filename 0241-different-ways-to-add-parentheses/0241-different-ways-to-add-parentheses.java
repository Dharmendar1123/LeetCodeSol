class Solution {
    
    public List<Integer> diffWaysToCompute(String expression) {
        char[] exp = expression.toCharArray();
        List<Integer> res = new ArrayList<>();
        
        if (expression.length() == 0) {
            return res;
        }
        
        if (expression.length() == 1) {
            res.add(Integer.parseInt(expression));
            return res;
        }
        if (expression.length() == 2 && Character.isDigit(exp[0])) {
            res.add(Integer.parseInt(expression));
            return res;
        }
        
        for (int i = 0; i < expression.length(); ++i) {
            char op = exp[i];
            
            if (op == '+' || op == '-' || op == '*') {
                
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);
                
                List<Integer> nums1 = diffWaysToCompute(left);
                List<Integer> nums2 = diffWaysToCompute(right);
                
                for (int n1 : nums1) {
                    for (int n2 : nums2) {
                        switch(op) {
                            case '+':
                                res.add(n1 + n2);
                                break;
                            case '-':
                                res.add(n1 - n2);
                                break;
                            case '*':
                                res.add(n1 * n2);
                                break;
                        }
                    }
                }
            }
        }
        return res;
    }
}