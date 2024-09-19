class Solution {
    
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < expression.length(); ++i) {
            char op = expression.charAt(i);
            
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
        
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }
        return res;
    }
}