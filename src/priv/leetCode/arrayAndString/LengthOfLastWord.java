package priv.leetCode.arrayAndString;

/*
    Given s string s consisting of words and spaces, return length of the last work in the string

    Input1: s = "Hello World"
    Output1: 5

    Input2: s = "    fly me    to   the moon  "
    Output2: 4

    LeetCode#58: https://leetcode.com/problems/length-of-last-word/?envType=study-plan-v2&envId=top-interview-150
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String inp1 = "Hello World";
        String inp2 = "    fly me    to   the moon  ";

        assert getLastWordLength(inp1) == 5;
        assert getLastWordLength(inp2) == 4;
    }

    public static int getLastWordLength(String str) {
        int length = 0;
        /*
            traverse from tail
            if length is 0 and get space - not reach last word yet. Continue
            if length is not 0 and get space - complete scanning last word. Return
         */
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                if (length != 0) {
                    return length;
                }
            } else {
                length++;
            }
        }
        return length;
    }
}
