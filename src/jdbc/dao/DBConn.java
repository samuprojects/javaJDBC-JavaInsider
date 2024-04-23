package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SuppressWarnings("ALL")
public class DBConn implements AutoCloseable { // AutoCloseable permite Objetos da classe sejam usados na definição de estruturas de try-with-resources

    private final Connection conn;

    public DBConn(Connection conn) {
        this.conn = conn;
    }

    public PreparedStatement statement(String sql) {
        try {
            return conn.prepareStatement(sql);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void close() throws Exception { // método obrigatório do AutoCloseable
        conn.close();
    }
}
