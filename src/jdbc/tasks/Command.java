package jdbc.tasks;

import java.util.List;

@SuppressWarnings("ALL")
public record Command(Action action, List<String> params) {
}
