package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;

import java.io.IOException;

public class SisseLogitud {

    @FXML
    private Button üksMängija;
    @FXML
    private Button kaksMängijat;
    @FXML
    private Button kolmMängijat;
    @FXML
    private Button neliMängijat;
    @FXML
    private Button viisMängijat;
    @FXML
    private Button logiVälja;


    public void valik1(javafx.event.ActionEvent actionEvent) throws IOException {
        Main m = new Main();
        m.changeScene("esimeneMängija.fxml");
    }

    public void valik2(javafx.event.ActionEvent actionEvent) throws IOException {
        Main m = new Main();
        m.changeScene("teineMängija.fxml");

    }
    public void valik3(javafx.event.ActionEvent actionEvent) throws IOException {
        Main m = new Main();
        m.changeScene("kolmasMängija.fxml");
    }
    public void valik4(javafx.event.ActionEvent actionEvent) throws IOException {
        Main m = new Main();
        m.changeScene("neljasMängija.fxml");
    }
    public void valik5(javafx.event.ActionEvent actionEvent) throws IOException {
        Main m = new Main();
        m.changeScene("viiesMängija.fxml");
    }

    public void logiVälja(javafx.event.ActionEvent actionEvent) throws IOException {
        Main m = new Main();
        m.changeScene("sample.fxml");
    }
}
