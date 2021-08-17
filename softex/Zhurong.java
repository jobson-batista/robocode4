package softex;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Zhurong - a robot by (your name here)
 */
public class Zhurong extends AdvancedRobot
{
	/**
	 * run: Zhurong's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:
		
		setBodyColor(Color.orange); 		
		setGunColor(Color.blue);		
		setRadarColor(Color.yellow);		
		setBulletColor(Color.red);
		setScanColor(Color.yellow);		
	
		// Robot main loop
		while(true) {
			
			double frent = (double) (40+Math.random()*200);
			double tras = (double) (40+Math.random()*200);
			double dir = (double) (20+Math.random()*190);
			double esq = (double) (20+Math.random()*180);
			
			ahead(frent);
			turnGunLeft(360);
			turnRight(dir);
			turnGunLeft(360);
			ahead(frent);
			turnGunLeft(360);
			turnLeft(esq);
			turnGunLeft(360);
			ahead(frent);		
			turnGunRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		//System.out.println("NOME DO ROBO --> "+e.getName());
		if(!e.getName().contains("NeoWitcher")){
			fire(2);
			System.out.println("Entrou!");
		}
		
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		ahead(100);
		back(200);
	}
	
	public void onHitRobot(HitRobotEvent e) {
		if(e.getName().contains("NeoWitcher")){
			back(100);
		} else {
			fire(Rules.MAX_BULLET_POWER);
		}
	}
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		
		double x = getX();
		double y = getY();
		double m = getBattleFieldWidth();
		double n = getBattleFieldHeight();
		if((x==m)||(x==0)) {
			ahead(100);
		}
		if((y==n)||(y==0)) {
			back(40);
		}

	}	
}
