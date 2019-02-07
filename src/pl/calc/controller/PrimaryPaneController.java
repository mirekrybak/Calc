package pl.calc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryPaneController implements Initializable {

    @FXML
    PositionPaneController positionPaneController;

    @FXML
    BonusPaneController bonusPaneController;

    @FXML
    private Button exitButton;

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
                String text = bonusPaneController.getBonusTextField().getText();
                String[] numbers = text.split("\\.");
                double bonus = 0;

                if (text.length() > 0) {
                    try {
                        bonus = Double.parseDouble(text);
                    } catch (NumberFormatException e) {
                        bonusPaneController.getBonusTextField().clear();
                        bonusPaneController.getBonusTextField().setText(text.substring(0, text.length() - 1));
                        bonusPaneController.getBonusTextField().positionCaret(text.length());
                    }

                    System.err.println(bonus);
                }
            }
        });

        //String text = position.getPayment1TextField().getText();

//        payTextField2.setOnKeyReleased(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//
//
//            }
//        });

    }
}
