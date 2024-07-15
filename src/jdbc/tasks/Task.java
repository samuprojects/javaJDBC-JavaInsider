package jdbc.tasks;

@SuppressWarnings("ALL")
public record Task(Integer id, String description) {

    public Task(String description) {
        this(null, description);
    }
}
