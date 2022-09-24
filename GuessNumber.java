// Simionescu Robert

package src;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;

public class GuessNumber {



    //Methods
    public static void guessNumberGame() throws InterruptedException
    {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random(System.currentTimeMillis());
        int max=-1; //the maximum number
        int num=-1; //the number in that interval [0,max]
        int guess; //the number the user guessed
        int tries; //number of tries the user has

        //TO CHANGE NUMBER OF TRIES
        int tries_org =3; // variable that controls number of tries
        
        //A character to verify if another instance starts
        String q = "y";
        //A boolean to check the win_status
        boolean ok = true;
    
        System.out.println("Hi");
        Thread.sleep(2000);
        System.out.println("Let's play guess the number");
        Thread.sleep(2000);
        while(q.equalsIgnoreCase("y"))
        {
            //Tries gets a predefined value
            tries = tries_org;
            
            
            //Reinitialize guess and max;
            guess = -1;
            max = -1;
            //Define max
            while(max == -1)
            {
                //Make sure max is a number
                while(true)
                {
                    try
                    {
                      Thread.sleep(500);
                      System.out.println("In what range do you want to guess?");
                      max = scanner.nextInt();
                      //Make sure max > 0;
                      while(max < 0)
                      {
                        Thread.sleep(500);
                        System.out.println("A number above 0, smartie\n");
                        Thread.sleep(500);
                        System.out.println("Try again\n");
                        max = scanner.nextInt();
                        scanner.nextLine();
                      }
                      
                      break;
                    }
                    //Wrong input type
                    catch(InputMismatchException e)
                    {
                        Thread.sleep(500);
                        System.out.println("That is not a number i know... \n");
                        scanner.nextLine();
                    }
                }

                //Max 1 and 0 are not accepted(too litlle options)
                if((max == 0) || (max ==1))
                {
                    System.out.println("That's not really fair, is it?\n");
                    Thread.sleep(500); //sleep for a more human feeling
                    System.out.println("Choose again\n");
                    Thread.sleep(500);
                    max = -1;
                }
            }
            //Start of guessing
            System.out.println("Ok... Choose a number between 0 and " + max);
            Thread.sleep(500);
            while(tries != 0)
            {
                System.out.println("\nYou have " + tries + " tries");
                num = rand.nextInt(max) + 1; //a number between 0 and max
                guess=scanner.nextInt(); //the guess of the player
                if(guess>max)
                {
                    Thread.sleep(500);
                    System.out.println("You know the max is " + max + " , right?\n");
                    Thread.sleep(500);
                    System.out.println("Anyway, try again\n");
                }
                else if(guess == num)
                    {
                    ok=true;
                    System.out.println("\nYou guessed the number");
                    Thread.sleep(1000);
                    break;
                    }

                else
                    {
                    ok=false;
                    System.out.println("\nYou didn't get it");
                    Thread.sleep(1000);
                    tries -=1;
                    }

            }

            if(ok == true)
            {
                System.out.println("\nYou won this time\n\nDo you want to play again? \n n-no y-yes");
                scanner.nextLine();
                q=scanner.nextLine();
            }
            else
            {
                System.out.println("\nYou didn't win this time\n\nI was thinking of " + num + "\n\nDo you want to play again? \n y-yes n-no");
                scanner.nextLine();
                q=scanner.nextLine();
            }
            if( q.equalsIgnoreCase("n"))
                System.out.println("Okay, bye!");
                Thread.sleep(2000);

        }
        scanner.close();
    }
}
