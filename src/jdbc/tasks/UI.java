package jdbc.tasks;

import java.util.Scanner;

import static java.util.Objects.isNull;

public final class UI {

    private UI () {}

    public static String nextCommand() {
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine().trim();
    }

    public static void show(String text) {
        if (!isNull(text)){
            System.out.println(text);
            System.out.println();
        }
    }
}
