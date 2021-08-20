package bot;
import robocode.*;
import java.awt.Color;
//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * NeoWitcher - a robot by (your name here)
 */
public class NeoWitcher extends Robot
{
	/**
	 * run: NeoWitcher's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		setColors(Color.DARK_GRAY, Color.RED, Color.GREEN, Color.GREEN, Color.YELLOW);
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			turnGunRight(360);
			ahead(getPositionRandom(50,150));
			turnGunRight(360);
			back(getPositionRandom(50,150));
			turnGunRight(360);
			turnRight(getPositionRandom(45,90));
			turnGunRight(360);
			ahead(getPositionRandom(50,150));
			turnGunRight(360);
			turnLeft(getPositionRandom(45,90));
		}
	}
	
	public int getPositionRandom(int max, int min) {
		return (int)(Math.random() * (max - min + 1) + min);
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		double ang = e.getBearing();
		double dist = e.getDistance();
		
		if ( dist < 200 && !e.getName().contains("Zhurong")){
			fire(Rules.MAX_BULLET_POWER);
		} else if(!e.getName().contains("Zhurong")) {
			fire(Rules.MAX_BULLET_POWER/2);
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		ahead(100);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		turnLeft(100);
	}
	
	public void onWin(WinEvent e) {
		turnRight(36000);
	}
	
	public void onHitRobot(HitRobotEvent bot) {
		if(bot.getName().contains("Zhurong")){
			ahead(100);
		} else {
			fire(Rules.MAX_BULLET_POWER);
		}
	} 
}
