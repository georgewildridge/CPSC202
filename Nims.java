/*
George Wildridge
Nim
2/17/16
Driver Class
The purpose of this game was to implement a program that could play a human in nim.  
*/

import java.util.Scanner;
import java.util.InputMismatchException;

public class Nims {
	public Scanner sc = new Scanner(System.in);
	public Nim nim = new Nim();
	public String city; 
	public int bet;
	public int shortBet;
	// calls the intro method
	public Nims() {
		introduction();
	}	
	public void introduction() {
		System.out.println("   _..._   .--. __  __   ___ ");
		System.out.println(" .'     '. |__||  |/  `.'   `. ");
		System.out.println(".   .-.   ..--.|   .-.  .-.   '");	
		System.out.println("|  '   '  ||  ||  |  |  |  |  |");	
		System.out.println("|  |   |  ||  ||  |  |  |  |  |");	
		System.out.println("|  |   |  ||  ||  |  |  |  |  |");	
		System.out.println("|  |   |  ||  ||  |  |  |  |  |");
		System.out.println("|  |   |  ||__||__|  |__|  |__|");
		System.out.println("|  |   |  |   ");
		System.out.println("|  |   |  |   ");
		System.out.println("'--'   '--'  ");

		System.out.println("\n\nWelcome to Nim. \n");
		System.out.println("In nim, you have a given number of stacks, and a given number of chips within those stacks, and two \nplayers take turns reducing one stack at a time, with each player aiming to be the last one to reduce the stacks.\n\n\n\n");
		System.out.println();
		intro();
	}
	// gives user the choice of where to travel, where they travel determines the game mode of nim. Go Home is a dead end. 
	public void intro() {
		System.out.println("How many stacks would you like to play with? ");
		System.out.println("	(A) Random");
		System.out.println("	(B) I'll input it myself. ");
		try{
			String string = sc.next().toLowerCase();
			if (string.equals("a")) {
				nim.stacks();
				piles();
			} else if (string.equals("b")) {
				System.out.println("\nInput a number less than or equal to 10 and greater than 1");
				try{
					int a = sc.nextInt();
					if (a<=10 && a>1){
						nim.mstacks(a);
						piles();
					} else {
						System.out.println("Sorry, that number is bigger then 10 or smaller than 2.");
						intro();
					}
				} catch (InputMismatchException e) {
					sc.nextLine(); // clear the newline in the buffer
					System.out.println("Sorry! That's not a Number. Try again.");
					intro();
				}
			} else {
				intro();
			}
		} catch (InputMismatchException e) {
			sc.nextLine(); // clear the newline in the buffer
			System.out.println("Sorry! That's not a Letter. Try again.");
			intro();
		}
	}

	public void piles() {
		System.out.println("What number of chips would you like to be in each pile? ");
		System.out.println("	(A) Random");
		System.out.println("	(B) I'll input it myself. ");
	try{
			String string = sc.next().toLowerCase();
			if (string.equals("a")) {
				nim.piles();
				whoFirst();
			} else if (string.equals("b")) {
				System.out.println("here");
				for (int i = 0; i < nim.getNumPiles(); i++) {
					System.out.println("\n Input a number less than or equal to 100");
					try{
						int a = sc.nextInt();
						if (a<=100){
							nim.mpiles(i,a);
						} else {
							System.out.println("Sorry, that number is bigger then 100.");
							piles();
						}
					} catch (InputMismatchException e) {
						sc.nextLine(); // clear the newline in the buffer
						System.out.println("Sorry! That's not a Number. Try again.");
						piles();
					}
				}
				nim.tidyStacks();
				whoFirst();
				
			} else {
				piles();
			}
		} catch (InputMismatchException e) {
			sc.nextLine(); // clear the newline in the buffer
			System.out.println("Sorry! That's not a Letter. Try again.");
			piles();
		}
	}

	public void whoFirst() {
		System.out.println("Great, now that we have the game set up let's decide who goes first. The starting pile configuration looks like this: \n \n ");
		nim.getStacksPrint();
		System.out.println("\n Do (A) you want to go first, (B) you want me to go first or (C) would you like it to be random?");
		try{
			String string = sc.next().toLowerCase();
			if (string.equals("a")) {
				nim.setTurn(0);
				nim();
			} else if (string.equals("b")) {
				nim.setTurn(1);
				nim();
			} else if (string.equals("c")) {
				nim.randomTurn();
				if (nim.getTurn() == 0) {
					System.out.println("\nYou start.");
				} else {
					System.out.println("\nI'll start.");
				}
				nim();
			} else {
				System.out.println("Please enter the letter A, B or C.");
				whoFirst();
			}
		} catch (InputMismatchException e) {
			sc.nextLine(); // clear the newline in the buffer
			System.out.println("Sorry! That's not a Letter. Try again.");
			whoFirst();
		}
	}

	public void nim() {
		System.out.println("\nJust to remind you, here are the piles again: ");
		nim.getStacksPrint();


		while(nim.getStacks().size() > 0) {
			System.out.println("\n\n");
			if (nim.getTurn() == 0) {
				System.out.println("It's your turn, which number would you like to change?");
				try{
					int a = sc.nextInt();
					int index = nim.checkStacks(a);
					if (index != -1){
						System.out.println("What would you like to change " + a + " to?");
						try{
							int b = sc.nextInt();
							if (b<a) {
								nim.setStacks(index, b);
								nim.setTurn(1);
							} else {
								System.out.println("Sorry, that number is bigger then " + a + ". Let's try that again.");
								nim();
							}
						} catch (InputMismatchException e) {
							sc.nextLine(); // clear the newline in the buffer
							System.out.println("Sorry! That's not a Number. Try again.");
							nim();
						}
					} else {
						System.out.println("Sorry, that number is not a pile. Let's try again.");
						nim();
					}
				} catch (InputMismatchException e) {
					sc.nextLine(); // clear the newline in the buffer
					System.out.println("Sorry! That's not a Number. Try again.");
					nim();
				}
			} else {
				nim.nimP();
				nim.setTurn(0);

			}
			System.out.println("The piles now look like this: ");
			nim.getStacksPrint();
		}
		if (nim.getTurn() == 1) {
			System.out.println("\n\nYou won... great job!");
			
		} else {
			System.out.println("\n\nI Won... Better luck next time!");
		}
		playAgain();
	}
	public void playAgain() {
		System.out.println("\n\nWould you like to play again? Yes or No?");
		try{
			String string = sc.next().toLowerCase();
			if (string.equals("yes")) {
				intro();
			} else if (string.equals("no")) {
				
			} else {
				System.out.println("Please enter yes or no.");
				playAgain();
			}
		} catch (InputMismatchException e) {
			sc.nextLine(); // clear the newline in the buffer
			System.out.println("Sorry! That's not a word. Try again.");
			playAgain();
		}
	}
		
	public static void main(String [] args) {
		new Nims();
	}
}