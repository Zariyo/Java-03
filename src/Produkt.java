public class Produkt {
    private String kod;
    private String nazwa;
    private double cena;

    Produkt(String kod, String nazwa, double cena){
        this.kod = kod;
        this.nazwa = nazwa;
        this.cena = cena;
    }

    double pokazCene(){
        return this.cena;
    }

    String pokazNazwe(){
        return this.nazwa;
    }

    String pokazKod(){
        return this.kod;
    }

}