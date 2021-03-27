package pH_package;

import java.util.Scanner;

public class Can_we_turn_the_heat_on
   {
      private static final char DOUBLE_DASH = '=';
      private static final char SPACE = ' ';
      private static final int CENTER_SPACING = 10;
      private static final int TITLE_SPACING = 45;
      private static final int TWO_ENDLINES = 2;
      private static Scanner sc;

      public static void main(String[] args)
         {
            //initialize variables
            int snowOnWindowResponse, temperature, howItFeels;

            //program will be a neutral decider in when we can turn on the heat
            
            //factors that means we can turn on the heat
               /*
               snow on the window    ---   turn on the heat 
               snow on the ground    ---   only if temp is less than 40
               temp less than 40     ---   heat, but only until the target heat 
                                           has been reached
               how cold it feels     ---   only heat if we are both wearing 
                                           warm clothes and still feel cold
               */
            
           
            //TODO what I need:
            /* Get user response for the following things 
             *    status of the snow:
             *       if on our window: turn on the heat now
             *       if on the ground: turn on the heat only if the temp is < 40
             *       
             *    the temperature outside:
             *       ask the user if:  
             *       if the temperature is between 60 and 50 degrees: 
             *          don't turn on the heat
             *       if the temp is between 49 and 10:
             *          turn on the heat
             *          
             *    how cold it feels:
             *       ask if we both have and it still feels cold: 
             *          long sleeves and long pants on
             *          if true: turn on the heat
             *          
             *          
             *   Unbiased Formula: 
             *   snowWindow = snow on the window: turn on heat
             *   snowGround = snow on the ground: only if temp < 40 
             *   
             *   temp = if between 49 and 10 turn on temp until target is met
             *   
             *   how cold = if both wearing long top and bottom
             *   
             *   if(user_response == snowWindow)
             *      print immediate turn on heat
             *   else if(user_response == snowWindow)
             *      ask the user for the temp
             *         if the temp is less than 50 turn on
             *         else
             *            ask how cold are you
             *               if wearing long top and bottom and still cold
             *                  turn on heat
             *               else 
             *                  dont
             */
            //print and display the title and how the program works
            printTitle();

            //prompt the user for the status of snow
               //method: promptForYesNo
               //"is there snow on the window?"
               //if snow on window is true -> turn on heat
            snowOnWindowResponse = promptForInt("is there snow on the window?"
                                    + "       Yes = 1     | No = 2    ");
            if(snowOnWindowResponse == 1)
               {
                  turnOnHeatMessages();
               }
            else
               {
                  //if the temperature is less than 50, heat is on 
                  temperature = promptForInt("How cold is it outside");
                  
                  if(temperature < 50)
                     {
                        //heat is on
                        turnOnHeatMessages();
                     }
                  else
                     {
                        //how it feels will always result in not turning on 
                        //the heat
                        howItFeels = promptForInt("Ask yourself if you have "
                              + " warm clothes that you can wear "
                              +"      Yes = 1     | No = 2    ");
                        if(howItFeels == 2)
                           {
                              System.out.print("i know you have that "
                                    + "sweatshirt in the closet...");
                           }
                        else
                           {
                              dontTurnOnHeatMessages();
                           }
                        
                     }
               }
            displayEnd();
               

         }
      
      public static void printTitle()
         {
            //tell the user how the program works 
              //print the three factors
              //methods needed: System.out.print
            printCharacters(SPACE, CENTER_SPACING);
            System.out.print("Can you turn on the heat?");
            System.out.println();
            printCharacters(DOUBLE_DASH, TITLE_SPACING);
            System.out.println();
            System.out.print("This code will decide that for you with three "
                  + "easy factors!");
            printEndlines(TWO_ENDLINES);
            
            printCharacters(SPACE, CENTER_SPACING);
            System.out.print("SNOW");
            printEndlines(TWO_ENDLINES);
            
            printCharacters(SPACE, CENTER_SPACING);
            System.out.print("TEMPERATURE");
            printEndlines(TWO_ENDLINES);
            
            printCharacters(SPACE, CENTER_SPACING);
            System.out.print("HOW COLD IT FEELS");
            printEndlines(TWO_ENDLINES);
            
            System.out.print("These factors will be processed and a decision "
                  + "will be made:");
            System.out.println();
            
         }
      //printCharacters prints a charcters a number of times 
      private static void printCharacters(char charToBePrinted, 
                                                            int numTimesPrinted)
        {
            //initialize
           int index;
            //create a for loop that prints the character to be printed, num times
           for(index = 0; index < numTimesPrinted; index++)
              {
                 System.out.print(charToBePrinted);
              }
        }
      //reads in an integer from the user
      private static int promptForInt(String prompt)
         {
            //initialize 
               //initialize Scanner 
            int userEnteredInteger;
            sc = new Scanner(System.in);
            
            //prompt for an integer
            printEndlines(TWO_ENDLINES);
            System.out.println(prompt);
            
            userEnteredInteger = sc.nextInt();
         
            return userEnteredInteger;
         }
      //prints x number of endlines
      private static void printEndlines(int numEndlines)
         {
            //initialize 
            int index;
            //for(index = 0; index < numEndlines; index++)
            for(index = 0; index < numEndlines; index++)
               {
                  System.out.println();
               }
         }
      
      private static void turnOnHeatMessages()
         {
            //initialize 
            int max = 5;
            
            String message1 = "Its way too cold, turn on the heat";
            String message2 = "I, all being and all knowing, hath granted "
                  + "thou with the exploitation of modern luxeries.";
            String message3 = "yeah I guess you can :/";
            String message4 = "Its kinda chilly and I can never work when I'm "
                  + "slightly uncomfortable";
            
            //get a random integer from 1 to 4
            int randomMessageChoice = (int)(Math.random() * max - 1);
            //create a string array to hold the messages
               //use the random int generator as an index and print a message
            String[] messageArray = new String[] {message1, message2, message3, 
                                                                      message4};
            
            System.out.println(messageArray[randomMessageChoice]);
         }
      
      private static void dontTurnOnHeatMessages()
         {
          //initialize 
            int max = 5;
            
            String message1 = "Pfft, youre fine";
            String message2 = "Dont turn on the heat, put on a jacket";
            String message3 = "no.";
            String message4 = "Eat something, I dont know";
            
            //get a random integer from 1 to 4
            int randomMessageChoice = (int)(Math.random() * max - 1);
            //create a string array to hold the messages
               //use the random int generator as an index and print a message
            String[] messageArray = new String[] {message1, message2, message3, 
                                                                      message4};
            System.out.println(messageArray[randomMessageChoice]);
         }
      
      private static void displayEnd()
         {
            //print an endline and tell the user the program ended
            System.out.println();
            System.out.print("End of Program");
         }
      
      

   }
