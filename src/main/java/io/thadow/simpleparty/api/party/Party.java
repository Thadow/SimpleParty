package io.thadow.simpleparty.api.party;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.List;

@Getter @Setter
public class Party {

    String leader;
    List<PartyMember> members;
    PartyPrivacy privacy;
    int maxSize;

    public Party(String leader, List<PartyMember> members, PartyPrivacy privacy, int maxSize) {
        this.leader = leader;
        this.members = members;
        this.privacy = privacy;
        this.maxSize = maxSize;
    }
}
