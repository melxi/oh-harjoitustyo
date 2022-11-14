package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void kortilleVoiLadataRahaa() {
        kortti.lataaRahaa(25);
        assertEquals("saldo: 0.35", kortti.toString());
    }
    
    @Test
    public void saldoaVaheneeOikein() {
        kortti.otaRahaa(1);
        System.out.println(kortti.saldo());
        System.out.println(kortti.toString());
        assertEquals("saldo: 0.9", kortti.toString());
    }
    
    @Test
    public void saldoEiMuutuJosEiTarpeeksiRahaa() {
        kortti.otaRahaa(15);
        System.out.println(kortti.saldo());
        System.out.println(kortti.toString());
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void josRahaaRiittaaPalauttaaTrue() {
        assertTrue(kortti.otaRahaa(5));
    }

    @Test
    public void josRahaaEiRiittaPalauttaaFalse() {
        assertFalse(kortti.otaRahaa(15));
    }
}
