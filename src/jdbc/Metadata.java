package jdbc;

/*
* O JDBC possui uma API para trabalhar com metadados.
* Metadados é a exposição da própria estrutura do banco de dados
* (tabelas, colunas, etc) para quem está usando a API do JDBC.
*
* O primeiro contato com metadados pode ser com o método getMetaData() que retorna
* um objeto do tipo DatabaseMetaData. Esse objeto permite, por exemplo, questionar
* o JDBC sobre quais são as tabelas que existem no banco de dados, por
* meio do getTables que passando os parâmetros como null vai retornar tudo em um ResultSet.
*
* Para identificar a estrutura rodou em modo debug a linha
* System.out.println(rs); e dentro do ResultSet buscou em
* columnDefinition / fields aparecendo 10 registros.
* Localizou um que possuía o columnName = TABLE_NAME.
*
* Depois apagando esse código mudou para getString passando o TABLE_NAME e
* armazenando em uma variável e exibindo na tela.
*
* O resultado foi a exibição de todas as tabelas internas do banco (incluindo as de sistema).
*
* Para filtrar isso e trazer apenas as tabelas do usuário mudou o parâmetro String[] types
* de getTable incluindo TABLE.
*
* Ainda assim apareceu apenas uma tabela de sistema, mas que também pode ser removida com outros critérios.
* E foi possível ver a tabela customer sem realizar um SELECT diretamente no banco de dados SQL
* apenas utilizando o JDBC.
*
* */

import java.sql.*;

public class Metadata {

    public static void main(String[] args) throws Exception {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "admin")) {
            System.out.println("Connected successfully!");

            DatabaseMetaData dbmd = conn.getMetaData();

            try (ResultSet rs = dbmd.getTables(null, null, null, new String[] { "TABLE" })) {
                while (rs.next()) {
                    String tableName = rs.getString("TABLE_NAME");
                    System.out.println(tableName);
                }
            }
        }
    }
}
