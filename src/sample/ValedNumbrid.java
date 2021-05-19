package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class ValedNumbrid {
    @FXML
    private Button tagasi;
    @FXML
    private Label lbl;

    private String text;


    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("sisseLogitud.fxml");
        tagasi.getScene().getWindow().hide();
    }

}
