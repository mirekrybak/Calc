package pl.calc.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PositionPaneController implements Initializable {

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

    public void setPayment1TextField(TextField payment1TextField) {
        this.payment1TextField = payment1TextField;
    }

    public TextField getPayment2TextField() {
        return payment2TextField;
    }

    public void setPayment2TextField(TextField payment2TextField) {
        this.payment2TextField = payment2TextField;
    }

    public TextField getPayment3TextField() {
        return payment3TextField;
    }

    public void setPayment3TextField(TextField payment3TextField) {
        this.payment3TextField = payment3TextField;
    }

    public TextField getPayment4TextField() {
        return payment4TextField;
    }

    public void setPayment4TextField(TextField payment4TextField) {
        this.payment4TextField = payment4TextField;
    }

    public TextField getPayment5TextField() {
        return payment5TextField;
    }

    public void setPayment5TextField(TextField payment5TextField) {
        this.payment5TextField = payment5TextField;
    }

    public TextField getRestTextField() {
        return restTextField;
    }

    public void setRestTextField(TextField restTextField) {
        this.restTextField = restTextField;
    }

    public TextField getProfit1TextField() {
        return profit1TextField;
    }

    public void setProfit1TextField(TextField profit1TextField) {
        this.profit1TextField = profit1TextField;
    }

    public TextField getProfit2TextField() {
        return profit2TextField;
    }

    public void setProfit2TextField(TextField profit2TextField) {
        this.profit2TextField = profit2TextField;
    }

    public TextField getProfit3TextField() {
        return profit3TextField;
    }

    public void setProfit3TextField(TextField profit3TextField) {
        this.profit3TextField = profit3TextField;
    }

    public TextField getProfit4TextField() {
        return profit4TextField;
    }

    public void setProfit4TextField(TextField profit4TextField) {
        this.profit4TextField = profit4TextField;
    }

    public TextField getProfit5TextField() {
        return profit5TextField;
    }

    public void setProfit5TextField(TextField profit5TextField) {
        this.profit5TextField = profit5TextField;
    }

    public TextField getPoints1TextField() {
        return points1TextField;
    }

    public void setPoints1TextField(TextField points1TextField) {
        this.points1TextField = points1TextField;
    }

    @FXML

    private TextField points1TextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("--->        Init PositionPaneController ...");
    }
}
