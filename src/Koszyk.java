import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Koszyk {
    private List<Produkt> listaZakupow;

    Koszyk(List<Produkt> produkty){
        this.listaZakupow = produkty;
    }

    Koszyk(Produkt produkt){
        this.listaZakupow = new ArrayList<>();
        this.listaZakupow.add(produkt);
    }

    public void dodajProdukt(Produkt produkt){
        this.listaZakupow.add(produkt);
    }

    public void usunProdukt(Produkt produkt){
        this.listaZakupow.remove(produkt);
    }

    public Produkt pokazPierwszyProdukt(){
        return this.listaZakupow.get(0);
    }

    public List<String> pokazKoszyk(){
        ArrayList<String> lista = new ArrayList<String>();
        listaZakupow.forEach(Produkt -> {lista.add(Produkt.pokazNazwe());});
        return lista;
    }
}
