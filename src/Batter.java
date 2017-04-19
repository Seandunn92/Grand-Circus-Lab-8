/**
 * Created by seandunn92 on 4/18/17.
 */
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.text.DecimalFormat;

public class Batter {
    private int[] batterResults;
    private int batterNumber;


    public Batter(){
        batterResults = new int[]{};
        int battterNumber=-1;
    }

    public Batter(int[] batterResults, int batterNumber){
        this.batterNumber=batterNumber;
        this.batterResults = Arrays.copyOf(batterResults, batterResults.length);
    }



    public void setBatterNumber(int batterNumber){
        this.batterNumber=batterNumber;
    }

    public int getBatterNumber(){
        return batterNumber;
    }
    public void setBattingResults (int[] BatterResults){
        this.batterResults = Arrays.copyOf(BatterResults, BatterResults.length);
    }

    public double getSluggingPercentage(){
        double numToDivideInto =0;
        for(int x : batterResults){
            if(x>0)
            numToDivideInto+=x;
        }
        return numToDivideInto/ batterResults.length;
    }


    public double getBattingAverage(){
        double numToDivideInto =0;
        for(int x : batterResults){
            if (x>0)
                numToDivideInto++;
        }
        return numToDivideInto/ batterResults.length;
    }
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.###");
        return "Batter " + batterNumber + " average: " +df.format(getBattingAverage()) + "       slugging percentage: "
                + df.format(getSluggingPercentage());
    }

}
