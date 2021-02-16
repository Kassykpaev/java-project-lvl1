//package com.company.games;
package hexlet.code.games;

//import com.company.view.Cli;
import hexlet.code.view.Cli;

public class GCD implements Game {

    private static final String GAME_NAME = "GCD";

    private static final int COUNT = 3;

    private static final int MAX_NUMBER = 1_001;

    @Override
    public void start(final String gamerName) throws Exception {
        System.out.println("Find the greatest common divisor"
                + " of given numbers.");

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
        int secondNumber = (int) (Math.random() * MAX_NUMBER);

        System.out.println("Question: " + String.format("%d %d",
                firstNumber,
                secondNumber));
        System.out.print("Your Answer: ");
        String answer = Cli.getLine();
        String result = check(firstNumber, secondNumber, answer);
        if (result == null) {
            return null;
        } else {
            return String.format("'%s' is wrong answer ;(. "
                            + "Correct answer was '%s'.\n",
                    answer, result);
        }
    }

    private String check(final int firstNumber,
                         final int secondNumber,
                         final String answer) {
        int result = gcd(firstNumber, secondNumber);
        if (!Cli.isNumeric(answer)) {
            return Integer.toString(result);
        } else if (Integer.parseInt(answer) == result) {
            return null;
        } else {
            return Integer.toString(result);
        }
    }

    private int gcd(final int x, final int y) {
        int a = x;
        int b = y;
        while (b > 0) {
            a %= b;
            int tmp = a;
            a = b;
            b = tmp;
        }
        return a;
    }
}
