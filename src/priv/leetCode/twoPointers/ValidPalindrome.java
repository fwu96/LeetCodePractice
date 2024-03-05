package priv.leetCode.twoPointers;

/*
    A phrase is a palindrome if after converting all uppercase letters into lowercase letters and removing all
    non-alphanumeric chars, it reads the same forward and backward. Empty string is palindrome

    Input1: s = "A man, a plan, a canal: Panama"
    Output: true -> "amanaplanacanalpanama"

    Input2: s = "race a car"
    Output: false -> "raceacar"

    LeetCode#125: https://leetcode.com/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String input1 = "A man, a plan, a canal: Panama";
        String input2 = "race a car";
        String input3 = "aa";
        String input4 = "a";
        String input5 = " ";
        String input6 = "a b";

        assert isPalindrome(input1);
        assert !isPalindrome(input2);
        assert isPalindrome(input3);
        assert isPalindrome(input4);
        assert isPalindrome(input5);
        assert !isPalindrome(input6);

        assert isPalindromeV2(input1);
        assert !isPalindromeV2(input2);
        assert isPalindromeV2(input3);
        assert isPalindromeV2(input4);
        assert isPalindromeV2(input5);
        assert !isPalindromeV2(input6);
    }

    private static boolean isPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (str.isEmpty() || str.length() == 1) {
            return true;
        }
        int mid = str.length() / 2;
        if (str.length() % 2 == 0) {
            if (str.charAt(mid) != str.charAt(mid - 1)) {
                return false;
            }
        }
        int i = 0;
        int j = str.length() - 1;
        while (i < mid && j > mid) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindromeV2(String str) {
        if (str.isEmpty() || str.length() == 1) {
            return true;
        }
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            } else {
                if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                    return false;
                } else {
                    left++;
                    right--;
                }
            }
        }
        return true;
    }
}
