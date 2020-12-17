package GUI;

import Game.PlayerObjects.Kurwe;

import java.util.HashSet;
import java.util.Set;

public class RenderTestDriver {
    public static Set<Kurwe> createKurweSet() {
        Set<Kurwe> kurwes = new HashSet<Kurwe>();

        for(int i = 1; i <= 4; i++) {
            Kurwe kurwe = new Kurwe(i);
            for(int x = 0; x < (int) (Math.random() * 5000); x++)
                kurwe.move();
            kurwes.add(kurwe);
        }

        return kurwes;
    }


}
