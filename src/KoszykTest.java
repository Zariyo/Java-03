import org.junit.Before;
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
        assertEquals(mleko, sut.pokazPierwszyProdukt());
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
        assertEquals(kakao, sut.pokazPierwszyProdukt());
    }

    @Test
    public void testAddElement(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 2.00);
        Koszyk sut = new Koszyk(mleko);
        Produkt kakao = new Produkt("02", "Kakao", 3.00);
        // Act
        sut.dodajProdukt(kakao);
        // Assert
        ArrayList<Produkt> lista = new ArrayList<Produkt>();
        lista.add(mleko);
        lista.add(kakao);
        ArrayList<String> strList = new ArrayList<String>();
        lista.forEach(Produkt -> {strList.add(Produkt.pokazNazwe());});
        assertEquals(strList, sut.pokazKoszyk());
    }

    @Test
    public void testRemoveElement(){
        // Arrange
        // sut = System Under Test
        Produkt mleko = new Produkt("01", "Mleko", 2.00);
        Produkt kakao = new Produkt("02", "Kakao", 3.00);
        Koszyk sut = new Koszyk(mleko);

        // Act
        sut.usunProdukt(mleko);
        sut.dodajProdukt(kakao);
        // Assert
        assertEquals(kakao, sut.pokazPierwszyProdukt());
    }
}
