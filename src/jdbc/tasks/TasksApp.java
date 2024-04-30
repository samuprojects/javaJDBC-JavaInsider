package jdbc.tasks;

@SuppressWarnings("ALL")
public class TasksApp {

    public static void main(String[] args) {

        new TasksApp().start();
    }

    public void start() {
        while (true) {
            try {
                Command command = UI.nextCommand();

                UI.show(command.toString());
            } catch (InvalidCommandException e) {
                UI.show(e.getMessage());
            }

        }
    }
}
