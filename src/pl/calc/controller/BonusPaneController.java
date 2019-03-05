package pl.calc.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BonusPaneController {

    @FXML
    private TextField bonusTextField;

    @FXML
    private TextField paymentTextField;

    @FXML
    private TextField profit19TextField;

    @FXML
    private TextField profitTextField;

    @FXML
    private TextField pointsTextField;

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

    public TextField getProfit19TextField() {
        return profit19TextField;
    }

    public void setProfit19TextField(TextField profit19TextField) {
        this.profit19TextField = profit19TextField;
    }

    public TextField getProfitTextField() {
        return profitTextField;
    }

    public void setProfitTextField(TextField profitTextField) {
        this.profitTextField = profitTextField;
    }

    public TextField getPointsTextField() {
        return pointsTextField;
    }

    public void setPointsTextField(TextField pointsTextField) {
        this.pointsTextField = pointsTextField;
    }

}
