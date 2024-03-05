package priv.leetCode.arrayAndString;

/*
    Roman numerals are represented by seven different symbols 'I', 'V', 'X', 'L', 'C', 'D', 'M'
    Referring to 1, 5,  10, 50, 100, 500, 1000
    'I' can be placed before 'V' and 'X' to make 4 or 9
    'X' can be placed before 'L' and "C' to make 40 and 90
    'C' can be placed before 'D' and 'M' to make 400 and 900

    Input1: s = 3
    Output1: "III"

    Input2: s = 58
    Output2: "LVIII"

    Input3: s = 1994
    Output: "MCMXCIV"

    LeetCode#12: https://leetcode.com/problems/integer-to-roman/?envType=study-plan-v2&envId=top-interview-150
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        int inp1 = 3;
        int inp2 = 58;
        int inp3 = 1994;

        assert convertIntegerToRoman(inp1).equals("III");
        assert convertIntegerToRoman(inp2).equals("LVIII");
        assert convertIntegerToRoman(inp3).equals("MCMXCIV");
    }

    public static String convertIntegerToRoman(int num) {
        // To use Romans present integer with as less letters as possible.
        // Other than general mapping, 900, 400, 90, 40, 9, 4 need to be additionally considered since those are sub combined
        int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        int idx = 0;

        while (idx < vals.length) {
            while (num >= vals[idx]) {
                sb.append(romans[idx]);
                num -= vals[idx];
            }
            idx++;
        }
        return sb.toString();
    }
}
