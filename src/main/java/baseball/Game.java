package baseball;

import java.util.*;

public class Game {

    private static Game game = null;
    private Computer computer = Computer.getComputer();
    private Player player = Player.getPlayer();

    private Game() {
    }

    public static Game getGame() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    public void start() {
        List<Integer> computerNumbers = computer.getRandomNumbers();
        while (true) {
            List<Integer> playerNumbers = player.getInputNumbers();
            if (compareNumbers(computerNumbers, playerNumbers)) {
                String replayInput = player.getReplayInput();
                if (replayInput.equals("1")) {
                    computer.resetRandomNumbers();
                    computerNumbers = computer.getRandomNumbers();
                } else if (replayInput.equals("2")) {
                    break;
                }
            }
        }
    }

    public boolean compareNumbers(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strike = 0, ball = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strike++;
            } else if (computerNumbers.contains(playerNumbers.get(i))) {
                ball++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (strike == 0 && ball == 0) {
            sb.append("낫싱");
        } else {
            if (ball > 0) {
                sb.append(ball).append("볼 ");
            }
            if (strike > 0) {
                sb.append(strike).append("스트라이크");
            }
        }
        System.out.println(sb);
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else {
            return false;
        }
    }

}
