package pl.calc.main;

import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldCalculate {

    public void checkDoubleValue(TextField textField) {
        String text = textField.getText();                   //      range 1.0 - 1.999
        if (text.length() < 2) {
            text = "1.";
        }

        String regex = "[1]{1}[\\.]{1}[0-9]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (text.length() > 0) {
            if (!matcher.matches() || text.length() > 5) {
                text = text.substring(0, text.length() - 1);
            }
        }

        printTextField(text, textField);
    }

    public void checkIntegerValue(TextField textField) {
        String text = textField.getText();
        String regex = "[1-9]{1}[0-9]*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (text.length() > 0) {
            if (!matcher.matches() || text.length() > 6) {
                text = text.substring(0, text.length() - 1);
            }
        }
        printTextField(text, textField);
    }

    public static void printTextField(String text, TextField textField) {
        if (text.length() > 1) {
            textField.clear();
            textField.setText(text);
            textField.positionCaret(text.length());
        }
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
