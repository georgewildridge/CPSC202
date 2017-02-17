/*
George Wildridge
Nim
2/17/17
Nim Class
The purpose of this class was to hold all the possible methods of nim. 
*/
import java.util.Arrays;
import java.util.Random;
import java.io.IOException;
import java.util.ArrayList;

public class Nim {
	public int numStacks;
	public int numPiles;
	public int turn; // 0 is human, 1 is computer 
	public static ArrayList<Integer> stacks = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0,0,0));



	public void stacks() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(7) + 2;		
		this.numStacks = randomInt; 	
	}
	public void mstacks(int man) {
		this.numStacks = man;
	}
	public void refreshStacks() {
		stacks.add(0);
		stacks.add(0);
		stacks.add(0);
		stacks.add(0);
		stacks.add(0);
		stacks.add(0);
		stacks.add(0);
		stacks.add(0);
		stacks.add(0);
		stacks.add(0);


	}
	public void setStacks(int index, int a) {
		stacks.set(index, a);
	}
	public int randomPile() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100) + 1;		
		return randomInt; 	
	}
	public void piles() {
		for (int i = 0; i<numStacks; i++) {
			int rand = randomPile();
			stacks.set(i,rand);
		} 
		while(stacks.indexOf(0) != -1) {
			stacks.remove(stacks.indexOf(0));
		}
	}
	public void mpiles(int index, int num) {
		stacks.set(index, num);
	}
	public void tidyStacks() {
		while(stacks.indexOf(0) != -1) {
			stacks.remove(stacks.indexOf(0));
		}
	}
	public static ArrayList<Integer> getStacks() {
		return stacks;
	}

	public void getStacksPrint() {
		System.out.println(this.stacks.toString());
	}

	public int checkStacks(int i){
		return this.stacks.indexOf(i);
	}

	public int getNumPiles(){
		return this.numStacks;
	}

	public void setTurn(int t){
		this.turn = t;
	}
	public void randomTurn(){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(2);		
		if (randomInt == 0) {
			this.turn = 0;
		} else {
			this.turn = 1;
		}
			
	}
	public int getTurn(){
		return this.turn;
	}
	public int nimAddition(ArrayList<Integer> array) {
		int exor = 0;
		for (int i = 0; i < array.size(); i++) {
			exor = exor ^ array.get(i);
		}
		return exor;
	}

	public void nimP() {
		int nimA = nimAddition(stacks);
		for (int i = 0; i < stacks.size(); i++) {
			int fetch = stacks.get(i);
			int sum = fetch ^ nimA;
			if (sum < fetch) {
				stacks.set(i, fetch ^ nimA);
				System.out.println("I'm going to set " + fetch + " equal to " + sum + ".");
				int zero = 0;
				while(stacks.indexOf(zero) != -1) {
					stacks.remove(stacks.indexOf(zero));
				}
				break;
			} else if (i == stacks.size()-1) {
				Random randomGenerator = new Random();
				int randomStack = randomGenerator.nextInt(stacks.size());
				int randomPile = randomGenerator.nextInt(stacks.get(randomStack));
				System.out.println("I'm going to set " + stacks.get(randomStack) + " equal to " + randomPile + ".");
				stacks.set(randomStack, randomPile);
				if (stacks.size()>1) {
					while(stacks.indexOf(0) != -1) {
						stacks.remove(stacks.indexOf(0));
					}
				}
			}
		}
	}
}
//