package Kupony;

import Koszyk.Koszyk;

import java.util.ArrayList;
import java.util.Objects;

public class Kupon_Kakao_50_percent implements Kupon{

    @Override
    public void apply(Koszyk koszyk) {
        koszyk.getProductsList().forEach(Produkt -> {
            if(Objects.equals(Produkt.getName(), "Kakao")){
                Produkt.setDiscountPrice(Produkt.getDiscountPrice()*0.5);
            }
        });

    }

    @Override
    public boolean isAppliable(Koszyk koszyk) {
        ArrayList<String> lista = new ArrayList<>();
        koszyk.getProductsList().forEach(Produkt -> lista.add(Produkt.getName()));
        return lista.contains("Kakao");
    }

}
