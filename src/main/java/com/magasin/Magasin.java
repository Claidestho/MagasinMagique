package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {

            Item item = items[i];
            item.sellIn = item.sellIn - 1;

            if (item.name.equals("Comte")) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            } else if (item.name.equals("Pass VIP Concert")) {
                if (item.sellIn > 10) {
                    item.quality = item.quality + 1;
                } else {
                    item.quality = item.quality + 2;
                    if (item.sellIn < 5) {
                        item.quality = item.quality + 1;
                    }
                }
                if (item.sellIn <= 0) {
                    item.quality = 0;
                }
        }
            else if (item.name.equals("Kryptonite")) {
            item.sellIn = 0;
            item.quality = 80;
        } else if (item.name.equals("Pouvoirs Magiques")) {
            item.quality = item.quality - 2;
        } else {
            if (item.quality > 50) {
                item.quality = 50;
            }
            if (item.sellIn >= 0) {
                item.quality = item.quality - 1;
            } else {
                item.quality = item.quality - 2;
            }
            if (item.quality < 0) {
                item.quality = 0;
            }
        }
    }
}
}