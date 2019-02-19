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
            }
        });

        bonusPaneController.getPaymentTextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                String text = calculate.intFormatVerify(bonusPaneController.getPaymentTextField().getText());

                bonusPaneController.getPaymentTextField().clear();
                bonusPaneController.getPaymentTextField().setText(text);
                bonusPaneController.getPaymentTextField().positionCaret(text.length());
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
