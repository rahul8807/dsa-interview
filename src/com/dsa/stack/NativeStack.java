package com.dsa.stack;

public class NativeStack {

    int[] stack = null;

    public NativeStack (){
        this.stack = new int[100];
    }


    public Boolean push(int no){

        return Boolean.TRUE;
    }

    public Boolean pop(){

        return Boolean.TRUE;
    }


    public int top() {
        // ...
        return 0; // Placeholder
    }

    public int getMin() {
        // ...
        return 0; // Placeholder
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
        NativeStack nativeStack = new NativeStack ();
        nativeStack.push(-2);
        nativeStack.push(0);
        nativeStack.push(-3);
        assert nativeStack.getMin() == -3;
        nativeStack.pop();
        assert nativeStack.top() == 0;
        assert nativeStack.getMin() == -2;
        System.out.println("Test Case 1 Passed");
    }

    public static void testCase2() {
        NativeStack nativeStack = new NativeStack ();
        nativeStack.push(2);
        nativeStack.push(1);
        nativeStack.push(3);
        assert nativeStack.getMin() == 1;
        nativeStack.pop();
        assert nativeStack.top() == 1;
        assert nativeStack.getMin() == 1;
        System.out.println("Test Case 2 Passed");
    }

    public static void testCase3() {
        NativeStack nativeStack = new NativeStack ();
        nativeStack.push(2);
        nativeStack.push(3);
        nativeStack.push(1);
        assert nativeStack.getMin() == 1;
        nativeStack.pop();
        assert nativeStack.top() == 3;
        assert nativeStack.getMin() == 2;
        System.out.println("Test Case 3 Passed");
    }

    public static void testCase4() {
        NativeStack nativeStack = new NativeStack ();
        nativeStack.push(-1);
        assert nativeStack.top() == -1;
        assert nativeStack.getMin() == -1;
        nativeStack.pop();
        try {
            nativeStack.top(); // Should throw an exception or return a special value
            System.out.println("Test Case 4 Failed: Top after pop on empty stack should throw error");
        } catch (Exception e) {
            System.out.println("Test Case 4 Passed");
        }
    }

    public static void testCase5() {
        NativeStack nativeStack = new NativeStack ();
        nativeStack.push(0);
        nativeStack.push(1);
        nativeStack.push(0);
        assert nativeStack.getMin() == 0;
        nativeStack.pop();
        assert nativeStack.getMin() == 0;
        System.out.println("Test Case 5 Passed");
    }

    public static void testCase6() {
        NativeStack nativeStack = new NativeStack ();
        nativeStack.push(2147483646);
        nativeStack.push(2147483646);
        nativeStack.push(2147483647);
        assert nativeStack.top() == 2147483647;
        nativeStack.pop();
        assert nativeStack.getMin() == 2147483646;
        nativeStack.pop();
        assert nativeStack.getMin() == 2147483646;
        nativeStack.pop();
        System.out.println("Test Case 6 Passed");
    }

    public static void testCase7() {
        NativeStack nativeStack = new NativeStack ();
        nativeStack.push(-2147483648);
        assert nativeStack.top() == -2147483648;
        assert nativeStack.getMin() == -2147483648;
        System.out.println("Test Case 7 Passed");
    }

    public static void testCase8() {
        NativeStack nativeStack = new NativeStack ();
        nativeStack.push(-2147483648);
        nativeStack.push(-2147483648);
        nativeStack.push(-2147483647);
        assert nativeStack.getMin() == -2147483648;
        nativeStack.pop();
        assert nativeStack.getMin() == -2147483648;
        System.out.println("Test Case 8 Passed");
    }
}