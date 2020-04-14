package simstation;

import java.util.Random;

/*
 * Edit history:
 *   Quang-Duy, 03/30: created
 *   Quang-Duy, 04/10: added getRandomDirection() method
*/

public enum Heading {
	NORTH,
	SOUTH,
	EAST,
	WEST;
	
	private static final Heading[] VALUES = values();
	private static final int SIZE = VALUES.length;
	private static final Random RANDOM = new Random();
	
	public static Heading getRandomDirection() {
		return VALUES[RANDOM.nextInt(SIZE)];
	}
}
