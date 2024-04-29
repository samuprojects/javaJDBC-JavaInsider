package jdbc.tasks;

@SuppressWarnings("ALL")
public class TasksApp {

    public static void main(String[] args) {

        new TasksApp().start();
    }

    public void start() {
        while (true) {
            Command command = UI.nextCommand();
            UI.show(command.toString());
        }
    }
}
