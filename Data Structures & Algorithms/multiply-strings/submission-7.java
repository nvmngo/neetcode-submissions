class Solution {
    public String multiply(String num1, String num2) {
        // The intuition for this question:
        /* 
            We can not simply convert the 'strings' into int / long - in order to calculate the product
            
            For cases where the number is too large - the constraint for the length of num1 & 2 is < 200
            -> Int - Long overflow
            -> Even for the 'multiplier' -> can have long overflow

            ---------------
            THE CURRENT MOST PLAUSIBLE SOLUTION:
            
            We will start the multiplication, directly onto the strings of the number
            String * String = String

            But we will try to refine and optimize the code in this sense 

            a * bc = a * b0 + c

            So thus, it will be easier for us to implement the code the multiplication process

            a * b00 = NEW STRING (a * b) then add two trailing '0's
        */

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        String curr = "0";

        while (num2 != "") {
            int digit = num2.charAt(0) - '0'; // get the first digit
            int length = num2.length() - 1; // get the number of trailing '0's

            curr = addition(curr, multiplicationHelper(num1, digit, length));

            num2 = num2.substring(1, num2.length());
        }

        return curr;
    }

    public String multiplicationHelper(String num1, int num2, int length) {
        
        // num1 -> String representation of the multiplier "abcxyz"
        // num2 -> The leading int for the second multiplier -> a if before num2 == 'abcxyz'
        // length -> The number of trailing '0's -> 3 if num2 == 'a000'
        
        int carry = 0;
        String res = "";

        for (int i = num1.length() - 1; i >= 0; i--) {
            int digit = num1.charAt(i) - '0';

            int prod = digit * num2;

            if (carry > 0) {
                prod += carry;
                carry = 0;
            }

            carry += prod / 10;

            res = prod % 10 + res;
        }

        if (carry != 0) {
            res = carry + res;
            carry = 0;
        }

        for (int i = 0; i < length; i++) {
            res += 0;
        }

        return res;
    }

    public String addition(String num1, String num2) {
        int l = num1.length() - 1;  // pointer for num1
        int r = num2.length() - 1;  // pointer for num2

        String res = "";
        int carry = 0;

        while (l >= 0 && r >= 0) {
            int digit1 = num1.charAt(l) - '0';
            int digit2 = num2.charAt(r) - '0';

            int sum = digit1 + digit2;

            if (carry > 0) {
                sum += carry;
                carry = 0;
            }

            carry += sum/10;
            res = sum % 10 + res;

            l--;
            r--;
        }

        while (l >= 0) {
            
            int sum = num1.charAt(l) - '0' + carry;

            carry = sum / 10;

            res = sum % 10 + res;

            l--;
        }

        while (r >= 0) {
            
            int sum = num2.charAt(r) - '0' + carry;

            carry = sum/10;

            res = sum % 10 + res;
            
            r--;
        }

        if (carry != 0) {
            res = carry + res;
            carry = 0;
        }

        return res;
    }
}
