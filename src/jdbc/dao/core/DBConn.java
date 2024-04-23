package jdbc.dao.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

@SuppressWarnings("ALL")
public class DBConn implements AutoCloseable { // AutoCloseable permite Objetos da classe sejam usados na definição de estruturas de try-with-resources

    private final Connection conn;

    public DBConn(Connection conn) {
        this.conn = conn;
    }

    public PreparedStatement statement(String sql) {
        try {
            return conn.prepareStatement(sql, RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void close() { // método obrigatório do AutoCloseable
        try {
            conn.close();
        } catch (SQLException e) {
            throw new DAOException("Error closing connection", e);
        }
    }
}
