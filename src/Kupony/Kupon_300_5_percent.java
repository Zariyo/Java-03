package Kupony;

import Koszyk.Koszyk;
import Produkt.Produkt;

import java.util.List;

public class Kupon_300_5_percent implements Kupon{


    @Override
    public void apply(Koszyk koszyk) {
        koszyk.getProductsList().forEach(Produkt -> {
            Produkt.setDiscountPrice(Produkt.getPrice()*0.95);});
    }

    @Override
    public boolean isAppliable(Koszyk koszyk) {
        final double[] cena = {0};
        koszyk.getProductsList().forEach(Produkt -> {
            cena[0] = cena[0] + Produkt.getPrice();});
        return cena[0] >= 300;
    }
}
