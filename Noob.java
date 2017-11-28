package Noob;
import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Noob - a robot by (your name here)
 */
public class Noob extends Robot
{
    /**
     * run: Noob's default behavior
     */
    public void run() {
        
        while(true) {
            // Replace the next 4 lines with any behavior you would like
            if(getX() > 40 && getX() < (getBattleFieldWidth() - 40) &&
               getY() >40 && getY() <(getBattleFieldHeight()- 40)){
                ahead(60);
                turnRight(40);
                turnRadarLeft(30);
                turnGunRight(20);
                ahead(30);
                turnGunLeft(20);
                turnRadarRight(30);
            }
            else {
                //bottom half
                if(getX() < 40 && (245 < getHeading())&& ( getHeading()< 295)){
                    back(100);
                    turnRight(140);
                    ahead(60);
                }
                if(getX() < 40 && (180 < getHeading())&& ( getHeading() <=245 )){
                    turnRight(100);
                    ahead(120);
                }
                if(getX()< 40 && ( 295 <= getHeading())&& (getHeading() <=360)){
                    turnLeft(100);
                    ahead(120);
                }
                
                // At top half
                if(getY() > (getBattleFieldWidth()- 40) && ( 75 <= getHeading())&& (getHeading() <= 125)){
                    back(100);
                    turnRight(140);
                    ahead(60);
                }
                if(getY() > (getBattleFieldWidth()- 40) && (0 <= getHeading())&&(getHeading() < 75)){
                    turnRight(100);
                    ahead(120);
                }
                if(getY() > (getBattleFieldWidth()- 40) && ( 125 < getHeading())&& (getHeading() < 180)){
                    turnLeft(100);
                    ahead(120);
                }
                
                //bottom half
                if(getY() < 40 && (getHeading() > 235) &&(getHeading() < 290)){
                    back(100);
                    turnRight(140);
                    ahead(60);
                }
                if(getY() < 40 && (getHeading() > 180) && (getHeading() <=235)){
                    turnRight(100);
                    ahead(120);
                }
                if(getY() < 40 &&(getHeading() > 235 ) && ( getHeading() <= 360)){
                    turnLeft(100);
                    ahead(120);
                }
                
                
                
                if(getX() > (getBattleFieldWidth() - 40) && ( 75 < getHeading()) && ( 125 > getHeading())){
                    turnRight(100);
                    ahead(120);
                }
                if(getX() > (getBattleFieldWidth() - 40) && ( 125 <= getHeading()) && ( 235 > getHeading())){
                    back(100);
                    turnRight(140);
                    ahead(60);
                }
                if(getX() > (getBattleFieldWidth() - 40) && ( 235 <= getHeading()) && ( 270 > getHeading())){
                    turnLeft(100);
                    ahead(120);
                }
                
                
                //}
            }
        }
    }
    
    public  void run(int count){
        
        int Counter = 0;
        while(Counter < count) {
            
            // Replace the next 4 lines with any behavior you would like
            if(getX() > 40 && getX() < (getBattleFieldWidth() - 40) &&
               getY() >40 && getY() <(getBattleFieldHeight()- 40)){
                ahead(30);
                turnRight(40);
                turnRadarLeft(30);
                turnGunRight(20);
                back(10);
                ahead(30);
                turnGunLeft(20);
                turnLeft(30);
                turnRadarRight(30);
            }
            else{
                //	while(getX() < 40 && getX() >(getBattleFieldWidth() - 40) &&
                //		getY() <40 && getY() > (getBattleFieldHeight()- 40)){
                turnRadarLeft(10);
                if(getX() < 40){
                    back(10);
                    turnRight(100);
                    ahead(30);
                }
                turnRadarLeft(30);
                if(getY() > (getBattleFieldWidth()- 40)){
                    back(10);
                    turnRight(100);
                    ahead(30);
                }
                turnRadarRight(30);
                if(getY() < 40){
                    back(10);
                    turnRight(100);
                    ahead(30);
                }
                if(getX() > (getBattleFieldWidth() - 40)){
                    back(10);
                    turnRight(100);
                    ahead(30);
                }
                //}
            }
            ++Counter;
        }
    }
    /**
     * onScannedRobot: What to do when you see another robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        double gunTurnAmt = 10;
        double where_is_bot = getRadarHeading();
        int count = 0;
        String trackName;
        fire(5);
        
        run(2);
        fire(2);
        
        turnRadarLeft(30);
        turnRadarRight(30);
        if (e.getDistance() < 50 && getEnergy() > 50) {
            fire(3); }
        else {
            fire(1); }
        scan();
        while (true) {
            turnGunRight(gunTurnAmt);
            count++;
            if (count > 2) {
                gunTurnAmt = -10; }
            if (count > 5) {
                gunTurnAmt = 10; }
            if (count > 11) {
                trackName = null; }
        }
    }
    
    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    public void onHitByBullet(HitByBulletEvent e) {
        // Replace the next line with any behavior you would like
        back(10);
    }
    
    /**
     * onHitWall: What to do when you hit a wall
     */
    public void onHitWall(HitWallEvent e) {
        // Replace the next line with any behavior you would like
        back(40);
        turnRight(100);
        ahead(30);
    }
}
