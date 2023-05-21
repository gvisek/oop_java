package lab5vjezba;

public class Factory {

    public static Game createGame(String name, int score){
        GameFactory gf= MyGame::new;
        Game g=gf.createGame(name, score);
        return g;
    }
}
