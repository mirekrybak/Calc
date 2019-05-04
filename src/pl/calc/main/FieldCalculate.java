package pl.calc.main;

import javafx.scene.control.TextField;

import java.math.RoundingMode;

public class FieldCalculate {
    Parser parser = new Parser();
    //      factor 1.9

    public void factor(TextField paymentField, TextField profitField) {
        try {
            String value = String.valueOf(
                    parser.parseToBigDecimal(paymentField.getText())
                            .multiply(parser.parseToBigDecimal("1.9"))
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
                    parser.parseToBigDecimal(paymentField.getText())
                            .multiply(parser.parseToBigDecimal(bonusField.getText()))
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
                    parser.parseToBigDecimal(paymentField.getText()).
                            multiply(parser.parseToBigDecimal(bonusField.getText())).
                            divide(parser.parseToBigDecimal("1.9"), RoundingMode.HALF_EVEN).
                            setScale(0, RoundingMode.HALF_UP).
                            subtract(parser.parseToBigDecimal(paymentField.getText())));
            printTextField(profitField, value);
        } catch (NullPointerException e) {
            // e.printStackTrace();
        }
    }

    public String trimLastChar(String text) {
        String txt;
        try {
            txt = text.substring(0, text.length() - 1);
        } catch (StringIndexOutOfBoundsException e) {
            txt = "";
        }
        return txt;
    }

    public void printTextField(TextField textField, String text) {
        textField.clear();
        textField.setText(text);
        textField.positionCaret(text.length());
    }
}
