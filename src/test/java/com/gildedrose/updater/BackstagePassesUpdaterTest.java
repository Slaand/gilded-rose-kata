package com.gildedrose.updater;

import com.gildedrose.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassesUpdaterTest {

    @ParameterizedTest
    @CsvSource({
            "15, 20, 14, 21", // +1 to quality
            "10, 20, 9, 22",  // +2 to quality
            "5, 20, 4, 23",   // +3 to quality
            "0, 20, -1, 0",   // Test quality drops to 0 after the concert
            "5, 49, 4, 50",   // Test quality cap
            "0, 50, -1, 0"    // Test case with max quality and sellIn < 0
    })
    void testUpdate(int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
        BackstagePassesUpdater updater = new BackstagePassesUpdater();

        updater.update(item);

        assertEquals(expectedSellIn, item.sellIn);
        assertEquals(expectedQuality, item.quality);
    }
}
