package com.magasin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    public void testComte10sellin15qualityAndQualityGrowing() {
        Item[] items = new Item[]{new Item("Comte", 10, 15)};
        Magasin magasin = new Magasin(items);
        for(int day = 0; day < 10; day++){
            magasin.updateQuality();
        }
        int expected = 25;
        Assertions.assertEquals(expected, items[0].quality);
    }

    @Test
    public void testComteQualityNeverAbove50() {
        Item[] items = new Item[]{new Item("Comte", 10, 15)};
        Magasin magasin = new Magasin(items);
        for(int day = 0; day < 200; day++){
            magasin.updateQuality();
        }
        assertEquals(50, items[0].quality);
    }

    @Test
    public void testKryptoniteQualityStay() {
        Item[] items = new Item[]{new Item("Kryptonite", 20, 15)};
        Magasin magasin = new Magasin(items);
        for(int day = 0; day < 200; day++){
            magasin.updateQuality();
        }
        assertEquals(80, items[0].quality);
    }

    @Test
    public void testKryptoniteSellinStay() {
        Item[] items = new Item[]{new Item("Kryptonite", 20, 15)};
        Magasin magasin = new Magasin(items);
        for(int day = 0; day < 30; day++){
            magasin.updateQuality();
        }

        assertEquals(0, items[0].sellIn);
    }

    @Test
    public void testQualityDecayFasterAfterSellinNull() {
        Item[] items = new Item[]{new Item("test", 5, 15)};
        Magasin magasin = new Magasin(items);
        for(int day = 0; day < 6; day++){
            magasin.updateQuality();
        }
        assertEquals(8, items[0].quality);
    }

    @Test
    public void testVipPassGain2QualityBefore10Day() {
        Item[] items = new Item[]{new Item("Pass VIP Concert", 10, 20)};
        Magasin magasin = new Magasin(items);
        for(int day = 0; day < 5; day++){
            magasin.updateQuality();
        }
        assertEquals(30, items[0].quality);
    }

    @Test
    public void testVipPassGain3QualityBefore5Day() {
        Item[] items = new Item[]{new Item("Pass VIP Concert", 10, 20)};
        Magasin magasin = new Magasin(items);
        for(int day = 0; day < 6; day++){
            magasin.updateQuality();
        }
        assertEquals(33, items[0].quality);
    }

    @Test
    public void testVip0AfterSellinDate() {
        Item[] items = new Item[]{new Item("Pass VIP Concert", 6, 20)};
        Magasin magasin = new Magasin(items);
        for(int day = 0; day < 10; day++){
            magasin.updateQuality();
        }
        assertEquals(0, items[0].quality);
    }

    public void testMagicPowerDecay2TimesFaster() {
        Item[] items = new Item[]{new Item("Pouvoirs magiques", 5, 5)};
        Magasin magasin = new Magasin(items);
        for(int day = 0; day < 1; day++){
            magasin.updateQuality();
        }
        assertEquals(3, items[0].quality);
    }
}