package Kupony;

import Koszyk.Koszyk;
import Produkt.Produkt;

public class Kupon_FreeMug_200 implements Kupon{

    @Override
    public void apply(Koszyk koszyk) {
        Produkt kubek = new Produkt("405", "Kubek firmowy", 0);
        koszyk.addProduct(kubek);

    }

    @Override
    public boolean isAppliable(Koszyk koszyk) {
        final double[] cena = {0};
        koszyk.getProductsList().forEach(Produkt -> {
            cena[0] = cena[0] + Produkt.getPrice();
        });
        return cena[0] >= 200;
    }
}
