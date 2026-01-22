package assignment_1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Q2
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Before Q2: " + Arrays.toString(arr));
        arr = Assignment1.removeRandomElement(arr);
        System.out.println("After Q2: " + Arrays.toString(arr));

        // Q4
        int[] rev = {10, 20, 30};
        Assignment1.reverseArray(rev);
        System.out.println("Q4 Reverse: " + Arrays.toString(rev));

        // Q6 & Q8
        Assignment1.SNode head = new Assignment1.SNode(1);
        head.next = new Assignment1.SNode(2);
        head.next.next = new Assignment1.SNode(3);

        head = Assignment1.rotateRight(head, 1);
        System.out.println("Q8 Index of 2: " + Assignment1.indexOf(head, 2));

        // Q10 & Q12
        Assignment1.DNode d1 = new Assignment1.DNode(1);
        Assignment1.DNode d2 = new Assignment1.DNode(2);
        Assignment1.DNode d3 = new Assignment1.DNode(2);

        d1.next = d2; d2.prev = d1;
        d2.next = d3; d3.prev = d2;

        Assignment1.removeDuplicates(d1);
        System.out.println("Q12 Search 2: " + Assignment1.search(d1, 2));
        
    }
}
