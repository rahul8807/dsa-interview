package com.dsa.linkedlist;

public class LinkedListCycle {
    // Method to detect a cycle in the linked list
    public static boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != null || fast != null){
            if(slow == fast){
                return true;
            }

            slow = slow.next;

            if(fast != null && fast.next != null) {
                fast = fast.next.next;
            }else{
                fast = null;
            }

        }

        return false; // Placeholder return value
    }

    // ANSI color codes for colored console output
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    // Test cases
    public static void main(String[] args) {
        // Test Case 1: Cycle exists
        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates a cycle
        runTest(head1, true, "Test Case 1");

        // Test Case 2: No cycle
        ListNode head2 = new ListNode(1);
        ListNode node2_2 = new ListNode(2);
        head2.next = node2_2;
        runTest(head2, false, "Test Case 2");

        // Test Case 3: Single node with self-loop
        ListNode head3 = new ListNode(1);
        head3.next = head3; // Points back to itself
        runTest(head3, true, "Test Case 3");

        // Test Case 4: Empty list
        ListNode head4 = null;
        runTest(head4, false, "Test Case 4");

        // Test Case 5: Single node without cycle
        ListNode head5 = new ListNode(1);
        runTest(head5, false, "Test Case 5");
    }

    // Helper method to run a test case and print colored output
    private static void runTest(ListNode head, boolean expected, String testCaseName) {
        boolean result = hasCycle(head);

        if (result == expected) {
            System.out.println(ANSI_GREEN + testCaseName + " Passed" + ANSI_RESET);
        } else {
            System.out.print(ANSI_RED + testCaseName + " Failed" + ANSI_RESET);
            System.out.println(" (Expected: " + expected + ", Got: " + result + ")");
        }
    }
}
