package com.gildedrose.updater;

import com.gildedrose.Item;

public class AgedBrieUpdater implements QualityUpdater {

    @Override
    public void update(Item item) {
        item.sellIn--;
        item.quality++;

        if (item.sellIn < 0) {
            item.quality++;
        }

        if (item.quality > 50) {
            item.quality = 50;
        }
    }
}
