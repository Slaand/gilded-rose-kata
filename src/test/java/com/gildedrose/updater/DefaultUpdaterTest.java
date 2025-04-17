package com.gildedrose.updater;

import com.gildedrose.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultUpdaterTest {

    @ParameterizedTest
    @CsvSource({
            "10, 20, 9, 19",
            "0, 20, -1, 18",  // Test additional decrease after sellIn < 0
            "-1, 1, -2, 0",   // Test quality does not go below 0
            "5, 0, 4, 0"      // Test case with 0 quality
    })
    void testUpdate(int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        Item item = new Item("+5 Dexterity Vest", sellIn, quality);
        DefaultUpdater updater = new DefaultUpdater();

        updater.update(item);

        assertEquals(expectedSellIn, item.sellIn);
        assertEquals(expectedQuality, item.quality);
    }
}
