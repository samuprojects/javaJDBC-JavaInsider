package jdbc.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.Objects.isNull;

@SuppressWarnings("ALL")
public final class UI {

    private UI () {}

    public static Command nextCommand() throws InvalidCommandException {
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);

        try {
            List<String> tokens = Arrays.asList(scanner.nextLine().split(" "));
            Action action = Action.fromString(tokens.get(0));

            List<String> params = new ArrayList<>();

            if (tokens.size() > 1) {
                params.add(tokens.get(1));

                if (tokens.size() > 2) {
                    params.add(String.join(" ", tokens.subList(2, tokens.size())).trim());
                }
            }

            return new Command(action, params);
        } catch (Exception e) {
            throw new InvalidCommandException();
        }
    }

    public static void show(String text) {
        if (!isNull(text)){
            System.out.println(text);
            System.out.println();
        }
    }
}
