class Solution {
    
    private List<Integer> backTrack(String exp, int left, int right) {
        List<Integer> res = new ArrayList<>();
        
        for (int i = left; i <= right; ++i) {
            char op = exp.charAt(i);
            if (op == '+' || op == '-' || op == '*') {
                List<Integer> nums1 = backTrack(exp, left, i - 1);
                List<Integer> nums2 = backTrack(exp, i + 1, right);
                
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
            res.add(Integer.parseInt(exp.substring(left, right + 1)));
        }
        return res;
    }
    
    public List<Integer> diffWaysToCompute(String expression) {
        return backTrack(expression, 0, expression.length() - 1);
    }
}