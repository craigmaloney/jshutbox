// Shut the Box Java
// Version 1.0
// Written by Craig Maloney
import java.io.*;
import java.util.*;
public class ShutBox {

	static boolean validate(String inputArray[], Tiles tiles) {
		Hashtable numbers = new Hashtable();
		boolean validated = true;
		numbers.clear();
		try {
			// Check to see if the tiles are available
			for (int x=0;x<inputArray.length;x++) {

				// Check for duplicates
				if (numbers.containsKey(inputArray[x])) {
					System.out.println ("Duplicate entry");
					validated = false;
				} else {
					// Add the number to the duplicates hash
					numbers.put(inputArray[x], new Integer(1));

					// Check to see if the tile is still available
					validated = validated && tiles.show(Integer.parseInt(inputArray[x]));
				}
			}
			return validated;
		} 
		catch (Exception e) {
			System.out.println ("Input Invalid, Try again");
			return false;
		}
	}

	static boolean checkSumResults (String inputArray[],int testsum) {
		int sum = 0;

		try {
			for (int x=0;x<inputArray.length;x++) {
				sum += Integer.parseInt(inputArray[x]);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		if (sum == testsum) {
			return true;
		} 
		// Gets here if sum != testsum
		System.out.println ("Numbers don't add up. Try again!");
		return false;

	}


	public static void main(String[] args) { 

		ShutBoxDice dice = new ShutBoxDice();
		Tiles box = new Tiles();
		TurnCounter turn = new TurnCounter();

		String          s    = null;
		BufferedReader  buff = null;
		String[] 	result = null;
		boolean		gettingInput = true;
		boolean		newGame = false;

		while (true) {
			System.out.println ("Starting new game");
			box.reset();
			turn.reset();
			newGame = false;

			while (!box.win() && !newGame) {
				dice.roll();
				turn.increment();
				gettingInput = true;

				while (gettingInput) {
					box.display();
					turn.display();
					dice.display();
                                        if (!box.checkEnd(dice.getValue())) { 
						System.out.println("No more possibilities. Type 'new' to restart.");
					}
					try {
						buff = new BufferedReader(new InputStreamReader( System.in ));						System.out.print("\n=> ");
						System.out.flush();
                                                s = buff.readLine();
						result = s.split("\\W");
					}
					catch (Exception e) {
						System.out.println(e);
					}
					finally {
						for (int x=0;x<result.length;x++) {
							if (result[x].equalsIgnoreCase("q") || 
									result[x].equalsIgnoreCase("quit")) {
								System.exit(0);
							}
							if (result[x].equalsIgnoreCase("n") ||
									result[x].equalsIgnoreCase("new")) {
								newGame = true;
								gettingInput = false;
							}
						}
					}

					try {
						if (gettingInput &&
								validate(result,box) && 
								checkSumResults(result,dice.getValue())) { 
							for (int x=0;x<result.length;x++) {
								box.flip(Integer.parseInt(result[x]));
							}
							gettingInput = false; 
						} 
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			}
			if (box.win()) {
				System.out.println ("Congratulations! You won!!!");
			}

		}
	}
}
