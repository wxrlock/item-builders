package io.github.wxrlock.item.builders;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;
import java.util.stream.Collectors;

public class ItemBuilder implements StackBuilder {

    private final ItemStack item;
    private ItemMeta meta;

    public ItemBuilder(ItemStack item) {
        this.item = item;
        meta = item.getItemMeta();
    }

    public ItemBuilder(Material material) {
        item = new ItemStack(material);
        meta = item.getItemMeta();
    }

    public ItemBuilder(Material material, int data) {
        item = new ItemStack(material, 1, (short) data);
        meta = item.getItemMeta();
    }

    public ItemBuilder(Material material, int data, int amount) {
        item = new ItemStack(material, amount, (short) data);
        meta = item.getItemMeta();
    }

    @Override
    public StackBuilder setMaterial(Material material) {
        item.setType(material);
        return this;
    }

    @Override
    public StackBuilder setData(int data) {
        item.setDurability((short) data);
        return this;
    }

    @Override
    public StackBuilder setAmount(int amount) {
        item.setAmount(amount);
        return this;
    }

    @Override
    public StackBuilder setType(Material material, int data) {
        setMaterial(material);
        setData(data);
        return this;
    }

    @Override
    public StackBuilder setType(Material material, int data, int amount) {
        setMaterial(material);
        setData(data);
        setAmount(amount);
        return this;
    }

    @Override
    public StackBuilder setDisplay(String display) {
        meta.setDisplayName(display);
        return this;
    }

    @Override
    public StackBuilder setLore(String... lore) {
        meta.setLore(Arrays.stream(lore).collect(Collectors.toList()));
        return this;
    }

    @Override
    public StackBuilder setLore(Collection<String> lore) {
        meta.setLore(new ArrayList<>(lore));
        return this;
    }

    @Override
    public StackBuilder setLoreLine(int line, String text) {
        final List<String> current = meta.getLore() == null ? new ArrayList<>() : new ArrayList<>(meta.getLore());
        current.set(line, text);
        meta.setLore(current);
        return this;
    }

    @Override
    public StackBuilder addLore(String... lore) {
        final List<String> current = meta.getLore() == null ? new ArrayList<>() : new ArrayList<>(meta.getLore());
        Collections.addAll(current, lore);
        meta.setLore(current);
        return this;
    }

    @Override
    public StackBuilder addLore(Collection<String> lore) {
        final List<String> current = meta.getLore() == null ? new ArrayList<>() : new ArrayList<>(meta.getLore());
        current.addAll(lore);
        meta.setLore(current);
        return this;
    }

    @Override
    public StackBuilder remLoreLine(int... lines) {
        final List<String> current = meta.getLore() == null ? new ArrayList<>() : new ArrayList<>(meta.getLore());
        for (int line : lines) {
            current.remove(line);
        }
        meta.setLore(current);
        return this;
    }

    @Override
    public StackBuilder remLore(String... lore) {
        final List<String> current = meta.getLore() == null ? new ArrayList<>() : new ArrayList<>(meta.getLore());
        for (String line : lore) {
            current.remove(line);
        }
        meta.setLore(current);
        return this;
    }

    @Override
    public StackBuilder remLore(Collection<String> lore) {
        final List<String> current = meta.getLore() == null ? new ArrayList<>() : new ArrayList<>(meta.getLore());
        current.removeAll(lore);
        meta.setLore(current);
        return this;
    }

    @Override
    public StackBuilder addEnchant(Enchantment enchantment, int level) {
        meta.addEnchant(enchantment, level, true);
        return this;
    }

    @Override
    public StackBuilder addEnchants(Map<Enchantment, Integer> enchants) {
        enchants.forEach(this::addEnchant);
        return this;
    }

    @Override
    public StackBuilder addEnchants(Collection<String> enchants) {
        for (String key : enchants) {
            final String[] split = key.split(":");
            final Enchantment enchant = Enchantment.getByName(split[0]);
            final int level = Integer.parseInt(split[1]);
            addEnchant(enchant, level);
        }
        return this;
    }

    @Override
    public StackBuilder remEnchant(Enchantment enchantment) {
        meta.removeEnchant(enchantment);
        return this;
    }

    @Override
    public StackBuilder remEnchants(Collection<Enchantment> enchants) {
        enchants.forEach(this::remEnchant);
        return this;
    }

    @Override
    public StackBuilder remEnchants(Enchantment... enchantments) {
        for (Enchantment enchantment : enchantments) {
            remEnchant(enchantment);
        }
        return this;
    }

    @Override
    public StackBuilder setGlow(boolean condition) {
        if (condition) {
            addEnchant(Enchantment.LURE, 1);
            addFlags(ItemFlag.HIDE_ENCHANTS);
        }
        return this;
    }

    @Override
    public StackBuilder remGlow(boolean condition) {
        if (condition) {
            remEnchant(Enchantment.LURE);
            remFlags(ItemFlag.HIDE_ENCHANTS);
        }
        return this;
    }

    @Override
    public StackBuilder setUnbreakable(boolean condition) {
        meta.spigot().setUnbreakable(condition);
        return this;
    }

    @Override
    public StackBuilder addFlags(ItemFlag... flags) {
        meta.addItemFlags(flags);
        return this;
    }

    @Override
    public StackBuilder addFlags(Collection<String> flags) {
        for (String flag : flags) {
            addFlags(ItemFlag.valueOf(flag));
        }
        return this;
    }

    @Override
    public StackBuilder remFlags(ItemFlag... flags) {
        meta.removeItemFlags(flags);
        return this;
    }

    @Override
    public StackBuilder remFlags(Collection<String> flags) {
        for (String flag : flags) {
            remFlags(ItemFlag.valueOf(flag));
        }
        return this;
    }

    @Override
    public ItemStack build() {
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public ItemMeta getItemMeta() {
        return meta;
    }

    @Override
    public ItemMeta setItemMeta(ItemMeta itemMeta) {
        meta = itemMeta;
        return meta;
    }

}