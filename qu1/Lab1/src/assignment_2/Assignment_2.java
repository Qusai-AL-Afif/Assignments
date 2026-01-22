
package assignment_2;

import java.util.*;

public class Assignment_2 {

    // 1. Reverse string using stack
    public static String reverseString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            stack.push(c);
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }


        return result.toString();
    }

    // 2. Sort stack using another stack
    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty()) {
            int value = stack.pop();

            while (!temp.isEmpty() && temp.peek() > value) {
                stack.push(temp.pop());
            }

            temp.push(value);
        }
        return temp;
    }


    // 3. Reverse queue
    public static Queue<Integer> reverseQueue(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();

        while (!q.isEmpty()) {
            stack.push(q.poll());
        }

        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        return q;
    }

    // 4. Priority queue – smallest first
    public static PriorityQueue<Integer> createPriorityQueue() {
        return new PriorityQueue<>();

    }

    // 5. Merge two sorted queues
    public static Queue<Integer> mergeSortedQueues(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> result = new LinkedList<>();

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek() <= q2.peek()) {
                result.add(q1.poll());
            } else {
                result.add(q2.poll());
            }
        }

        while (!q1.isEmpty()) result.add(q1.poll());
        while (!q2.isEmpty()) 

result.add(q2.poll());
        
        
        return result;
    }
}
