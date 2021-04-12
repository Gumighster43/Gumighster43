
import java.util.Random;
/**
 *  Lab: TalkingRobot Lab <br>
 *
 *  The TalkingRobot class provides a robot that can tell the time and a random statement based off of that time. 
 * 
 *
 *  A more detailed description goes here, if necessary.
 *  <br> <br>
 *  Created: <br>
 *     [9 January 2019], [Matthew Gu]<br>
 *  Modifications: <br>
 *     [15 January 2019], [Matthew Gu], <br>
 *
 *  @author [Matthew Gu]  
 *  @author [with assistance from T.A]
 *  @version [15 January 2019]
 */
public class TalkingRobot
{
    /**
     *  The main function initiates execution of this program.
     *    @param    String[] args not used in this program
     **/
    public static void main(String[] args)
    {
        System.out.println ("Welcome to your Timestamp App!"); 
        System.out.println ("Time is:");
        Clock clock1 = new Clock ();  
        clock1.randomizeTimes();

        for(int i=1 ; i<20; i++) 
        {  
            Random generator = new Random(); 
            int randNum = generator.nextInt(10); 
            clock1.changeTime();
            System.out.print (clock1.getHour() + ":" + clock1.getMM() ); 
            if (clock1.getHour() <= 12) 
                System.out.println ("A.M"); 
            else if (clock1.getHour() >= 12) 
                System.out.println ("P.M") ;  
        
            if (clock1.getHour() <5)  
                System.out.println ("It is too early go back to sleep!");
            else if (clock1.getHour() <=8)  
            {if (randNum >= 5)
                    System.out.println ("Good Morning Sunshine!") ;  
                else if (randNum <=5)  
                    System.out.println ("Rise and Shine Let's Eat Some Cereal!"); }
            else if (clock1.getHour() <= 12)  
            {if (randNum >= 5) 
                    System.out.println ("I am famished let's go to 2 Fellas") ; 
                else if  (randNum <= 5) 
                    System.out.println ("You wanna go play some Football");}
            else if (clock1.getHour() <= 18) 
            {if (randNum >= 5) 
                    System.out.println ("I'm hungry again let's go to Rice Kitchen");  
                else if (randNum <= 5) 
                    System.out.println ("Let's sit on the porch and enjoy a cigar");}
            else if (clock1.getHour() <= 24)  
            {if (randNum >=5) 
                    System.out.println ("I'm getting sleepy Goodnight") ; 
                else if (randNum <=5) 
                    System.out.println ("You want to grab a glass of milk?");}
                      System.out.println (" "); 
        }
    }//end main

}//end class
