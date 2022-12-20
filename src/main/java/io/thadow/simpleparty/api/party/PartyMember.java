package io.thadow.simpleparty.api.party;

import lombok.Getter;
import org.bukkit.entity.Player;

public class PartyMember {

    @Getter
    Player player;
    @Getter
    PartyRole role;

    public PartyMember(Player player, PartyRole role) {
        this.player = player;
        this.role = role;
    }
}
