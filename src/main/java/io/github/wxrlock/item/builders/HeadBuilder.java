package io.github.wxrlock.item.builders;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class HeadBuilder extends ItemBuilder {

    private static final String TEXTURE_URL = "https://textures.minecraft.net/texture/%s";
    private static final String TEXTURE_FORMAT = "{textures:{SKIN:{url:\"%s\"}}}";

    @SuppressWarnings("UnstableApiUsage")
    private static final Cache<String, GameProfile> PROFILE_CACHE = CacheBuilder.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .maximumSize(100)
            .build();

    public HeadBuilder() {
        super(Material.SKULL_ITEM, 3);
    }

    public HeadBuilder setOwner(String owner) {
        final SkullMeta skullMeta = (SkullMeta) getItemMeta();
        skullMeta.setOwner(owner);

        setItemMeta(skullMeta);
        return this;
    }

    public HeadBuilder setOwner(Player player) {
        return setOwner(player.getName());
    }

    public HeadBuilder setURL(String input) {
        if (!input.startsWith("https://")) {
            input = String.format(TEXTURE_URL, input);
        }

        final SkullMeta skullMeta = (SkullMeta) getItemMeta();
        final GameProfile profile = getProfileFromCacheOrCreate(input);
        setProfile(skullMeta, profile);

        setItemMeta(skullMeta);
        return this;
    }

    public HeadBuilder setBase64(String input) {
        final SkullMeta skullMeta = (SkullMeta) getItemMeta();
        final GameProfile profile = getProfileFromCacheOrCreateBase64(input);
        setProfile(skullMeta, profile);

        setItemMeta(skullMeta);
        return this;
    }

    @SuppressWarnings("UnstableApiUsage")
    private GameProfile getProfileFromCacheOrCreate(String input) {
        GameProfile profile = PROFILE_CACHE.getIfPresent(input);
        if (profile == null) {
            profile = createProfileFromURL(input);
            PROFILE_CACHE.put(input, profile);
        }
        return profile;
    }

    @SuppressWarnings("UnstableApiUsage")
    private GameProfile getProfileFromCacheOrCreateBase64(String input) {
        GameProfile profile = PROFILE_CACHE.getIfPresent(input);
        if (profile == null) {
            profile = createProfileFromBase64(input);
            PROFILE_CACHE.put(input, profile);
        }
        return profile;
    }

    private void setProfile(SkullMeta skullMeta, GameProfile profile) {
        try {
            Field profileField = skullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(skullMeta, profile);
        } catch (NoSuchFieldException | IllegalAccessException exception) {
            throw new RuntimeException("Error setting profile:", exception);
        }
    }

    private GameProfile createProfileFromURL(String input) {
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        String texture = Base64.getEncoder().encodeToString(String.format(TEXTURE_FORMAT, input).getBytes());
        profile.getProperties().put("textures", new Property("textures", texture));
        return profile;
    }

    private GameProfile createProfileFromBase64(String input) {
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", input));
        return profile;
    }

}