import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Вася", 10);
    Player player2 = new Player(2, "Петя", 40);
    Player player3 = new Player(3, "Миша", 20);
    Player player4 = new Player(4, "Коля", 10);
    Player player5 = new Player(5, "Оля", 50);

    @Test
    public void strongerPlayer2() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expected = 2;
        int actual = game.round("Вася", "Петя");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void equalPlayer() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expected = 0;
        int actual = game.round("Вася", "Коля");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void strongerPlayer1() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expected = 1;
        int actual = game.round("Оля", "Коля");
        Assertions.assertEquals(expected, actual);

    }


    @Test
    public void strongerNotExistPlayer1() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
                    game.round("Аня", "Петя");
                }
        );
    }

    @Test
    public void strongerNotExistPlayer2() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
                    game.round("Петя", "Аня");
                }
        );
    }

    @Test
    public void strongerPlayerMap() {
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        game.addPlayer(player5);
        int expected = 1;
        int actual = game.round1("Оля", "Коля");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void strongerPlayerMap1() {
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        game.addPlayer(player5);
        int expected = 2;
        int actual = game.round1("Миша", "Петя");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void strongerPlayerMap2() {
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        game.addPlayer(player5);
        int expected = 0;
        int actual = game.round1("Вася", "Коля");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void strongerNotExistPlayerWithMap() {
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        game.addPlayer(player5);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
                    game.round1("Петя", "Аня");
                }
        );
    }
    @Test
    public void strongerNotExistPlayerWithMap1() {
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        game.addPlayer(player5);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
                    game.round1("Аня", "Петя");
                }
        );
    }
}
