package jdbc.tasks;

public class TasksApp {

    public static void main(String[] args) {

        new TasksApp().start();
    }

    public void start() {
        String command = UI.nextCommand();
        UI.show(command);
    }
}
