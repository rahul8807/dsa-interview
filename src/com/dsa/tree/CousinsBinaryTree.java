package com.dsa.tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class CousinsBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        return (height(root, x) == height(root, y) && parent(root,x,-1) != parent(root, y, -1)); 
    }
    
    public int parent(TreeNode root , int value, int parent) {
    	
    	if(root == null) {
    		return -1;
    	}
    	
    	if(root.val == value) {
    		return parent;
    	}
    	
    	return Math.max(parent(root.left,value,root.val) , parent(root.right,value,root.val));
    	
    }
    
    public int height(TreeNode root , int value) {
    	
    	if(root == null) {
    		return 100_000;
    	}
    	
    	if(root.val == value) {
    		return 1;
    	}
    	
    	 int left = 1 + height(root.left, value);
    	 int right = 1 + height(root.right, value);
    	 return Math.min(left, right);
    	
    }

    public static void main(String[] args) {
        // Example Test Cases
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        testIsCousins(root, 4, 5, true, "Test Case 1"); // Expected: true
        testIsCousins(root, 4, 3, false, "Test Case 2"); // Expected: false
        testIsCousins(root, 2, 3, false, "Test Case 3"); // Expected: false
    }

    public static void testIsCousins(TreeNode root, int x, int y, boolean expected, String testCaseName) {
        boolean result = new CousinsBinaryTree().isCousins(root, x, y);
        if (result == expected) {
            System.out.println(testCaseName + " Passed");
        } else {
            System.out.println(testCaseName + " Failed");
            System.out.println("Expected: " + expected + ", Got: " + result);
        }
    }
}
