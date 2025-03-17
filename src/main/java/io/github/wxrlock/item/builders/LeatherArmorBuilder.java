package io.github.wxrlock.item.builders;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class LeatherArmorBuilder extends ItemBuilder {

    public LeatherArmorBuilder(Material material) {
        super(material);
    }

    public LeatherArmorBuilder armorColor(Color color) {
        final LeatherArmorMeta leatherMeta = (LeatherArmorMeta) getItemMeta();
        leatherMeta.setColor(color);

        setItemMeta(leatherMeta);
        return this;
    }

    public LeatherArmorBuilder armorColor(int r, int g, int b) {
        final LeatherArmorMeta leatherMeta = (LeatherArmorMeta) getItemMeta();
        leatherMeta.setColor(Color.fromRGB(r, g, b));

        setItemMeta(leatherMeta);
        return this;
    }

    public LeatherArmorBuilder armorColor(String hex) {
        final LeatherArmorMeta leatherMeta = (LeatherArmorMeta) getItemMeta();
        leatherMeta.setColor(Color.fromRGB(
                Integer.parseInt(hex.substring(1, 3), 16),
                Integer.parseInt(hex.substring(3, 5), 16),
                Integer.parseInt(hex.substring(5, 7), 16)
        ));

        setItemMeta(leatherMeta);
        return this;
    }

}