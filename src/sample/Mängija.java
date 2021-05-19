package sample;

public class Mängija {

    private String nimi;
    private int[] piletinumbrid;

    public Mängija(String nimi, int[] piletinumbrid) {
        this.nimi = nimi;
        this.piletinumbrid = piletinumbrid;
    }


    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int[] getPiletinumbrid() {
        return piletinumbrid;
    }

    public void setPiletinumbrid(int[] piletinumbrid) {
        this.piletinumbrid = piletinumbrid;
    }
}
