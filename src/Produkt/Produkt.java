package Produkt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produkt {
    private String code;
    private String name;
    private double price;

    private double discountPrice;

    public Produkt(String kod, String nazwa, double cena){
        this.code = kod;
        this.name = nazwa;
        this.price = cena;
        this.discountPrice = cena;
    }

    public double getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    public String getCode(){
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }
}