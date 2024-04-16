package jdbc;

/*
* Aula 06
* Excluindo o registro com id 2
*
* Para operações de alterações como insert, update e delete utilizar o executeUpdate
 * com a instrução SQL
*
*
* */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteCustomers {

    public static void main(String[] args) throws Exception {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "admin")) {
            System.out.println("Connected successfully!");

            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("DELETE FROM customer WHERE id = 2");
            }

            System.out.println("Customer deleted!");
        }
    }
}
