// Tiles
// Shut the Box 1.0
// Written by Craig Maloney

public class Tiles {
	private boolean[] tiles;
	private static final int MAXTILES = 9;

	Tiles () {
		tiles = new boolean[MAXTILES+1];  // Take into account the off-by-one in Arrays
		for (int i = 0; i<tiles.length; i++) {
			tiles[i]=true;
		}
	}

	void display () {
		for (int i = 1; i < tiles.length; i++) {
			if (tiles[i]) {
				System.out.print (i + " ");
			} else {
				System.out.print ("_ ");
			}
		}
		System.out.println();
	}

	void reset () {
		for (int i = 1; i<tiles.length; i++) {
			tiles[i] = true;
		}
	}

	boolean flip (int flipTile) {
		if ( flipTile < 1 || flipTile >= tiles.length ) {
			return false;
		}

		if ( tiles[flipTile] ) { 
			tiles[flipTile] = false;
			return true;
		} else {
			return false;
		}
	}

	boolean show (int showTile) {
		if ( showTile < 1 || showTile >= tiles.length ) {
			return false;
		}

		return tiles[showTile];
	}

	boolean win () {
		boolean finished = true;
		for (int x=1;x<tiles.length;x++) {
			finished = finished && !tiles[x];
		}
		return finished;
	}

	boolean checkEnd (int sum) {
		int origSum = sum;
		int i;
		int tempValue;
		boolean result;
		if (sum == 0) { 
			return true;
		}
		if (sum >= MAXTILES)  {
			sum = MAXTILES;

		}
		for (i=sum; i>=1; i--) {
			if (tiles[i]) {
				tempValue = (origSum - i);
                                if (tempValue >= i) {
                                    return false;
                                }

				result = checkEnd(tempValue);
				if (result) {
					return true;
				}
			}
		}
		return false;
	}
		
}
