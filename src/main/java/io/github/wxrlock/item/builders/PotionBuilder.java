package io.github.wxrlock.item.builders;

import org.bukkit.Material;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.inventory.meta.PotionMeta;

public class PotionBuilder extends ItemBuilder {

    public PotionBuilder(int data) {
        super(Material.POTION, data);
    }

    public PotionBuilder addEffect(PotionEffectType type, int duration, int amplifier) {
        final PotionMeta potionMeta = (PotionMeta) getItemMeta();
        potionMeta.addCustomEffect(new PotionEffect(type, duration, amplifier), true);

        setItemMeta(potionMeta);
        return this;
    }

}