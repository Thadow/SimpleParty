package io.thadow.simpleparty.api.party;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.List;

public class Party {

    @Getter
    Player leader;
    @Getter
    List<PartyMember> members;
    @Getter
    int maxSize;

    public Party(Player leader, List<PartyMember> members, int maxSize) {
        this.leader = leader;
        this.members = members;
        this.maxSize = maxSize;
    }
}
