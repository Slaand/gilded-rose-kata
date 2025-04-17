package com.gildedrose.updater;

import com.gildedrose.Item;

public class ConjuredUpdater implements QualityUpdater {

    @Override
    public void update(Item item) {
        item.sellIn--;
        item.quality = item.quality - 2;
        if (item.quality < 0) {
            item.quality = 0;
        }
    }
}
