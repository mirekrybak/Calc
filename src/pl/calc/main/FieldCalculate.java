package pl.calc.main;

import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldCalculate {

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

    public static void printTextField(TextField textField, String text) {
        textField.clear();
        textField.setText(text);
        textField.positionCaret(text.length());
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

    public void factor(TextField paymentField, TextField profitField) {                         // 1.9 factor
        String value = String.valueOf(
                val(paymentField.getText())
                        .multiply(val("1.9"))
                        .setScale(0, RoundingMode.HALF_UP));
        printTextField(profitField, value);
    }

    public void factor(TextField paymentField, TextField bonusField, TextField profitField) {   // bonus factor
        String value = String.valueOf(
                val(paymentField.getText())
                        .multiply(val(bonusField.getText()))
                        .setScale(0, RoundingMode.HALF_UP));
        printTextField(profitField, value);
    }

    public void factor(TextField paymentField, TextField bonusField, TextField profitField, boolean positionPane) {
        String value = String.valueOf(
                val(paymentField.getText()).
                        multiply(val(bonusField.getText())).
                        divide(val("1.9"), RoundingMode.HALF_EVEN).
                        setScale(0,RoundingMode.HALF_UP).
                        subtract(val(paymentField.getText())));
        printTextField(profitField, value);
    }
    public String bonusFactor(TextField payTextField, TextField bonusTextField, boolean positionPane) {
        String profit = String.valueOf(val(payTextField.getText())
                    .multiply(val(bonusTextField.getText()))
                    .divide(val("1.9"), RoundingMode.HALF_EVEN)
                    .setScale(0, RoundingMode.HALF_UP)
                    .subtract(val(payTextField.getText())));
        return profit;
    }

    public String bonusFactor(TextField payTextField, TextField bonusTextField) {
        String profit;
        profit = String.valueOf(val(bonusTextField.getText())
                .multiply(val(payTextField.getText()))
                .setScale(0, RoundingMode.HALF_UP));
        return profit;
    }

    public void checkProvidedPosition(String[] pays, TextField pay, TextField nextPlace, TextField points) {
        int allPoints = 0;
        int maxPoints = 0;
        try {
            maxPoints = parseToInt(points.getText());
            System.out.println("maxPoints = " + maxPoints);
            for (String l : pays) {
                allPoints += parseToInt(l);
            }
            System.out.println("allPoints = " + allPoints);
        } catch (NumberFormatException e) {
            // TODO
        }

        System.out.println("===> " + parseToInt(pay.getText()) + "   ===> " + (parseToInt(nextPlace.getText()) + maxPoints - allPoints));
        System.out.println("===> " + (parseToInt(pay.getText()) < (parseToInt(nextPlace.getText()) + maxPoints - allPoints)));
        if (parseToInt(pay.getText()) < (parseToInt(nextPlace.getText()) + maxPoints - allPoints)) {
            pay.setStyle("-fx-background-color: #ff321e");
        } else {
            pay.setStyle("-fx-background-color: #65ff00");
        }
    }

    public boolean check(String[] pays, TextField pay, TextField nextPoints, TextField points) {
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


//      TODO    nextPoint = null;                           :/
//        if (parseToInt(pay.getText()) < parseToInt(nextPoints.getText())) {
//            String temp = pay.getText();
//            pay.setText(nextPoints.getText());
//            nextPoints.setText(temp);
//
//            System.out.println(pay.getText());
//            System.out.println(nextPoints.getText());
//        }
//
//        printTextField(pay, pay.getText());
//        printTextField(nextPoints, nextPoints.getText());

        if (parseToInt(pay.getText()) < (parseToInt(nextPoints.getText()) + maxPoints - allPoints)) {
            return false;
        }



//        System.err.println((parseToInt(pay.getText()) + parseToInt(nextPoints.getText()) / 2)
//                + " > "
//                + (maxPoints-allPoints));
//        if ((parseToInt(pay.getText()) + parseToInt(nextPoints.getText())) / 2 > (maxPoints - allPoints)) {
//            return true;
//        }

//        if (parseToInt(pay.getText()) < (parseToInt(nextPoints.getText()) + (maxPoints - allPoints))) {
//            //System.out.println(parseToInt(pay.getText()) + "   <   " + (parseToInt(nextPoints.getText()) + (maxPoints - allPoints)));
//            return false;
//        } else if (parseToInt(pay.getText()) >= (maxPoints - allPoints)) {      // TODO: ustalić warunek kiedy maxPoints -
//            return true;
//        }

        return true;
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
