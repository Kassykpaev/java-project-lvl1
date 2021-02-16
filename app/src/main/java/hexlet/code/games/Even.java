package hexlet.code.games;

import hexlet.code.view.Cli;
//import com.company.view.Cli;

public class Even implements Game {
    private static final String GAME_NAME = "Even";

    private static final int MAX_NUMBER = 1_000_001;

    private static final int COUNT = 3;

    @SuppressWarnings("DesignForExtension")
    @Override
    public String getName() {
        return GAME_NAME;
    }

    @SuppressWarnings("DesignForExtension")
    @Override
    public void start(final String gamerName) {
        System.out.print("Answer 'yes' if the number is even,"
                + " otherwise answer 'no'.\n");

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
            System.out.print(String.format("Congratulations, %s!\n", gamerName));
        }
    }

    private String session() {
        int tmpNumber = (int) (Math.random() * MAX_NUMBER);
        System.out.print(String.format("Question: %d\n", tmpNumber));
        System.out.print("Your Answer: ");
        String answer = Cli.getLine();
        String result = check(tmpNumber, answer);
        if (result == null) {
            return null;
        } else {
            return String.format("'%s' is wrong answer ;(. "
                            + "Correct answer was '%s'.\n",
                    answer, result);
        }
    }

    private String check(final int number, final String answer) {
        if (!"yes".equals(answer) && !"no".equals(answer)) {
            return (number % 2 == 0 ? "yes" : "no");
        } else if ((number % 2 == 0 && "yes".equals(answer))
                || (number % 2 == 1 && "no".equals(answer))) {
            return null;
        } else {
            return (number % 2 == 0 ? "yes" : "no");
        }
    }
}
