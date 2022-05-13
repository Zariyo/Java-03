package Sort;

import Produkt.Produkt;

import java.util.Comparator;

public class ByName implements Comparator<Produkt> {

    @Override
    public int compare(Produkt prod1, Produkt prod2) {
        return prod1.getName().compareTo(prod2.getName());
    }
}
