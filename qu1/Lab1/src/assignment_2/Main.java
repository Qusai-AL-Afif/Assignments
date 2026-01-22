
package assignment_2;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // TEST 1: Reverse string
        System.out.println("Reversed: " +
                Assignment_2.reverseString("hello"));

        // TEST 2: Sort stack
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(1);
        st.push(3);
        System.out.println("Sorted Stack: " +
                Assignment_2.sortStack(st));

        // TEST 3: Reverse queue

        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        System.out.println("Reversed Queue: " +
                Assignment_2.reverseQueue(q));

        // TEST 4: Priority queue
        PriorityQueue<Integer> pq = Assignment_2.createPriorityQueue();
        pq.add(40);
        pq.add(10);
        pq.add(30);

        System.out.print("Priority Queue Output: ");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }


        // TEST 5: Merge sorted queues
        Queue<Integer> q1 = new LinkedList<>(Arrays.asList(1, 3, 5));
        Queue<Integer> q2 = new LinkedList<>(Arrays.asList(2, 4, 6));

        System.out.println("\nMerged Queue: " +
                Assignment_2.mergeSortedQueues(q1, q2));
    }
}
