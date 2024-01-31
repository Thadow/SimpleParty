package io.thadow.simpleparty.utils.messages;

import io.thadow.simpleparty.Main;
import io.thadow.simpleparty.utils.Utils;
import org.bukkit.entity.Player;

import java.util.List;

public class Messages {

    public static void sendPartyDisbandedMessage(Player player) {
        String message = Main.getInstance().getConfig().getString("Messages.Party disbanded");
        message = Utils.format(message);
        player.sendMessage(message);
    }

    public static void sendNotTheLeaderMessage(Player player) {
        String message = Main.getInstance().getConfig().getString("Messages.Not the leader");
        message = Utils.format(message);
        player.sendMessage(message);
    }

    public static void sendNotInAPartyMessage(Player player) {
        String message = Main.getInstance().getConfig().getString("Messages.Not in a Party");
        message = Utils.format(message);
        player.sendMessage(message);
    }

    public static void sendPartyCreatedMessage(Player player) {
        String message = Main.getInstance().getConfig().getString("Messages.Party created");
        message = Utils.format(message);
        player.sendMessage(message);
    }

    public static void sendAlreadyInPartyMessage(Player player) {
        String message = Main.getInstance().getConfig().getString("Messages.Already in a Party");
        message = Utils.format(message);
        player.sendMessage(message);
    }

    public static void sendHelpMessage(Player player) {
        List<String> message = Main.getInstance().getConfig().getStringList("Messages.Usage");
        message = Utils.format(message);
        for (String line : message) {
            player.sendMessage(line);
        }
    }

    public static void sendPermissionDenyMessage(Player player) {
        String message = Main.getInstance().getConfig().getString("Messages.No Permission");
        message = Utils.format(message);
        player.sendMessage(message);
    }
}
