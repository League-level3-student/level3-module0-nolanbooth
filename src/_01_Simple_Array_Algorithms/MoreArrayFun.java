package _01_Simple_Array_Algorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MoreArrayFun {
	// 1. Create a main method to test the other methods you write.
	public static void main(String[] args) {
		String[] words = { "one", "two", "three", "four", "five" };
		print(words);
		printR(words);
		everyOther(words);
		randomOrder(words);

	}

	// 2. Write a method that takes an array of Strings and prints all the Strings
	// in the array.
	public static void print(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		System.out.println("- - - - Printed All Strings - - - -");
	}

	// 3. Write a method that takes an array of Strings and prints all the Strings
	// in the array
	// in reverse order.
	public static void printR(String[] array) {
		for (int i = array.length; i > 0; i--) {
			System.out.println(array[i - 1]);
		}
		System.out.println("- - - - Printed Strings in Reverse - - - -");
	}

	// 4. Write a method that takes an array of Strings and prints every other
	// String in the array.
	public static void everyOther(String[] array) {
		for (int i = 0; i < array.length; i += 2) {
			System.out.println(array[i]);
		}
		System.out.println("- - - - Printed Every Other String - - - -");
	}

	// 5. Write a method that takes an array of Strings and prints all the Strings
	// in the array
	// in a completely random order. Almost every run of the program should result
	// in a different order.
	public static void randomOrder(String[] array) {
		Random ran = new Random();
		ArrayList<String> copy = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			copy.add(array[i]);

		}
		Collections.shuffle(copy);
		for (int i = 0; i < array.length; i++) {
			System.out.println(copy.get(i));
		}
		System.out.println("- - - - Numbers Randomized - - - -");
	}

}
