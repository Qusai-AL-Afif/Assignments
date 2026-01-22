
package Lab1;

import java.util.Scanner;
 import java.util.Arrays;
import java.util.Scanner;

public class Main {

   
  
 


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        int[] numbers = {23, 5, 87, 12, 55, 1, 99};
        System.out.println("The original Array " + Arrays.toString(numbers));

        // 1. Traversing: 
        System.out.println("\nTraversing (Show all elements):");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("اThe element in index :" + i + " = " + numbers[i]);
        }

        // 2. Linear Search:  
        System.out.print("\nEnter the number to serch for it  (Linear Search): ");
        int target = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                System.out.println("The number has been found in index: " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The number unfound in Array ! ");
        }

        // 3. Sorting:   
        Arrays.sort(numbers);
        System.out.println("\nArray after sorting: " + Arrays.toString(numbers));

        // 4. Binary Search: 
        System.out.print("\n Enter the number to serch for it (Binary Search): ");
        int targetBinary = sc.nextInt();
        int index = Arrays.binarySearch(numbers, targetBinary);
        if (index >= 0) {
            System.out.println("The number has been found in index: " + index);
        } else {
            System.out.println("The number unfound in Array !.");
        }

        sc.close();
    }
}

    

