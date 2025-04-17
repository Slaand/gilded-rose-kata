package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            // Aged Brie
            // Backstage passes
            // Sulfuras
            // TODO Conjured Mana Cake
            // Default

            if (item.name.equals("Aged Brie")) {
                item.sellIn = item.sellIn - 1;
                item.quality = item.quality + 1;

                if (item.sellIn < 0) {
                    item.quality = item.quality + 1;
                }

                if (item.quality > 50) {
                    item.quality = 50;
                }
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.sellIn < 6) {
                    item.quality = item.quality + 3;
                } else if (item.sellIn < 11) {
                    item.quality = item.quality + 2;
                } else {
                    item.quality = item.quality + 1;
                }

                if (item.quality > 50) {
                    item.quality = 50;
                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0) {
                    item.quality = 0;
                }
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                // legendary item, no quality and sellIn changes
            } else {
                item.sellIn = item.sellIn - 1;
                item.quality = item.quality - 1;
                if (item.sellIn < 0) {
                    item.quality = item.quality - 1;
                }

                if (item.quality < 0) {
                    item.quality = 0;
                }
            }
        }
    }
}
