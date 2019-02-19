package pl.calc.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainPaneController implements Initializable {

    @FXML
    private TextField payTextField1;

    @FXML
    private TextField payTextField2;

    @FXML
    private TextField payTextField3;

    @FXML
    private TextField payTextField4;

    @FXML
    private TextField payTextField5;

    @FXML
    private TextField payTextField6;

    @FXML
    private Label pointLabel;

    @FXML
    private Label profitLabel1;

    @FXML
    private Label profitLabel2;

    @FXML
    private Label profitLabel3;

    @FXML
    private Label profitLabel4;

    @FXML
    private Label profitLabel5;

    @FXML
    private TextField bonusTextField;

    @FXML
    private Button exitButton;

    @FXML
    private TextField paymentTextField;

    @FXML
    private Label profitPointsLabel;

    @FXML
    private TextField pointsValuesTextField;

    private Logic logic;                                //  L O G I K A

    public TextField getPayTextField1() {
        return payTextField1;
    }

    public void setPayTextField1(TextField payTextField1) {
        this.payTextField1 = payTextField1;
    }

    public TextField getPayTextField2() {
        return payTextField2;
    }

    public void setPayTextField2(TextField payTextField2) {
        this.payTextField2 = payTextField2;
    }

    public TextField getPayTextField3() {
        return payTextField3;
    }

    public void setPayTextField3(TextField payTextField3) {
        this.payTextField3 = payTextField3;
    }

    public TextField getPayTextField4() {
        return payTextField4;
    }

    public void setPayTextField4(TextField payTextField4) {
        this.payTextField4 = payTextField4;
    }

    public TextField getPayTextField5() {
        return payTextField5;
    }

    public void setPayTextField5(TextField payTextField5) {
        this.payTextField5 = payTextField5;
    }

    public Label getPointLabel() {
        return pointLabel;
    }

    public void setPointLabel(Label pointLabel) {
        this.pointLabel = pointLabel;
    }

    public Label getProfitLabel1() {
        return profitLabel1;
    }

    public void setProfitLabel1(Label profitLabel1) {
        this.profitLabel1 = profitLabel1;
    }

    public Label getProfitLabel2() {
        return profitLabel2;
    }

    public void setProfitLabel2(Label profitLabel2) {
        this.profitLabel2 = profitLabel2;
    }

    public Label getProfitLabel3() {
        return profitLabel3;
    }

    public void setProfitLabel3(Label profitLabel3) {
        this.profitLabel3 = profitLabel3;
    }

    public Label getProfitLabel4() {
        return profitLabel4;
    }

    public void setProfitLabel4(Label profitLabel4) {
        this.profitLabel4 = profitLabel4;
    }

    public Label getProfitLabel5() {
        return profitLabel5;
    }

    public void setProfitLabel5(Label profitLabel5) {
        this.profitLabel5 = profitLabel5;
    }

    public TextField getBonusTextField() {
        return bonusTextField;
    }

    public void setBonusTextField(TextField bonusTextField) {
        this.bonusTextField = bonusTextField;
    }

    public TextField getPaymentTextField() {
        return paymentTextField;
    }

    public void setPaymentTextField(TextField paymentTextField) {
        this.paymentTextField = paymentTextField;
    }

    public Label getProfitPointsLabel() {
        return profitPointsLabel;
    }

    public void setProfitPointsLabel(Label profitPointsLabel) {
        this.profitPointsLabel = profitPointsLabel;
    }

    public TextField getPointsValuesTextField() {
        return pointsValuesTextField;
    }

    public void setPointsValuesTextField(TextField pointsValuesTextField) {
        this.pointsValuesTextField = pointsValuesTextField;
    }

    public Button getExitButton() {
        return exitButton;
    }

    public void setExitButton(Button exitButton) {
        this.exitButton = exitButton;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(-1);
            }
        });

        payTextField1.addEventFilter(KeyEvent.KEY_RELEASED, x -> profitLabel1.setText(getPayTextField1().getText()));

        payTextField2.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                String text = getPayTextField2().getText();
                try {
                    text.chars().map(c -> Integer.parseInt(text)).forEach(d -> profitLabel2.setText(payTextField2.getText()));
                } catch (NumberFormatException e) {
                    payTextField2.clear();
                    payTextField2.setText(text.substring(0, text.length()-1));
                    payTextField2.positionCaret(text.length());
                    profitLabel2.setText(text.substring(0,text.length()-1));
                }
             }
        });
    }
}


//      12a32                   3 0 4