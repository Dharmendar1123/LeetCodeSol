class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> numbers = new ArrayList<>(n);
        for (int i = 1; i <= Math.min(9, n); i++) {
            addToNumbers(i, n, numbers);
        }
        return numbers;
    }

    private void addToNumbers(int number, int maxNumber, List<Integer> numbers) {
        if (number <= maxNumber) {
            numbers.add(number);
            for (int i = 0; i <= 9; i++) {
                addToNumbers(number * 10 + i, maxNumber, numbers);
            }
        }
    }
}