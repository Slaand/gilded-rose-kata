package com.gildedrose;

import com.gildedrose.updater.AgedBrieUpdater;
import com.gildedrose.updater.BackstagePassesUpdater;
import com.gildedrose.updater.ConjuredUpdater;
import com.gildedrose.updater.DefaultUpdater;
import com.gildedrose.updater.QualityUpdater;
import com.gildedrose.updater.SulfurasUpdater;

public class QualityUpdateFactory {

    private QualityUpdateFactory() {}

    private static final QualityUpdater AGED_BRIE_UPDATER = new AgedBrieUpdater();
    private static final QualityUpdater BACKSTAGE_PASSES_UPDATER = new BackstagePassesUpdater();
    private static final QualityUpdater SULFURAS_UPDATER = new SulfurasUpdater();
    private static final QualityUpdater CONJURED_UPDATER = new ConjuredUpdater();
    private static final QualityUpdater DEFAULT_UPDATER = new DefaultUpdater();

    public static QualityUpdater getUpdater(Item item) {
        return switch (item.name) {
            case "Aged Brie" -> AGED_BRIE_UPDATER;
            case "Backstage passes to a TAFKAL80ETC concert" -> BACKSTAGE_PASSES_UPDATER;
            case "Sulfuras, Hand of Ragnaros" -> SULFURAS_UPDATER;
            case "Conjured Mana Cake" -> CONJURED_UPDATER;
            default -> DEFAULT_UPDATER;
        };
    }
}
