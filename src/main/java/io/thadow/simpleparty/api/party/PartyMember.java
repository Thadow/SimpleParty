package io.thadow.simpleparty.api.party;

import lombok.Getter;
import org.bukkit.entity.Player;

import javax.naming.Name;

@Getter
public class PartyMember {

    String name;
    PartyRole role;

    public PartyMember(String name, PartyRole role) {
        this.name = name;
        this.role = role;
    }
}
