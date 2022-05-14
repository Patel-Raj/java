package io;

import java.util.Stack;

public class RecursionMain {
    public static void main(String[] args) {
        System.out.println(new Test().reverseString("abc"));
        System.out.println(new Test().palindrome("abaa"));
        System.out.println(new Test().mod2(10));
        Node headA = new Node(1, null);
        headA.next = new Node(4, null);
        headA.next.next = new Node(6, null);
        Node headB = new Node(2, null);
        headB.next = new Node(3, null);
        headB.next.next = new Node(5, null);
        headB.next.next.next = new Node(9, null);
        /*
        headA = new Test().reverseIt(headA);
        while(headA != null) {
            System.out.print(headA.val);
            headA = headA.next;
        }
        */
        Node merged = new Test().mergeTwoList(headA, headB);
        while(merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
        System.out.println();

        TreeNode head = null;
        head = insertBst(head, 100);
        head = insertBst(head, 50);
        head = insertBst(head, 500);
        head = insertBst(head, 20);
        head = insertBst(head, 250);
        head = insertBst(head, 30);
        head = insertBst(head, 3);
        head = insertBst(head, 700);
        head = insertBst(head, 600);

        printLeaves(head);
        System.out.println();

        Stack<Integer> st = new Stack<>();

        int maxi = maxRootToLeaves(head, st);
        System.out.println(maxi);
        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }

    }

    private static int maxRootToLeaves(TreeNode root, Stack<Integer> st) {
        if(root == null) {
            return 0;
        }
        int maxLeft = maxRootToLeaves(root.left, st);
        int maxRight = maxRootToLeaves(root.right, st);
        if(maxLeft >= maxRight) {
            if(root.left != null)
                st.push(root.left.val);
        }
        else{
            if(root.right != null)
                st.push(root.right.val);
        }

        return root.val + Math.max(maxLeft, maxRight);
    }

    public static TreeNode insertBst(TreeNode head, int val) {
        if(head == null) {
            head = new TreeNode(val);
            return head;
        }
        if(val <= head.val) {
            head.left = insertBst(head.left, val);
            return head;
        } else {
            head.right = insertBst(head.right, val);
            return head;
        }
    }

    public static void printLeaves(TreeNode root) {
        if(root == null)    return;
        if(root.left == null && root.right==null) {
            System.out.print(root.val + " ");
            return;
        }
        printLeaves(root.left);
        printLeaves(root.right);
    }
}

class Test {
    public String reverseString(String str) {
        if(str.length() == 1)   return str;
        return str.charAt(str.length()-1) + reverseString(str.substring(0, str.length()-1));
    }

    public boolean palindrome(String str) {
        if(str.equals(""))  return true;
        if(str.length() == 1)   return true;
        return str.charAt(0) == str.charAt(str.length()-1) ? palindrome(str.substring(1,str.length()-1)) : false;
    }

    public String mod2(int num) {
        if(num == 0)    return "0";
        return mod2(num/2) + String.valueOf(num%2);
    }

    public Node reverseIt(Node head) {
        if(head == null)    return null;
        if(head.next == null)   return head;
        Node newHead = reverseIt(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public Node mergeTwoList(Node headA, Node headB) {
        if(headA == null)   return headB;
        if(headB == null)   return headA;

        if(headA.val <= headB.val) {
            headA.next = mergeTwoList(headA.next, headB);
            return headA;
        }
        else {
            headB.next = mergeTwoList(headA, headB.next);
            return headB;
        }
    }
}

class Node {
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}