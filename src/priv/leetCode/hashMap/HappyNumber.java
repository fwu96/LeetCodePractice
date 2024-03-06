package priv.leetCode.hashMap;

/*
    Determine if a number n is happy. True if processing:
        Starting with any positive integer, replace the number by the sum of the squares of its digits
        Repeat the process until number equals to 1, or it loops endlessly which does not include 1
        Those numbers for which ends in 1 are happy

    Input1: n = 19 -> 1^2 + 9^2 = 82, 8^2 + 2^2 = 68, 6^2 + 8^2 = 100, 1^2 + 0^2 + 0^2 = 1
    Output1: true

    Input2: n = 2
    Output2: false

    LeetCode#202: https://leetcode.com/problems/happy-number/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class HappyNumber {
    public static void main(String[] args) {
        assert isHappy(19);
        assert !isHappy(2);
    }

    private static boolean isHappy(int n) {
        // Ideally if n is happy number it must ends up with 1 with the process
        // if n is not a happy number, it runs into infinite loop while process
        // which means, some result by adding up square of each digit is repeated
        int executedByOneStep = n;
        int executedByTwoStep = n;
        boolean firstRun = true;
        while (firstRun || executedByOneStep != executedByTwoStep) {
            firstRun = false;
            executedByOneStep = getSumOfSquare(executedByOneStep);
            executedByTwoStep = getSumOfSquare(getSumOfSquare(executedByTwoStep));
        }
        return executedByOneStep == 1;
    }

    private static int getSumOfSquare(int n) {
        int squareSum = 0;
        while (n > 0) {
            int remainder = n % 10;
            squareSum += (remainder * remainder);
            n /= 10;
        }
        return squareSum;
    }
}
