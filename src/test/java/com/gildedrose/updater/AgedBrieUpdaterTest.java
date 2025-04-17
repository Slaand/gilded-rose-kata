package com.gildedrose.updater;

import com.gildedrose.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieUpdaterTest {

    @ParameterizedTest
    @CsvSource({
            "10, 20, 9, 21",  // +1 to quality
            "-1, 20, -2, 22", // +2 to quality when sellIn is less than 0
            "0, 49, -1, 50",  // Test quality cap
            "-1, 50, -2, 50"  // Test quality cap
    })
    void testUpdate(int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        Item item = new Item("Aged Brie", sellIn, quality);
        AgedBrieUpdater updater = new AgedBrieUpdater();

        updater.update(item);

        assertEquals(expectedSellIn, item.sellIn);
        assertEquals(expectedQuality, item.quality);
    }
}
