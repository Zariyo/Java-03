package Koszyk;

import Kupony.Kupon;
import Produkt.Produkt;
import Sort.ByPrice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Koszyk {
    private List<Produkt> shoppingList;
    private List<Kupon> couponList;
    private Comparator<Produkt> sortType;

    public Koszyk(ArrayList<Produkt> produkty){
        this.shoppingList = produkty;
        couponList = new ArrayList<>();
        this.sortType = new ByPrice();
    }

    public Koszyk(Produkt produkt){
        couponList = new ArrayList<>();
        this.shoppingList = new ArrayList<>();
        this.shoppingList.add(produkt);
        this.sortType = new ByPrice();
    }

    public void addProduct(Produkt produkt){
        this.shoppingList.add(produkt);
    }

    public void removeProduct(Produkt produkt){
        this.shoppingList.remove(produkt);
    }

    public Produkt showFirstProduct(){
        return this.shoppingList.get(0);
    }

    public List<String> showCart(){
        ArrayList<String> lista = new ArrayList<>();
        shoppingList.forEach(Produkt -> lista.add(Produkt.getName()));
        return lista;
    }

    public double cartPrice(){
        double[] cena = {0};

        shoppingList.forEach(Produkt -> cena[0] = cena[0] + Produkt.getDiscountPrice());

        return cena[0];
    }

    public void addCoupon(Kupon kupon){
        couponList.add(kupon);
    }

    public void applyCoupons(){
        for (Kupon kupon : couponList) {
            if (kupon.isAppliable(this)) {
                kupon.apply(this);
            }
        }
        couponList.clear();
    }

    public Produkt getCheapest(){
        List<Produkt> list = shoppingList.stream().sorted(Comparator.comparing(Produkt::getPrice)).toList();
        return list.get(0);
    }
    public List<Produkt> getSomeCheapest(int n){
        List<Produkt> list = shoppingList.stream().sorted(Comparator.comparing(Produkt::getPrice)).toList();
        return list.subList(0, n);
    }

    public Produkt getMostExpensive(){
        List<Produkt> list = shoppingList.stream().sorted(Comparator.comparing(Produkt::getPrice).reversed()).toList();
        return list.get(0);
    }

    public List<Produkt> getSomeMostExpensive(int n){
        List<Produkt> list = shoppingList.stream().sorted(Comparator.comparing(Produkt::getPrice).reversed()).toList();
        return list.subList(0, n);
    }

    public List<Produkt> getProductsList(){
        return shoppingList.stream().sorted(Comparator.comparing(Produkt::getName)).toList();
    }

    public List<String> getProductsListNamePrice(){
        List<String> namesList = new ArrayList<>();
        shoppingList.forEach(Produkt -> namesList.add(Produkt.getName() + " " + Produkt.getPrice()));
        return namesList;
    }

    public void setSortType(Comparator<Produkt> newType){
        this.sortType = newType;
    }
    public void sortCart(){
        this.shoppingList.sort(sortType);
    }
}
