/**
 * Created by seandunn92 on 4/18/17.
 */
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.text.DecimalFormat;

public class Batter {
    private int[] batterResults;
    private int batterNumber;

//default constructor
    public Batter(){
        batterResults = new int[]{};
        int battterNumber=-1;
    }

    //overloaded contstructor
    public Batter(int[] batterResults, int batterNumber){
        this.batterNumber=batterNumber;
        this.batterResults = Arrays.copyOf(batterResults, batterResults.length);
    }


//setter
    public void setBatterNumber(int batterNumber){
        this.batterNumber=batterNumber;
    }
//getter
    public int getBatterNumber(){
        return batterNumber;
    }
    /*
    This method takes in an int array of BatterResults and assigns that to the Batter Object Batter results
     */
    public void setBattingResults (int[] BatterResults){
        this.batterResults = Arrays.copyOf(BatterResults, BatterResults.length);
    }
/*
This method takes no parameters and returns the slugging Percentage
 */
    public double getSluggingPercentage(){
        double numToDivideInto =0;
        for(int x : batterResults){
            if(x>0)
            numToDivideInto+=x;
        }
        return numToDivideInto/ batterResults.length;
    }

//This method takes in no parameters and returns the Batter's Batting Average
    public double getBattingAverage(){
        double numToDivideInto =0;
        for(int x : batterResults){
            if (x>0)
                numToDivideInto++;
        }
        return numToDivideInto/ batterResults.length;
    }
    /*
    This is what will print out if the user tries to output a Batter
     */
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.###");
        return "Batter " + batterNumber + " average: " +df.format(getBattingAverage()) + "       slugging percentage: "
                + df.format(getSluggingPercentage());
    }

}
