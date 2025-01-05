package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Player {

    private static Player player = null;
    private List<Integer> inputNumbers;

    private Player() {
        inputNumbers = new ArrayList<>();
    }

    public static Player getPlayer() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }

    private void validateInputNumbers(String inputNumbers) {
        List<String> inputNumbersList = Arrays.asList(inputNumbers.split(""));
        if (inputNumbersList.size() != 3) {
            throw new IllegalArgumentException("입력한 숫자의 개수가 올바르지 않습니다. 게임 종료");
        }
        if (inputNumbers.chars().anyMatch(ch -> !Character.isDigit(ch))) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다. 게임 종료");
        }
        if (inputNumbersList.stream().distinct().count() != 3) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다. 게임 종료");
        }
    }

    public List<Integer> getInputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateInputNumbers(input);
        inputNumbers.clear();
        Arrays.stream(input.split("")).forEach(number -> inputNumbers.add(Integer.parseInt(number)));
        return inputNumbers;
    }

    private void validateReplayInput(int replayInput) {
        if (replayInput != 1 && replayInput != 2) {
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다. 게임 종료");
        }
    }

    public int getReplayInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int replayInput = Integer.parseInt(Console.readLine());
        validateReplayInput(replayInput);
        return replayInput;
    }

}
