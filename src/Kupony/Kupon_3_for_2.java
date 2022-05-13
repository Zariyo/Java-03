package Kupony;

import Koszyk.Koszyk;
public class Kupon_3_for_2 implements Kupon{

    @Override
    public void apply(Koszyk koszyk) {
        koszyk.getCheapest().setDiscountPrice(0);
    }

    @Override
    public boolean isAppliable(Koszyk koszyk) {
        return koszyk.getProductsList().size()>=3;
    }
}
