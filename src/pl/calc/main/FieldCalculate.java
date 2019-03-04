package pl.calc.main;

import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldCalculate {

    public static void printTextField(TextField textField, String text) {
        textField.clear();
        textField.setText(text);
        textField.positionCaret(text.length());
    }

    public void doubleValueVerify(TextField textField) {
        String text = textField.getText();                   //      range 1.0 - 1.999
        if (text.length() < 2) {
            text = "1.";
        }

        String regex = "[1]{1}[\\.]{1}[0-9]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (!matcher.matches() || text.length() > 5) {
            text = text.substring(0, text.length() - 1);
        }

        printTextField(textField, text);
    }

    public void integerValueVerify(TextField textField) {
        String text = textField.getText();
        String regex = "[1-9]{1}[0-9]*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (text.length() > 0 && (!matcher.matches() || text.length() > 6)) {
            text = text.substring(0, text.length() - 1);
        }

        printTextField(textField, text);
    }

    public String factor19(TextField textField, String text) {
        String profit19 = String.valueOf(
                val(text).multiply(val(textField.getText())).setScale(0, RoundingMode.HALF_UP));
        return profit19;
    }

    public String bonusFactor(TextField payTextField, TextField bonusTextField) {
        String profit = String.valueOf(
                val(payTextField.getText()).multiply(val(bonusTextField.getText())).setScale(0, RoundingMode.HALF_UP));
        return profit;
    }

    public static BigDecimal val(String text) {
        if (text.endsWith(".") || text.length() < 1) {
            text = text.concat("0");
        }
        BigDecimal txt = new BigDecimal(text);
        return txt;
    }
}
