package Kupony;

import Koszyk.Koszyk;
import Produkt.Produkt;

import java.util.List;
public class Kupon_3_for_2 implements Kupon{

    @Override
    public void apply(Koszyk koszyk) {
        final int[] count = {0};
        koszyk.getProductsList().forEach(Produkt -> {
            count[0] = count[0] + 1;});
        count[0] =  count[0] / 3;

        koszyk.getSomeCheapest(count[0]).forEach(Produkt -> {
            Produkt.setDiscountPrice(0);
        });

    }

    @Override
    public boolean isAppliable(Koszyk koszyk) {
        final double[] count = {0};
        koszyk.getProductsList().forEach(Produkt -> {
            count[0] = count[0] + 1;});
        return count[0]>=3;
    }
}
