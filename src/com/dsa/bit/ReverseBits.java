package com.dsa.bit;

import java.math.BigInteger;

public class ReverseBits {

    // Method to reverse bits of a 32-bit integer
    public int reverseBits(int n) {
       String str = new String();
       for(int i=0; i<32; i++) {
    	   if( (n  & 1<<i) > 0 ) {
    		   str = str+"1";
    	   }else {
    		   str = str+"0";
    	   }
       }
       
       //System.out.println(str);
       BigInteger bigInt = new BigInteger(str,2);
       
       return bigInt.intValue();
       
    }

    // Test cases
    public static void main(String[] args) {
        testReverseBits(43261596, 964176192, "Test Case 1"); // Binary: 00000010100101000001111010011100 → 00111001011110000010100101000000
        //testReverseBits(4294967293, 3221225471, "Test Case 2"); // Binary: 11111111111111111111111111111101 → 10111111111111111111111111111111
        testReverseBits(0, 0, "Test Case 3"); // Binary: 00000000000000000000000000000000 → 00000000000000000000000000000000
        testReverseBits(1, Integer.MIN_VALUE, "Test Case 4"); // Binary: 00000000000000000000000000000001 → 10000000000000000000000000000000
        testReverseBits(Integer.MAX_VALUE, -2, "Test Case 5"); // Binary: 01111111111111111111111111111111 → 11111111111111111111111111111110
    }

    // Test framework to validate the reverseBits method
    public static void testReverseBits(int n, int expected, String testCaseName) {
        int result = new ReverseBits().reverseBits(n); // Create an instance and call the method
        if (result == expected) {
            System.out.println(testCaseName + " Passed");
        } else {
            System.out.println(testCaseName + " Failed");
            System.out.println("Expected: " + expected + ", Got: " + result);
        }
    }
}


