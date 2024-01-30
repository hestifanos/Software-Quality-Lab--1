
package com.ontariotechu.sofe3980U;

import org.joda.time.LocalTime;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
	/**
	 * Main program:  The entry point of the program. The local time will be printed first,
	 *      Then it will create two binary variables, add them and print the result.
	 *
	 * @param args: not used
	 */
	public static void main( String[] args )
	{
		LocalTime currentTime = new LocalTime();
		System.out.println("The current local time is: " + currentTime);

		// Create a Scanner for user input
		Scanner scanner = new Scanner(System.in);

// Input the first binary number
		System.out.print("Enter the first binary number: ");
		String binaryStr1 = scanner.nextLine();
		Binary binary1 = new Binary(binaryStr1);
		System.out.println("First binary number is " + binary1.getValue());


		// Input the second binary number
		System.out.print("Enter the second binary number: ");
		String binaryStr2 = scanner.nextLine();
		Binary binary2 = new Binary(binaryStr2);
		System.out.println("Second binary number is " + binary2.getValue());



		// Choose the operation
		System.out.println("Choose an operation:");
		System.out.println("1. Addition");
		System.out.println("2. Bitwise OR");
		System.out.println("3. Bitwise AND");
		System.out.println("4. Multiplication");

		int choice = scanner.nextInt();
		scanner.nextLine(); // consume the newline character

		Binary result = null;

		// Perform the chosen operation
		switch (choice) {
			case 1:
				result = Binary.add(binary1, binary2);
				break;
			case 2:
				result = binary1.or(binary2);
				break;
			case 3:
				result = binary1.and(binary2);
				break;
			case 4:
				result = binary1.multiply(binary2);
				break;
			default:
				System.out.println("Invalid choice. Exiting program.");
				System.exit(0);
		}

		// Output the result
		System.out.println("The result is: " + result.getValue());

		// Close the scanner to avoid resource leaks
		scanner.close();
	}
}





