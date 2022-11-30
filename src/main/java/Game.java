import java.security.Key;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Game  {

    ArrayList<Player> players = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();

    public void register(Player player) {
        players.add(player);
    }
    public void addPlayer(Player player) {
        map.put(player.getName(), player.getStrength());
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }

        if (player1 == null) {
            throw new NotRegisteredException("Игрок с именем" + playerName1 + "не зарегестрирован");
        }
        {
            if (player2 == null) {
                throw new NotRegisteredException("Игрок с именем" + playerName2 + "не зарегестрирован");
            }
            if (player1.getStrength() > player2.getStrength()) {
                return 1;
            }
            if (player2.getStrength() > player1.getStrength()) {
                return 2;
            }
            return 0;
        }

    }

    public int round1(String playerName1, String playerName2) {
        String player1 = null;
        String player2 = null;
        for (String player : map.keySet()) {
            if (map.containsKey(playerName1)) {

                player1 = player;
            }
            if (map.containsKey(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException("Игрок с именем" + playerName1 + "не зарегестрирован");
        }
        {
            if (player2 == null) {
                throw new NotRegisteredException("Игрок с именем" + playerName2 + "не зарегестрирован");
            }
           if (map.get(playerName1) > map.get(playerName2)) {
                return 1;
            }
            if (map.get(playerName2) > map.get(playerName1)) {
                return 2;
            }
            return 0;
        }

    }}



