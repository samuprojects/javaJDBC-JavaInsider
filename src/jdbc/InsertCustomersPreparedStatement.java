package jdbc;

/*
* O PreparedStatement (uma interface que estende Statement) também é um Statement(que tem o papel de ser o veículo que encaminha as instruções
* SQL para o banco de dados) só que mais especializado.
* O PreparedStatement trabalha um pouco diferente internamente porque pré compila a operação de Statement
* sendo necessário já fornecer a query, a instrução SQL, no momento da criação do objeto.
* Não é necessário passar os valores nesse momento, somente a estrutura do SQL, ficando no lugar pontos de interrogação (?),
* também com a utilização do try-with-resource.
* Antes de chamar o executeUpdate passar os parâmetros com set + tipo do dado e o índice é um número inteiro que representa o (?).
* E por último o executeUpdate não recebe mais parâmetros quando utilizamos o PreparedStatement, além de ficar despreocupado
* quanto ao uso das aspas simples.
* Outra vantagem do PreparedStatement é o fato da query já estar montada bastando apenas trocar os parâmetros,
* muito útil num cenário de loop.
*
* Se precisar escolher entre PreparedStatement e Statement o primeiro é melhor porque, além dos pontos já citados,
* também protege de SQL Injection, motivo esse que o professor reforçou que será utilizado PreparedStatement no restante do curso.
*
* */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertCustomersPreparedStatement {

    public static void main(String[] args) throws Exception {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "admin")) {
            System.out.println("Connected successfully!");

//            try (Statement stmt = conn.createStatement()) {
//                stmt.executeUpdate("INSERT INTO customer (name, email, age) VALUES ('Pedro', 'pedro@email.com', 20)");
//            }

            // Protege contra SQL Injection
            try(PreparedStatement stmt = conn.prepareStatement("INSERT INTO customer (name, email, age) VALUES (?, ?, ?)")) {
                stmt.setString(1, "Paulo"); // o número 1 representa o primeiro ponto de interrogação
                stmt.setString(2, "paulo@email.com");
                stmt.setInt(3, 25);
                stmt.executeUpdate();
            }

            System.out.println("Customer inserted!");
        }
    }
}
