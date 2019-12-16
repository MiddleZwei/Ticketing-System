package com.s15920;

import com.s15920.Utility.AlertHelper;
import com.s15920.Utility.Utility;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static com.ibm.icu.impl.ValidIdentifiers.Datatype.t;

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
            LocalDate from = this.from.getValue();
            LocalDate to = this.to.getValue();

            System.out.println("-------------------");
            if (from == null || to ==  null){
                System.out.println("Start date: " + from);
                System.out.println("End date: " + to);
                showNullDatesWarning();
            } else {
                Date f = java.sql.Date.valueOf(from);
                Date t =java.sql.Date.valueOf(to);
                int status=f.compareTo(t);
                if (status>0) {
                    System.out.println(f + " is greater than "+ t);
                    showWrongDatesWarning();
                } else {
                    if (status==0) System.out.println(f + " equals " + t+ " : " + (String.valueOf(f).equals(String.valueOf(t))));
                    if (status<0) System.out.println(f + " is lower than "+ t);

                    System.out.println("-------------------");
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/concerts.fxml"));
                    Utility.loadNewScene(fxmlLoader, f, t);
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void showNullDatesWarning() {
        try {
            Window owner = showCustomersButton.getScene().getWindow();
            AlertHelper.showAlert(Alert.AlertType.WARNING, owner, "WARNING", "You haven't provided the range of dates");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void showWrongDatesWarning() {
        try {
            Window owner = showCustomersButton.getScene().getWindow();
            AlertHelper.showAlert(Alert.AlertType.WARNING, owner, "WARNING", "End date cannot be earlier than the start date");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void handleShowAllCustomers(ActionEvent event) throws IOException {
        try {
            Window owner = showCustomersButton.getScene().getWindow();
            AlertHelper.showAlert(Alert.AlertType.WARNING, owner, "WARNING", "Not supported yet.");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void handleLogOutButton(ActionEvent event) throws IOException {
        try {
            Platform.exit();
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
