package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    //sisselogimise stseen
    @FXML
    private Button button;
    @FXML
    private TextField kasutajanimi;
    @FXML
    private PasswordField parool;
    @FXML
    private Label label;

    //registreerimise stseen
    @FXML
    private TextField kasutajanimi1;
    @FXML
    private TextField parool1;
    @FXML
    private TextField paroolUuesti;
    @FXML
    private Label label1;

    private Map<String, String> kasutajad = new HashMap<>();


    //Sisselogimise meetodid
    public static void loeandmed(String failinimi, Map<String, String> kasutajad) throws IOException {

        try (BufferedReader lugeja = new BufferedReader(new InputStreamReader(new FileInputStream(failinimi), "UTF-8"))) {
            while (true) {

                String rida = lugeja.readLine();
                if (rida == null)
                    break;
                String osad[] = rida.split(" ");
                kasutajad.put(osad[0], osad[1]);
            }
        }

        /*for (String s : kasutajad.keySet()) {
            System.out.println(s + " "+ kasutajad.get(s));
        }*/
    }

    private static void salvestaandmedfaili(Map<String, String> kasutajad, String failinimi) throws IOException {
        File fail = new File(failinimi);
        FileWriter fileWriter = new FileWriter(fail, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (String s : kasutajad.keySet()) {
            bufferedWriter.write(s + " " + kasutajad.get(s) + "\n");
        }
        bufferedWriter.close();
    }

    private void sisselogimine() throws IOException {

        Main main = new Main();

        loeandmed("kasutajad.txt", kasutajad);

        if (kasutajad.containsKey(kasutajanimi.getText().toString())) {
            if (kasutajad.get(kasutajanimi.getText().toString()).equals(parool.getText().toString())) {
                label.setText("Oled sisse logitud!");
                main.changeScene("Sisselogitud.fxml");
            }
        } else if (kasutajanimi.getText().isEmpty() || parool.getText().isEmpty()) {
            label.setText("Palun sisestage andmed!");
        } else {
            label.setText("Vale kasutajanimi või parool");
        }
    }

    public void loginClicked() throws IOException {

        sisselogimine();

    }

    public void uusKasutajaClicked() throws IOException {
        loeandmed("kasutajad.txt", kasutajad);

        Main main = new Main();

        main.changeScene("uusKasutaja.fxml");

    }

    //Registreermise meetodid
    public void tagasiClicked() throws IOException {
        Main main = new Main();
        main.changeScene("sample.fxml");
    }

    public void registreeriClicked() throws IOException {
        registreerimine();
    }

    private void registreerimine() throws IOException {
        Main main = new Main();

        if (kasutajanimi1.getText().isEmpty() || parool1.getText().isEmpty() || paroolUuesti.getText().isEmpty()) {
            label1.setText("Palun sisestage andmed!");
        } else if (kasutajad.containsKey(kasutajanimi1.getText().toString())) {
            label1.setText("Selline kasutajanimi on juba kasutusel");

        } else if (!(parool1.getText().toString().equals(paroolUuesti.getText().toString()))) {
            label1.setText("Paroolid ei ole identsed");

        } else {
            kasutajad.put(kasutajanimi1.getText().toString(), parool1.getText().toString());
            main.changeScene("sample.fxml");
            salvestaandmedfaili(kasutajad, "kasutajad.txt");
        }
    }
}