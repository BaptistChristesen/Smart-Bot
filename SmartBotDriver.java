import kareltherobot.*;
import java.awt.Color;

public class SmartBotDriver
{
    public static void main(String[] args)
    {
        World.reset();
        World.setVisible(true);     // make the world visible
        World.setTrace(false);      // turn off the trace feature
        World.setDelay(25);         // set to medium speed
        try {Thread.sleep(3000); } catch (Exception e){};

        // first robot        
        World.placeBeepers(4,1,1);  // at 4th street & 1st avenue put 1 beeper        
        SmartBot alex = new SmartBot(1, 1, Directions.North, 0, Color.RED);
        while(!alex.nextToABeeper())
            alex.move();
        alex.pickBeeper();
        alex.move();                // move off the beeper location
        alex.turnOff();
        
        // second robot
        World.placeBeepers(8,2,5);  // at 8th street & 2nd avenue put 5 beepers                
        SmartBot nick = new SmartBot(1, 2, Directions.North, 0, Color.BLUE);
        nick.move(7);
        nick.pickAll();
        nick.move();
        nick.turnOff();

        // third robot
        World.placeBeepers(7,3,1);  // at 7th street & 3rd avenue put 1 beeper        
        SmartBot wyatt = new SmartBot(1, 3, Directions.North, 0, Color.GREEN);
        wyatt.findBeeper();
        wyatt.turnOff();

        // fourth robot
        World.placeBeepers(5,4,7);  // at 5th street & 4th avenue put 7 beepers
        SmartBot tara = new SmartBot(4, 4, Directions.North, 0, Color.BLACK);
        tara.move();
        tara.setVisible(false);     // make the robot invisible so we can see the beepers
        System.out.println("The pile is: " + tara.countPile() + " beepers");
        tara.setVisible(true);      // make the robot visible again
        tara.move();
        tara.turnOff();
        
    }
}