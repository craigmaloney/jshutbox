public class TurnCounter {
	int turn;

	TurnCounter () {
		turn = 0;
	}

	void reset () {
		turn = 0;
	}

	void increment () {
		turn++;
	}

	int getValue () {
		return turn;
	}

	void display () {
		System.out.print ("Turn: ");
		System.out.println (turn);
	}
}

