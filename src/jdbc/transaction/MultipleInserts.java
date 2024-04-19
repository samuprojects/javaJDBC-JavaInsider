package jdbc.transaction;

/*
* Realizando inserts múltiplos sem transação e seus efeitos colaterais
* Para isso inserido um registro de pessoa e um telefone associado a ela.
* Para recuperar o id gerado utilizamos o getGeneratedKeys() e depois o
* getInt porque a informação da chave gerada está dentro do ResultSet já no
* primeiro registro, primeira coluna.
* Para isso acrescentado também essa instrução no SQL utilizando
* Statement.RETURN_GENERATED_KEYS, pois havia dado erro sem isso.
*
* Depois foi confirmado a inserção graficamente no workbench e excluído os registros da "maria".
* (observado que o professor estava com a estrutura do banco diferente das aulas anteriores (não tinha a coluna city)).
*
* Depois seguiu para inserir os dados na tabela phone utilizando o id gerado na primeira tabela (no primeiro insert)
*
* Apesar de tudo funcionar não é o cenário ideal conforme o professor vai mostrar mais a frente
* */

import java.sql.*;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class MultipleInserts {

    public static void main(String[] args) throws  Exception {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "admin")) {

            int customerId;

            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO customer (name, email, age) VALUES (?, ?, ?)", RETURN_GENERATED_KEYS)) {
                stmt.setString(1, "Maria");
                stmt.setString(2, "maria@email.com");
                stmt.setInt(3, 30);
                stmt.executeUpdate();

                try (ResultSet rs = stmt.getGeneratedKeys()){
                    rs.next();
                    customerId = rs.getInt(1); // vai receber o valor de customerId
                }
            }

            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO phone (customer_id, description, number) VALUES (?, ?, ?)")) {
                stmt.setInt(1, customerId);
                stmt.setString(2, "Celular");
                stmt.setString(3, "(21) 3498-49389");
                stmt.executeUpdate();
            }
        }
    }
}
