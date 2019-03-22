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

//    public boolean check(String[] pays, TextField points, TextField pay) {
//        int allPoints = 0;
//        int maxPoints = 0;
//        try {
//            maxPoints = parseToInt(points.getText());
//            for (String l : pays) {
//                allPoints += parseToInt(l);
//            }
//        } catch (NumberFormatException e) {
//            System.out.println("===");
//        }
//
////        if ((maxPoints - allPoints) > (parseToInt(pay.getText()))) {
////            return false;
////        }             TODO:           OK !!!!!!!!!!!!!!!!!!!!!
//
//        try {
//            for (int i = 1; i < pays.length; i++) {
//                System.out.print("i = " + i + "   " +
//                        parseToInt(pays[i]) + "   <   " + (parseToInt(pays[i + 1]) + (maxPoints - allPoints)));
//                System.out.println("\t" + (parseToInt(pays[i]) < (parseToInt(pays[i + 1]) + (maxPoints - allPoints))));
//                if (parseToInt(pays[i]) < ((parseToInt(pays[i + 1]) + (maxPoints - allPoints)))) {
//                    System.out.println("N I E");
//                }
//            }
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println(" eh...");
//        }
//
//
//
//        return true;
//    }

//    public boolean check(String[] pays, TextField pay, String nextPoints, TextField points) {
//        int allPoints = 0;
//        int maxPoints = 0;
//        try {
//            maxPoints = parseToInt(points.getText());
//            for (String l : pays) {
//                allPoints += parseToInt(l);
//            }
//        } catch (NumberFormatException e) {
//            System.out.println("===");
//        }
//
//        if (parseToInt(pay.getText()) < (parseToInt(nextPoints) + (maxPoints - allPoints))) {
//            return false;
//        }
//
//        return true;
//    }

    public boolean check(String[] pays, TextField pay, TextField nextPoints, TextField points) {
        int allPoints = 0;
        int maxPoints = 0;
        try {
            maxPoints = parseToInt(points.getText());
            for (String l : pays) {
                allPoints += parseToInt(l);
            }
        } catch (NumberFormatException e) {
            System.out.println("===");
        }

        if (parseToInt(pay.getText()) < (parseToInt(nextPoints.getText()) + (maxPoints - allPoints))) {
            return false;
        }

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
        if (text.endsWith(".") || text.length() < 1) {
            text = text.concat("0");
        }
        BigDecimal txt = new BigDecimal(text);
        return txt;
    }
}
