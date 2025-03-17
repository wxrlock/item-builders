package io.github.wxrlock.item.builders;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.meta.BannerMeta;

import java.util.*;

public class BannerBuilder extends ItemBuilder {

    private static final DyeColor BASE_COLOR = DyeColor.WHITE;
    private static final DyeColor DYE_COLOR = DyeColor.BLACK;

    private static final Map<String, List<Pattern>> ALPHABET_PATTERNS = new HashMap<>();

    static {
        ALPHABET_PATTERNS.put("A", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(DYE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_MIDDLE),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("B", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(DYE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(DYE_COLOR, PatternType.STRIPE_MIDDLE),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("C", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("D", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(BASE_COLOR, PatternType.CURLY_BORDER),
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("E", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_MIDDLE),
                new Pattern(BASE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("F", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_MIDDLE),
                new Pattern(BASE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("G", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(BASE_COLOR, PatternType.HALF_HORIZONTAL),
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("H", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_MIDDLE),
                new Pattern(DYE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("I", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(DYE_COLOR, PatternType.STRIPE_CENTER),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("J", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(BASE_COLOR, PatternType.HALF_HORIZONTAL),
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(DYE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("K", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_MIDDLE),
                new Pattern(BASE_COLOR, PatternType.HALF_VERTICAL_MIRROR),
                new Pattern(DYE_COLOR, PatternType.CROSS),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("L", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("M", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.TRIANGLE_TOP),
                new Pattern(BASE_COLOR, PatternType.TRIANGLES_TOP),
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("N", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(BASE_COLOR, PatternType.DIAGONAL_RIGHT_MIRROR),
                new Pattern(DYE_COLOR, PatternType.STRIPE_DOWNRIGHT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("O", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(DYE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("P", Arrays.asList(
                new Pattern(BASE_COLOR, PatternType.HALF_HORIZONTAL),
                new Pattern(DYE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(BASE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("Q", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(DYE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(BASE_COLOR, PatternType.BORDER),
                new Pattern(DYE_COLOR, PatternType.SQUARE_BOTTOM_RIGHT)
        ));

        ALPHABET_PATTERNS.put("R", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(BASE_COLOR, PatternType.HALF_HORIZONTAL_MIRROR),
                new Pattern(DYE_COLOR, PatternType.STRIPE_DOWNRIGHT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("S", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(BASE_COLOR, PatternType.RHOMBUS_MIDDLE),
                new Pattern(DYE_COLOR, PatternType.STRIPE_DOWNRIGHT),
                new Pattern(BASE_COLOR, PatternType.BORDER),
                new Pattern(BASE_COLOR, PatternType.CURLY_BORDER)
        ));

        ALPHABET_PATTERNS.put("T", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(DYE_COLOR, PatternType.STRIPE_CENTER),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("U", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(DYE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("V", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(BASE_COLOR, PatternType.TRIANGLES_BOTTOM),
                new Pattern(DYE_COLOR, PatternType.STRIPE_DOWNLEFT),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("W", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.TRIANGLE_BOTTOM),
                new Pattern(BASE_COLOR, PatternType.TRIANGLES_BOTTOM),
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("X", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(BASE_COLOR, PatternType.STRIPE_CENTER),
                new Pattern(DYE_COLOR, PatternType.CROSS),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("Y", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.CROSS),
                new Pattern(BASE_COLOR, PatternType.HALF_VERTICAL_MIRROR),
                new Pattern(DYE_COLOR, PatternType.STRIPE_DOWNLEFT),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("Z", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(DYE_COLOR, PatternType.STRIPE_DOWNLEFT),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("1", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.SQUARE_TOP_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_CENTER),
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("2", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(BASE_COLOR, PatternType.RHOMBUS_MIDDLE),
                new Pattern(DYE_COLOR, PatternType.STRIPE_DOWNLEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("3", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_MIDDLE),
                new Pattern(BASE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(DYE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("4", Arrays.asList(
                new Pattern(BASE_COLOR, PatternType.HALF_HORIZONTAL),
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(BASE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(DYE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_MIDDLE),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("5", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(DYE_COLOR, PatternType.STRIPE_DOWNRIGHT),
                new Pattern(BASE_COLOR, PatternType.CURLY_BORDER),
                new Pattern(DYE_COLOR, PatternType.SQUARE_BOTTOM_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("6", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(BASE_COLOR, PatternType.HALF_HORIZONTAL),
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(DYE_COLOR, PatternType.STRIPE_MIDDLE),
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("7", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(BASE_COLOR, PatternType.DIAGONAL_RIGHT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_DOWNLEFT),
                new Pattern(DYE_COLOR, PatternType.SQUARE_BOTTOM_LEFT),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("8", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(DYE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(DYE_COLOR, PatternType.STRIPE_MIDDLE),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("9", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(BASE_COLOR, PatternType.HALF_HORIZONTAL_MIRROR),
                new Pattern(DYE_COLOR, PatternType.STRIPE_MIDDLE),
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(DYE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));

        ALPHABET_PATTERNS.put("0", Arrays.asList(
                new Pattern(DYE_COLOR, PatternType.STRIPE_TOP),
                new Pattern(DYE_COLOR, PatternType.STRIPE_RIGHT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_BOTTOM),
                new Pattern(DYE_COLOR, PatternType.STRIPE_LEFT),
                new Pattern(DYE_COLOR, PatternType.STRIPE_DOWNLEFT),
                new Pattern(BASE_COLOR, PatternType.BORDER)
        ));
    }

    public BannerBuilder() {
        super(Material.BANNER);
    }

    public BannerBuilder setLetter(String letter) {
        final BannerMeta bannerMeta = (BannerMeta) getItemMeta();
        for (Pattern pattern : ALPHABET_PATTERNS.getOrDefault(letter, Collections.emptyList())) {
            bannerMeta.addPattern(pattern);
        }

        setItemMeta(bannerMeta);
        return this;
    }

}