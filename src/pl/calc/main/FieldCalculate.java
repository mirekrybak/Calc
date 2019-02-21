package pl.calc.main;

import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldCalculate {

    public String doubleFormatVerify(String text) {
        if (text.length() < 2) {
            text = "1.";
        }

        String txt = text;
        String regex = "[1]{1}[\\.]{1}[0-9]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (text.length() > 0) {
            if (!matcher.matches() || text.length() > 5) {
                txt = text.substring(0, text.length() - 1);
        //        System.err.println(txt + "    <--- WRONG !!!");                 //  error information
            }
        }

        //System.out.println(text + "   " + txt);                                 //  print text, txt variables

        return txt;
    }

    public String intFormatVerify(String text) {
        String txt = text;
        String regex = "[1-9]{1}[0-9]*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (text.length() > 0) {
            if (!matcher.matches() || text.length() > 6) {
                txt = text.substring(0, text.length() - 1);
            //    System.err.println(txt + "    <--- WRONG !!!");                 //  error information
            }
        }

        //System.out.println(text + "   " + txt);                                 //  print text, txt variables

        return txt;
    }

    public BigDecimal value(String text) {
        if (text.endsWith(".")) {
            text = text.concat("0");
        }
        BigDecimal txt = new BigDecimal(text);
        System.out.println(txt + "  as BigDecimal");

        return txt;
    }

    public String countProfitValue(TextField field) {


        return field.getText();
    }
}
