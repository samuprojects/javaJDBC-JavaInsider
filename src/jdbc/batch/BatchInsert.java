package jdbc.batch;

/*
* Para saber quando utilizar o Batch Update é necessário realizar testes
* Professor explicou que utilizando ferramentas observa qual o melhor desempenho
* dependendo do cenário em que está.
* Por exemplo, para inserir 500 mil registros, faz testes com o PreparedStatement,
* depois com o Batch, se o Batch foi melhor testa a quantidade de agrupamentos para cada Batch
* no intuito de chegar numa otimização que faça sentido em ganho de desempenho.
*
* Trocando o executeUpdate() pelo addBatch(), este último vai guardar, dentro do PreparedStatement,
* a informação na memória, ou seja, não é enviada diretamente ao banco de dados, vai acumulando
* até que seja enviado tudo com a chamada ao executeBatch().
*
* Enfim o Batch serve apenas para atrasar o envio para o banco de dados.
* */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

public class BatchInsert {

    public static void main(String[] args)  throws Exception {

        Random random = new Random();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "admin")) {

            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO customer (name, email, age) VALUES (?, ?, ?)")) {

                for (int i = 1; i <= 100; i++) {
                    stmt.setString(1, String.format("Customer %03d", i));
                    stmt.setString(2, String.format("c%03d@email.com", i));
                    stmt.setInt(3, random.nextInt(10, 80));
                    //stmt.executeUpdate(); // com essa iteração faz 100 chamadas no banco
                    stmt.addBatch();
                }

                stmt.executeBatch();
            }
        }
    }
}
