package com.dsa.recurssion;


import java.util.ArrayList;
import java.util.List;

public class LimitedCoinChange {

    static int MAX_AMOUNT = 0;
    public int limitedCoinChange(int[] coins, int[] quantities, int amount) {
        MAX_AMOUNT = amount+1;

        List <Integer> list = new ArrayList <> (  );
        for(int i=0; i<quantities.length; i++){
            for(int j=0; j<quantities[i]; j++){
                list.add ( coins[i] );
            }
        }

        int[] coinss = list.stream().mapToInt(i -> i).toArray();
        int value =  coinChange ( coinss,amount, 0 ); // Placeholder

        if(value >= MAX_AMOUNT){
            return -1;
        }else{
            return value;
        }
    }

    public static int coinChange(int[] coins, int amount, int index) {

        if(amount == 0){
            return 0;
        }

        if(index >= coins.length){
            return MAX_AMOUNT;
        }

        if(coins[index] > amount){
            return coinChange ( coins, amount, index + 1);
        }

        int include = 1 + coinChange ( coins, amount - coins[index], index+1 );
        int exclude = coinChange ( coins, amount, index + 1 );

        return Math.min ( include,exclude ); // Placeholder return value
    }


    public static void main(String[] args) {
        LimitedCoinChange limitedCoinChange = new LimitedCoinChange();

        // Test Case 1: Limited coins
        int[] coins1 = {1, 2, 5};
        int[] quantities1 = {2, 2, 1}; // 2 ones, 2 twos, 1 five
        int amount1 = 11;
        int result1 = limitedCoinChange.limitedCoinChange(coins1, quantities1, amount1);
        System.out.println("Test Case 1: " + result1 + ": " + (result1 == 5 ? "\u001B[32mPassed\u001B[0m" : "\u001B[31mFailed\u001B[0m"));

        // Test Case 2: Limited coins, possible amount
        int[] coins2 = {1, 2, 5};
        int[] quantities2 = {3, 2, 1}; // 3 ones, 2 twos, 1 five
        int amount2 = 7;
        int result2 = limitedCoinChange.limitedCoinChange(coins2, quantities2, amount2);
        System.out.println("Test Case 2: " + result2 + ": " + (result2 == 2 ? "\u001B[32mPassed\u001B[0m" : "\u001B[31mFailed\u001B[0m"));

        // Test Case 3: Limited coins, zero amount
        int[] coins3 = {1, 2, 5};
        int[] quantities3 = {3, 2, 1};
        int amount3 = 0;
        int result3 = limitedCoinChange.limitedCoinChange(coins3, quantities3, amount3);
        System.out.println("Test Case 3: " + result3 + ": " + (result3 == 0 ? "\u001B[32mPassed\u001B[0m" : "\u001B[31mFailed\u001B[0m"));

        // Test Case 5: amount is possible
        int[] coins5 = {1,2,5};
        int[] quantities5 = {3,2,1};
        int amount5 = 4;
        int result5 = limitedCoinChange.limitedCoinChange(coins5, quantities5, amount5);
        System.out.println("Test Case 5: " + result5 + ": " + (result5 == 2 ? "\u001B[32mPassed\u001B[0m" : "\u001B[31mFailed\u001B[0m"));
    }
}
