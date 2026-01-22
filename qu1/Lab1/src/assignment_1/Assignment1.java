package assignment_1;

import java.util.*;

/*
 * Data Structure Assignment - EVEN Questions 
 * Q2, Q4, Q6, Q8, Q10, Q12, Q14, Q16
 */
public class Assignment1 {

    // =========================
    // Q2: Remove a random element from an array
    // =========================
    public static int[] removeRandomElement(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        if (arr.length == 1) return new int[0];

        Random rand = new Random();
        int removeIndex = rand.nextInt(arr.length);

        int[] result = new int[arr.length - 1];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == removeIndex) continue;
            result[j++] = arr[i];
        }
        return result;
    }

    // =========================
    // Q4: Reverse an array
    // =========================
    public static void reverseArray(int[] arr) {
        if (arr == null) return;
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }

    // =========================
    // Singly Linked List (for Q6, Q8)
    // =========================
    static class SNode {
        int data;
        SNode next;
        SNode(int data) { this.data = data; }
    }

    // Q6: Rotate singly linked list to the right by k places
    public static SNode rotateRight(SNode head, int k) {
        if (head == null || head.next == null || k <= 0) return head;

        // Find length and tail
        int len = 1;
        SNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        k = k % len;
        if (k == 0) return head;

        // Make it circular
        tail.next = head;

        // New tail is at position len - k - 1 (0-based from head)
        int stepsToNewTail = len - k;
        SNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        SNode newHead = newTail.next;
        newTail.next = null; // break circle
        return newHead;
    }

    // Q8: Find index of a given data value in a linked list (return -1 if not found)
    public static int indexOf(SNode head, int value) {
        int idx = 0;
        SNode cur = head;
        while (cur != null) {
            if (cur.data == value) return idx;
            cur = cur.next;
            idx++;
        }
        return -1;
    }

    // =========================
    // Doubly Linked List (for Q10, Q12)
    // =========================
    static class DNode {
        int data;
        DNode prev, next;
        DNode(int data) { this.data = data; }
    }

    // Q10: Remove duplicate elements from doubly linked list
    // Approach: HashSet to track seen values, remove nodes when repeated.
    public static DNode removeDuplicates(DNode head) {
        if (head == null) return null;

        Set<Integer> seen = new HashSet<>();
        DNode cur = head;

        while (cur != null) {
            if (seen.contains(cur.data)) {
                // remove cur
                DNode next = cur.next;

                if (cur.prev != null) cur.prev.next = cur.next;
                if (cur.next != null) cur.next.prev = cur.prev;

                // if removing head
                if (cur == head) head = next;

                cur = next;
            } else {
                seen.add(cur.data);
                cur = cur.next;
            }
        }
        return head;
    }

    // Q12: Search for an element in a doubly linked list (return true/false)
    public static boolean search(DNode head, int value) {
        DNode cur = head;
        while (cur != null) {
            if (cur.data == value) return true;
            cur = cur.next;
        }
        return false;
    }

    // =========================
    // Circular Linked List (for Q14, Q16)
    // =========================
    static class CNode {
        int data;
        CNode next;
        CNode(int data) { this.data = data; }
    }

    // Q14: Delete a node from a specific position in a circular linked list
    // Positions: 0-based (0 = head)
    public static CNode deleteAtPosition(CNode head, int pos) {
        if (head == null || pos < 0) return head;

        // If only one node
        if (head.next == head) {
            return (pos == 0) ? null : head;
        }

        // Deleting head (pos = 0)
        if (pos == 0) {
            // find tail
            CNode tail = head;
            while (tail.next != head) tail = tail.next;

            CNode newHead = head.next;
            tail.next = newHead;
            return newHead;
        }

        // Delete non-head
        CNode cur = head;
        for (int i = 0; i < pos - 1; i++) {
            cur = cur.next;
            if (cur == head) return head; // pos too large
        }

        CNode nodeToDelete = cur.next;
        if (nodeToDelete == head) return head; // pos too large
        cur.next = nodeToDelete.next;
        return head;
    }

    // Q16: Split a circular linked list into two halves
    // Returns array [head1, head2]
    public static CNode[] splitIntoTwoHalves(CNode head) {
        if (head == null) return new CNode[]{null, null};
        if (head.next == head) return new CNode[]{head, null};

        // slow/fast pointers
        CNode slow = head, fast = head;
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // If even number of nodes, move fast one step
        if (fast.next.next == head) fast = fast.next;

        CNode head1 = head;
        CNode head2 = slow.next;

        // Make first half circular
        slow.next = head1;

        // Make second half circular
        fast.next = head2;

        return new CNode[]{head1, head2};
    }

    // =========================
    // Helpers (build/print) for quick testing
    // =========================
    static SNode buildSingly(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        SNode head = new SNode(arr[0]);
        SNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new SNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    static void printSingly(SNode head) {
        SNode cur = head;
        while (cur != null) {
            System.out.print(cur.data + (cur.next != null ? " -> " : ""));
            cur = cur.next;
        }
        System.out.println();
    }

    static DNode buildDoubly(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        DNode head = new DNode(arr[0]);
        DNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            DNode n = new DNode(arr[i]);
            cur.next = n;
            n.prev = cur;
            cur = n;
        }
        return head;
    }

    static void printDoubly(DNode head) {
        DNode cur = head;
        while (cur != null) {
            System.out.print(cur.data + (cur.next != null ? " <-> " : ""));
            cur = cur.next;
        }
        System.out.println();
    }

    static CNode buildCircular(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        CNode head = new CNode(arr[0]);
        CNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new CNode(arr[i]);
            cur = cur.next;
        }
        cur.next = head;
        return head;
    }

    static void printCircular(CNode head, int maxNodes) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        CNode cur = head;
        int count = 0;
        while (count < maxNodes) {
            System.out.print(cur.data);
            cur = cur.next;
            count++;
            if (cur == head) break;
            System.out.print(" -> ");
        }
        System.out.println(" (circular)");
    }
}
