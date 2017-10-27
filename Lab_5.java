
/*
Tim Johnson
10/26/17
Grand Circus
Lab 5

*/

import java.util.Random;
import java.util.Scanner;

public class Lab_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean repeat = true;
		int rollCount = 1;


		System.out.println("Welcome to the Grand Circus Casino!");
		
		while (repeat) {
			
			System.out.print("\nHow many sides should each die have? ");
			printStoredRolls( rollDie(confirmValidInt(sc)), rollCount);
			
			System.out.println("\nRoll again? (y/n)");
			repeat = repeatYesNo(sc);
			
			rollCount++;
		}
		
		sc.close();
	}

	public static int[] rollDie(int numberOfSides) {
		// rolls two dice a set numberOfRolls (default number: 5) and stores each roll into an array
		
		Random dice1 = new Random();

		int numberOfRolls = 5;

		int[] storedRolls = new int[numberOfRolls];

		for (int i = 0; i < storedRolls.length; i++) {
			if (i % 2 == 0) {  // for even rolls, roll dice 1
				storedRolls[i] = dice1.nextInt(numberOfSides) + 1;
			} else { // for odd rolss, roll dice 2
				storedRolls[i] = (int) (Math.random() * numberOfSides + 1);
			}
		}

		return storedRolls;
	}

	public static void printStoredRolls(int[] storedRolls, int rollCount) {
		//prints the rolls that were saved into an array 
		System.out.println("\nRoll " + rollCount + ":");
		for (int i = 0; i < storedRolls.length; i++) {
			System.out.println(storedRolls[i]);
		}
	}

	public static int confirmValidInt(Scanner sc) {
		// ensures that the user enters an int 
		while (!sc.hasNextInt()) {
			System.out.println("\nDude... please enter an WHOLE number.");
			sc.nextLine();
		}

		return sc.nextInt();
	}
	
	public static boolean repeatYesNo(Scanner sc) {
	// returns true or false depending if the user enters 'n'
		sc.hasNext();
		
		if(sc.nextLine().equalsIgnoreCase("N")) {
			return false;
		} else {
			sc.nextLine();
			return true;
		}
		
	}
}
