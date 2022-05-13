import Koszyk.Koszyk;
import Kupony.*;
import Produkt.Produkt;
import Sort.ByName;
import Sort.ByNameThenPrice;
import Sort.ByPriceThenName;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class KoszykTest {

    @Test
    public void testShowFirstElement(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 2.00);
        Koszyk sut = new Koszyk(mleko);
        // Act

        // Assert
        assertEquals(mleko, sut.showFirstProduct());
    }

    @Test
    public void testShowFirstElementList(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 2.00);
        Produkt kakao = new Produkt("02", "Kakao", 3.00);
        ArrayList<Produkt> lista = new ArrayList<>();
        lista.add(kakao);
        lista.add(mleko);
        Koszyk sut = new Koszyk(lista);
        // Act

        // Assert
        assertEquals(kakao, sut.showFirstProduct());
    }

    @Test
    public void testAddElement(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 2.00);
        Koszyk sut = new Koszyk(mleko);
        Produkt kakao = new Produkt("02", "Kakao", 3.00);
        // Act
        sut.addProduct(kakao);
        // Assert
        ArrayList<Produkt> lista = new ArrayList<>();
        lista.add(mleko);
        lista.add(kakao);
        ArrayList<String> strList = new ArrayList<>();
        lista.forEach(Produkt -> strList.add(Produkt.getName()));
        assertEquals(strList, sut.showCart());
    }

    @Test
    public void testRemoveElement(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 2.00);
        Produkt kakao = new Produkt("02", "Kakao", 3.00);
        Koszyk sut = new Koszyk(mleko);

        // Act
        sut.removeProduct(mleko);
        sut.addProduct(kakao);
        // Assert
        assertEquals(kakao, sut.showFirstProduct());
    }

    @Test
    public void testShowAll(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 2.00);
        Produkt kakao = new Produkt("02", "Kakao", 3.00);
        Koszyk sut = new Koszyk(mleko);

        // Act
        sut.addProduct(kakao);
        // Assert
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Mleko");
        lista.add("Kakao");
        assertEquals(lista, sut.showCart());
    }

    @Test
    public void testGetPrice(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 2.00);
        Produkt kakao = new Produkt("02", "Kakao", 3.00);
        Koszyk sut = new Koszyk(mleko);

        // Act
        sut.addProduct(kakao);
        // Assert
        assertEquals("5.00",5.00, sut.cartPrice(),0.01);
    }

    @Test
    public void testApplyCoupon_5_percent(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 200.00);
        Produkt kakao = new Produkt("02", "Kakao", 300.00);
        Koszyk sut = new Koszyk(mleko);

        // Act
        sut.addProduct(kakao);
        Kupon kupon = new Kupon_300_5_percent();
        sut.addCoupon(kupon);
        sut.applyCoupons();
        // Assert
        assertEquals("5.00",475.00, sut.cartPrice(),0.01);
    }

    @Test
    public void testApplyCoupon_3_for_2(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 200.00);
        Produkt kakao = new Produkt("02", "Kakao", 300.00);
        Produkt platki = new Produkt("03", "Platki", 100.00);
        Koszyk sut = new Koszyk(mleko);

        // Act
        sut.addProduct(kakao);
        sut.addProduct(platki);
        Kupon kupon = new Kupon_3_for_2();
        sut.addCoupon(kupon);
        sut.applyCoupons();
        // Assert
        assertEquals("5.00",500.00, sut.cartPrice(),0.01);
    }

    @Test
    public void testGetCheapest(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 200.00);
        Produkt kakao = new Produkt("02", "Kakao", 300.00);
        Produkt platki = new Produkt("03", "Platki", 100.00);
        Produkt herbata = new Produkt("04", "Herbata", 150.00);
        Koszyk sut = new Koszyk(mleko);

        // Act
        sut.addProduct(kakao);
        sut.addProduct(platki);
        sut.addProduct(herbata);
        // Assert
        assertEquals("",platki, sut.getCheapest());
    }

    @Test
    public void testGetSomeCheapest(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 200.00);
        Produkt kakao = new Produkt("02", "Kakao", 300.00);
        Produkt platki = new Produkt("03", "Platki", 100.00);
        Produkt herbata = new Produkt("04", "Herbata", 150.00);
        Koszyk sut = new Koszyk(mleko);

        // Act
        sut.addProduct(kakao);
        sut.addProduct(platki);
        sut.addProduct(herbata);
        // Assert
        ArrayList<Produkt> lista = new ArrayList<>();
        lista.add(platki);
        lista.add(herbata);
        assertEquals("",lista, sut.getSomeCheapest(2));
    }

    @Test
    public void testGetExpensive(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 200.00);
        Produkt kakao = new Produkt("02", "Kakao", 300.00);
        Produkt platki = new Produkt("03", "Platki", 100.00);
        Produkt herbata = new Produkt("04", "Herbata", 150.00);
        Koszyk sut = new Koszyk(mleko);

        // Act
        sut.addProduct(kakao);
        sut.addProduct(platki);
        sut.addProduct(herbata);
        // Assert
        assertEquals("",kakao, sut.getMostExpensive());
    }

    @Test
    public void testGetSomeExpensive(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 200.00);
        Produkt kakao = new Produkt("02", "Kakao", 300.00);
        Produkt platki = new Produkt("03", "Platki", 100.00);
        Produkt herbata = new Produkt("04", "Herbata", 150.00);
        Koszyk sut = new Koszyk(mleko);

        // Act
        sut.addProduct(kakao);
        sut.addProduct(platki);
        sut.addProduct(herbata);
        // Assert
        ArrayList<Produkt> lista = new ArrayList<>();
        lista.add(kakao);
        lista.add(mleko);
        assertEquals("",lista, sut.getSomeMostExpensive(2));
    }

    @Test
    public void testGetProductsList(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 200.00);
        Produkt kakao = new Produkt("02", "Kakao", 300.00);
        Produkt platki = new Produkt("03", "Platki", 100.00);
        Produkt herbata = new Produkt("04", "Herbata", 150.00);
        Koszyk sut = new Koszyk(mleko);

        // Act
        sut.addProduct(kakao);
        sut.addProduct(platki);
        sut.addProduct(herbata);
        // Assert
        ArrayList<Produkt> lista = new ArrayList<>();
        lista.add(herbata);
        lista.add(kakao);
        lista.add(mleko);
        lista.add(platki);

        assertEquals("",lista, sut.getProductsList());
    }

    @Test
    public void testApplyCoupon_FreeMug_200(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 200.00);
        Produkt kakao = new Produkt("02", "Kakao", 300.00);
        Koszyk sut = new Koszyk(mleko);

        // Act
        sut.addProduct(kakao);
        Kupon kupon = new Kupon_FreeMug_200();
        sut.addCoupon(kupon);
        sut.applyCoupons();
        // Assert
        Produkt kubek = new Produkt("405", "Kubek firmowy", 0);
        ArrayList<String> lista = new ArrayList<>();
        sut.getProductsList().forEach(Produkt -> lista.add(Produkt.getName()));
        assertTrue(lista.contains(kubek.getName()));
    }

    @Test
    public void testApplyCoupon_Kakao_50_percent(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 200.00);
        Produkt kakao = new Produkt("02", "Kakao", 300.00);
        Koszyk sut = new Koszyk(mleko);

        // Act
        sut.addProduct(kakao);
        Kupon kupon = new Kupon_Kakao_50_percent();
        sut.addCoupon(kupon);
        sut.applyCoupons();
        // Assert
        assertEquals("5.00",350.00, sut.cartPrice(),0.01);
    }

    @Test
    public void testMultipleCoupons(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 200.00);
        Produkt kakao = new Produkt("02", "Kakao", 120.00);
        Produkt platki = new Produkt("03", "Platki", 100.00);
        Produkt herbata = new Produkt("04", "Herbata", 150.00);
        Koszyk sut = new Koszyk(mleko);

        // Act
        sut.addProduct(kakao);
        sut.addProduct(platki);
        sut.addProduct(herbata);
        sut.addCoupon(new Kupon_3_for_2());
        sut.addCoupon(new Kupon_Kakao_50_percent());
        sut.addCoupon(new Kupon_300_5_percent());
        sut.applyCoupons();
        // Assert
        assertEquals("5.00",389.50, sut.cartPrice(),0.01);
    }

    @Test
    public void testGetProductsListNamesPrice(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 200.00);
        Produkt kakao = new Produkt("02", "Kakao", 300.00);
        Produkt platki = new Produkt("03", "Platki", 100.00);
        Produkt herbata = new Produkt("04", "Herbata", 150.00);
        Koszyk sut = new Koszyk(mleko);

        // Act
        sut.addProduct(kakao);
        sut.addProduct(platki);
        sut.addProduct(herbata);
        // Assert
        List<String> lista = new ArrayList<>();
        lista.add(mleko.getName() + " " + mleko.getPrice());
        lista.add(kakao.getName() + " " + kakao.getPrice());
        lista.add(platki.getName() + " " + platki.getPrice());
        lista.add(herbata.getName() + " " + herbata.getPrice());

        assertEquals("",lista, sut.getProductsListNamePrice());
    }

    @Test
    public void testSortByPrice(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 200.00);
        Produkt kakao = new Produkt("02", "Kakao", 300.00);
        Produkt platki = new Produkt("03", "Platki", 100.00);
        Produkt herbata = new Produkt("04", "Herbata", 150.00);
        Koszyk sut = new Koszyk(mleko);

        // Act
        sut.addProduct(kakao);
        sut.addProduct(platki);
        sut.addProduct(herbata);
        sut.sortCart();
        // Assert
        List<String> lista = new ArrayList<>();
        lista.add(kakao.getName() + " " + kakao.getPrice());
        lista.add(mleko.getName() + " " + mleko.getPrice());
        lista.add(herbata.getName() + " " + herbata.getPrice());
        lista.add(platki.getName() + " " + platki.getPrice());

        assertEquals("",lista, sut.getProductsListNamePrice());
    }

    @Test
    public void testSortByName(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 200.00);
        Produkt kakao = new Produkt("02", "Kakao", 300.00);
        Produkt platki = new Produkt("03", "Platki", 100.00);
        Produkt herbata = new Produkt("04", "Herbata", 150.00);
        Koszyk sut = new Koszyk(mleko);

        // Act
        sut.addProduct(kakao);
        sut.addProduct(platki);
        sut.addProduct(herbata);
        sut.setSortType(new ByName());
        sut.sortCart();
        // Assert
        List<String> lista = new ArrayList<>();
        lista.add(herbata.getName() + " " + herbata.getPrice());
        lista.add(kakao.getName() + " " + kakao.getPrice());
        lista.add(mleko.getName() + " " + mleko.getPrice());
        lista.add(platki.getName() + " " + platki.getPrice());

        assertEquals("",lista, sut.getProductsListNamePrice());
    }

    @Test
    public void testSortByPriceThenName(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 200.00);
        Produkt kakao = new Produkt("02", "Kakao", 300.00);
        Produkt platki = new Produkt("03", "Platki", 100.00);
        Produkt herbata = new Produkt("04", "Herbata", 150.00);
        Produkt kawa = new Produkt("05", "Kawa", 150.00);
        Koszyk sut = new Koszyk(mleko);

        // Act
        sut.addProduct(kakao);
        sut.addProduct(platki);
        sut.addProduct(kawa);
        sut.addProduct(herbata);
        sut.setSortType(new ByPriceThenName());
        sut.sortCart();
        // Assert
        List<String> lista = new ArrayList<>();
        lista.add(kakao.getName() + " " + kakao.getPrice());
        lista.add(mleko.getName() + " " + mleko.getPrice());
        lista.add(herbata.getName() + " " + herbata.getPrice());
        lista.add(kawa.getName() + " " + kawa.getPrice());
        lista.add(platki.getName() + " " + platki.getPrice());

        assertEquals("",lista, sut.getProductsListNamePrice());
    }

    @Test
    public void testSortByNameThenPrice(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 200.00);
        Produkt kakao = new Produkt("02", "Kakao", 300.00);
        Produkt platki = new Produkt("03", "Platki", 100.00);
        Produkt herbata = new Produkt("04", "Herbata", 150.00);
        Produkt herbataPremium = new Produkt("05", "Herbata", 175.00);
        Koszyk sut = new Koszyk(mleko);

        // Act
        sut.addProduct(kakao);
        sut.addProduct(platki);
        sut.addProduct(herbataPremium);
        sut.addProduct(herbata);
        sut.setSortType(new ByNameThenPrice());
        sut.sortCart();
        // Assert
        List<String> lista = new ArrayList<>();
        lista.add(herbataPremium.getName() + " " + herbataPremium.getPrice());
        lista.add(herbata.getName() + " " + herbata.getPrice());
        lista.add(kakao.getName() + " " + kakao.getPrice());
        lista.add(mleko.getName() + " " + mleko.getPrice());
        lista.add(platki.getName() + " " + platki.getPrice());

        assertEquals("",lista, sut.getProductsListNamePrice());
    }
}
