package lab5vjezba;

@FunctionalInterface
public interface GameFactory {
    Game createGame(String name, int rating);
}
