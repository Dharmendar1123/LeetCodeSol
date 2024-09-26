class Solution {
    private void addToNumbers(int currNum, int n, List<Integer> numbers) {
        if (currNum > n) {
            return;
        }
        numbers.add(currNum);
        
        for (int i = 0; i <= 9; i++) {
            int newNum = (currNum * 10) + i;
            
            if (newNum > n) {
                return;
            }
            addToNumbers(newNum, n, numbers);
        }
    }
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> numbers = new ArrayList<>(n);
        
        for (int i = 1; i <= Math.min(9, n); i++) {
            addToNumbers(i, n, numbers);
        }
        return numbers;
    }
}