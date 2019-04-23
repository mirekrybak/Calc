package pl.calc.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PositionPaneController {

    @FXML
    private TextField payment1TextField;

    @FXML
    private TextField payment2TextField;

    @FXML
    private TextField payment3TextField;

    @FXML
    private TextField payment4TextField;

    @FXML
    private TextField payment5TextField;

    @FXML
    private TextField payment6TextField;

    @FXML
    private TextField restTextField;

    @FXML
    private TextField profit1TextField;

    @FXML
    private TextField profit2TextField;

    @FXML
    private TextField profit3TextField;

    @FXML
    private TextField profit4TextField;

    @FXML
    private TextField profit5TextField;


    public TextField getPayment1TextField() {
        return payment1TextField;
    }

    public TextField getPayment2TextField() {
        return payment2TextField;
    }

    public TextField getPayment3TextField() {
        return payment3TextField;
    }

    public TextField getPayment4TextField() {
        return payment4TextField;
    }

    public TextField getPayment5TextField() {
        return payment5TextField;
    }

    public TextField getPayment6TextField() { return payment6TextField; }

    public TextField getRestTextField() {
        return restTextField;
    }

    public TextField getProfit1TextField() { return profit1TextField; }

    public TextField getProfit2TextField() {
        return profit2TextField;
    }

    public TextField getProfit3TextField() {
        return profit3TextField;
    }

    public TextField getProfit4TextField() {
        return profit4TextField;
    }

    public TextField getProfit5TextField() {
        return profit5TextField;
    }

}
