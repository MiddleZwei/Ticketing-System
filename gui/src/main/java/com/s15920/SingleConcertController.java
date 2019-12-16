package com.s15920;

import com.s15920.Utility.Utility;
import com.s15920.model.Ticket;
import com.s15920.service.ITicketService;
import com.s15920.service.TicketService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SingleConcertController implements Initializable {

    private ITicketService ticketService;

    List<Ticket> tickets;

    @FXML
    private Text concertNameTextField;
    private String concertName;


    private Date from;
    private Date to;
    private int concertId;

    public SingleConcertController(int concertId, String concertName) {
        this.concertId = concertId;
        this.concertName = concertName;
//        this.from = from;
//        this.to = to;
    }

    public SingleConcertController() {
    }

    @FXML
    TableColumn<List<StringProperty>, String> titleColumn = new TableColumn<>("title");
    @FXML
    TableColumn<List<StringProperty>, String> seatColumn = new TableColumn<>("seat");
    @FXML
    TableColumn<List<StringProperty>, String> rowColumn = new TableColumn<>("row");
    @FXML
    TableColumn<List<StringProperty>, String> fromColumn = new TableColumn<>("from");
    @FXML
    TableColumn<List<StringProperty>, String> toColumn = new TableColumn<>("to");

    @FXML
    private TableView<List<StringProperty>> tableTickets;

    @FXML
    private AnchorPane anchorPane;


    @FXML
    private Button purchaseButton;

    @FXML
    private Button backButton;


    @FXML
    public void initialize(URL url, ResourceBundle rb) {

        System.out.println("init single concert controller");
        ticketService = new TicketService();
        tickets = new ArrayList<>();
        buildData();
    }

    private void buildData() {
        ObservableList<List<StringProperty>> data = FXCollections.observableArrayList();
        tickets = ticketService.getTicketsByConcertId(concertId); // FIXME
        System.out.println("Single concert :"+concertId);
        for (Ticket c : tickets){ // FIXME display all concerts, the last one 5 times
//            System.out.println(c);

            List<StringProperty> row = new ArrayList<>();

            titleColumn.setCellValueFactory(cdf -> new SimpleStringProperty(c.getTitle()));
            seatColumn.setCellValueFactory(cdf -> new SimpleStringProperty("seat number"));
            rowColumn.setCellValueFactory(cdf -> new SimpleStringProperty("seat row"));
            fromColumn.setCellValueFactory(cdf -> new SimpleStringProperty(c.getValidFrom().toString()));
            toColumn.setCellValueFactory(cdf -> new SimpleStringProperty(c.getValidTo().toString()));

            data.add(row);
        }

        tableTickets.setItems(data);
    }

    @FXML
    protected void handleBackButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu.fxml"));
            Utility.loadNewScene(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void handlePurchaseButton(ActionEvent actionEvent) {
        try {
            System.out.println("Pressed purchase button");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ticket.fxml"));
            for(TablePosition row : tableTickets.getSelectionModel().getSelectedCells()){
                String ticketId = tickets.get(row.getRow()).getConcertId();
                String from = tickets.get(row.getRow()).getValidFrom().toString();
                String to = tickets.get(row.getRow()).getValidTo().toString();
                String concertName = this.concertName;
                int row_ = 0;
                int seat_ = 0;
                System.out.println("--------------------------------------");
                System.out.println("Selected ticket id: "+ticketId);
                System.out.println("Selected valid from: "+from);
                System.out.println("Selected valid to: "+to);
                System.out.println("Selected concert name: "+concertName);
                System.out.println("Selected row: "+row_);
                System.out.println("Selected seat: "+seat_);
                System.out.println("--------------------------------------");
                Utility.loadNewScene(fxmlLoader, ticketId, from, to, concertName, row_, seat_);
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setConcertName(String concertName) {
        System.out.println("SingleController setter controller got: "+concertName);
        this.concertNameTextField.setText(concertName);
//        this.concertName = concertName;
    }

    public void setConcertId(int concertId) {
        this.concertId = concertId;
    }
}
