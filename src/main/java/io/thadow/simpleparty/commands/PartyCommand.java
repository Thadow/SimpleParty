package io.thadow.simpleparty.commands;

import io.thadow.simpleparty.Main;
import io.thadow.simpleparty.api.party.Party;
import io.thadow.simpleparty.api.party.PartyMember;
import io.thadow.simpleparty.api.party.PartyRole;
import io.thadow.simpleparty.party.PartyManager;
import io.thadow.simpleparty.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PartyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("simpleparty.commands.main")) {
                    List<String> usageMessage = Main.getInstance().getConfig().getStringList("Messages.Usage");
                    usageMessage = Utils.format(usageMessage);
                    for (String line : usageMessage) {
                        player.sendMessage(line);
                    }
                    return true;
                } else {
                    player.sendMessage(Utils.getPermissionDenyMessage());
                }
            } else if (args[0].equalsIgnoreCase("create")) {
                if (player.hasPermission("simpleparty.commands.create")) {
                    List<PartyMember> members = new ArrayList<>();
                    members.add(new PartyMember(player, PartyRole.LEADER));
                    int maxSize = Main.getInstance().getConfig().getInt("Configuration.Parties.Max Size");
                    PartyManager.addParty(new Party(player, members, maxSize));
                    player.sendMessage("Party creada!");
                    return true;
                } else {
                    player.sendMessage(Utils.getPermissionDenyMessage());
                }
            }
            return true;
        }
        return false;
    }
}
