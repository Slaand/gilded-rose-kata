package com.gildedrose;

import com.gildedrose.updater.AgedBrieUpdater;
import com.gildedrose.updater.BackstagePassesUpdater;
import com.gildedrose.updater.ConjuredUpdater;
import com.gildedrose.updater.DefaultUpdater;
import com.gildedrose.updater.QualityUpdater;
import com.gildedrose.updater.SulfurasUpdater;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class QualityUpdateFactoryTest {

    @ParameterizedTest
    @MethodSource("provideItemsAndExpectedUpdaters")
    void testGetUpdater(Item item, Class<? extends QualityUpdater> expectedUpdaterClass) {
        QualityUpdater updater = QualityUpdateFactory.getUpdater(item);
        assertTrue(expectedUpdaterClass.isInstance(updater));
    }

    private static Stream<Arguments> provideItemsAndExpectedUpdaters() {
        return Stream.of(
                Arguments.of(new Item("Aged Brie", 5, 0), AgedBrieUpdater.class),
                Arguments.of(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20), BackstagePassesUpdater.class),
                Arguments.of(new Item("Sulfuras, Hand of Ragnaros", 0, 80), SulfurasUpdater.class),
                Arguments.of(new Item("Conjured Mana Cake", 3, 6), ConjuredUpdater.class),
                Arguments.of(new Item("Elixir of the Mongoose", 5, 7), DefaultUpdater.class)
        );
    }
}