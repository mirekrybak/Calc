package pl.calc.main;

import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verify {
    FieldCalculate calculate = new FieldCalculate();
    Parser parser = new Parser();

    public void doubleValueVerify(TextField textField) {
        String text = textField.getText();                   //      range 1.0 - 1.999
        try {
            if (text.length() < 2 || !(text.substring(0, 2).equals("1."))) {
                text = "1.";
            }

            String regex = "[1]{1}[.]{1}[0-9]*";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            if (!matcher.matches() || text.length() > 5) {
                text = calculate.trimLastChar(text);
            }
        } catch (IndexOutOfBoundsException e) {
            text = "1.";
        }

        calculate.printTextField(textField, text);
    }

    public void integerValueVerify(TextField textField) {
        String text = textField.getText();
        String regex = "[1-9]{1}[0-9]*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (text.length() > 0 && (!matcher.matches() || text.length() > 6)) {
            text = calculate.trimLastChar(text);
        }
        text = text.replace("-", "");

        calculate.printTextField(textField, text);
    }

    public String pointsVerify(String[] tab, TextField current, TextField previous) {
        String value;
        int payment = 0;
        for (int i = 1; i < tab.length; i++) {
            payment += parser.parseToInt(tab[i]);
        }

        int left = parser.parseToInt(tab[0]) - payment + parser.parseToInt(current.getText());

        if (parser.parseToInt(current.getText()) > parser.parseToInt(previous.getText())) {
            value = previous.getText();
        } else if ((parser.parseToInt(tab[0]) - payment) < 0) {
            value = String.valueOf(left);
        } else if (parser.parseToInt(current.getText()) > parser.parseToInt(tab[0])) {
            value = tab[0];
        } else {
            value = current.getText();
        }

        if (parser.parseToInt(value) < 0) {
            value = "";
        }

        calculate.printTextField(current, value);

        return value;
    }

    public void checkGuaranteedPosition(String[] pays, TextField pay, TextField nextPlace) {
        int allPoints = 0;
        int maxPoints = parser.parseToInt(pays[0]);

        try {
            for (int i = 1; i < pays.length; i++) {
                allPoints += parser.parseToInt(pays[i]);
            }
        } catch (NumberFormatException e) {
            // TODO
        }

        if ((parser.parseToInt(pay.getText()) < (parser.parseToInt(nextPlace.getText()) + maxPoints - allPoints)) ||
                parser.parseToInt(pay.getText()) == 0) {
            notEnough(pay);
        } else {
            enough(pay);
        }
    }

    private void notEnough(TextField colour) {
        colour.setStyle("-fx-background-color: #ff321e");
    }

    private void enough(TextField colour) {
        colour.setStyle("-fx-background-color: #65ff00");
    }
}
