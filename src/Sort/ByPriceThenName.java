package Sort;

import Produkt.Produkt;

import java.util.Comparator;

public class ByPriceThenName implements Comparator<Produkt> {

    @Override
    public int compare(Produkt prod1, Produkt prod2) {
        if(prod1.getDiscountPrice() < prod2.getDiscountPrice()){
            return 1;
        }
        if(prod1.getDiscountPrice() > prod2.getDiscountPrice()){
            return -1;
        }
        return prod1.getName().compareTo(prod2.getName());
    }
}