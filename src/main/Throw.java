package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gsheppard on 8/12/16.
 */
public class Throw {
    private int multiplier;
    private int points;

    public Throw(String throwStr){

        if(throwStr.toLowerCase().equals("m")) {
            multiplier = 1;
            points = 50;
        }
        else if(throwStr.toLowerCase().equals("b")){
            multiplier = 1;
            points = 25;
        }
        else if(throwStr.toLowerCase().startsWith("d")){
            multiplier = 2;
            points = Integer.parseInt(throwStr.substring(1));
        }
        else if(throwStr.toLowerCase().startsWith("t")){
            multiplier = 3;
            points = Integer.parseInt(throwStr.substring(1));
        }
        else if(throwStr.toLowerCase().startsWith("s")){
            multiplier = 1;
            points = Integer.parseInt(throwStr.substring(1));
        }
        else{
            multiplier = 1;
            points = Integer.parseInt(throwStr);
        }
    }

    public static boolean validateThrowInput(String throwStr) {
        Pattern withLetter = Pattern.compile("[SsDdTt]?[0-9]{1,2}");
        Matcher m = withLetter.matcher(throwStr);
        boolean valid =  m.matches();
        if (throwStr.toLowerCase().equals("m"))
            return true;
        if (throwStr.toLowerCase().equals("b"))
            return true;
        if (valid)
            if (validateNumber(throwStr))
                return true;
        return false;
    }

    public int getThrowPoints(){
        return points * multiplier;
    }

    public int getSlice(){
        return points;
    }

    private static boolean validateNumber(String throwStr){
        int number;
        try {
            number = Integer.parseInt(throwStr);
        }catch (NumberFormatException e){
            number = Integer.parseInt(throwStr.substring(1));
        }
        if (number < 1)
            return false;
        else if(number > 20){
            if(number != 25)
                return false;

        }
        return true;
    }

}
