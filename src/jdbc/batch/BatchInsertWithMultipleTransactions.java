package jdbc.batch;

/*
* No dia a dia pode ocorrer de ter um batch tão grande, executando numa transação, que pode exceder a capacidade do banco de dados
* lidar com o volume de dados para fazer uma atualização numa transação.
* O banco de dados tem um TransactionLog que registra tudo que deve ser realizado no banco de dados para depois
* aplicar as mudanças ou fazer o rollback do que já foi realizado.
* Como o Transaction Log não é ilimitado pode ocorrer, por exemplo, de 1 milhão de inserts numa única transação, no mesmo batch,
* não ser suportado pelo banco, o que gerará o lançamento de uma exceção produzida pelo fabricante do banco com alguma coisa do tipo
* "o transaction log está cheio", etc.
* Uma solução para esse problema e não abandonar as transações é realizar esse processo parcialmente, executando commits de tempos
* em tempos.
* Para isso precisamos de um mecanismo para quebrar o batch em pedaços.
* Podemos, por exemplo, escolher até quantos registros colocar dentro de 1 batch.
* Para saber o melhor número é importante a realização de vários testes para encontrar o cenário
* ideal do ponto de vista de performace, tempo de execução, etc.
*
*
* */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

public class BatchInsertWithMultipleTransactions {

    public static void main(String[] args)  throws Exception {

        Random random = new Random();
        int batchMaxSize = 50; // após o envio dos primeiros 50 registros, faz a efetivação do commit e começa outra nova.

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "admin")) {

            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO customer (name, email, age) VALUES (?, ?, ?)")) {

                conn.setAutoCommit(false); // agora tudo estará dentro da transação

                for (int i = 1; i <= 100; i++) {
                    stmt.setString(1, String.format("Customer %03d", i));
                    stmt.setString(2, String.format("c%03d@email.com", i));
                    stmt.setInt(3, random.nextInt(10, 80));

                    stmt.addBatch();

                    if (i % batchMaxSize == 0) { // mecanismo que faz a checagem se o resto é zero (commits no 50, 100, 150, etc)
                        stmt.executeBatch();
                        conn.commit(); // como o JDBC retorna o setAutoCommit para true, mudar para false na sequencia
                        conn.setAutoCommit(false);
                    }
                }

                stmt.executeBatch(); // executa os restantes finais dos registros
                conn.commit(); // realiza o último commit para encerrar o processo.
            }
        }
    }
}
