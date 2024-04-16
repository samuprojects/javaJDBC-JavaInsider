package jdbc;

/*
* Aula 06
* Atualização do nome no registro com id 1
*
* Para operações de alterações como insert, update e delete utilizar o executeUpdate
* com a instrução SQL
*
* */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateCustomers {

    public static void main(String[] args) throws Exception {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "admin")) {
            System.out.println("Connected successfully!");

            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("UPDATE customer SET name = 'Pedro Silva' WHERE id = 1");
            }

            System.out.println("Customer updated!");
        }
    }
}
