package sample;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loterii {

    private static int alampiir;
    private static int ülempiir;
    private int võidunr;
    ArrayList võitjad = new ArrayList();
    double piletiteSumma = 0;
    boolean võitis;


    public Loterii(int alampiir, int ülempiir) {
        Loterii.alampiir = alampiir;
        Loterii.ülempiir = ülempiir;
        võidunr = (int) (Math.random()*((ülempiir-alampiir)+1)) + alampiir; //genereerime suvalise võidunumbri

    }

    public static int getAlampiir() {
        return alampiir;
    }

    public static int getÜlempiir() {
        return ülempiir;
    }

    // Meetod, millega toimub kogu mängu osa
    public void mängime(List<Mängija> mängijad) {

        for (Mängija m : mängijad) {

            // Kordame tsüklit ostetud piletite arv kordi, kasutame teise klassi Mängija meetodit.
            for (int i : m.getPiletinumbrid()) {

                if (i == võidunr) { //lisame võitjad listi
                    if (võitjad.contains(m.getNimi())) {
                    } else
                        võitjad.add(m.getNimi());
                }
                piletiteSumma += 5.5;
            }

        }
    }

    // Meetod ümardamiseks
    public static DecimalFormat df = new DecimalFormat("0.00");

    //Meetod, millega teeme võitjate listist stringi
    public String võitjad() {
        StringBuilder b = new StringBuilder();
        for (Object o : võitjad) {
            b.append(", ");
            b.append(o);
        }
        return b.toString();
    }

    //String, mis tagastab mängu tulemuse
    public boolean kasVõitis() {
        if (võitjad.isEmpty()) {
            võitis =false;
        } else {
            võitis =true;
        }
        return võitis;
    }

}


