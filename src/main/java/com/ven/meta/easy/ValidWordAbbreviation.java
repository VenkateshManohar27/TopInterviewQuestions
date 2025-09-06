package com.ven.meta.easy;

/**
 * A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings with their lengths. The lengths should not have leading zeros.
 * <p>
 * For example, a string such as "substitution" could be abbreviated as (but not limited to):
 * <p>
 * "s10n" ("s ubstitutio n")
 * "sub4u4" ("sub stit u tion")
 * "12" ("substitution")
 * "su3i1u2on" ("su bst i t u ti on")
 * "substitution" (no substrings replaced)
 * The following are not valid abbreviations:
 * <p>
 * "s55n" ("s ubsti tutio n", the replaced substrings are adjacent)
 * "s010n" (has leading zeros)
 * "s0ubstitution" (replaces an empty substring)
 * Given a string word and an abbreviation abbr, return whether the string matches the given abbreviation.
 * <p>
 * A substring is a contiguous non-empty sequence of characters within a string.
 * <p>
 *
 *
 * Example 1:
 * <p>
 * Input: word = "internationalization", abbr = "i12iz4n"
 * Output: true
 * Explanation: The word "internationalization" can be abbreviated as "i12iz4n" ("i nternational iz atio n").
 * Example 2:
 * <p>
 * Input: word = "apple", abbr = "a2e"
 * Output: false
 * Explanation: The word "apple" cannot be abbreviated as "a2e".
 * <p>
 *
 * Constraints:
 * <p>
 * 1 <= word.length <= 20
 * word consists of only lowercase English letters.
 * 1 <= abbr.length <= 10
 * abbr consists of lowercase English letters and digits.
 * All the integers in abbr will fit in a 32-bit integer.
 */
public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int idx = 0;
        int i = 0, j = 0;

        while(i < word.length() && j < abbr.length()) {
            int num = 0;
            //System.out.println("["+i+","+j+"]");
            while( j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                if(num == 0 && abbr.charAt(j) =='0'){
                    return false;
                }
                num = num * 10 + (int)(abbr.charAt(j) - '0');
                j++;
            }
            //System.out.println("num :"+num);
            if(num > 0) {
                i += num;
                if(i > word.length()) {
                    return false;
                }
            }else {
                if(word.charAt(i) == abbr.charAt(j)) {
                    i++;
                    j++;
                }else{
                    return false;
                }
            }
            // System.out.println("num :"+num);
        }
        return i == word.length() && j == abbr.length();
    }

    public static void main(String[] args) {
        ValidWordAbbreviation solution = new ValidWordAbbreviation();
        String word1 = "internationalization";
        String abbr1 = "i12iz4n";
        boolean result1 = solution.validWordAbbreviation(word1, abbr1);
        System.out.println("Output for (\"internationalization\", \"i12iz4n\"): " + result1); // Expected: true

        String word2 = "apple";
        String abbr2 = "a2e";
        boolean result2 = solution.validWordAbbreviation(word2, abbr2);
        System.out.println("Output for (\"apple\", \"a2e\"): " + result2); // Expected: false

        String word3 = "substitution";
        String abbr3 = "s10n";
        boolean result3 = solution.validWordAbbreviation(word3, abbr3);
        System.out.println("Output for (\"substitution\", \"s10n\"): " + result3); // Expected: true

        String word4 = "substitution";
        String abbr4 = "s55n";
        boolean result4 = solution.validWordAbbreviation(word4, abbr4);
        System.out.println("Output for (\"substitution\", \"s55n\"): " + result4); // Expected: false

        String word5 = "substitution";
        String abbr5 = "s010n";
        boolean result5 = solution.validWordAbbreviation(word5, abbr5);
        System.out.println("Output for (\"substitution\", \"s010n\"): " + result5); // Expected: false
    }
}
