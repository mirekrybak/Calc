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
            text = trimLastChar(text);
        }

        printTextField(textField, text);
    }

    public void integerValueVerify(TextField textField) {
        String text = textField.getText();
        String regex = "[1-9]{1}[0-9]*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (text.length() > 0 && (!matcher.matches() || text.length() > 6)) {
            text = trimLastChar(text);
        }

        printTextField(textField, text);
    }

    public static String trimLastChar(String text) {
        String txt = text.substring(0, text.length() - 1);
        return txt;
    }

    public String factor19(TextField textField, String text) {
        String profit19 = String.valueOf(
                val(text).multiply(val(textField.getText()))
                        .setScale(0, RoundingMode.HALF_UP));
        return profit19;
    }

    public String bonusFactor(TextField payTextField, TextField bonusTextField, boolean positionPane) {
        String profit;

        if (!positionPane) {
            profit = String.valueOf(
                    val(bonusTextField.getText()).multiply(val(payTextField.getText()))
                            .setScale(0, RoundingMode.HALF_UP));
        } else {
            profit = String.valueOf(val(payTextField.getText())
                    .multiply(val(bonusTextField.getText()))
                    .divide(val("1.9"), RoundingMode.HALF_EVEN)
                    .setScale(0, RoundingMode.HALF_UP)
                    .subtract(val(payTextField.getText())));
        }

        return profit;
    }

    public boolean check(String[] pays, TextField points, TextField pay) {
        int value = 0;
        int maxPoints = 0;
        try {
            maxPoints = parseToInt(points.getText());
            for (String l : pays) {
                value =+ parseToInt(l);
                System.out.println(maxPoints + "\t\t" + value);
            }
        } catch (NumberFormatException e) {
            System.out.println("===");
        }

        if ((maxPoints/2) > (value + parseToInt(pay.getText()))) {
            System.out.println("=== > " + (maxPoints/2) + "   <   " + (value + parseToInt(pay.getText())));
            return false;
        } else {
            return true;
        }
    }

    public static int parseToInt(String text) {
        int value;
        try {
            value = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            value = 0;
        }

        return value;
    }

    public static BigDecimal val(String text) {
        if (text.endsWith(".") || text.length() < 1) {
            text = text.concat("0");
        }
        BigDecimal txt = new BigDecimal(text);
        return txt;
    }
}
