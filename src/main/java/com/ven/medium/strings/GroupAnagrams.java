package com.ven.medium.strings;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * <p>
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * Explanation:
 * <p>
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 * Example 2:
 * <p>
 * Input: strs = [""]
 * <p>
 * Output: [[""]]
 * <p>
 * Example 3:
 * <p>
 * Input: strs = ["a"]
 * <p>
 * Output: [["a"]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> group = new HashMap<>();
        List<List<String>> li = new ArrayList<>();
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(freq, 0);
            sb.setLength(0);
            char[] chrs = strs[i].toCharArray();

            for (int j = 0; j < chrs.length; j++) {
                freq[chrs[j] - 'a']++;
            }

            for (int k = 0; k < 26; k++) {
                sb.append(freq[k]);
                sb.append("#");
            }

            String g = sb.toString();

            if (group.containsKey(g)) {
                li.get(group.get(g)).add(strs[i]);
            } else {
                li.add(new ArrayList<>());
                li.get(li.size() - 1).add(strs[i]);
                group.put(g, li.size() - 1);
            }
        }
        return li;

    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, Integer> group = new HashMap<>();
        List<List<String>> li = new ArrayList<>();
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(freq, 0);
            sb.setLength(0);
            char[] chrs = strs[i].toCharArray();

            for (int j = 0; j < chrs.length; j++) {
                freq[chrs[j] - 'a']++;
            }

            for (int k = 0; k < 26; k++) {
                if (freq[k] == 0) {
                    continue;
                }
                while (freq[k] > 0) {
                    sb.append((char) (k + 'a'));
                    freq[k]--;
                }
            }
            String g = sb.toString();
            if (group.containsKey(g)) {
                li.get(group.get(g)).add(strs[i]);
            } else {
                li.add(new ArrayList<>());
                li.get(li.size() - 1).add(strs[i]);
                group.put(g, li.size() - 1);
            }
        }
        return li;

    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"}; // Example input
        List<List<String>> result = groupAnagrams.groupAnagrams(strs);
        System.out.println("Grouped anagrams: " + result); // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
        List<List<String>> result2 = groupAnagrams.groupAnagrams2(strs);
        System.out.println("Grouped anagrams using second method: " + result2); // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    }
}
