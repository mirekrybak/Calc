package pl.calc.main;

import java.math.BigDecimal;

public class Parser {
    public BigDecimal parseToBigDecimal(String text) {
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

    public int parseToInt(String text) {
        int value;
        try {
            value = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            value = 0;
        }

        return value;
    }
}
