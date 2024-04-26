package jdbc.tasks;

import java.util.Arrays;

@SuppressWarnings("ALL")
public enum Action {

    LIST,
    INSERT,
    DELETE,
    UPDATE,
    QUIT;

    public static Action fromString(String actionStr) {
        return Arrays.stream(Action.values()).filter(a -> a.name().equalsIgnoreCase(actionStr)).findFirst().orElseThrow();
    }
}
