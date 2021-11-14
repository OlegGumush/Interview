package com.interview.DataStructure_01;

//        383. Ransom Note
//        Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
//        Each letter in magazine can only be used once in ransomNote.

//        Example 1:
//        Input: ransomNote = "a", magazine = "b"
//        Output: false

//        Example 2:
//        Input: ransomNote = "aa", magazine = "ab"
//        Output: false

//        Example 3:
//        Input: ransomNote = "aa", magazine = "aab"
//        Output: true

import java.util.Arrays;
import java.util.HashSet;

public class LeetCode_0383 {

    public static void main(String[] args) {

        System.out.println(canConstruct("a", "b"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] magazineCount = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            magazineCount[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {

            int index = ransomNote.charAt(i) - 'a';
            if (magazineCount[index] == 0) {
                return false;
            }
            magazineCount[index]--;
        }

        return true;
    }
}