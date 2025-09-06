package com.ven.meta.hard;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 *
 *
 * Example 1:
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 * <p>
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 * <p>
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * <p>
 *
 * Constraints:
 * <p>
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 * <p>
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] freq = new int[52];

        int[] currFreq =  new int[52];

        updateFreq(t, freq);
        int[] ans = new int[]{-1, 0 ,0};
        char[] chrs = s.toCharArray();
        int left = 0;
        for(int i = 0 ; i < chrs.length; i++)
        {
            char c = chrs[i];
            if(Character.isLowerCase(c)) {
                currFreq[c-'a']++;
            }else{
                currFreq[c-'A' +26]++;
            }
            print(freq, currFreq);
            if(charsFound(freq, currFreq)) {
                // System.out.println("found all");
                if(ans[0] == -1 || (ans[0]) > (i - left +1) ){
                    ans[0] = i - left + 1;
                    ans[1] = left;
                    ans[2] = i;
                    // System.out.println("res :"+res);
                }
                while(charsFound(freq, currFreq)){
                    //  System.out.println("RESIZE");
                    if(ans[0] == -1 || (ans[0]) > (i - left +1) ){
                        ans[0] = i - left + 1;
                        ans[1] = left;
                        ans[2] = i;
                        // System.out.println("res :"+res);
                    }
                    char temp = chrs[left++];
                    if(Character.isLowerCase(temp)) {
                        currFreq[temp-'a']--;
                    }else{
                        currFreq[temp-'A' +26]--;
                    }
                }
                //System.out.println("AFTER RESIZE "+left);
            }

        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
    }

    private void print(int[] freq, int[] currFreq) {
//         System.out.println("================");
//         for(int i = 0; i < freq.length; i++) {
//             System.out.print(freq[i] +",");
//         }
//         System.out.println("xx");
//         for(int i = 0; i < currFreq.length; i++) {
//             System.out.print(currFreq[i] +",");
//         }

//         System.out.println("================");
    }

    private boolean charsFound(int[] freq, int[] curr) {
        for(int i = 0; i < freq.length; i++) {
            if(freq[i] != 0 && freq[i] > curr[i]){
                return false;
            }
        }
        return true;
    }

    private void updateFreq(String t, int[] freq) {
        char[] chrs = t.toCharArray();

        for(int i = 0; i < chrs.length; i++) {
            char c = chrs[i];
            if(Character.isLowerCase(c)) {
                freq[c-'a']++;
            }else{
                freq[c-'A' +26]++;
            }
        }
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Input: s = \"" + s1 + "\", t = \"" + t1 + "\"");
        System.out.println("Output: \"" + solution.minWindow(s1, t1) + "\""); // Expected: "BANC"

        String s2 = "a";
        String t2 = "a";
        System.out.println("Input: s = \"" + s2 + "\", t = \"" + t2 + "\"");
        System.out.println("Output: \"" + solution.minWindow(s2, t2) + "\""); // Expected: "a"

        String s3 = "a";
        String t3 = "aa";
        System.out.println("Input: s = \"" + s3 + "\", t = \"" + t3 + "\"");
        System.out.println("Output: \"" + solution.minWindow(s3, t3) + "\""); // Expected: ""
    }
}
