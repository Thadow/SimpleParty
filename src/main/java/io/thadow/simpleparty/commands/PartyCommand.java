package io.thadow.simpleparty.commands;

import com.sun.xml.internal.ws.wsdl.writer.document.Part;
import io.thadow.simpleparty.api.party.Party;
import io.thadow.simpleparty.api.party.PartyPrivacy;
import io.thadow.simpleparty.party.PartyManager;
import io.thadow.simpleparty.utils.messages.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PartyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                Messages.sendHelpMessage(player);
                return true;
            } else if (args[0].equalsIgnoreCase("create")) {
                if (player.hasPermission("simpleparty.commands.create")) {
                    if (PartyManager.getParty(player) != null) {
                        Messages.sendAlreadyInPartyMessage(player);
                        return true;
                    }
                    PartyManager.createParty(player);
                    return true;
                } else {
                    Messages.sendPermissionDenyMessage(player);
                }
            } else if (args[0].equalsIgnoreCase("disband")) {
                if (player.hasPermission("simpleparty.commands.disband")) {
                    Party party = PartyManager.getParty(player);
                    if (party == null) {
                        Messages.sendNotInAPartyMessage(player);
                        return true;
                    }
                    if (!PartyManager.isTheLeader(player, party)) {
                        Messages.sendNotTheLeaderMessage(player);
                        return true;
                    }
                    PartyManager.disbandParty(player);
                } else {
                    Messages.sendPermissionDenyMessage(player);
                }
            } else if (args[0].equalsIgnoreCase("private")) {
                if (player.hasPermission("simpleparty.commands.changeprivacy")) {
                    Party party = PartyManager.getParty(player);
                    if (party == null) {
                        Messages.sendNotInAPartyMessage(player);
                        return true;
                    }
                    if (!PartyManager.isTheLeader(player, party)) {
                        Messages.sendNotTheLeaderMessage(player);
                        return true;
                    }
                    party.setPrivacy(PartyPrivacy.PRIVATE);
                } else {
                    Messages.sendPermissionDenyMessage(player);
                }
            }
            return true;
        }
        return false;
    }
}
