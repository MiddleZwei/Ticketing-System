package com.s15920.Utility;

import com.s15920.App;
import com.s15920.ConcertsController;
import com.s15920.SingleConcertController;
import com.s15920.TicketController;
import com.s15920.model.Ticket;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorIngresDatabaseImpl;

import java.io.IOException;
import java.sql.Date;

public final class Utility {
    // Example Utility method
    public static void loadNewScene(FXMLLoader fxmlLoader) throws IOException {
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        App.firstStage.close();
    }

    public static void loadNewScene(FXMLLoader fxmlLoader, Date f, Date t) throws IOException {
        ConcertsController controller = new ConcertsController(f.toString(), t.toString());
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        controller.setFrom(f);
        controller.setTo(t);
        setup(root);
    }

    public static void loadNewScene(FXMLLoader fxmlLoader, int concert_id, String concert_name) throws IOException {
        SingleConcertController controller = new SingleConcertController(concert_id, concert_name);
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        controller.setConcertName(concert_name);
        controller.setConcertId(concert_id);
        setup(root);
    }

    private static void setup(Parent root) {
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        App.firstStage.close();
    }

    public static void loadNewScene(FXMLLoader fxmlLoader, String ticketId, String from, String to, String concertName, int row_, int seat_) throws IOException {
        String details = "Ticket #: " + ticketId + "\n" +
                        "Concert: " + concertName + "\n" +
                        "Valid from: " + from + "\n" +
                        "Valid to: " + to + "\n" +
                        "Row: " + row_ + "\n" +
                        "Seat: " + seat_ + "\n";

        TicketController controller = new TicketController(ticketId, details);
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        controller.setDetails(details);
        controller.setTicketNumberTitle(ticketId);
        setup(root);

    }
}
