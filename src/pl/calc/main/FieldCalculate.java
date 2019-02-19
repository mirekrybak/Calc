package pl.calc.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldCalculate {

    public String doubleFormatVerify(String text) {

        if (text.length() < 2) {
            text = "1.";
        }

        String txt = text;
        String regex = "[1]{1}[.]{1}[0-9]*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (text.length() > 0) {
            if (!matcher.matches()) {
                txt = text.substring(0, text.length() - 1);
                System.err.println(txt + "    <--- WRONG !!!");
            }
        }

        System.out.println(text + "   " + txt);

        return txt;
    }

    public String intFormatVerify(String text) {
        String txt = text;
        String regex = "[1-9]{1}[0-9]*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (text.length() > 0) {
            if (!matcher.matches()) {
                txt = text.substring(0, text.length() - 1);
                System.err.println(txt + "    <--- WRONG !!!");
            }
        }

        System.out.println(text + "   " + txt);

        return txt;
    }
}
