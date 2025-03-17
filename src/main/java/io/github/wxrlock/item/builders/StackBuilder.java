package io.github.wxrlock.item.builders;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collection;
import java.util.Map;

public interface StackBuilder {

    StackBuilder setMaterial(Material material);

    StackBuilder setData(int durability);

    StackBuilder setAmount(int amount);

    StackBuilder setType(Material material, int data);

    StackBuilder setType(Material material, int data, int amount);

    StackBuilder setDisplay(String display);

    StackBuilder setLore(String... lore);

    StackBuilder setLore(Collection<String> lore);

    StackBuilder setLoreLine(int line, String text);

    default StackBuilder setLoreLineIf(boolean condition, int line, String text) {
        if (condition) setLoreLine(line, text);
        return this;
    }

    StackBuilder addLore(String... lore);

    StackBuilder addLore(Collection<String> lore);

    default StackBuilder addLoreIf(boolean condition, String... lore) {
        if (condition) addLore(lore);
        return this;
    }

    default StackBuilder addLoreIf(boolean condition, Collection<String> lore) {
        if (condition) addLore(lore);
        return this;
    }

    StackBuilder remLoreLine(int... lines);

    default StackBuilder remLoreLineIf(boolean condition, int... lines) {
        if (condition) remLoreLine(lines);
        return this;
    }

    StackBuilder remLore(String... lore);

    StackBuilder remLore(Collection<String> lore);

    default StackBuilder remLoreIf(boolean condition, String... lore) {
        if (condition) remLore(lore);
        return this;
    }

    default StackBuilder remLoreIf(boolean condition, Collection<String> lore) {
        if (condition) remLore(lore);
        return this;
    }

    StackBuilder addEnchant(Enchantment enchantment, int level);

    default StackBuilder addEnchantIf(boolean condition, Enchantment enchantment, int level) {
        if (condition) addEnchant(enchantment, level);
        return this;
    }

    StackBuilder addEnchants(Map<Enchantment, Integer> enchants);

    default StackBuilder addEnchantsIf(boolean condition, Map<Enchantment, Integer> enchants) {
        if (condition) addEnchants(enchants);
        return this;
    }

    StackBuilder addEnchants(Collection<String> enchants);

    default StackBuilder addEnchantsIf(boolean condition, Collection<String> enchants) {
        if (condition) addEnchants(enchants);
        return this;
    }

    StackBuilder remEnchant(Enchantment enchantment);

    default StackBuilder remEnchantIf(boolean condition, Enchantment enchantment) {
        if (condition) remEnchant(enchantment);
        return this;
    }

    StackBuilder remEnchants(Collection<Enchantment> enchants);

    default StackBuilder remEnchantsIf(boolean condition, Collection<Enchantment> enchants) {
        if (condition) remEnchants(enchants);
        return this;
    }

    StackBuilder remEnchants(Enchantment... enchantments);

    default StackBuilder remEnchantsIf(boolean condition, Enchantment... enchantments) {
        if (condition) remEnchants(enchantments);
        return this;
    }

    StackBuilder setGlow(boolean condition);

    StackBuilder remGlow(boolean condition);

    StackBuilder setUnbreakable(boolean condition);

    StackBuilder addFlags(ItemFlag... flags);

    default StackBuilder addFlagsIf(boolean condition, ItemFlag... flags) {
        if (condition) addFlags(flags);
        return this;
    }

    StackBuilder addFlags(Collection<String> flags);

    default StackBuilder addFlagsIf(boolean condition, Collection<String> flags) {
        if (condition) addFlags(flags);
        return this;
    }

    StackBuilder remFlags(ItemFlag... flags);

    default StackBuilder remFlagsIf(boolean condition, ItemFlag... flags) {
        if (condition) remFlags(flags);
        return this;
    }

    StackBuilder remFlags(Collection<String> flags);

    default StackBuilder remFlagsIf(boolean condition, Collection<String> flags) {
        if (condition) remFlags(flags);
        return this;
    }

    ItemStack build();

    ItemMeta getItemMeta();

    ItemMeta setItemMeta(ItemMeta itemMeta);

}