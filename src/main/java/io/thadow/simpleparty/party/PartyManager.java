package io.thadow.simpleparty.party;

import com.sun.xml.internal.ws.wsdl.writer.document.Part;
import io.thadow.simpleparty.Main;
import io.thadow.simpleparty.api.party.Party;
import io.thadow.simpleparty.api.party.PartyMember;
import io.thadow.simpleparty.api.party.PartyPrivacy;
import io.thadow.simpleparty.api.party.PartyRole;
import io.thadow.simpleparty.utils.messages.Messages;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PartyManager {
    @Getter
    private static List<Party> parties = new ArrayList<>();

    public static void createParty(Player leader) {
        List<PartyMember> members = new ArrayList<>();
        members.add(new PartyMember(leader.getName(), PartyRole.LEADER));
        int maxSize = Main.getInstance().getConfig().getInt("Configuration.Parties.Max Size");
        PartyPrivacy privacy = PartyPrivacy.valueOf(Main.getInstance().getConfig().getString("Configuration.Parties.Default Privacy"));
        addParty(new Party(leader.getName(), members, privacy, maxSize));
        Messages.sendPartyCreatedMessage(leader);
    }

    public static void addParty(Party party) {
        parties.add(party);
    }

    public static void deleteParty(Party party) {
        parties.remove(party);
    }

    public static void disbandParty(Player player) {
        Party party = getParty(player);
        if (party == null) return;
        for (Player member : Objects.requireNonNull(getPartyMembers(player))) {
            Messages.sendPartyDisbandedMessage(member);
        }
        deleteParty(party);
    }

    public static boolean isTheLeader(Player player, Party party) {
        return party.getLeader().equalsIgnoreCase(player.getName());
    }

    public static boolean hasParty(Player player) {
        for (Party party : parties) {
            for (PartyMember member : party.getMembers()) {
                if (member.getName().equalsIgnoreCase(player.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Party getParty(Player player) {
        for (Party party : parties) {
            for (PartyMember member : party.getMembers()) {
                if (member.getName().equalsIgnoreCase(player.getName())) {
                    return party;
                }
            }
        }
        return null;
    }

    public static List<Player> getPartyMembers(Player player) {
        Party party = getParty(player);
        if (party == null) return null;
        List<Player> members = new ArrayList<>();
        for (PartyMember member : party.getMembers()) {
            Player m = Bukkit.getPlayerExact(member.getName());
            members.add(m);
        }
        return members;
    }
}
