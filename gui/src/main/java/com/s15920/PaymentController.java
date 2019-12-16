package com.s15920;

import com.s15920.Utility.AlertHelper;
import com.s15920.Utility.Utility;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.IOException;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    public void handleReceiptCopyButton(ActionEvent actionEvent) {
        System.out.println("receipt ticket");
        notSupportedWindowWarning();
    }

    @FXML
    public void handleTicketCopyButton(ActionEvent actionEvent) {
        System.out.println("copy ticket");
        notSupportedWindowWarning();
    }


    public void handleThankYouWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/thankyou.fxml"));
            Utility.loadNewScene(fxmlLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void handleBackButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu.fxml"));
            Utility.loadNewScene(fxmlLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void notSupportedWindowWarning() {
        try {
            Window owner = ticketCopyButton.getScene().getWindow();
            AlertHelper.showAlert(Alert.AlertType.WARNING, owner, "WARNING", "Not supported yet.");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
