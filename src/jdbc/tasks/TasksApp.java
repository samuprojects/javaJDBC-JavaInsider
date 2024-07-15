package jdbc.tasks;

import jdbc.dao.core.ConnectionFactory;
import jdbc.dao.core.DBConn;

@SuppressWarnings("ALL")
public class TasksApp {

    private DBConn conn;
    private CommandInterpreter interpreter;

    public static void main(String[] args) {
        new TasksApp().start();
    }

    public void start() {
        setup();

        while (true) {
            try {
                Command command = UI.nextCommand();
                String text = interpreter.interpret(command);
                UI.show(text);
            } catch (InvalidCommandException e) {
                UI.show(e.getMessage());
            }
        }
    }

    private void setup() {
        conn = ConnectionFactory.getConnection();
        interpreter = new CommandInterpreter(new TaskDAO(conn));
    }
}
