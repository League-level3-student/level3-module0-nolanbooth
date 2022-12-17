package _00_Intro_To_Arrays;

import java.util.ArrayList;
import java.util.Random;

public class _01_IntroToArrays {
    public static void main(String[] args) {
        // 1. declare and Initialize an array 5 Strings
    	String[] strings = {"One", "Two", "Three", "Four", "Five"};
        // 2. print the third element in the array
    	System.out.println(strings[2]);
        // 3. set the third element to a different value
    	strings[2] = "THREEEEE";
        // 4. print the third element again
    	System.out.println(strings[2]);
        // 5. use a for loop to set all the elements in the array to a string
        //    of your choice
    	for(int i = 0; i < strings.length; i++) {
    		strings[i] = "doug demuro";
    	}
        // 6. use a for loop to print all the values in the array
        //    BE SURE TO USE THE ARRAY'S length VARIABLE
    	for(int i = 0; i < strings.length; i++) {
    		System.out.println(strings[i]);
    	}
        // 7. make an array of 50 integers
    	int[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50};
    	
        // 8. use a for loop to make every value of the integer array a random
        //    number
        Random ran = new Random();
        for(int i = 0; i < numbers.length; i++){
         numbers[i] =  ran.nextInt(200);
           
        }
        // 9. without printing the entire array, print only the smallest number
        //    on the array
        int smallestNumber = numbers[0];
        for(int i = 0; i < numbers.length; i++){
        if(numbers[i] < smallestNumber){
            smallestNumber = numbers[i];
            }
        }
        System.out.println(smallestNumber);
        // 10 print the entire array to see if step 8 was correct
        for(int i = 0; i < numbers.length; i++){
         System.out.println(numbers[i]);   
        }
        // 11. print the largest number in the array.
        int largestNumber = numbers[0];
        for(int i = 0; i < numbers.length; i++){
        if(numbers[i] > largestNumber){
            largestNumber = numbers[i];
            }
        }
        System.out.println(largestNumber);
        
        // 12. print only the last element in the array
        System.out.println(numbers[49]);
    }
}
