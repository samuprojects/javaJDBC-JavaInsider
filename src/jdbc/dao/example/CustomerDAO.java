package jdbc.dao.example;

import jdbc.dao.core.DAO;
import jdbc.dao.core.DAOException;
import jdbc.dao.core.DBConn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO extends DAO<Customer, Integer> {

    public CustomerDAO(DBConn conn) {
        super(conn);
    }

    @Override
    public Integer insert(Customer customer) {
        try (PreparedStatement stmt = conn.statement("INSERT INTO customer (name, email, age) VALUES (?, ?, ?)")) {
            stmt.setString(1, customer.name());
            stmt.setString(2, customer.email());
            stmt.setInt(3, customer.age());
            stmt.executeUpdate();

            try (ResultSet keysRS = stmt.getGeneratedKeys()) {
                keysRS.next();
                return keysRS.getInt(1);
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
