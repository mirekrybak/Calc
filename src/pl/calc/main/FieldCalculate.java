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
        text = text.replace("-", "");

        printTextField(textField, text);
    }

    public String pointsVerify(String[] tab, TextField current, TextField previous) {
        String value;
        int payment = 0;
        for (int i = 1; i < tab.length; i++) {
            payment += parseToInt(tab[i]);
        }

        int left = parseToInt(tab[0]) - payment + parseToInt(current.getText());
        //System.out.println("\t\tWpłacono: " + payment + "\tZostało: " + left);

        //System.out.println("tab[0] - payment: " + (parseToInt(tab[0]) - payment));

        if ((parseToInt(tab[0]) - payment) < 0) {
            value = String.valueOf(left);
            //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } else if (parseToInt(current.getText()) > parseToInt(previous.getText())) {
            value = previous.getText();
        } else if (parseToInt(current.getText()) > parseToInt(tab[0])) {
            value = tab[0];
        } else {
            value = current.getText();
        }

        //System.out.println("\t\tValue = " + value);
        printTextField(current, value);

        return value;
    }

    //      factor 1.9

    public void factor(TextField paymentField, TextField profitField) {
        try {
            String value = String.valueOf(
                    parseToBigDecimal(paymentField.getText())
                            .multiply(parseToBigDecimal("1.9"))
                            .setScale(0, RoundingMode.HALF_UP));
            printTextField(profitField, value);
        } catch (NullPointerException e) {
            //  e.printStackTrace();
        }
    }

    //      bonus factor

    public void factor(TextField paymentField, TextField bonusField, TextField profitField) {
        try {
            String value = String.valueOf(
                    parseToBigDecimal(paymentField.getText())
                            .multiply(parseToBigDecimal(bonusField.getText()))
                            .setScale(0, RoundingMode.HALF_UP));
            printTextField(profitField, value);
        } catch (NullPointerException e) {
            // e.printStackTrace();
        }
    }

    //      profit (bonus - 1.9)

    public void factor(TextField paymentField, TextField bonusField, TextField profitField, boolean positionPane) {
        try {
            String value = String.valueOf(
                    parseToBigDecimal(paymentField.getText()).
                            multiply(parseToBigDecimal(bonusField.getText())).
                            divide(parseToBigDecimal("1.9"), RoundingMode.HALF_EVEN).
                            setScale(0, RoundingMode.HALF_UP).
                            subtract(parseToBigDecimal(paymentField.getText())));
            printTextField(profitField, value);
        } catch (NullPointerException e) {
            // e.printStackTrace();
        }
    }

    public void checkGuaranteedPosition(String[] pays, TextField pay, TextField nextPlace) {
        int allPoints = 0;
        int maxPoints = parseToInt(pays[0]);

        try {
            for (int i = 1; i < pays.length; i++) {
                allPoints += parseToInt(pays[i]);
            }
        } catch (NumberFormatException e) {
            // TODO
        }

        if ((parseToInt(pay.getText()) < (parseToInt(nextPlace.getText()) + maxPoints - allPoints)) ||
                parseToInt(pay.getText()) == 0) {
            notEnough(pay);
        } else {
            enough(pay);
        }
    }

    private BigDecimal parseToBigDecimal(String text) {
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

    private void printTextField(TextField textField, String text) {
        textField.clear();
        textField.setText(text);
        textField.positionCaret(text.length());
    }

    private String trimLastChar(String text) {
        String txt = text.substring(0, text.length() - 1);
        return txt;
    }

    private void notEnough(TextField colour) {
        colour.setStyle("-fx-background-color: #ff321e");
    }

    private void enough(TextField colour) {
        colour.setStyle("-fx-background-color: #65ff00");
    }

    private int parseToInt(String text) {
        int value;
        try {
            value = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            value = 0;
        }

        return value;
    }
}
