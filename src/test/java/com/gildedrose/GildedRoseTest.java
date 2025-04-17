package com.gildedrose;

import com.gildedrose.updater.QualityUpdater;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class GildedRoseTest {

    @Test
    void testUpdateQuality() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 5, 0),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80)
        };
        GildedRose gildedRose = new GildedRose(items);

        QualityUpdater mockUpdater = mock(QualityUpdater.class);
        try (MockedStatic<QualityUpdateFactory> mockedFactory = Mockito.mockStatic(QualityUpdateFactory.class)) {
            mockedFactory.when(() -> QualityUpdateFactory.getUpdater(any(Item.class)))
                    .thenReturn(mockUpdater);

            gildedRose.updateQuality();

            verify(mockUpdater, times(items.length)).update(any(Item.class));
        }
    }
}
