package leetcode.questions.array;

//        567. Permutation in String
//        Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
//        In other words, return true if one of s1's permutations is the substring of s2.

//        Example 1:
//        Input: s1 = "ab", s2 = "eidbaooo"
//        Output: true
//        Explanation: s2 contains one permutation of s1 ("ba").

//        Example 2:
//        Input: s1 = "ab", s2 = "eidboaoo"
//        Output: false

public class LeetCode_0567_Permutation {

    public static void main(String[] args) {

        System.out.println(checkInclusion("adc", "dcedac"));
        System.out.println(checkInclusion("adc", "dcda"));
    }

    public static boolean checkInclusion(String s1, String s2) {

        if (s2.length() == 1) {
            if (s2.equals(s1)) {
                return true;
            }
        }
        int arr1[] = new int[26];
        int orig[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 97]++;
            orig[s1.charAt(i) - 97]++;
        }

        int i = 0;
        int firstChaned = 0;

        while (i < s2.length() && firstChaned < s2.length()) {
            char c = s2.charAt(i);

            if (arr1[c - 97] > 0) {
                arr1[c - 97]--;

                if (isAllZeros(arr1)) {
                    return true;
                }
                i++;
            } else {
                // if char was in original array
                if (orig[s2.charAt(firstChaned) - 97] > 0) {
                    // return reduced value
                    arr1[s2.charAt(firstChaned) - 97]++;
                    // move first by one
                    firstChaned++;
                } else {
                    // if char wasn't in original array move to next character
                    i++;
                    firstChaned = i;
                }
            }
        }
        return false;
    }

    public static boolean isAllZeros(int[] arr1) {

        for (int j = 0; j < arr1.length; j++) {
            if (arr1[j] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkInclusionExtraSpace(String s1, String s2) {

        int arr1[] = new int[26];
        int arr2[] = new int[26];
        int counter = 0;

        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 97]++;
            arr2[s1.charAt(i) - 97]++;
            counter++;
        }

        int i = 0;
        int j = 0;
        int counterTemp = counter;

        while (i < s2.length()) {
            if (arr1[s2.charAt(i) - 97] > 0) {
                arr1[s2.charAt(i) - 97]--;
                counter--;
                if (counter == 0) {
                    return true;
                }
                i++;
            } else {
                j++;
                i = j;
                counter = counterTemp;
                for (int k = 0; k < arr2.length; k++) {
                    arr1[k] = arr2[k];
                }
            }
        }
        return false;
    }
}