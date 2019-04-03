package pl.calc.main;

import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldCalculate {

    public void doubleValueVerify(TextField textField) {
        String text = textField.getText();                   //      range 1.0 - 1.999
        try {
            if (text.length() < 2 || !(text.substring(0, 2).equals("1."))) {
                text = "1.";
            }

            String regex = "[1]{1}[\\.]{1}[0-9]*";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            if (!matcher.matches() || text.length() > 5) {
                text = trimLastChar(text);
            }
        } catch (IndexOutOfBoundsException e) {
            text = "1.";
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

    public static void printTextField(TextField textField, String text) {
        textField.clear();
        textField.setText(text);
        textField.positionCaret(text.length());
    }

    public static String trimLastChar(String text) {
        String txt = text.substring(0, text.length() - 1);
        return txt;
    }

    //      factor 1.9

    public void factor(TextField paymentField, TextField profitField) {
        String value = String.valueOf(
                val(paymentField.getText())
                        .multiply(val("1.9"))
                        .setScale(0, RoundingMode.HALF_UP));
        printTextField(profitField, value);
    }

    //      bonus factor

    public void factor(TextField paymentField, TextField bonusField, TextField profitField) {
        String value = String.valueOf(
                val(paymentField.getText())
                        .multiply(val(bonusField.getText()))
                        .setScale(0, RoundingMode.HALF_UP));
        printTextField(profitField, value);
    }

    //      profit (bonus - 1.9)

    public void factor(TextField paymentField, TextField bonusField, TextField profitField, boolean positionPane) {
        String value = String.valueOf(
                val(paymentField.getText()).
                        multiply(val(bonusField.getText())).
                        divide(val("1.9"), RoundingMode.HALF_EVEN).
                        setScale(0, RoundingMode.HALF_UP).
                        subtract(val(paymentField.getText())));
        printTextField(profitField, value);
    }

    public void checkProvidedPosition(String[] pays, TextField pay, TextField nextPlace, TextField points) {
        int allPoints = 0;
        int maxPoints = 0;

        try {
            maxPoints = parseToInt(points.getText());
            for (String l : pays) {
                allPoints += parseToInt(l);
            }
        } catch (NumberFormatException e) {
            // TODO
        }

        if (parseToInt(pay.getText()) < (parseToInt(nextPlace.getText()) + maxPoints - allPoints)) {
            notEnough(pay);
        } else {
            enough(pay);
        }
    }

    public static void notEnough(TextField colour) {
        colour.setStyle("-fx-background-color: #ff321e");
    }

    public static void enough(TextField colour) {
        colour.setStyle("-fx-background-color: #65ff00");
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
        BigDecimal txt = null;
        if (text.endsWith(".") || text.length() < 1) {
            text = text.concat("0");
        }

        try {
            txt = new BigDecimal(text);
        } catch (NumberFormatException e) {
            // TODO
        }

        return txt;
    }
}
