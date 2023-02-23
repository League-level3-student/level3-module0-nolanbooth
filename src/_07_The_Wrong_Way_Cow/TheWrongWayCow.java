/*
 * https://www.codewars.com/kata/the-wrong-way-cow
 * 
 * Task
 * Given a field of cows find which one is the Wrong-Way Cow and return her
 * position.
 * 
 * Notes:
 * 
 * There are always at least 3 cows in a herd
 * There is only 1 Wrong-Way Cow!
 * Fields are rectangular
 * The cow position is zero-based [col,row] of her head (i.e. the letter c)
 * Examples
 * Ex1
 * 
 * cow.cow.cow.cow.cow
 * cow.cow.cow.cow.cow
 * cow.woc.cow.cow.cow
 * cow.cow.cow.cow.cow
 * Answer: [6,2]
 * 
 * Ex2
 * 
 * c..........
 * o...c......
 * w...o.c....
 * ....w.o....
 * ......w.cow
 * Answer: [8,4]
 * 
 * Notes
 * The test cases will NOT test any situations where there are "imaginary" cows,
 * so your solution does not need to worry about such things!
 * 
 * To explain - Yes, I recognize that there are certain configurations where an
 * "imaginary" cow may appear that in fact is just made of three other "real" cows.
 * 
 * In the following field you can see there are 4 real cows (3 are facing south and
 * 1 is facing north). There are also 2 imaginary cows (facing east and west).
 * 
 * ...w...
 * ..cow..
 * .woco..
 * .ow.c..
 * .c.....
*/

package _07_The_Wrong_Way_Cow;

public class TheWrongWayCow {
	static char letterC = 'c';
	static char letterO = 'o';
	static char letterW = 'w';
	static int northCount = 0;
	static int southCount = 0;
	static int westCount = 0;
	static int eastCount = 0;
	static int northX;
	static int northY;
	static int westX;
	static int westY;
	static int eastX;
	static int eastY;
	static int southX;
	static int southY;

	public static int[] findWrongWayCow(final char[][] field) {
		int[] coordinate = new int[2];
		// System.out.println(field);
		northCount = 0;
		eastCount = 0;
		southCount = 0;
		westCount = 0;
		// Fill in the code to return the [col, row] coordinate position of the
		// head (letter 'c') of the wrong way cow!

		// counts

		// X and Y of the cows
		

		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j] == letterC) {
					
					checkCowDirection(field, i, j);
					
				}
				
			}
			
		}
		System.out.println("counts");
		System.out.println(northCount);
		System.out.println(eastCount);
		System.out.println(southCount);
		System.out.println(westCount);
		System.out.println();
		System.out.println("Coordinates: ");
		System.out.println(northX + "   " + northY);
		System.out.println(eastX + "   " + eastY);
		System.out.println(southX + "   " + southY);
		System.out.println(westX + "   " + westY);
		
		
		if(northCount == 1) {
			coordinate[1] = northX;
			coordinate[0] = northY;
		}else if(southCount == 1) {
			coordinate[1] = southX;
			coordinate[0] = southY;
		}else if(eastCount == 1) {
			coordinate[1] = eastX;
			coordinate[0] = eastY;
		}else if(westCount == 1) {
			coordinate[1] = westX;
			coordinate[0] = westY;
		}else {
			System.out.println("none had value of 1");
		}
		System.out.println("returned: ");
		System.out.println(coordinate[0] + "  " + coordinate[1]);
		

		return coordinate;
	}

	// x is row
	// y is column
	/*
	 * North = 0 East = 1 South = 2 West = 3
	 * 
	 */
	public static int checkCowDirection(char[][] field, int x, int y) {
		if (x + 2 < field.length) {
			if (field[x + 1][y] == letterO && field[x + 2][y] == letterW) {
				eastCount++;
				eastX = x;
				eastY = y;
				return 1;
			}
		}
		if (x - 2 >= 0) {
			if (field[x - 1][y] == letterO && field[x - 2][y] == letterW) {
				westCount++;
				westX = x;
				westY = y;
				return 3;
			}
		}
		if (y + 2 < field[0].length) {
			if (field[x][y + 1] == letterO && field[x][y + 2] == letterW) {
				southCount++;
				southX = x;
				southY = y;
				return 2;
			}
		}
		if (y - 2 >= field[0].length) {
			if (field[x][y - 1] == letterO && field[x][y - 2] == letterW) {
				northCount++;
				northX = x;
				northY = y;
				return 0;
			}
		}
		return (Integer)null;
	}
}
