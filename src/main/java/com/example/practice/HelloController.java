package com.example.practice;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Label welcomeText;
    @FXML
    public ComboBox<CountryCodeFactory> Fromcb;
    @FXML
    public ComboBox<CountryCodeFactory> Tocb;
    @FXML
    private TextField amountTextfield;
    @FXML
    private Button convertbutton;
    @FXML
    private Label convertLabel;
    @FXML
    private TextField convertedTextfield;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    private Label convertedAmountValueLabel;
    @FXML
    private Label negativeLabel;
    float amount;

    CountryCodeFactory[] countryCodes = {};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println("Initialize is calling.");
        countryCodes = CountryCodeFactory.values();

        Fromcb.setItems(FXCollections.observableArrayList(CountryCodeFactory.values()));
        Tocb.setItems(FXCollections.observableArrayList(CountryCodeFactory.values()));
    }

    @FXML
    public void convertButtonaction(ActionEvent event) throws IOException {

        DecimalFormat f = new DecimalFormat("0.00");

        negativeLabel.setText("");
        convertLabel.setText("");
        convertedAmountValueLabel.setText("");


       String fromCode = Fromcb.getSelectionModel().getSelectedItem().toString();

       CountryCodeFactory fromCodeResult = CountryCodeFactory.findByName(fromCode);

       String toCode = Tocb.getSelectionModel().getSelectedItem().toString();

       CountryCodeFactory toCodeResult = CountryCodeFactory.findByName(toCode);

        System.out.println("working button");
        amount = Float.parseFloat(amountTextfield.getText());
        if (amount <= 0 )
        {
            System.out.println("Invalid Amount");
            negativeLabel.setText("Invalid Amount");
        }

       else
        {
            double convertedAmount;
            try {

                convertedAmount = NetworkLayer.getSharedObject().getLatestCurrency(fromCodeResult.getValue(), toCodeResult.getValue(), amount);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            DecimalFormat d = new DecimalFormat("0.00");

//        convertedTextfield.setText(d.format(convertedAmount));
            convertLabel.setText("Converted Amount");

            convertedAmountValueLabel.setText(d.format(convertedAmount));
        }

    }




}


