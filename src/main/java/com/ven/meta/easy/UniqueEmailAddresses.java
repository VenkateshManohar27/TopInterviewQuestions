package com.ven.meta.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.
 * <p>
 * For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
 * If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.
 * <p>
 * For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
 * If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.
 * <p>
 * For example, "m.y+name@email.com" will be forwarded to "my@email.com".
 * It is possible to use both of these rules at the same time.
 * <p>
 * Given an array of strings emails where we send one email to each emails[i], return the number of different addresses that actually receive mails.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
 * Example 2:
 * <p>
 * Input: emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= emails.length <= 100
 * 1 <= emails[i].length <= 100
 * emails[i] consist of lowercase English letters, '+', '.' and '@'.
 * Each emails[i] contains exactly one '@' character.
 * All local and domain names are non-empty.
 * Local names do not start with a '+' character.
 * Domain names end with the ".com" suffix.
 * Domain names must contain at least one character before ".com" suffix.
 */
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();

        for (int i = 0; i < emails.length; i++) {
            char[] email = emails[i].toCharArray();

            int j = 0;
            StringBuilder sb = new StringBuilder();
            boolean domainName = false;
            while (j < email.length) {
                char c = email[j++];
                if (!domainName && c == '.') {
                    continue;
                } else if (c == '@') {
                    domainName = true;
                } else if (!domainName && c == '+') {
                    while (email[j] != '@') {
                        j++;
                    }
                    continue;
                }
                sb.append(c);

            }
            unique.add(sb.toString());
        }
        //System.out.println(unique);
        return unique.size();
    }

    public static void main(String[] args) {
        //test the code
        UniqueEmailAddresses uea = new UniqueEmailAddresses();
        System.out.println("Unique should be 2: " + uea.numUniqueEmails(new String[]{
                "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
        System.out.println("Unique should be 3: " + uea.numUniqueEmails(new String[]{
                "a@leetcode.com", "b@leetcode.com", "c@leetcode.com"}));
    }
}
