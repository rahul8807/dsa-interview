package com.dsa.bit;

public class NumberOfBits {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int count = 0;

		for (int i = 0; i < 32; i++) {
			if ((n & (1 << i)) != 0) {
				count++;
			}
		}

		return count; // Placeholder
	}

	public static void main(String[] args) {

		testHammingWeight(11, 3, "Test Case 1"); // Binary 1011
		testHammingWeight(128, 1, "Test Case 2"); // Binary 10000000
		testHammingWeight(-1, 32, "Test Case 3"); // All 32 bits are 1
		testHammingWeight(0, 0, "Test Case 4"); // Binary 0

		testHammingWeight(1, 1, "Test Case 5");
		testHammingWeight(3, 2, "Test Case 6");
	}

	public static void testHammingWeight(int n, int expected, String testCaseName) {
		int result = new NumberOfBits().hammingWeight(n);
		if (result == expected) {
			System.out.println("\u001B[32m" + testCaseName + " Passed \u001B[0m");
		} else {
			System.out.println("\u001B[31m" + testCaseName + " Failed \u001B[0m");
			System.out.println("Expected: " + expected + ", Got: " + result);
		}
	}
}