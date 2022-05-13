import Koszyk.Koszyk;
import Kupony.Kupon;
import Kupony.Kupon_300_5_percent;
import Kupony.Kupon_3_for_2;
import Produkt.Produkt;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


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
        ArrayList<Produkt> lista = new ArrayList<Produkt>();
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
        ArrayList<Produkt> lista = new ArrayList<Produkt>();
        lista.add(mleko);
        lista.add(kakao);
        ArrayList<String> strList = new ArrayList<String>();
        lista.forEach(Produkt -> {strList.add(Produkt.getName());});
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
        ArrayList<String> lista = new ArrayList<String>();
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
        Kupon kupon = new Kupon_3_for_2();
        //sut.dodajKupon(kupon);
        // Assert
        ArrayList<Produkt> lista = new ArrayList<Produkt>();
        lista.add(platki);
        lista.add(herbata);
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
        Kupon kupon = new Kupon_3_for_2();
        //sut.dodajKupon(kupon);
        // Assert
        ArrayList<Produkt> lista = new ArrayList<Produkt>();
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
        Kupon kupon = new Kupon_3_for_2();
        //sut.dodajKupon(kupon);
        // Assert
        ArrayList<Produkt> lista = new ArrayList<Produkt>();
        lista.add(platki);
        lista.add(herbata);
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
        Kupon kupon = new Kupon_3_for_2();
        //sut.dodajKupon(kupon);
        // Assert
        ArrayList<Produkt> lista = new ArrayList<Produkt>();
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
        Kupon kupon = new Kupon_3_for_2();
        //sut.dodajKupon(kupon);
        // Assert
        ArrayList<Produkt> lista = new ArrayList<Produkt>();
        lista.add(herbata);
        lista.add(kakao);
        lista.add(mleko);
        lista.add(platki);
        assertEquals("",lista, sut.getProductsList());
    }
}
