package jdbc.tasks;

import java.util.List;

@SuppressWarnings("ALL")
public class CommandInterpreter {

    public String interpret (Command command) {
        var params = command.params();
        return switch (command.action()) {
            case LIST -> list();
            case QUIT -> quit();
            case INSERT -> insert(params);
            case DELETE -> delete(params);
            case UPDATE -> update(params);
        };
    }

    private String list() {
        return "TODO";
    }

    private String quit() {
        return "TODO";
    }

    private String insert (List<String> params) {
        return "TODO";
    }

    private String delete (List<String> params) {
        return "TODO";
    }

    private String update (List<String> params) {
        return "TODO";
    }
}
