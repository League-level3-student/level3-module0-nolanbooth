package _00_Intro_To_Arrays;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class _02_RobotRace {
	// 1. make a main method
	public static void main(String[] args) {
		// Robot rob = new Robot();
		Random ran = new Random();
		// 2. create an array of 5 robots.
		Robot[] robots = { null, null, null, null, null };
		// 3. use a for loop to initialize the robots.
		for (int i = 0; i < robots.length; i++) {
			robots[i] = new Robot();
			robots[i].miniaturize();
		}
		/*
		 * robots[0].setX(100); robots[0].setY(500); robots[1].setX(200);
		 * robots[1].setY(500); robots[2].setX(300); robots[2].setY(500);
		 * robots[3].setX(400); robots[3].setY(500); robots[4].setX(500);
		 * robots[4].setY(500);
		 * 
		 * // 4. make each robot start at the bottom of the screen, side by side, facing
		 * up
		 * 
		 * // 5. use another for loop to iterate through the array and make each robot
		 * move // a random amount less than 50.
		 * 
		 * // 6. use a while loop to repeat step 5 until a robot has reached the top of
		 * the // screen. boolean topReached = false;
		 * 
		 * int winner = 0; while (topReached == false) { bill: for (int i = 0; i <
		 * robots.length; i++) { robots[i].move(ran.nextInt(50)); if (robots[i].getY()
		 * <= 50) { topReached = true; winner = i; break bill; } } }
		 * 
		 * 
		 * // System.out.println("Robot #" + winner + " is the winner!");
		 * 
		 * //robots[winner].turn(360);
		 */

		// 8. try different races with different amounts of robots.
		// tried with 3 robots, it worked
		// 9. make the robots race around a circular track.
		for (int i = 0; i < robots.length; i++) {
			robots[i].moveTo(450, 500);

		}
		for (int i = 0; i < robots.length; i++) {
			robots[i].turn(90);

		}
		for (int i = 0; i < 180; i++) {
			for (int j = 0; j < robots.length; j++) {
				circle(robots[j], -2);
			}
		}

	}

	public static void circle(Robot r, int degrees) {
		r.turn(degrees);
		r.move(degrees);
	}
}
