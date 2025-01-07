package Problems;
/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned). 

steps :-

1.Initialize the reversed number (rev) to 0.
2.Loop through each digit of the input number.
For each digit, check if adding it to the reversed number will cause an overflow.
3.If an overflow is detected, return 0.
Otherwise, update the reversed number by multiplying it by 10 and adding the current digit.
4.Continue this process until all digits are processed.
5.Return the reversed number with the appropriate sign.
 */

public class reverseinteger {
        public int reverse(int x) {
            int num = Math.abs(x);  // Original number ka absolute value nikala
            
            int rev = 0;  // Reversed number
            
            while (num != 0) {
                int ld = num % 10;  // Last digit nikala
                
                // Overflow check
                if (rev > (Integer.MAX_VALUE - ld) / 10) {
                    return 0;  // Agar overflow hua, toh 0 return kardo
                }
                
                rev = rev * 10 + ld;  // Reverse mein digit ko add kiya
                num = num / 10;  // Last digit hata diya, next iteration ke liye
            }
            
            return (x < 0) ? (-rev) : rev;  // Original number ke sign ke hisaab se result diya
        }
        public static void main(String[] args) {
            reverseinteger rs =new reverseinteger();
            int x=123;
           System.out.println(  rs.reverse(x));
        }
    }
    