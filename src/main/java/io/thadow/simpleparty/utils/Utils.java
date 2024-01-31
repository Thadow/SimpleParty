package io.thadow.simpleparty.utils;

import io.thadow.simpleparty.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static String format(String m) {
        return ChatColor.translateAlternateColorCodes('&', m);
    }

    public static List<String> format(List<String> m) {
        List<String> newList = new ArrayList<>();
        for (String line : m) {
            line = ChatColor.translateAlternateColorCodes('&', line);
            newList.add(line);
        }
        return newList;
    }

    public static boolean isPlayer(String s) {
        return Bukkit.getPlayerExact(s) != null;
    }
}
