package io.thadow.simpleparty.party;

import io.thadow.simpleparty.api.party.Party;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class PartyManager {
    @Getter
    private static List<Party> parties = new ArrayList<>();

    public static void addParty(Party party) {
        parties.add(party);
    }

    public static void removeParty(Party party) {
        parties.remove(party);
    }
}
