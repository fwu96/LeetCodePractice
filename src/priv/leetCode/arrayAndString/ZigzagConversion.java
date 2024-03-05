package priv.leetCode.arrayAndString;

/*
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:

    P   A   H   N
    A P L S I I G
    Y   I   R

    then read line by line "PAHNAPLSHIIGYIR"

    Input1: s = "PAYPALISHIRING", numRow = 3
    Output1: "PAHNAPLSHIIGYIR"

    Input2: s = "A", numRow = 1
    Output2: "A"

    LeetCode#6: https://leetcode.com/problems/zigzag-conversion/?envType=study-plan-v2&envId=top-interview-150
 */
public class ZigzagConversion {
    public static void main(String[] args) {
        String input1 = "PAYPALISHIRING";
        String input2 = "A";

        assert convertToZigzag(input1, 3).equals("PAHNAPLSIIGYIR");
        assert convertToZigzag(input2, 1).equals("A");
    }

    private static String convertToZigzag(String str, int rowNum) {
        if (rowNum == 1) {
            return str;
        }
        StringBuilder[] sbs = new StringBuilder[rowNum];
        for (int i = 0; i < rowNum; i++) {
            sbs[i] = new StringBuilder();
        }
        int strIdx = 0;
        while (strIdx < str.length()) {
            // scanning vertically down until hit row count
            for (int rowIdx = 0; rowIdx < rowNum && strIdx < str.length(); rowIdx++) {
                sbs[rowIdx].append(str.charAt(strIdx));
                strIdx++;
            }
            // scanning diagonally up until hit first row
            for (int rowIdx = rowNum - 2; rowIdx >= 1 && strIdx < str.length(); rowIdx--) {
                sbs[rowIdx].append(str.charAt(strIdx));
                strIdx++;
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : sbs) {
            res.append(sb);
        }
        return res.toString();
    }
}
