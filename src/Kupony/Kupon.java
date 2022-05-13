package Kupony;
import Koszyk.Koszyk;
import Produkt.Produkt;

import java.util.List;

public interface Kupon {

    void apply(Koszyk koszyk);

    boolean isAppliable(Koszyk koszyk);
}
