package jdbc.batch;

/*
* Para corrigir o problema da inconsistência com o Batch basta utilizar a transação nessa operação.
* Com isso ao gerar o erro será automaticamente executado um rollback devido à ausência do commit
* Dessa forma não haverá nenhuma alteração no banco de dados evitando que as operações com Batch
* executem de forma parcial mantendo a consistência.
* */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

public class BatchInsertAdjust {

    public static void main(String[] args)  throws Exception {

        Random random = new Random();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "admin")) {

            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO customer (name, email, age) VALUES (?, ?, ?)")) {

                conn.setAutoCommit(false); // agora tudo estará dentro da transação

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
                conn.commit(); // até aqui é o escopo da transação, qualquer erro antes disso será revertido pelo rollback automaticamente.
            }
        }
    }
}
