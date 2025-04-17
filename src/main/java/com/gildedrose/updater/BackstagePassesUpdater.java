package com.gildedrose.updater;

import com.gildedrose.Item;

public class BackstagePassesUpdater implements QualityUpdater {

    @Override
    public void update(Item item) {
        item.quality += qualityIncreaseBy(item.sellIn);

        if (item.quality > 50) {
            item.quality = 50;
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private int qualityIncreaseBy(int remainingDays) {
        if (remainingDays < 6) {
            return 3;
        } else if (remainingDays < 11) {
            return 2;
        } else {
            return 1;
        }
    }
}
