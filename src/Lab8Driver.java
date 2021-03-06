/**
 * Created by seandunn92 on 4/18/17.
 */
import java.util.Scanner;
public class Lab8Driver {
    private static Scanner scan = new Scanner(System.in);
    private static int batterNumber = 1;   //this starts at 1 and will be incremented to 2 when batter 1 is handled
                                            //3 when batter 2 is etc...

    public static void main(String[] args) {


        int numBats = getNumBats();

        Batter[] batterArray = new Batter[numBats];

       setBatterArray(batterArray);

       for (int i=0; i<numBats; i++)
        System.out.println(batterArray[i]);






    }

    //getNumBats isn't passed any input, and prompts the user until they enter a vaild integer, then returns that integer
    private static int getNumBats() {
        int numBats=-1;



        while (numBats<0){

            System.out.println("Enter in the number of batters");
            try {
                numBats = scan.nextInt();
            }catch (Exception e){
                System.out.println("Invalid Input");
                scan.nextLine();
            }
        }
        return numBats;
    }


    /*
        setBatterArray takes in an array of Batters, and uses getBatterData for each part of the Batter Array to assign
        ther proper values
     */
    private static void setBatterArray(Batter[] batterArray) {
        for (int i=0; i<batterArray.length; i++){
            batterArray[i] =getBatterData(batterArray[i]);

        }
    }

    /*
        getBatterData takes in a Batter, and loops through user Information to set the Batter Data
     */
    private static Batter getBatterData(Batter batter) {

        int numTimesAtBat = getNumTimesAtBat();

        //this variable is equal to 0,1,2,3,4 depending on how the batter did at the bat this round
        int battingResult =-1;
        int [] batterResults = new int[numTimesAtBat];
        for (int i=0; i<numTimesAtBat; i++){
            while(battingResult<0){
                try{ System.out.println("Enter in the batter's result for try " + (i+1));
                    battingResult = scan.nextInt();

                }catch(Exception e){
                    System.out.println("Invalid Input");
                    scan.nextLine();
                }
            }
            batterResults[i] = battingResult;
            //reset battingResult to -1 so we can reuse the while loop in the next iteration
            battingResult = -1;

        }

        batter = new Batter(batterResults, batterNumber);


        batterNumber++;  //next time we use this method we will be looking at Batter 2, (or 3 if 2 was looked at etc..)

        return batter;
    }

    /*
    When looking at a batter, we need to now how many times that batter will bat. getNumTimesAtBat() prompts user until a
    valid integer input is given, then returns that integer
     */
    private static int getNumTimesAtBat() {
        int numTimesAtBat =-1;
        while(numTimesAtBat <0){
            try {
                System.out.println("Enter in the number of times at Bat for batter " + batterNumber);
                numTimesAtBat = scan.nextInt();

            }catch (Exception e){
                System.out.println("Invalid Input");
                scan.nextLine();
            }
        }
        return numTimesAtBat;
    }

}
