package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class KassapaateTest {
    Kassapaate kassapaate;
    Maksukortti maksukortti;

    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
        maksukortti = new Maksukortti(1000);
    }

    @Test
    public void konstruktoriAsettaaKassassaRahaaOikein() {
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void alussaMaukaitaLounaitaMyytyNolla() {
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void alussaEdullisiaLounaitaMyytyNolla() {
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kassanRahaKasvaaOikeallaMaarallaMaukkaallaLounaalla() {
        kassapaate.syoMaukkaasti(400);
        assertEquals(100400, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kassanRahaKasvaaOikeallaMaaralla() {
        kassapaate.syoEdullisesti(240);
        assertEquals(100240, kassapaate.kassassaRahaa());
    }

    @Test
    public void maukkaidenLounaidenMyytyjenMaaraKasvaaJosMaksuRiittava() {
        kassapaate.syoMaukkaasti(400);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void edullistenLounaidenMyytyjenMaaraKasvaaJosMaksuRiittava() {
        kassapaate.syoEdullisesti(240);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kassanRahaEiMuutuJosMaksuEiRiittava() {
        kassapaate.syoMaukkaasti(390);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void maukkaidenLounaidenMyytyjenMaaraEiMuutuJosMaksuEiRiittava() {
        kassapaate.syoMaukkaasti(390);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void edullistenLounaidenMyytyjenMaaraEiMuutuJosMaksuEiRiittava() {
        kassapaate.syoEdullisesti(230);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void josKortillaTarpeeksiRahaaVeloitetaanSummaJaPalautetaanTrueMaukkaalleLounaalle() {
        assertTrue(kassapaate.syoMaukkaasti(maksukortti));
        assertEquals(600, maksukortti.saldo());
    }

    @Test
    public void josKortillaTarpeeksiRahaaVeloitetaanSummaJaPalautetaanTrueEdulliselleLounaalle() {
        assertTrue(kassapaate.syoEdullisesti(maksukortti));
        assertEquals(760, maksukortti.saldo());
    }

    @Test
    public void josKortillaTarpeeksiRahaaMyytyjenMaukkaidenLounaidenMaaraKasvaa() {
        kassapaate.syoMaukkaasti(maksukortti);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void josKortillaTarpeeksiRahaaMyytyjenEdullistenLounaidenMaaraKasvaa() {
        kassapaate.syoEdullisesti(maksukortti);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void josKortillaEiTarpeeksiRahaaMyytyjenMaukkaidenLounaidenMaaraEiKasva() {
        kassapaate.syoMaukkaasti(maksukortti);
        kassapaate.syoMaukkaasti(maksukortti);
        kassapaate.syoMaukkaasti(maksukortti);
        assertEquals(2, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void josKortillaEiTarpeeksiRahaaMyytyjenEdullistenLounaidenMaaraEiKasva() {
        kassapaate.syoEdullisesti(maksukortti);
        kassapaate.syoEdullisesti(maksukortti);
        kassapaate.syoEdullisesti(maksukortti);
        kassapaate.syoEdullisesti(maksukortti);
        kassapaate.syoEdullisesti(maksukortti);
        assertEquals(4, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void josKortillaEiTarpeeksiRahaaEiVeloitetaSummaaJaPalautetaanFalseMaukkaalleLounaalle() {
        kassapaate.syoMaukkaasti(maksukortti);
        kassapaate.syoMaukkaasti(maksukortti);
        assertFalse(kassapaate.syoMaukkaasti(maksukortti));
        assertEquals(200, maksukortti.saldo());
    }

    @Test
    public void josKortillaEiTarpeeksiRahaaEiVeloitetaSummaaJaPalautetaanFalseEdulliselleLounaalle() {
        kassapaate.syoEdullisesti(maksukortti);
        kassapaate.syoEdullisesti(maksukortti);
        kassapaate.syoEdullisesti(maksukortti);
        kassapaate.syoEdullisesti(maksukortti);
        assertFalse(kassapaate.syoEdullisesti(maksukortti));
        assertEquals(40, maksukortti.saldo());
    }

    @Test
    public void kassanRahaEiMuutuJosMaksaaKortilla() {
        kassapaate.syoMaukkaasti(maksukortti);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void kortilleLadatessaSaldoMuuttuuJaKassanRahaKasvaa() {
        kassapaate.lataaRahaaKortille(maksukortti, 500);
        assertEquals(1500, maksukortti.saldo());
        assertEquals(100500, kassapaate.kassassaRahaa());
    }

    @Test
    public void negatiivisenSummanLataaminenEiMuutaSaldoaJaKassanRahaEiKasva() {
        kassapaate.lataaRahaaKortille(maksukortti, -500);
        assertEquals(1000, maksukortti.saldo());
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
}
