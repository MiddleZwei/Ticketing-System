package com.s15920;

import com.s15920.Utility.Utility;
import com.s15920.model.Concert;
import com.s15920.service.ConcertService;
import com.s15920.service.IConcertService;
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
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.net.URL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;



public class ConcertsController implements Initializable  {

    private IConcertService concertService;
    private ITicketService ticketService;

    private List<Concert> concerts;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Text from;

    @FXML
    private Text to;

    @FXML
    TableColumn<List<StringProperty>, String> titleColumn = new TableColumn<>("title");
    @FXML
    TableColumn<List<StringProperty>, Void> performersColumn = new TableColumn<>("performers");
    @FXML
    TableColumn<List<StringProperty>, String> startColumn = new TableColumn<>("start");
    @FXML
    TableColumn<List<StringProperty>, String> durationColumn = new TableColumn<>("duration");
    @FXML
    TableColumn<List<StringProperty>, String> endColumn = new TableColumn<>("end");
    @FXML
    TableColumn<List<StringProperty>, Void> ticketsColumn = new TableColumn<>("tickets");

    @FXML
    private Button saveButton;

    @FXML
    private TableView<List<StringProperty>> tableConcerts;

    @FXML
    private Button backButton;

    private String fromText;
    private String toText;

    public ConcertsController() {
    }

    public ConcertsController(String fromText, String toText) {
        this.fromText = fromText;
        this.toText = toText;
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {

        System.out.println("init concert controller");
        concerts = new ArrayList<>();
        concertService = new ConcertService();
        ticketService = new TicketService();
        try {
            buildData();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void buildData() throws ParseException {
        ObservableList<List<StringProperty>> data = FXCollections.observableArrayList();
//        System.out.println(fromText);
//        System.out.println(toText);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = sdf.parse(fromText);
        java.util.Date date2= sdf.parse(toText);

        java.sql.Date sqlStartDate = new java.sql.Date(date1.getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(date1.getTime());

//        System.out.println(sqlEndDate.toString());
        concerts = concertService.getAllConcertsBetweenDates(sqlStartDate, sqlEndDate);
        for (Concert c : concerts){

            List<StringProperty> row = new ArrayList<>();

            titleColumn.setCellValueFactory(cdf -> new SimpleStringProperty(c.getTitle()));
            startColumn.setCellValueFactory(cdf -> new SimpleStringProperty(c.getFrom().toString()));
            durationColumn.setCellValueFactory(cdf -> new SimpleStringProperty("duration"));
            endColumn.setCellValueFactory(cdf -> new SimpleStringProperty(c.getTo().toString()));

            addButtonPerformers();
            addButtonTickets();

            data.add(row);
        }

        tableConcerts.setItems(data);
    }

    private void addButtonTickets() {
        Callback<TableColumn<List<StringProperty>, Void>, TableCell<List<StringProperty>, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<List<StringProperty>, Void> call(final TableColumn<List<StringProperty>, Void> param) {
                final TableCell<List<StringProperty>, Void> cell = new TableCell<List<StringProperty>, Void>() {

                    private final Button btn = new Button("Tickets");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            List<StringProperty> data = getTableView().getItems().get(getIndex());
//                            ticketService.getTicketsByConcertId(1); // TODO
//                            System.out.println("adcds");
                            handleShowTickets();
                            System.out.println("selectedData: " + data);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        ticketsColumn.setCellFactory(cellFactory);
    }

    private void addButtonPerformers() {
        Callback<TableColumn<List<StringProperty>, Void>, TableCell<List<StringProperty>, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<List<StringProperty>, Void> call(final TableColumn<List<StringProperty>, Void> param) {
                final TableCell<List<StringProperty>, Void> cell = new TableCell<List<StringProperty>, Void>() {

                    private final Button btn = new Button("Performers");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            List<StringProperty> data = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + data);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        performersColumn.setCellFactory(cellFactory);
    }

    @FXML
    protected void handleBackButton (ActionEvent actionEvent){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu.fxml"));
                Utility.loadNewScene(fxmlLoader);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    @FXML
    public void handleSaveButton (ActionEvent actionEvent){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu.fxml"));
                Utility.loadNewScene(fxmlLoader);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    private void handleShowTickets(){
        System.out.println("Pressed tickets button");
        try {
            System.out.println("Before calling single controller FXML");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/single_concert.fxml"));
            System.out.println("After calling single controller FXML");
            for (TablePosition row : tableConcerts.getSelectionModel().getSelectedCells()){
                int concert_id = concerts.get(row.getRow()).getConcertId();
                String concert_name = concerts.get(row.getRow()).getTitle();
                System.out.println("--------------------------------------");
                System.out.println("Selected concert id: "+concert_id);
                System.out.println("Selected concert name: "+concert_name);
                System.out.println("--------------------------------------");
                Utility.loadNewScene(fxmlLoader, concert_id, concert_name);
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setFrom(Date from) {
        this.from.setText(from.toString());
    }

    public Date getFrom() {
        return null;
    }

    public void setTo(Date to) {
        this.to.setText(to.toString());
    }

    public Date getTo() {
        return null;
    }
}
