// Dice.java
// Written by Craig Maloney

import java.security.SecureRandom;

public class Dice {

	int value;
	SecureRandom rand;

	Dice () {
		rand = new SecureRandom();
		value = 0;
	}

	void roll (int size) {
		value=rand.nextInt(size)+1;
	}

	int getValue () {
		return value;
	}
}
