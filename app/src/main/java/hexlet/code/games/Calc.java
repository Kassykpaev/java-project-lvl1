//package com.company.games;
package hexlet.code.games;

//import com.company.view.Cli;
import hexlet.code.view.Cli;

public class Calc implements Game {
    private static final String GAME_NAME = "Calc";

    private static final int MAX_NUMBER = 1_001;

    private static final int COUNT = 3;

    private static final String EXPRESSIONS = "+-*";

    @Override
    public String getName() throws Exception {
        return GAME_NAME;
    }

    @Override
    public void start(final String gamerName) {
        System.out.print("What is the result of the expression?");

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
    public String session() {
        int firstNumber = (int) (Math.random() * MAX_NUMBER);
        int secondNumber = (int) (Math.random() * MAX_NUMBER);
        int expression = (int) (Math.random() * EXPRESSIONS.length());

        System.out.println("Question: " + String.format("%d %c %d",
                firstNumber, EXPRESSIONS.charAt(expression),
                secondNumber));
        System.out.print("Your Answer: ");
        String answer = Cli.getLine();
        String result = check(firstNumber, secondNumber, expression, answer);
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
                         final int expression,
                         final String answer) {
        if (!Cli.isNumeric(answer)) {
            return null;
        }
        int result;
        if (expression == 0) {
            result = firstNumber + secondNumber;
        } else if (expression == 1) {
            result = firstNumber - secondNumber;
        } else {
            result = firstNumber * secondNumber;
        }
        if (Integer.parseInt(answer) == result) {
            return null;
        } else {
            return Integer.toString(result);
        }
    }
}
