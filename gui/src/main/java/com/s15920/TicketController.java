package com.s15920;

import com.s15920.Utility.Utility;
import com.s15920.model.Person;
import com.s15920.model.Purchase;
import com.s15920.service.IPersonService;
import com.s15920.service.IPurchaseService;
import com.s15920.service.PersonService;
import com.s15920.service.PurchaseService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class TicketController implements Initializable {

    IPurchaseService purchaseService;
    IPersonService personService;

    private String details;
    private String ticketNumber;

    @FXML
    private Text ticketNumberTitle;

    @FXML
    private TextArea detailsText;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private CheckBox emailCheck = new CheckBox("Email receipt checkbox");
    private Boolean emailCheckBool = Boolean.FALSE;;

    @FXML
    private CheckBox personalDataCheck = new CheckBox("Personal data checkbox");
    private Boolean personalDataCheckBool = Boolean.FALSE;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField emailField;

    @FXML
    private TextField mobileField;


    @FXML
    private Button backButton;

    @FXML
    private Button submitAndPayButton;



    public TicketController(String ticketId, String details) {
        this.ticketNumber = ticketId;
        this.details = details;
    }

    public TicketController() {
    }

    private void setupCheckerListeners() {
        emailCheck.selectedProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("------------------");
            if(newValue){
                System.out.println("CheckBox: "+ emailCheck.getText());
                System.out.println("Old value: "+ oldValue);
                System.out.println("New value value: "+ newValue);
            }else{
                System.out.println("CheckBox: "+ emailCheck.getText());
                System.out.println("Old value: "+ oldValue);
                System.out.println("New value value: "+ newValue);
            }
            emailCheckBool = newValue;
            System.out.println("------------------");
        });

        personalDataCheck.selectedProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("------------------");
            if(newValue){
                System.out.println("CheckBox: "+ personalDataCheck.getText());
                System.out.println("Old value: "+ oldValue);
                System.out.println("New value value: "+ newValue);
            }else{
                System.out.println("CheckBox: "+ personalDataCheck.getText());
                System.out.println("Old value: "+ oldValue);
                System.out.println("New value value: "+ newValue);
            }
            personalDataCheckBool = newValue;
            System.out.println("------------------");
        });
    }

    @FXML
    public void handleSubmitAndPayButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/payment.fxml"));
            String fn = firstName.getText();
            String ln = lastName.getText();
            String email = emailField.getText();
            String mobile = mobileField.getText();

            System.out.println("--------------------------------------");
            System.out.println("Selected first name: "+firstName);
            System.out.println("Selected last name from: "+lastName);
            System.out.println("Selected email: "+email);
            System.out.println("Selected mobile: "+mobile);

            Person person = personService.saveOrUpdate(fn, ln, email, mobile);


            Byte ec = (byte)(emailCheckBool?1:0);
            Byte pdc = (byte)(personalDataCheckBool?1:0);

            System.out.println("Selected email checkbox: "+ec);
            System.out.println("Selected personal data checkbox: "+pdc);

            purchaseService.saveOrUpdate(person, ec, pdc);

            System.out.println("--------------------------------------");

            Utility.loadNewScene(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void handleBackButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu.fxml"));
            Utility.loadNewScene(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        purchaseService = new PurchaseService();
        personService = new PersonService();
        setupCheckerListeners();

    }

    public void setDetails(String details) {
        this.detailsText.setText(details);
    }

    public String getDetails() {
        return details;
    }

    public void setTicketNumberTitle(String ticketNumberTitle) {
        this.ticketNumberTitle.setText(ticketNumberTitle);
    }

    public String getTicketNumberTitle() {
        return ticketNumber;
    }
}
