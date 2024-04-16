package jdbc;

/*
 * Aula 09
 * Outra forma de iterar sobre ResultSets
 *
 * SELECT COUNT(*) FROM customer é um SQL que possui a particularidade de
 * nunca retornar vazio (se a tabela estiver sem registros retorna 0),
 * se a tabela possuir registros retornará 1 ou maior do que 1.
 * Outro ponto é que sempre retornará apenas uma linha.
 *
 * Por isso nesse cenário é possível iterar sobre o ResultSet de forma diferente.
 *
 * Ao invés de fazer um while para iterar enquanto existir registro,
 * podemos chamar o next para ir para o próximo e o getInt para indicar a
 * coluna que vai retornar os dados.
 *
 * Isso acontece muito quando trabalha-se com count, sum, e outras funções de agregação.
 * O único cuidado a se tomar é que dependendo da função, a forma de agregar pode gerar um resultado
 * vazio (sem linhas), aí nesse caso o next() não vai funcionar (vai retornar false) e deverá ser
 * tratado no código.
 *
 * Na sequência o valor foi armazenado em uma variável inteiro para retornar a quantidade
 * de registros da tabela do banco de dados.
 *
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CountCustomers {

    public static void main(String[] args) throws Exception {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "admin")) {
            System.out.println("Connected successfully!");

            try (PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM customer")) {
                ResultSet rs = stmt.executeQuery();

                rs.next();
                int count = rs.getInt(1);
                System.out.println(count);

            }
        }
    }
}

