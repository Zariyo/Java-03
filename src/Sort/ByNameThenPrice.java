package Sort;

import Produkt.Produkt;

import java.util.Comparator;

public class ByNameThenPrice implements Comparator<Produkt> {

    @Override
    public int compare(Produkt prod1, Produkt prod2) {
        if (prod1.getName().compareTo(prod2.getName()) == 0) {
            if(prod1.getDiscountPrice() < prod2.getDiscountPrice()){
                return 1;
            }
            if(prod1.getDiscountPrice() > prod2.getDiscountPrice()){
                return -1;
            }
            return 0;
        }
        return prod1.getName().compareTo(prod2.getName());
    }
}