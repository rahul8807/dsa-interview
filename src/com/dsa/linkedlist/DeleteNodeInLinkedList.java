package com.dsa.linkedlist;

public class DeleteNodeInLinkedList {
    // Method to delete the given node in a linked list
    public static void deleteNode(ListNode node) {
        ListNode previous = node;
        ListNode current = node.next;

        while(current != null){
            previous.value = current.value;
            if(current.next != null) {
                previous = current;
            }
            current = current.next;
        }

        previous.next = null;
    }

    // ANSI color codes for console output
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    // Test cases
    public static void main(String[] args) {
        // Test Case 1: Deleting a middle node
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(9);
        deleteNode(head1.next); // Delete node with value 5
        runTest(head1, new int[] {4, 1, 9}, "Test Case 1");

        // Test Case 2: Deleting another middle node
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        deleteNode(head2.next.next); // Delete node with value 3
        runTest(head2, new int[] {1, 2, 4}, "Test Case 2");
    }

    // Helper method to print and validate linked list
    private static void runTest(ListNode head, int[] expected, String testCaseName) {
        boolean isSuccess = true;
        ListNode current = head;
        int i = 0;

        while (current != null) {
            if (i >= expected.length || current.value != expected[i]) {
                isSuccess = false;
                break;
            }
            current = current.next;
            i++;
        }

        if (isSuccess && i == expected.length) {
            System.out.println(ANSI_GREEN + testCaseName + " Passed" + ANSI_RESET);
        } else {
            System.out.print(ANSI_RED + testCaseName + " Failed" + ANSI_RESET);
            System.out.print(" (Expected: [");
            for (int val : expected) {
                System.out.print(val + " ");
            }
            System.out.print("], Got: [");
            current = head;
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
            System.out.println("])");
        }
    }
}
