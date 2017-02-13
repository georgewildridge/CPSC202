/*
George Wildridge
Roulette Adventure Game
10/12/15
Roulette class
The purpose of this class was to hold all the possible betting options of roulette. It also allows another class to specify which roullette table they want to use. 
*/
import java.util.Arrays;
import java.util.Random;
import java.io.IOException;
import java.util.ArrayList;

public class Roulette {
	public int numStacks;
	public int numPiles;
	public List<int> stacks = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0,0,0));



	public void stacks() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10) + 1;		//http://www.javapractices.com/topic/TopicAction.do?Id=62
		this.numStacks = randomInt; 	
	}
	public void mstacks(int man) {
		this.numStacks = man;
	}
	public int randomPile() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100) + 1;		//http://www.javapractices.com/topic/TopicAction.do?Id=62
		return randomInt; 	
	}
	public void piles() {
		for (int i = 0; i<numStacks; i++) {
			int rand = randomPile();
			stacks.set(i,rand);
		} for (int i = 0; i<(10-numStacks); i++) {
			stacks.remove(0)
		}
	}
	public void mpiles(int one, int two, int three, int four, int five, int six, int seven, int eight, int nine, int ten) {
		stacks.set(0, one);
		stacks.set(1, two);
		stacks.set(2, three);
		stacks.set(3, four);
		stacks.set(4, five);
		stacks.set(5, six);
		stacks.set(6, seven);
		stacks.set(7, eight);
		stacks.set(8, nine);
		stacks.set(9, ten);
	}

	public int nimAddition(int one, int two, int three, int four, int five, int six, int seven, int eight, int nine) {
		int num = one ^ two ^ three ^ four ^ five ^ six ^ seven ^ eight ^ nine;
		return num;
	}

	public void nim() {
		if (numStacks < 3) {
			if ()
		} else {
			// trying to use nimAddition on all but one of the stacks. Would I have to define a variable for each stack and then pass that variable?

			for (int i = 0; i < numStacks - 1;i++) {
				
			}
			int nimAdd = nimAddition()
			if (nimAdd > stacks.get(i)) {
				
			}
		}

	}
}
