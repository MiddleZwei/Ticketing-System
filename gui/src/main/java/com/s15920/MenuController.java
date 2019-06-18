package com.s15920;

import com.s15920.Utility.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private TextField nameField;

    @FXML
    private DatePicker from;

    @FXML
    private DatePicker to;

    @FXML
    private Button logOutButton;

    @FXML
    private Button showConcertsButton;

    @FXML
    private Button showCustomersButton;

    @FXML
    protected void handleShowConcerts(ActionEvent event) throws IOException {
        try {
            Date f = java.sql.Date.valueOf(this.from.getValue());
            Date t =java.sql.Date.valueOf(this.to.getValue());
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/concerts.fxml"));
            Utility.loadNewScene(fxmlLoader, f, t);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleShowCustomers(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
