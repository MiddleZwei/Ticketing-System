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

public class ThankYouController implements Initializable {
    @FXML
    private Button exitButton;

    @FXML
    private Button ticketCopyButton;

    @FXML
    private Button receiptCopyButton;

    @FXML
    public void handleReceiptCopyButton(ActionEvent actionEvent) {
        try {
            // TODO
            System.out.println("copy receipt");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void handleExitButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu.fxml"));
            Utility.loadNewScene(fxmlLoader);
//            Utility.closeAll();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void handleTicketCopyButton(ActionEvent actionEvent) {
        try {
            // TODO
            System.out.println("copy ticket");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
