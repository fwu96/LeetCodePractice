package priv.leetCode.arrayAndString;

/*
    Given an input string s, reverse the order of words (not whole string)
    Return a string of the works in reverse order, concatenated by a single space

    Input1: s = "the sky is blue"
    Output1: "blue is sky the"

    Input2: s = "   hello world  "
    Output2: "world hello"

    Input3: s = "a good     example"
    Output3: "example good a"

    LeetCode#151: https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ReverseWordsInString {
    public static void main(String[] args) {
        String inp1 = "the sky is blue";
        String inp2 = "   hello world  ";
        String inp3 = "a good     example";
        String inp4 = "EPY2giL";

        assert reverseWords(inp1).equals("blue is sky the");
        assert reverseWords(inp2).equals("world hello");
        assert reverseWords(inp3).equals("example good a");
        assert reverseWords(inp4).equals("EPY2giL");

    }

    private static String reverseWords(String str) {
        // there is only one word in the string
        if (!str.contains(" ")) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        boolean wordCaptured = false;
        boolean tailCaptured = false;
        int tailIdx = str.length() - 1;
        // traverse from tail
        for (int i = str.length() - 1; i >= 0; i--) {
            // a space at index i
            if (str.charAt(i) == ' ') {
                // word is captured, so this is a space before a word
                // append the captured word to result string
                if (wordCaptured) {
                    sb.append(str, i + 1, tailIdx + 1);
                    sb.append(" ");  // may cause a space at the end of result string if original string start with a bunch of spaces
                    tailCaptured = false;
                    wordCaptured = false;
                }
            // a char at index i
            } else if (i != 0) {  // not reach head of string
                // store index of tail of this word
                if (!tailCaptured) {
                    tailIdx = i;
                    tailCaptured = true;
                }
                wordCaptured = true;
            } else {  // reach head of string
                // we handled single word case, so here just need to append first word to the end of result string
                tailIdx = str.indexOf(' ');
                if (tailIdx != 0) {  // the first char of the string is not space
                    sb.append(str, 0, tailIdx);
                }
            }
        }
        // remove the last space from result string in case original string starts with a bunch of spaces
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
