package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TeineMängija {

    @FXML
    private TextField esimeneNimi;
    @FXML
    private TextField teineNimi;
    @FXML
    private Button mängi;
    @FXML
    private Label Võitjad;
    @FXML
    private TextField piletiteNumbrid1;
    @FXML
    private TextField piletiteNumbrid2;


    Main m = new Main();
    List<Mängija> mängijad = new ArrayList<>();
    Loterii loto = new Loterii(1,30);

    public void mängi(javafx.event.ActionEvent actionEvent) throws IOException {


        mängijad.add(saanMängija(piletiteNumbrid1, esimeneNimi));
        mängijad.add(saanMängija(piletiteNumbrid2,teineNimi));
        loto.mängime(mängijad);

        if (loto.kasVõitis()) {
            DecimalFormat df = new DecimalFormat("0.00");

            Võitjad.setText("Palju õnne!"  + loto.võitjad() + " võitsid " + df.format((loto.piletiteSumma/loto.võitjad.size())*0.95) + " eurot!");
            Võitjad.setVisible(true);
            mängijad.clear();
            loto.võitjad.clear();
        } else {
            m.changeScene("kaotas.fxml");
        }

    }
    private Mängija saanMängija(TextField piletiteNumbrid, TextField nimi) throws IOException {
        String[] abi = piletiteNumbrid.getText().toString().split(",");
        int[] piletid = new int[abi.length];
        for (int i = 0; i <= abi.length - 1; i++) {
            int pilet = Integer.parseInt(abi[i]);

            try {
                if (pilet <= Loterii.getÜlempiir()& pilet >= Loterii.getAlampiir()){
                    piletid[i] = pilet;
                    System.out.println(pilet);
                } else {
                    throw new ValeArvErind("valedNumbrid.fxml");
                }
            } catch (ValeArvErind valeArvErind){

                FXMLLoader loader = new FXMLLoader(getClass().getResource("valedNumbrid.fxml"));
                Stage stage = new Stage();
                stage.initOwner(mängi.getScene().getWindow());
                stage.setScene(new Scene((Parent) loader.load()));
                stage.showAndWait();
                mängijad.clear();


            }
        }
        Mängija mängija = new Mängija(nimi.getText().toString(), piletid);

        return mängija;
    }
}
