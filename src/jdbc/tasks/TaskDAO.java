package jdbc.tasks;

import jdbc.dao.core.DAO;
import jdbc.dao.core.DAOException;
import jdbc.dao.core.DBConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO extends DAO<Task, Integer> {

    public TaskDAO(DBConn conn) {
        super(conn);
    }

    @Override
    public List<Task> list() {
        try (var stmt = conn.statement("SELECT id, description FROM task ORDER by id")) {
            List<Task> tasks = new ArrayList<>();
            try (var rs= stmt.executeQuery()) {
                while (rs.next()){
                    tasks.add(extractFromResultSet(rs));
                }
            }

            return tasks;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public Integer insert(Task task) {
        try (var stmt = conn.statement("INSERT INTO task (description) VALUES(?)")) {
            stmt.setString(1, task.description());
            stmt.executeUpdate();

            try (var rs = stmt.getGeneratedKeys()) {
                rs.next();
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private Task extractFromResultSet(ResultSet rs) throws SQLException {
        return new Task(rs.getInt("id"), rs.getString("description"));
    }
}
