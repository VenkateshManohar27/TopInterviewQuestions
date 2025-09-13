package com.ven.medium.strings;

/**
 * Given a string queryIP, return "IPv4" if IP is a valid IPv4 address, "IPv6" if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.
 * <p>
 * A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0" are valid IPv4 addresses while "192.168.01.1", "192.168.1.00", and "192.168@1.1" are invalid IPv4 addresses.
 * <p>
 * A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:
 * <p>
 * 1 <= xi.length <= 4
 * xi is a hexadecimal string which may contain digits, lowercase English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
 * Leading zeros are allowed in xi.
 * For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses, while "2001:0db8:85a3::8A2E:037j:7334" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: queryIP = "172.16.254.1"
 * Output: "IPv4"
 * Explanation: This is a valid IPv4 address, return "IPv4".
 * Example 2:
 * <p>
 * Input: queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * Output: "IPv6"
 * Explanation: This is a valid IPv6 address, return "IPv6".
 * Example 3:
 * <p>
 * Input: queryIP = "256.256.256.256"
 * Output: "Neither"
 * Explanation: This is neither a IPv4 address nor a IPv6 address.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * queryIP consists only of English letters, digits and the characters '.' and ':'.
 */
public class ValidateIPAddress {
    public String validIPAddress(String queryIP) {
        if (queryIP.indexOf(".") != -1 && validateIPv4(queryIP)) {
            return "IPv4";
        } else if (queryIP.indexOf(":") != -1 && validateIPv6(queryIP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean validateIPv4(String queryIP) {
        String[] strs = queryIP.split("\\.", -1);
        //System.out.println("length :"+strs.length);
        if (strs.length != 4) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            char[] chrs = strs[i].toCharArray();
            //System.out.println("string :"+strs[i]);
            if (chrs.length == 0 || (chrs.length > 1 && chrs[0] == '0')) {
                return false;
            }

            int number = 0;

            for (int j = 0; j < chrs.length; j++) {
                char c = chrs[j];
                if (!(c >= '0' && c <= '9')) {
                    return false;
                }
                number *= 10;
                number += c - '0';
            }
            //System.out.println("number :"+number);
            if (number < 0 || number >= 256)
                return false;
        }
        return true;
    }

    private boolean validateIPv6(String queryIP) {
        String[] strs = queryIP.split("\\:", -1);
        //System.out.println("IPv6 length :"+strs.length);
        if (strs.length != 8) {
            return false;
        }

        for (int i = 0; i < 8; i++) {
            char[] chrs = strs[i].toCharArray();
            if (chrs.length == 0 || chrs.length > 4) {
                return false;
            }

            for (int j = 0; j < chrs.length; j++) {
                char c = chrs[j];
                if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidateIPAddress validator = new ValidateIPAddress();
        String queryIP1 = "172.16.254.1"; // Example input
        String queryIP2 = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        String queryIP3 = "256.256.256.256";

        System.out.println("Input: " + queryIP1 + " -> Output: " + validator.validIPAddress(queryIP1));
        System.out.println("Input: " + queryIP2 + " -> Output: " + validator.validIPAddress(queryIP2));
        System.out.println("Input: " + queryIP3 + " -> Output: " + validator.validIPAddress(queryIP3));
    }
}
