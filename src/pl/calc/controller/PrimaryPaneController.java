package pl.calc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import pl.calc.main.FieldCalculate;

import java.awt.*;
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
                calculate.doubleValueVerify(bonusPaneController.getBonusTextField());

                String profit19 = calculate.factor19(bonusPaneController.getPaymentTextField(), "1.9");
                String profit = calculate.bonusFactor(bonusPaneController.getPaymentTextField(), bonusPaneController.getBonusTextField());

                //  DOPISAĆ WYLICZENIA bonusFactor DLA PROFITtEXTfIELD

                FieldCalculate.printTextField(bonusPaneController.getProfitTextField(), profit);
                FieldCalculate.printTextField(bonusPaneController.getProfit19TextField(), profit19);

                String profit1 = calculate.bonusFactor(positionPaneController.getPayment1TextField(),
                        bonusPaneController.getBonusTextField());
                String profit2 = calculate.bonusFactor(positionPaneController.getPayment2TextField(),
                        bonusPaneController.getBonusTextField());
                String profit3 = calculate.bonusFactor(positionPaneController.getPayment3TextField(),
                        bonusPaneController.getBonusTextField());
                String profit4 = calculate.bonusFactor(positionPaneController.getPayment4TextField(),
                        bonusPaneController.getBonusTextField());
                String profit5 = calculate.bonusFactor(positionPaneController.getPayment5TextField(),
                        bonusPaneController.getBonusTextField());

                FieldCalculate.printTextField(positionPaneController.getProfit1TextField(), profit1);
                FieldCalculate.printTextField(positionPaneController.getProfit2TextField(), profit2);
                FieldCalculate.printTextField(positionPaneController.getProfit3TextField(), profit3);
                FieldCalculate.printTextField(positionPaneController.getProfit4TextField(), profit4);
                FieldCalculate.printTextField(positionPaneController.getProfit5TextField(), profit5);
            }
        });

        bonusPaneController.getPaymentTextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                calculate.integerValueVerify(bonusPaneController.getPaymentTextField());

                String profit19 = calculate.factor19(bonusPaneController.getPaymentTextField(), "1.9");
                String profit = calculate.bonusFactor(bonusPaneController.getPaymentTextField(), bonusPaneController.getBonusTextField());

                FieldCalculate.printTextField(bonusPaneController.getProfitTextField(), profit);
                FieldCalculate.printTextField(bonusPaneController.getProfit19TextField(), profit19);

            }
        });

        bonusPaneController.getPointsTextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                calculate.integerValueVerify(bonusPaneController.getPointsTextField());

                Paint red = Paint.valueOf(Integer.toHexString(Color.LIGHT_GRAY.hashCode()));
                bonusPaneController.getPointsTextField().setStyle("-fx-background-color: #" + red.toString().substring(2));
            }
        });



        positionPaneController.getPayment1TextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                calculate.integerValueVerify(positionPaneController.getPayment1TextField());

                String profit19 = calculate.factor19(positionPaneController.getPayment1TextField(), "1.9");
                String profit = calculate.bonusFactor(
                        positionPaneController.getPayment1TextField(), bonusPaneController.getBonusTextField());

                FieldCalculate.printTextField(positionPaneController.getProfit1TextField(), profit);
                FieldCalculate.printTextField(positionPaneController.getPoints1TextField(), profit19);
            }
        });

        positionPaneController.getPayment2TextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                calculate.integerValueVerify(positionPaneController.getPayment2TextField());

                String profit19 = calculate.factor19(positionPaneController.getPayment2TextField(), "1.9");
                String profit = calculate.bonusFactor(
                        positionPaneController.getPayment2TextField(), bonusPaneController.getBonusTextField());

                FieldCalculate.printTextField(positionPaneController.getProfit2TextField(), profit);
                FieldCalculate.printTextField(positionPaneController.getPoints2TextField(), profit19);
            }
        });

        positionPaneController.getPayment3TextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                calculate.integerValueVerify(positionPaneController.getPayment3TextField());

                String profit19 = calculate.factor19(positionPaneController.getPayment3TextField(), "1.9");
                String profit = calculate.bonusFactor(
                        positionPaneController.getPayment3TextField(), bonusPaneController.getBonusTextField());

                FieldCalculate.printTextField(positionPaneController.getProfit3TextField(), profit);
                FieldCalculate.printTextField(positionPaneController.getPoints3TextField(), profit19);
            }
        });

        positionPaneController.getPayment4TextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                calculate.integerValueVerify(positionPaneController.getPayment4TextField());

                String profit19 = calculate.factor19(positionPaneController.getPayment4TextField(), "1.9");
                String profit = calculate.bonusFactor(
                        positionPaneController.getPayment4TextField(), bonusPaneController.getBonusTextField());

                FieldCalculate.printTextField(positionPaneController.getProfit4TextField(), profit);
                FieldCalculate.printTextField(positionPaneController.getPoints4TextField(), profit19);
            }
        });

        positionPaneController.getPayment5TextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                calculate.integerValueVerify(positionPaneController.getPayment5TextField());

                String profit19 = calculate.factor19(positionPaneController.getPayment5TextField(), "1.9");
                String profit = calculate.bonusFactor(
                        positionPaneController.getPayment5TextField(), bonusPaneController.getBonusTextField());

                FieldCalculate.printTextField(positionPaneController.getProfit5TextField(), profit);
                FieldCalculate.printTextField(positionPaneController.getPoints5TextField(), profit19);
            }
        });

        positionPaneController.getRestTextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                calculate.integerValueVerify(positionPaneController.getRestTextField());

            }
        });
    }
}
