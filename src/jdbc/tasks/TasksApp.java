package jdbc.tasks;

@SuppressWarnings("ALL")
public class TasksApp {

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
        interpreter = new CommandInterpreter();
    }
}
