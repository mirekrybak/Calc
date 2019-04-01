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
    String[] pays = new String[6];
    private boolean enough;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (int i = 0; i < pays.length; i++) {
            pays[i] = "0";
        }

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Application closing ...");
                System.exit(0);
            }
        });

        bonusPaneController.getBonusTextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                calculate.doubleValueVerify(bonusPaneController.getBonusTextField());
                calculate.factor(bonusPaneController.getPaymentTextField(),
                        bonusPaneController.getProfit19TextField());
                calculate.factor(bonusPaneController.getPaymentTextField(),
                        bonusPaneController.getBonusTextField(),
                        bonusPaneController.getProfitTextField());

//                String profit19 = calculate.factor19(bonusPaneController.getPaymentTextField(), "1.9");
//                String profit = calculate.bonusFactor(bonusPaneController.getPaymentTextField(),
//                        bonusPaneController.getBonusTextField());
//
//                FieldCalculate.printTextField(bonusPaneController.getProfitTextField(), profit);
//                FieldCalculate.printTextField(bonusPaneController.getProfit19TextField(), profit19);
//
                calculate.factor(positionPaneController.getPayment1TextField(),
                        bonusPaneController.getBonusTextField(),
                        positionPaneController.getProfit1TextField(), true);
//                String profit1 = calculate.bonusFactor(positionPaneController.getPayment1TextField(),
//                        bonusPaneController.getBonusTextField(), true);
//                String profit2 = calculate.bonusFactor(positionPaneController.getPayment2TextField(),
//                        bonusPaneController.getBonusTextField(), true);
//                String profit3 = calculate.bonusFactor(positionPaneController.getPayment3TextField(),
//                        bonusPaneController.getBonusTextField(), true);
//                String profit4 = calculate.bonusFactor(positionPaneController.getPayment4TextField(),
//                        bonusPaneController.getBonusTextField(), true);
//                String profit5 = calculate.bonusFactor(positionPaneController.getPayment5TextField(),
//                        bonusPaneController.getBonusTextField(), true);
//
//                FieldCalculate.printTextField(positionPaneController.getProfit1TextField(), profit1);
//                FieldCalculate.printTextField(positionPaneController.getProfit2TextField(), profit2);
//                FieldCalculate.printTextField(positionPaneController.getProfit3TextField(), profit3);
//                FieldCalculate.printTextField(positionPaneController.getProfit4TextField(), profit4);
//                FieldCalculate.printTextField(positionPaneController.getProfit5TextField(), profit5);
            }
        });

        bonusPaneController.getPaymentTextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                calculate.integerValueVerify(bonusPaneController.getPaymentTextField());
                calculate.factor(bonusPaneController.getPaymentTextField(),
                        bonusPaneController.getProfit19TextField());
                calculate.factor(bonusPaneController.getPaymentTextField(),
                        bonusPaneController.getBonusTextField(),
                        bonusPaneController.getProfitTextField());

//                String profit19 = calculate.factor19(bonusPaneController.getPaymentTextField(), "1.9");
//                String profit = calculate.bonusFactor(bonusPaneController.getPaymentTextField(),
//                        bonusPaneController.getBonusTextField());
//
//                FieldCalculate.printTextField(bonusPaneController.getProfitTextField(), profit);
//                FieldCalculate.printTextField(bonusPaneController.getProfit19TextField(), profit19);

            }
        });

        bonusPaneController.getPointsTextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                calculate.integerValueVerify(bonusPaneController.getPointsTextField());
            }
        });

        positionPaneController.getPayment1TextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                calculate.integerValueVerify(positionPaneController.getPayment1TextField());
                pays[1] = positionPaneController.getPayment1TextField().getText();

//                String profit = calculate.bonusFactor(
//                        positionPaneController.getPayment1TextField(), bonusPaneController.getBonusTextField(), true);
//                FieldCalculate.printTextField(positionPaneController.getProfit1TextField(), profit);

                calculate.factor(positionPaneController.getPayment1TextField(),
                        bonusPaneController.getBonusTextField(),
                        positionPaneController.getProfit1TextField(), true);
                calculate.checkProvidedPosition(pays,
                        positionPaneController.getPayment1TextField(),
                        positionPaneController.getPayment2TextField(),
                        bonusPaneController.getPointsTextField());

//                enough = calculate.check(pays,
//                        positionPaneController.getPayment1TextField(),
//                        positionPaneController.getPayment2TextField(),
//                        bonusPaneController.getPointsTextField());
//
//                if (enough) {
//                    positionPaneController.getPayment1TextField().setStyle("-fx-background-color: #65ff00");
//                } else {
//                    positionPaneController.getPayment1TextField().setStyle("-fx-background-color: #ff321e");
//                }
            }
        });

        positionPaneController.getPayment2TextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                calculate.integerValueVerify(positionPaneController.getPayment2TextField());
                pays[2] = positionPaneController.getPayment2TextField().getText();

                calculate.factor(positionPaneController.getPayment2TextField(),
                        bonusPaneController.getBonusTextField(),
                        positionPaneController.getProfit2TextField(), true);
                calculate.checkProvidedPosition(pays,
                        positionPaneController.getPayment2TextField(),
                        positionPaneController.getPayment3TextField(),
                        bonusPaneController.getPointsTextField());

//                String profit = calculate.bonusFactor(
//                        positionPaneController.getPayment2TextField(), bonusPaneController.getBonusTextField(), true);
//                FieldCalculate.printTextField(positionPaneController.getProfit2TextField(), profit);
//
//                enough = calculate.check(pays,
//                        positionPaneController.getPayment2TextField(),
//                        positionPaneController.getPayment3TextField(),
//                        bonusPaneController.getPointsTextField());
//
//                if (enough) {
//                    positionPaneController.getPayment2TextField().setStyle("-fx-background-color: #65ff00");
//                } else {
//                    positionPaneController.getPayment2TextField().setStyle("-fx-background-color: #ff321e");
//                }
            }


        });

        positionPaneController.getPayment3TextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                calculate.integerValueVerify(positionPaneController.getPayment3TextField());
                pays[3] = positionPaneController.getPayment3TextField().getText();

                calculate.factor(positionPaneController.getPayment3TextField(),
                        bonusPaneController.getBonusTextField(),
                        positionPaneController.getProfit3TextField(), true);
                calculate.checkProvidedPosition(pays,
                        positionPaneController.getPayment3TextField(),
                        positionPaneController.getPayment4TextField(),
                        bonusPaneController.getPointsTextField());
//                String profit = calculate.bonusFactor(
//                        positionPaneController.getPayment3TextField(), bonusPaneController.getBonusTextField(), true);
//                FieldCalculate.printTextField(positionPaneController.getProfit3TextField(), profit);
//
//                enough = calculate.check(pays,
//                        positionPaneController.getPayment3TextField(),
//                        positionPaneController.getPayment4TextField(),
//                        bonusPaneController.getPointsTextField());
//
//                if (enough) {
//                    positionPaneController.getPayment3TextField().setStyle("-fx-background-color: #65ff00");
//                } else {
//                    positionPaneController.getPayment3TextField().setStyle("-fx-background-color: #ff321e");
//                }
            }
        });

        positionPaneController.getPayment4TextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                calculate.integerValueVerify(positionPaneController.getPayment4TextField());
                pays[4] = positionPaneController.getPayment4TextField().getText();

                calculate.factor(positionPaneController.getPayment4TextField(),
                        bonusPaneController.getBonusTextField(),
                        positionPaneController.getProfit4TextField(), true);
                calculate.checkProvidedPosition(pays,
                        positionPaneController.getPayment4TextField(),
                        positionPaneController.getPayment5TextField(),
                        bonusPaneController.getPointsTextField());
//                String profit = calculate.bonusFactor(
//                        positionPaneController.getPayment4TextField(), bonusPaneController.getBonusTextField(), true);
//                FieldCalculate.printTextField(positionPaneController.getProfit4TextField(), profit);
//
//                enough = calculate.check(pays,
//                        positionPaneController.getPayment4TextField(),
//                        positionPaneController.getPayment5TextField(),
//                        bonusPaneController.getPointsTextField());
//
//                if (enough) {
//                    positionPaneController.getPayment4TextField().setStyle("-fx-background-color: #65ff00");
//                } else {
//                    positionPaneController.getPayment4TextField().setStyle("-fx-background-color: #ff321e");
//                }
            }
        });

        positionPaneController.getPayment5TextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                calculate.integerValueVerify(positionPaneController.getPayment5TextField());
                pays[5] = positionPaneController.getPayment5TextField().getText();

                calculate.factor(positionPaneController.getPayment5TextField(),
                        bonusPaneController.getBonusTextField(),
                        positionPaneController.getProfit5TextField(), true);
                calculate.checkProvidedPosition(pays,
                        positionPaneController.getPayment5TextField(),
                        positionPaneController.getRestTextField(),
                        bonusPaneController.getPointsTextField());

//                String profit = calculate.bonusFactor(
//                        positionPaneController.getPayment5TextField(), bonusPaneController.getBonusTextField(), true);
//                FieldCalculate.printTextField(positionPaneController.getProfit5TextField(), profit);
//
//                enough = calculate.check(pays,
//                        positionPaneController.getPayment5TextField(),
//                        positionPaneController.getRestTextField(),
//                        bonusPaneController.getPointsTextField());
//
//                if (enough) {
//                    positionPaneController.getPayment5TextField().setStyle("-fx-background-color: #65ff00");
//                } else {
//                    positionPaneController.getPayment5TextField().setStyle("-fx-background-color: #ff321e");
//                }
            }
        });

        positionPaneController.getRestTextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                calculate.integerValueVerify(positionPaneController.getRestTextField());
                pays[0] = positionPaneController.getRestTextField().getText();
            }
        });
    }
}
