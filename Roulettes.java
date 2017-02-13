/*
George Wildridge
Roulette Adventure Game
10/12/15
Driver Class
The purpose of this game was to implement roulette and an adventure scenario around it. To do this I created a scenario that leads a user to a city, and allows them to go on multiple different paths. Two different paths
end up at a roullette game (one is legal, the other is illegal).  
*/

import java.util.Scanner;
import java.util.InputMismatchException;

public class Roulettes {
	public Scanner sc = new Scanner(System.in);
	public Roulette roulette = new Roulette();
	public String city; 
	public int bet;
	public int shortBet;
	// calls the intro method
	public Roulettes() {
		introduction();
	}	
	public void introduction() {
		System.out.println("Welcome to Nim. \n\n\n\n\n");
		intro();
	}
	// gives user the choice of where to travel, where they travel determines the game mode of roulette. Go Home is a dead end. 
	public void intro() {
		System.out.println("How many stacks would you like to play with? ");
		System.out.println("	(A) Random");
		System.out.println("	(B) I'll input it myself. ");
		try{
			String string = sc.next().toLowerCase();
			if (string.equals("a")) {
				roulette.stacks();
				travel();
			} else if (string.equals("b")) {
				System.out.println("\n Input a number less than or equal to 10");
				try{
					int a = sc.nextInt();
					if (a<=10){
						roulette.mstacks(a);
					} else {
						System.out.println("Sorry, that number is bigger then 10.");
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
				roulette.piles();
				travel();
			} else if (string.equals("b")) {
				System.out.println("\n Input a number less than or equal to 100");
				try{
					int a = sc.nextInt();
					if (a<=100){
						roulette.mpiles(a);
					} else {
						System.out.println("Sorry, that number is bigger then 100.");
						piles();
					}
				} catch (InputMismatchException e) {
					sc.nextLine(); // clear the newline in the buffer
					System.out.println("Sorry! That's not a Number. Try again.");
					piles();
				}
			} else {
				piles();
			}
		} catch (InputMismatchException e) {
			sc.nextLine(); // clear the newline in the buffer
			System.out.println("Sorry! That's not a Letter. Try again.");
			piles();
		}
	}

	public void nim() {
		
	}
		


	// dead end if user decide to go home
	public void home() {
		System.out.println("\n You make it home ok and spend the remainder of your vacation watching Netflix on your couch. Game Over.");
	}
	// A travel function to connect the intro to the base method. So the parts of the intro do not have to be repeated through out the loop.
	public void travel() {
		System.out.println("\n You arrive at "+ city + ", a cab takes you to your hotel.");
		base();
	}
	// The 'base' method, a starting point that leads to all the possible adventures within the game.
	public void base() {	
		System.out.println("\n\n Welcome to the hotel lobby. You can go to the [A]Casino, your [B]Room, or you can go out and [C]explore the city of " + city + ".");
		try{
			String string = sc.next().toLowerCase();
			if (string.equals("a")){
				casino();
			} else if (string.equals("b")) {
				room();				
			} else if (string.equals("c")) {
				walk();
			} else {
				base();
			}
		} catch (InputMismatchException e) {
			sc.nextLine(); // clear the newline in the buffer
			System.out.println("Sorry! That's not a Letter. Try again.");
			base();
		}
	}
	//intro to the casino and the amout that the user wants to play with in the casino. Options to play roullette, black jack or go back to the lobby.
	public void casino() {
		System.out.println("\n\n Welcome to George's Casino. How much money would you like to play with today?  It must be less then 10000000$."); 
		try{
			int a = sc.nextInt();
			if (a>0 && a< 10000000) {
				this.bet = a;
			
			} else {
				System.out.println("You are unable to finance that bet");
				casino();
			}
		} catch (InputMismatchException e) {
			sc.nextLine(); // clear the newline in the buffer
			System.out.println("Sorry! That's not an integer. Try again.");
			casino();
		}
		System.out.println("\n We are currently under renovation so some of our tables are not open; however, feel free to play [A]roulette or [B]black jack or [C]go back to the lobby.");
		try{
			String string = sc.next().toLowerCase();
			if (string.equals("a")) {
				rouletteIntro();
			} else if (string.equals("b")) {
				blackJack();
			} else if (string.equals("c")) {
				base();
			} else {
				casino();
			}
		} catch (InputMismatchException e) {
			sc.nextLine(); // clear the newline in the buffer
			System.out.println("Sorry! That's not a Letter. Try again.");
			casino();
		}
	}
	// base method for the actions the user can complete within their room... eat, sleep or go to the lobby.
	public void room() {
		System.out.println("\n\n In your room you can take a [A]nap, [B]grab a quick bite to eat out of your minifridge or [C]go back to the lobby.");
		try{
			String string = sc.next().toLowerCase();
			if (string.equals("a")) {
				nap();
			} else if (string.equals("b")) {
				eat();
			} else if (string.equals("c")) {
				base();
			} else {
				room();
			}
		} catch (InputMismatchException e) {
			sc.nextLine(); // clear the newline in the buffer
			System.out.println("Sorry! That's not a Letter. Try again.");
			room();
		}
	}
	//base method for the user's walk, give the option for the user to go right (concert), go left (illegal gambling ring) or go back to the hotel  
	public void walk(){
		System.out.println("\n\nYou make your way down the street, you can either go [A]right or [B]left at the corner. You can also [C]go back to the hotel.");
		try{
			String string = sc.next().toLowerCase();
			if (string.equals("a")) {
				goRight();
			} else if (string.equals("b")) {
				goLeft();
			} else if (string.equals("c")) {
				base();
			} 
			else {
				walk();
			}
		} catch (InputMismatchException e) {
			sc.nextLine(); // clear the newline in the buffer
			System.out.println("Sorry! That's not a Letter. Try again.");
			room();
		}

	}
	// intro to roulette so it does not have to be repeated after every spin. calls the main roullete method.
	public void rouletteIntro(){
		System.out.println("\nHi, are you ready to play roulette. If you need a refresher on the rules, heres a link to the wikipedia page: https://en.wikipedia.org/wiki/Roulette . You should also use this image https://upload.wikimedia.org/wikipedia/en/a/ac/French_Layout-Single_Zero_Wheel.jpg as a reference while you play. \nAlright, lets get started.");
		rouletteBet();
	}
	// if you encounter the illegal roulette ring on your walk the story line does not take you through the casino so while this method introduces the game a little, it also must accept the amount the user wants to play with at the table. 
	public void illegalRouletteIntro() {
		System.out.println("\nLets play some roulette, I hope you know the rules. How much money would you like to play with today? We only deal with small cash... so keep it less then 10000000$.");
		try{
			int a = sc.nextInt();
			if (a>0 && a< 10000000) {
				this.bet = a;
			
			} else {
				System.out.println("You are unable to finace that bet");
				casino();
			}
		} catch (InputMismatchException e) {
			sc.nextLine(); // clear the newline in the buffer
			System.out.println("Sorry! That's not an interger. Try again.");
			casino();
		}
		rouletteBet();
	}
	//main method to run the roullet game, ensures user has enough money to play, asks the amount the user wants to bet and finally calls the function allowing the user to choose bet and outputs the result.
	//It also outputs the modified amount of money you can play with at the table. Finlly it calls itself so the user can keep playing. 
	public void rouletteBet() { 
		if (this.bet < 1) {
			System.out.println("Sorry you are out of money. Oh no, a big, ugly dude kicked you out of the casino.");
			base();
		
		}
		System.out.println("\nHow much would you like to bet on this turn?");
		try{
			int a = sc.nextInt();
			if (a<=this.bet && a>0){
				roulette.bet(a);
				this.shortBet = this.bet -a;
			} else {
				System.out.println("Sorry, you don't have enough money to make that bet.");
				rouletteBet();
			}
		} catch (InputMismatchException e) {
			sc.nextLine(); // clear the newline in the buffer
			System.out.println("Sorry! That's not a Number. Try again.");
			rouletteBet();
		}
		rouletteChooseBet();
		int ballPocket = roulette.getPocket();
		if (ballPocket == -1) {
			System.out.println(" The ball landed on 00. ");
		} else {
			System.out.println("The ball landed on " + ballPocket + ".");
		}
		int currentBet = roulette.getBet();
		this.bet = this.shortBet + currentBet; 
		System.out.println("You came away with " + currentBet +"$ from that turn. Now you have " + this.bet + "$\n" );
		rouletteBet();
	}

	//allows user to choose the bet they would like to perform during their turn or go back to the hotel. See Roulette for more information on how each bet works. This method also acts
	//to only accept the correct inputs from the user for each individual bet that can be called. 
	public void rouletteChooseBet() {
		System.out.println("What type of bet would you like to make? ");
		System.out.println("	[A]Even");
		System.out.println("	[B]Odd");
		System.out.println("	[C]Red");
		System.out.println("	[D]Black");
		System.out.println("	[E]Dozen");
		System.out.println("	[F]Snake");
		System.out.println("	[G]Column");
		System.out.println("	[H]Manque");
		System.out.println("	[I]Passe");
		System.out.println("	[J]Top Line");
		System.out.println("	[K]Basket");
		System.out.println("	[L]Trio");
		System.out.println("	[M]Six Line");
		System.out.println("	[N]Corner");
		System.out.println("	[O]Street");
		System.out.println("	[P]Split");
		System.out.println("	[Q]Straight");
		System.out.println("	[R]Step Away from the Table");

		try{
			String string = sc.next().toLowerCase();
			if (string.equals("a")) { //call the even method from the roulette class
				roulette.even();
			} else if (string.equals("b")) { // call the odd method from the roulette class
				roulette.odd();
			} else if (string.equals("c")) { // call the red method from the roulette class
				roulette.red();
			} else if (string.equals("d")) { // call the black method from the roulette class
				roulette.black();
			} else if (string.equals("e")) { // call the dozen method from the roulette class. See if the user wants to bet on the first, second or third dozen.
				System.out.println("Would you like to bet on the numbers [A] 1 through 12, [B] 13 through 24 or [C] 25 through 36.");
				try{
					String e = sc.next().toLowerCase();
					if (e.equals("a")) {
						roulette.dozen("first");

					} else if (e.equals("b")) {
						roulette.dozen("second");
					} else if (e.equals("c")) {
						roulette.dozen("third");
					} else {
						System.out.println("In the future please enter a single, specified letter.");
						rouletteBet();

					}					
				} catch (InputMismatchException e) {
					sc.nextLine(); // clear the newline in the buffer
					System.out.println("Sorry! That's not a Letter. Try again.");
				}
			} else if (string.equals("f")) { // call the snake method from the roulette class
				roulette.snake();

			} else if (string.equals("g")) { // call the column method from the roulette class. See if the user wants to bet on the first, second or third column.
				System.out.println("Would you like to bet on the [A] first, [B] second or [C] third column.");
				try{
					String g = sc.next().toLowerCase();
					if (g.equals("a")) {
						roulette.column("first");
					} else if (g.equals("b")) {
						roulette.column("second");	
					} else if (g.equals("c")) {
						roulette.column("third");
					} else{
						System.out.println("In the future please enter a single, specified, capitalized letter.");  
						rouletteBet();
					}					
				} catch (InputMismatchException e) {
					sc.nextLine(); // clear the newline in the buffer
					System.out.println("Sorry! That's not a Letter. Try again.");
					rouletteBet();
				}
			} else if (string.equals("h")) { // call the manque method from the roulette class
				roulette.manque();
			} else if (string.equals("i")) { // call the passe method from the roulette class
				roulette.passe();
			} else if (string.equals("j")) { // call the toLine method from the roulette class. Make sure the user is in america (using the right roulette wheel).
				if (city.equals("Las Vegas") || city.equals("Atlantic City")){ 
				roulette.topLine();
				} else {
					System.out.println("Nice try, this isn't America you can not make that type of bet. Try again.");
					rouletteBet();
				}
			} else if (string.equals("k")) { // call either the basketAmerican or basketEuropean methods from the roulette class depending on which city the user chooses to go to. Allows the user to select which type of basket they would like to bet on if they are in america.
				if (city.equals("Las Vegas") || city.equals("Atlantic City")){
					System.out.println("Which type of basket would you like to select: [A]0,1,2 ; [B]2,0,00 or [C]00,2,3.");
					try{
						String k = sc.next().toLowerCase();
						if (k.equals("a")) {
							roulette.basketAmerican("first");
						} else if (k.equals("b")) {
							roulette.basketAmerican("second");
						} else if (k.equals("c")) {
							roulette.basketAmerican("third");
						} else{
							System.out.println("In the future please enter a single, specified, capitalized letter.");
							rouletteBet();
						}					
					} catch (InputMismatchException e) {
						sc.nextLine(); // clear the newline in the buffer
						System.out.println("Sorry! That's not a Letter. Try again.");
						rouletteBet();
					}
				} else if (city.equals("Macao")|| city.equals("Monte Carlo")) {
					roulette.basketEuropean();
				} else {
					rouletteBet();
				}
			} else if (string.equals("l")) { // call the trio method from the roulette class. Allows the user to selct which trio they would like to bet on.
				System.out.println("Which trio would you like to bet upon: [A]0,1,2, [B]0,2,3.");
				try{
					String l = sc.next().toLowerCase();
					if (l.equals("a")) {
						roulette.trio("first");
					} else if (l.equals("b")) {
						roulette.trio("second");

					} else {
						System.out.println("In the future please enter a single, specified, capitalized letter.");
						rouletteBet();
					}					
				} catch (InputMismatchException e) {
					sc.nextLine(); // clear the newline in the buffer
					System.out.println("Sorry! That's not a Letter. Try again.");
					rouletteBet();
				}
			} else if (string.equals("m")) { // call the sixLine method from the roulette class. Take the inputs for the six numbers of the two side by side rows. Make sure all the numbers are entered correctly and actually pertain to the bet.
				System.out.println("A six line requires you you to pick two side by side rows. Please enter the 3 numbers of the first row you select one at time and the 3 numbers of the next row you selct one at a time in order from left to right.");
				try{
					int one = sc.nextInt();
					int two = sc.nextInt();
					int three = sc.nextInt();
					int four = sc.nextInt();
					int five = sc.nextInt();
					int six = sc.nextInt();
					if (one%3 == 1) {
						if (one + 1 == two && one + 2 == three && one + 3 == four && one + 5 == six && one > 0 && one < 32) {
							roulette.sixLine(one, two, three, four, five, six);
						} 
					} else {
						System.out.println("In the future please enter a single, specified, capitalized letter.");
						rouletteBet();
					}
				} catch (InputMismatchException e) {
					sc.nextLine(); // clear the newline in the buffer
					System.out.println("Sorry! That's not a number. Try again.");
					rouletteBet();
				}
			} else if (string.equals("n")) { // call the corner method from the roulette class. Make sure the values entered actually represent a square on the roullette board.
				System.out.println("A corner requires you to pick four abutting squares. Please enter the values of the square from  left to right, one at a time.");
				try{
					int one = sc.nextInt();
					int two = sc.nextInt();
					int three = sc.nextInt();
					int four = sc.nextInt();
					if (one%3 == 1 || one%3 == 2) {	
						if (one + 1 == two && one + 3 == three && one + 4 == four && one > 0 && one < 33) {
							roulette.corner(one,two,three,four);
						} else {
							System.out.println("In the future please enter the numbers of four abutting squares.");
							rouletteBet();
						}
					} else {
						System.out.println("In the future please enter the numbers of four abutting squares. Be sure to enter them in order from left to right.");
						rouletteBet();
					}
				} catch (InputMismatchException e) {
					sc.nextLine(); // clear the newline in the buffer
					System.out.println("Sorry! That's not a number. Try again.");
					rouletteBet();
				}
			} else if (string.equals("o")) { // call the street method from the roulette class. Make sure the numbers are a row on the roullette board. 
				System.out.println("A street is a row of three numbers. Please enter them in order from left to right one at a time:");
				try{
					int one = sc.nextInt();
					int two = sc.nextInt();
					int three = sc.nextInt();
					if (one%3 == 1 && one < 35 && one > 0) {	
						if (one + 1 == two && one + 2 == three) {
							roulette.street(one, two, three);
						} else {
							System.out.println("oops. Make sure you are entering the numbers of one row from left to right.");
							rouletteBet();
						}
					} else {
						System.out.println("oops. Make sure you are entering the numbers of one row from left to right.");
						rouletteBet();
					}
				} catch (InputMismatchException e) {
					sc.nextLine(); // clear the newline in the buffer
					System.out.println("Sorry! That's not a number. Try again.");
					rouletteBet();
				}
			} else if (string.equals("p")) { // call the split method from the roulette class. MAke sure the two numbers are adjoined horizantilly or vertically.
				System.out.println("Choose two numbers adjoined horizantally or vertically to bet on. Enter the number from left to right or from top to bottom.");
				try{
					int one = sc.nextInt();
					int two = sc.nextInt();
					if (one < 37 && two < 37 && one > 0 && two > 0 && one != two) {
						if (one+3 ==two ||one +1 ==two){
							roulette.split(one, two);
						} else {
							System.out.println("oops, make sure you are betting on numbers adjoined horizantally or vertically!!");
							rouletteBet();
						}
					} else{
						System.out.println("oops.Please make sure the two numbers you are betting on are on the wheel.");
						rouletteBet();
					}
				} catch (InputMismatchException e) {
					sc.nextLine(); // clear the newline in the buffer
					System.out.println("Sorry! That's not a number. Try again.");
					rouletteBet();
				}
			} else if (string.equals("q")) { // call the straight method from the roulette class. make sure a number on the wheel is entered.
				System.out.println("Choose a number to bet on:");
				try{
					int one = sc.nextInt();
					if (one < 37 && one > 0) {
						roulette.straight(one);
					} else {
						System.out.println("oops.Please make sure the number you are betting on is on the wheel.");
						rouletteBet();
					}
				} catch (InputMismatchException e) {
					sc.nextLine(); // clear the newline in the buffer
					System.out.println("Sorry! That's not a number. Try again.");
					rouletteBet();
				}
			} else if (string.equals("r")) { // bring the user back to the lobby
					base();
			} else {
				System.out.println("Lets start this turn over. \n");
				rouletteBet();
			} 
		} catch (InputMismatchException e) {
					sc.nextLine(); // clear the newline in the buffer
					System.out.println("Sorry! That's not one of the specified letters. Make sure the letter you typed was capitalized. Try again.");
					rouletteBet();  
		}
	}
	public void blackJack() { // simple story line that leads back to roulette while in the casino.
		System.out.println("\nOh, it looks like all the tables are full. I'm sorry, we will direct you to a roulette table.");
		rouletteIntro();

	}
	public void eat() { // allows you to eat while in your room and then takes you back to the room method.
		System.out.println("\nYour full. But a little sleepy.");
		room();

	}
	public void nap() { // allows you to nap while in your room and then takes you back to the room method.
		System.out.println("\nAfter that nap you feel replenished.");
		room();

	}
	public void goRight() { // while on your walk, if you choose to go right a dj is playing and you have the choice to go watch it or resume your walk
		System.out.println("\nWow, a huge dj is playing in the hotel next to yours. [A]Would you like to check it out? [B] or would you prefer to turn back.");
		try{
			String string = sc.next().toLowerCase();
			if (string.equals("a")) {
				concert();
			} else if (string.equals("b")) {
				walk();
			} else {
				goRight();
			}
		} catch (InputMismatchException e) {
			sc.nextLine(); // clear the newline in the buffer
			System.out.println("Sorry! That's not a Letter. Try again.");
			goRight();
		}

	}
	// if you go left on your walk you end up in an illegal street gambling ring where they are playing roullette. You can continue your walk or play roullette.
	public void goLeft() { 
		System.out.println("\n\nYou get roped into an illegal back street gambling ring. They take you into the back of a casino where they are playing roulette. [A]Make a dash for the door or [B]play some Roulette.");
		try{
			String string = sc.next().toLowerCase();
			if (string.equals("a")) {
				System.out.println("\nGood Choice, you make it out ok and are free to resume your walk.");
				walk();
			} else if (string.equals("b")) {
				System.out.println("\nAh some good old illegal roulette. Watch out, if you try to leave the table you might not remember what happens next.");
				illegalRouletteIntro();
			} else {
				goLeft();
			}
		} catch (InputMismatchException e) {
			sc.nextLine(); // clear the newline in the buffer
			System.out.println("Sorry! That's not a Letter. Try again.");
			goLeft();
		}
	
	}
	//if you choose to watch the concert from go right you will be looped back to your walk.
	public void concert() {
		System.out.println("\nIt looks like the music is just coming to an end. After enjoying the last song you go back out to the street. ");
		walk();
	}
	public static void main(String [] args) {
		new Roulettes();
	}
}