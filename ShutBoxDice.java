// ShutBoxDice
// Shut the Box 1.0
// Container for the Dice Class
// Written by Craig Maloney

public class ShutBoxDice {
	private Dice die1 = new Dice();
	private Dice die2 = new Dice();
	private static int value;

	void roll() {
		die1.roll(6);
		die2.roll(6);
		value = die1.getValue() + die2.getValue();
	}

	void display() {
		System.out.print("Die 1: " + die1.getValue());
		System.out.println("  Die 2: " + die2.getValue());
		System.out.println("Total: " + value);
	}

	static int getValue() {
		return value;
	}
}
