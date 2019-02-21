package pl.calc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import pl.calc.main.FieldCalculate;

import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryPaneController implements Initializable {

    @FXML
    PositionPaneController positionPaneController;

    @FXML
    BonusPaneController bonusPaneController;

    @FXML
    private Button exitButton;

    FieldCalculate calculate = new FieldCalculate();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Application closing ...");
                System.exit(-2);
            }
        });

        bonusPaneController.getBonusTextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                String text = calculate.doubleFormatVerify(bonusPaneController.getBonusTextField().getText());      // 1.xxxx   x - number
                System.out.println(text);

                bonusPaneController.getBonusTextField().clear();
                bonusPaneController.getBonusTextField().setText(text);
                bonusPaneController.getBonusTextField().positionCaret(text.length());

                System.out.println("Nowa metoda - " + calculate.countProfitValue(bonusPaneController.getBonusTextField()));

                if (!bonusPaneController.getBonusTextField().getText().equals("") &&
                        !bonusPaneController.getPaymentTextField().getText().equals("")) {
                    String ratio;

                    System.out.println("bonus: " + bonusPaneController.getBonusTextField().getText() + "\npayment: " + bonusPaneController.getPaymentTextField().getText());
                    if (bonusPaneController.getBonusTextField().getText().equals("1.")) {
                        ratio = "1.0";
                    } else {
                        ratio = bonusPaneController.getBonusTextField().getText();
                    }

                    String profit = String.valueOf(
                            calculate.value(ratio).multiply(
                                            calculate.value(bonusPaneController.getPaymentTextField().getText())));

                    bonusPaneController.getProfitTextField().setText(profit);

                    //System.out.println(ratio);
                    //bonusPaneController.getProfitTextField().setText();

                    // jeżeli 1. to do obliczeń 1.0
                }

            }
        });

        bonusPaneController.getPaymentTextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                String text = calculate.intFormatVerify(bonusPaneController.getPaymentTextField().getText());

                bonusPaneController.getPaymentTextField().clear();
                bonusPaneController.getPaymentTextField().setText(text);
                bonusPaneController.getPaymentTextField().positionCaret(text.length());


//                if (!bonusPaneController.getBonusTextField().getText().equals(null) &&
//                        !bonusPaneController.getPaymentTextField().getText().equals(null)) {
//                    String ratio;
//                    if (bonusPaneController.getBonusTextField().getText().equals("1.")) {
//                        ratio = "1.0";
//                    } else {
//                        ratio = bonusPaneController.getBonusTextField().getText();
//                    }
//
//                    String profit = String.valueOf(
//                            calculate.value(ratio).multiply(
//                                    calculate.value(bonusPaneController.getPaymentTextField().getText())));
//
//                    bonusPaneController.getProfitTextField().setText(profit);
//                }
            }
        });

        bonusPaneController.getPointsTextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                String text = calculate.intFormatVerify(bonusPaneController.getPointsTextField().getText());

                bonusPaneController.getPointsTextField().clear();
                bonusPaneController.getPointsTextField().setText(text);
                bonusPaneController.getPointsTextField().positionCaret(text.length());
            }
        });

    }




}
