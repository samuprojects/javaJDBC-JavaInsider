package jdbc.batch;

/*
* Inserido alteração para demonstrar que devido lançamento em coluna do tipo int com dados do tipo texto
* na presença de exceção o Batch executou todos os registros no banco EXCETO O QUE FOI INCORRETO
* tornando o banco de dados inconsistente.
* (Observar que do customer 49 pulou para o 51)
* # id, name, email, age, city
    '257', 'Customer 047', 'c047@email.com', '38', NULL
    '258', 'Customer 048', 'c048@email.com', '44', NULL
    '259', 'Customer 049', 'c049@email.com', '18', NULL
    '260', 'Customer 051', 'c051@email.com', '35', NULL
    '261', 'Customer 052', 'c052@email.com', '64', NULL
    '262', 'Customer 053', 'c053@email.com', '33', NULL
*
* Correção na outra classe...
* */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

public class BatchInsertError {

    public static void main(String[] args)  throws Exception {

        Random random = new Random();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "admin")) {

            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO customer (name, email, age) VALUES (?, ?, ?)")) {

                for (int i = 1; i <= 100; i++) {
                    stmt.setString(1, String.format("Customer %03d", i));
                    stmt.setString(2, String.format("c%03d@email.com", i));

                    if (i == 50) { // criando erro ao lançar texto na coluna idade
                        stmt.setString(3, "abc");
                    } else {
                        stmt.setInt(3, random.nextInt(10, 80));
                    }

                    stmt.addBatch();
                }

                stmt.executeBatch();
            }
        }
    }
}
