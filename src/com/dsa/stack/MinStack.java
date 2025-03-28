package com.dsa.stack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack = new Stack <> ();
    private Stack<Integer> minStack = new Stack <> ();

    public Boolean push(int num){
        if(stack.isEmpty ()){
            stack.push ( num );
            minStack.push ( num );
        }else{
            stack.push ( num );
            int top = stack.peek ();
            int mintop = minStack.peek ();
            if(top < mintop){
                minStack.push ( top );
            }else{
                minStack.push ( mintop );
            }
        }

        return Boolean.TRUE;
    }

    public Integer pop(){
        if(! stack.isEmpty ()){
            minStack.pop();
            return stack.pop ();

        }
        return -1;
    }


    public int top() {
        return stack.peek ();
    }

    public int getMin() {
        return minStack.peek ();
    }

    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        testCase1();
        testCase2();
        testCase3();
        testCase4();
        testCase5();
        testCase6();
        testCase7();
        testCase8();
    }

    public static void testCase1() {
        MinStack nativeStack = new MinStack();
        nativeStack.push(-2);
        nativeStack.push(0);
        nativeStack.push(-3);
        boolean passed = nativeStack.getMin() == -3;
        passed = passed && nativeStack.pop() == -3; // Pop returns the popped value
        passed = passed && nativeStack.top() == 0;
        passed = passed && nativeStack.getMin() == -2;
        printResult("Test Case 1", passed);
    }

    public static void testCase2() {
        MinStack nativeStack = new MinStack();
        nativeStack.push(2);
        nativeStack.push(1);
        nativeStack.push(3);
        boolean passed = nativeStack.getMin() == 1;
        passed = passed && nativeStack.pop() == 3;
        passed = passed && nativeStack.top() == 1;
        passed = passed && nativeStack.getMin() == 1;
        printResult("Test Case 2", passed);
    }

    public static void testCase3() {
        MinStack nativeStack = new MinStack();
        nativeStack.push(2);
        nativeStack.push(3);
        nativeStack.push(1);
        boolean passed = nativeStack.getMin() == 1;
        passed = passed && nativeStack.pop() == 1;
        passed = passed && nativeStack.top() == 3;
        passed = passed && nativeStack.getMin() == 2;
        printResult("Test Case 3", passed);
    }

    public static void testCase4() {
        MinStack nativeStack = new MinStack();
        nativeStack.push(-1);
        boolean passed = nativeStack.top() == -1 && nativeStack.getMin() == -1;
        nativeStack.pop();
        try {
            nativeStack.top(); // Should throw an exception or return a special value
            printResult("Test Case 4", false); // Failed if no exception
        } catch (Exception e) {
            printResult("Test Case 4", true);
        }
    }

    public static void testCase5() {
        MinStack nativeStack = new MinStack();
        nativeStack.push(0);
        nativeStack.push(1);
        nativeStack.push(0);
        boolean passed = nativeStack.getMin() == 0;
        passed = passed && nativeStack.pop() == 0;
        passed = passed && nativeStack.getMin() == 0;
        printResult("Test Case 5", passed);
    }

    public static void testCase6() {
        MinStack nativeStack = new MinStack();
        nativeStack.push(2147483646);
        nativeStack.push(2147483646);
        nativeStack.push(2147483647);
        boolean passed = nativeStack.top() == 2147483647;
        passed = passed && nativeStack.pop() == 2147483647;
        passed = passed && nativeStack.getMin() == 2147483646;
        passed = passed && nativeStack.pop() == 2147483646;
        passed = passed && nativeStack.getMin() == 2147483646;
        printResult("Test Case 6", passed);
    }

    public static void testCase7() {
        MinStack nativeStack = new MinStack();
        nativeStack.push(-2147483648);
        boolean passed = nativeStack.top() == -2147483648 && nativeStack.getMin() == -2147483648;
        printResult("Test Case 7", passed);
    }

    public static void testCase8() {
        MinStack nativeStack = new MinStack();
        nativeStack.push(-2147483648);
        nativeStack.push(-2147483648);
        nativeStack.push(-2147483647);
        boolean passed = nativeStack.getMin() == -2147483648;
        passed = passed && nativeStack.pop() == -2147483647;
        passed = passed && nativeStack.getMin() == -2147483648;
        printResult("Test Case 8", passed);
    }

    public static void printResult(String testName, boolean passed) {
        String green = "\u001B[32m";
        String red = "\u001B[31m";
        String reset = "\u001B[0m";

        if (passed) {
            System.out.println(green + testName + " Passed" + reset);
        } else {
            System.out.println(red + testName + " Failed" + reset);
        }
    }
}