package com.ven.easy.strings;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int carry = 0;
        for (int i = ac.length - 1, j = bc.length - 1; i >= 0 || j >= 0; i--, j--) {
            if (i >= 0 && ac[i] == '1') ++carry;
            if (j >= 0 && bc[j] == '1') ++carry;

            int digit = carry % 2;
            sb.append(digit);
            carry /= 2;

        }
        if (carry == 1) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String a = "1010";
        String b = "1011";
        System.out.println("Sum: " + addBinary.addBinary(a, b)); // Output: "10101"
    }
}
