package baseball;

public class Application {
    public static void main(String[] args) {
        try {
            Game.getGame().start();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
