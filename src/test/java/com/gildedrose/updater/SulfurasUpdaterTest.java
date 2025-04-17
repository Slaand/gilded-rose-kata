package com.gildedrose.updater;

import com.gildedrose.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SulfurasUpdaterTest {

    @ParameterizedTest
    @CsvSource({
            "0, 80, 0, 80"   // Legendary item remains constant
    })
    void testUpdate(int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        Item item = new Item("Sulfuras, Hand of Ragnaros", sellIn, quality);
        SulfurasUpdater updater = new SulfurasUpdater();

        updater.update(item);

        assertEquals(expectedSellIn, item.sellIn);
        assertEquals(expectedQuality, item.quality);
    }
}
