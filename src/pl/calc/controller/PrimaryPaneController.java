package pl.calc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import pl.calc.main.FieldCalculate;
import pl.calc.main.Verify;

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
    Verify verify = new Verify();

    String[] pays = new String[8];

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
                verify.doubleValueVerify(bonusPaneController.getBonusTextField());
                calculate.factor(bonusPaneController.getPaymentTextField(),
                        bonusPaneController.getProfit19TextField());
                calculate.factor(bonusPaneController.getPaymentTextField(),
                        bonusPaneController.getBonusTextField(),
                        bonusPaneController.getProfitTextField());

                calculate.factor(positionPaneController.getPayment1TextField(),
                        bonusPaneController.getBonusTextField(),
                        positionPaneController.getProfit1TextField(), true);
                calculate.factor(positionPaneController.getPayment2TextField(),
                        bonusPaneController.getBonusTextField(),
                        positionPaneController.getProfit2TextField(), true);
                calculate.factor(positionPaneController.getPayment3TextField(),
                        bonusPaneController.getBonusTextField(),
                        positionPaneController.getProfit3TextField(), true);
                calculate.factor(positionPaneController.getPayment4TextField(),
                        bonusPaneController.getBonusTextField(),
                        positionPaneController.getProfit4TextField(), true);
                calculate.factor(positionPaneController.getPayment5TextField(),
                        bonusPaneController.getBonusTextField(),
                        positionPaneController.getProfit5TextField(), true);
            }
        });

        bonusPaneController.getPaymentTextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                verify.integerValueVerify(bonusPaneController.getPaymentTextField());
                calculate.factor(bonusPaneController.getPaymentTextField(),
                        bonusPaneController.getProfit19TextField());
                calculate.factor(bonusPaneController.getPaymentTextField(),
                        bonusPaneController.getBonusTextField(),
                        bonusPaneController.getProfitTextField());
            }
        });

        bonusPaneController.getPointsTextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                verify.integerValueVerify(bonusPaneController.getPointsTextField());
                pays[0] = bonusPaneController.getPointsTextField().getText();
            }
        });

        positionPaneController.getPayment1TextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                verify.integerValueVerify(positionPaneController.getPayment1TextField());
                pays[1] = positionPaneController.getPayment1TextField().getText();
                pays[1] = verify.pointsVerify(pays,
                                positionPaneController.getPayment1TextField(),
                                bonusPaneController.getPointsTextField());
                verify.checkGuaranteedPosition(pays,
                        positionPaneController.getPayment1TextField(),
                        positionPaneController.getPayment2TextField()
                );
                calculate.factor(positionPaneController.getPayment1TextField(),
                        bonusPaneController.getBonusTextField(),
                        positionPaneController.getProfit1TextField(), true);
            }
        });

        positionPaneController.getPayment2TextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                verify.integerValueVerify(positionPaneController.getPayment2TextField());

                pays[2] = positionPaneController.getPayment2TextField().getText();
                pays[2] = verify.pointsVerify(pays,
                        positionPaneController.getPayment2TextField(),
                        positionPaneController.getPayment1TextField());
                verify.checkGuaranteedPosition(pays,
                        positionPaneController.getPayment2TextField(),
                        positionPaneController.getPayment3TextField()
                );
                calculate.factor(positionPaneController.getPayment2TextField(),
                        bonusPaneController.getBonusTextField(),
                        positionPaneController.getProfit2TextField(), true);
            }
        });

        positionPaneController.getPayment3TextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                verify.integerValueVerify(positionPaneController.getPayment3TextField());
                pays[3] = positionPaneController.getPayment3TextField().getText();
                pays[3] = verify.pointsVerify(pays,
                        positionPaneController.getPayment3TextField(),
                        positionPaneController.getPayment2TextField());
                verify.checkGuaranteedPosition(pays,
                        positionPaneController.getPayment3TextField(),
                        positionPaneController.getPayment4TextField()
                );
                calculate.factor(positionPaneController.getPayment3TextField(),
                        bonusPaneController.getBonusTextField(),
                        positionPaneController.getProfit3TextField(), true);
            }
        });

        positionPaneController.getPayment4TextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                verify.integerValueVerify(positionPaneController.getPayment4TextField());
                pays[4] = positionPaneController.getPayment4TextField().getText();
                pays[4] = verify.pointsVerify(pays,
                        positionPaneController.getPayment4TextField(),
                        positionPaneController.getPayment3TextField());
                verify.checkGuaranteedPosition(pays,
                        positionPaneController.getPayment4TextField(),
                        positionPaneController.getPayment5TextField()
                );
                calculate.factor(positionPaneController.getPayment4TextField(),
                        bonusPaneController.getBonusTextField(),
                        positionPaneController.getProfit4TextField(), true);
            }
        });

        positionPaneController.getPayment5TextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                verify.integerValueVerify(positionPaneController.getPayment5TextField());
                pays[5] = positionPaneController.getPayment5TextField().getText();
                pays[5] = verify.pointsVerify(pays,
                        positionPaneController.getPayment5TextField(),
                        positionPaneController.getPayment4TextField());
                verify.checkGuaranteedPosition(pays,
                        positionPaneController.getPayment5TextField(),
                        positionPaneController.getPayment6TextField()
                );
                calculate.factor(positionPaneController.getPayment5TextField(),
                        bonusPaneController.getBonusTextField(),
                        positionPaneController.getProfit5TextField(), true);
            }
        });

        positionPaneController.getPayment6TextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                verify.integerValueVerify(positionPaneController.getPayment6TextField());
                pays[6] = positionPaneController.getPayment6TextField().getText();
                pays[6] = verify.pointsVerify(pays,
                        positionPaneController.getPayment6TextField(),
                        positionPaneController.getPayment5TextField());
                verify.checkGuaranteedPosition(pays,
                        positionPaneController.getPayment6TextField(),
                        positionPaneController.getRestTextField()
                );
            }
        });

        positionPaneController.getRestTextField().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                verify.integerValueVerify(positionPaneController.getRestTextField());
                pays[7] = positionPaneController.getRestTextField().getText();
                pays[7] = verify.pointsVerify(pays,
                        positionPaneController.getRestTextField(),
                        positionPaneController.getPayment6TextField());
            }
        });
    }
}
