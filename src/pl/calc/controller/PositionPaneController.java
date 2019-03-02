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

    @FXML
    private TextField points1TextField;

    @FXML
    private TextField points2TextField;

    @FXML
    private TextField points3TextField;

    @FXML
    private TextField points4TextField;

    @FXML
    private TextField points5TextField;


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

    public TextField getRestTextField() {
        return restTextField;
    }

    public TextField getProfit1TextField() {
        return profit1TextField;
    }

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

    public TextField getPoints1TextField() {
        return points1TextField;
    }

    public TextField getPoints2TextField() {
        return points2TextField;
    }

    public TextField getPoints3TextField() {
        return points3TextField;
    }

    public TextField getPoints4TextField() {
        return points4TextField;
    }

    public TextField getPoints5TextField() {
        return points5TextField;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("--->        Init PositionPaneController ...");
    }
}
