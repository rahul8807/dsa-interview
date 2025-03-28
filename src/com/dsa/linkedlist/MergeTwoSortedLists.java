package com.dsa.linkedlist;



public class MergeTwoSortedLists {
    // Method to merge two sorted lists
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ptr1 = list1;
        ListNode ptr2 = list2;
        ListNode ptr3 = null;
        ListNode head = null;
        while(ptr1 != null && ptr2 != null){
            ListNode tempPtr = null;
            if(ptr1.value > ptr2.value){

                if(head == null){
                    head = ptr2;
                }

                tempPtr = ptr2.next;
                ptr3 = ptr1.next;
                ptr2.next = ptr1;
                ptr1.next = tempPtr;

                ptr2 = ptr1.next;
                ptr1 = tempPtr;
            }else{

                if(head == null){
                    head = ptr1;
                }

                tempPtr = ptr1.next;
                ptr3 = ptr2.next;
                ptr1.next = ptr2;
                ptr2.next = tempPtr;

                ptr1 = ptr2.next;
                ptr2 = tempPtr;
            }
        }

        return head; // Placeholder return value
    }

    // ANSI color codes for colored console output
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    // Test cases
    public static void main(String[] args) {
        // Test Case 1: Both lists have elements
        ListNode list1_1 = new ListNode(1);
        list1_1.next = new ListNode(2);
        list1_1.next.next = new ListNode(4);

        ListNode list2_1 = new ListNode(1);
        list2_1.next = new ListNode(3);
        list2_1.next.next = new ListNode(4);

        ListNode expected1 = buildExpected(new int[]{1, 1, 2, 3, 4, 4});
        runTest(list1_1, list2_1, expected1, "Test Case 1");

        // Test Case 2: Both lists are empty
        ListNode list1_2 = null;
        ListNode list2_2 = null;

        ListNode expected2 = null;
        runTest(list1_2, list2_2, expected2, "Test Case 2");

        // Test Case 3: One list is empty
        ListNode list1_3 = null;
        ListNode list2_3 = new ListNode(0);

        ListNode expected3 = buildExpected(new int[]{0});
        runTest(list1_3, list2_3, expected3, "Test Case 3");
    }

    // Helper method to build an expected linked list from an array
    private static ListNode buildExpected(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to validate and run test cases
    private static void runTest(ListNode list1, ListNode list2, ListNode expected, String testCaseName) {
        ListNode result = mergeTwoLists(list1, list2);

        if (compareLists(result, expected)) {
            System.out.println(ANSI_GREEN + testCaseName + " Passed" + ANSI_RESET);
        } else {
            System.out.print(ANSI_RED + testCaseName + " Failed" + ANSI_RESET);
            System.out.print(" (Expected: ");
            printList(expected);
            System.out.print(", Got: ");
            printList(result);
            System.out.println(")");
        }
    }

    // Helper method to compare two linked lists
    private static boolean compareLists(ListNode list1, ListNode list2) {
        while (list1 != null && list2 != null) {
            if (list1.value != list2.value) return false;
            list1 = list1.next;
            list2 = list2.next;
        }
        return list1 == null && list2 == null;
    }

    // Helper method to print a linked list
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}
