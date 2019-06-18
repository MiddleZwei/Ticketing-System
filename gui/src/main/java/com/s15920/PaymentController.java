package com.s15920;

import com.s15920.Utility.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {
    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;


    @FXML
    private Button backButton;

    @FXML
    private Button ticketCopyButton;

    @FXML
    private Button receiptCopyButton;

    @FXML
    public void handleReceiptCopyButton(ActionEvent actionEvent) {
        try {
            // TODO
            System.out.println("copy receipt");
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/payment.fxml"));
//            Utility.loadNewScene(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void handleBackButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ticket.fxml"));
            Utility.loadNewScene(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void handleTicketCopyButton(ActionEvent actionEvent) {
        try {
            // TODO
            System.out.println("copy ticket");
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/single_concert.fxml"));
//            Utility.loadNewScene(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
