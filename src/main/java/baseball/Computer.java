package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Computer {

    private static Computer computer = null;
    private List<Integer> randomNumbers;

    private Computer() {
        randomNumbers = generateRandomNumbers();
    }

    public static Computer getComputer() {
        if (computer == null) {
            computer = new Computer();
        }
        return computer;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> list = new ArrayList<>();
        while (list.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        return list;
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public void resetRandomNumbers() {
        randomNumbers = generateRandomNumbers();
    }

}
