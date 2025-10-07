package com.ven.medium.strings;

import java.util.Arrays;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        char[] answer = new char[230];
        Arrays.fill(answer, '0');
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int appendZeroes = 0;
        for (int i = n2.length - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            int zeroes = appendZeroes;
            while (zeroes > 0) {
                sb.append("0");
                zeroes--;
            }
            int digit = n2[i] - '0';
            int carry = 0;
            for (int j = n1.length - 1; j >= 0; j--) {
                int d = n1[j] - '0';
                int num = (d * digit) + carry;
                sb.append(num % 10);
                carry = num / 10;
            }
            if (carry > 0) {
                sb.append(carry);
            }
            //sb = sb.reverse();

            char[] curr = sb.toString().toCharArray();
            carry = 0;
            for (int k = 0; k < answer.length; k++) {

                int num = (k >= curr.length) ? 0 : (curr[k] - '0');

                int sum = (answer[k] - '0') + num + carry;
                //System.out.println("sum:"+sum);
                answer[k] = ((char) ('0' + (sum % 10)));
                carry = sum / 10;
            }


            //numbers.add(sb.toString());
            appendZeroes++;
        }
        StringBuilder sb = new StringBuilder();
        boolean nonZeroFound = false;
        for (int i = answer.length - 1; i >= 0; i--) {
            if (answer[i] != '0') {
                nonZeroFound = true;
            }
            if (nonZeroFound)
                sb.append(answer[i]);

        }
        //System.out.println(sb);
        if (!nonZeroFound) {
            return "0";
        }


        return sb.toString(); // Return the modified string
    }

    public static void main(String[] args) {
        MultiplyStrings ms = new MultiplyStrings();
        System.out.println("Expected 6: " + ms.multiply("2", "3"));
        System.out.println("Expected 56088: " + ms.multiply("123", "456"));
        System.out.println("Expected 0: " + ms.multiply("0", "0"));
        System.out.println("Expected 121932631112635269: " + ms.multiply("123456789", "987654321"));
        System.out.println("Expected 100: " + ms.multiply("10", "10"));
        System.out.println("Expected 900: " + ms.multiply("30", "30"));
        System.out.println("Expected 6: " + ms.multiply("2", "3"));
        System.out.println("Expected 1000000000000000000: " + ms.multiply("1000000000", "1000000000"));
    }
}
