package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Kaotas {

    @FXML
    private Button logiVälja;
    @FXML
    private Button mängiUuesti;

    public void mängiUuesti() throws IOException {
        Main m = new Main();
        m.changeScene("sisseLogitud.fxml");
    }

    public void logiVälja() throws IOException {
        Main m = new Main();
        m.changeScene("sample.fxml");
    }
}
