//package com.company.games;
package hexlet.code.games;

//import com.company.view.Cli;
import hexlet.code.view.Cli;

public class Progression implements Game {
    private static final String GAME_NAME = "Progression";

    private static final int COUNT = 3;

    private static final int MAX_NUMBER = 1_001;

    private static final int MAX_LENGTH = 6;

    private static final int MIN_LENGTH = 5;

    @Override
    public void start(final String gamerName) throws Exception {
        System.out.println("What number is missing in the progression?");

        int counter = 0;

        while (counter < COUNT) {
            String sessionAnswer = session();
            if (sessionAnswer == null) {
                System.out.print("Correct!\n");
                counter++;
            } else {
                System.out.print(sessionAnswer);
                System.out.print(String.format("Let's try again, %s!\n",
                        gamerName));
                break;
            }
        }

        if (counter == COUNT) {
            System.out.print(String.format("Congratulations, %s!\n",
                    gamerName));
        }
    }

    @Override
    public String getName() throws Exception {
        return GAME_NAME;
    }

    @Override
    public String session() {
        int firstNumber = (int) (Math.random() * MAX_NUMBER);
        int progSpeed = (int) (Math.random() * MAX_NUMBER);
        int progLength = (int) (Math.random() * MAX_LENGTH) + MIN_LENGTH;
        int searchingElement = (int) (Math.random() * progLength);
        int[] progression = makeProgression(firstNumber, progSpeed, progLength);

        System.out.println("Question: "
                + progressionToString(progression, searchingElement));

        System.out.print("Your Answer: ");
        String answer = Cli.getLine();
        String result = check(progression[searchingElement], answer);
        if (result == null) {
            return null;
        } else {
            return String.format("'%s' is wrong answer ;(. "
                            + "Correct answer was '%s'.\n",
                    answer, result);
        }
    }

    private int[] makeProgression(final int firstNumber,
                                  final int speed,
                                  final int length) {
        int[] a = new int[length];
        a[0] = firstNumber;
        for (int i = 1; i < length; i++) {
            a[i] = a[i - 1] + speed;
        }
        return a;
    }

    private String progressionToString(final int[] progression,
                                       final int index) {
        String answer = "";
        for (int i = 0; i < progression.length; i++) {
            if (i == index) {
                answer += ".. ";
            } else {
                answer += progression[i] + " ";
            }
        }
        return answer;
    }

    private String check(final int result, final String answer) {
        if (!Cli.isNumeric(answer)) {
            return Integer.toString(result);
        } else if (Integer.parseInt(answer) == result) {
            return null;
        } else {
            return Integer.toString(result);
        }
    }
}
