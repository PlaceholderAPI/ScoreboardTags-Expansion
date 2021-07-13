package com.placeholderapi.expansion.scoreboardtags;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardTagsExpansion extends PlaceholderExpansion {
    private final String VERSION = getClass().getPackage().getImplementationVersion();

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public String getAuthor() {
        return "Glare";
    }

    @Override
    public String getName() {
        return "ScoreboardTags";
    }

    @Override
    public String getIdentifier() {
        return "sbtags";
    }

    @Override
    public String getVersion() {
        return VERSION;
    }

    @Override
    public List<String> getPlaceholders() {
        final List<String> placeholders = new ArrayList<>();
        placeholders.add("%sbtags_has_tag_<tag>%");
        return placeholders;
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if (identifier.startsWith("has_tag_")) {
            final String tag = identifier.split("has_tag_")[1];
            return String.valueOf(player.getScoreboardTags().contains(tag));
        }

        return null;
    }
}
