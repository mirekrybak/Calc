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
                calculate.checkDoubleValue(bonusPaneController.getBonusTextField());


//                    String profit = String.valueOf(
//                            calculate.value(ratio).multiply(
//                                            calculate.value(bonusPaneController.getPaymentTextField().getText())));

//                    bonusPaneController.getProfitTextField().setText(profit);



            }
        });

        bonusPaneController.getPaymentTextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                calculate.checkIntegerValue(bonusPaneController.getPaymentTextField());
                String profit = String.valueOf(
                        calculate.value("1.9").multiply(
                                calculate.value(bonusPaneController.getPaymentTextField().getText())));
                FieldCalculate.printTextField(profit, bonusPaneController.getProfit19TextField());

            }
        });

        bonusPaneController.getPointsTextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                calculate.checkIntegerValue(bonusPaneController.getPointsTextField());
            }
        });

    }




}
