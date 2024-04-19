package jdbc.transaction;

/*
* Definir o escopo da transação para que o JDBC execute todas as operações de uma única vez (atômica).
*
* Para isso chamamos o setAutoCommit passando false depois do try da conexão.
*
* Essa ação é necessária porque no padrão o Commit é habilitado automaticamente, ou seja, toda vez que uma operação é executada
* o commit é realizado. É justamente o commit que informa ao banco de dados proceder com as alterações.
*
* Dessa forma o commit vai ocorrer quando você desejar, no exemplo, após as duas operações de insert chamamos o commit() no objeto da conexão.
*
* Como inserimos um erro no segundo insert as alterações previstas no primeiro insert não serão persistidas no banco de dados resolvendo a inconsistência.
*
* Pontos a observar:
* após chamar o commit() o setAutoCommit() volta ao padrão true
*
* o rollback() pode ser chamado explicitamente para desfazer a transação, ou seja, as alterações no banco de dados não serão persistidas.
* O rollback é feito automaticamente se uma exceção for lançada, ou seja, se não houve um commit o rollback é chamado por padrão.
*
* Se quiser chamar o rollback explicitamente uma das formas é utilizando o bloco catch em um try depois da conexão conforme demonstrado no código
* e depois lançando a exceção.
*
* Se corrigir o código o commit será realizado e as alterações serão persistidas no banco de dados.
*
* */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

@SuppressWarnings("ALL")
public class MultipleInsertsWithTransaction {

    public static void main(String[] args) throws  Exception {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "admin")) {

            try {
                conn.setAutoCommit(false);

                int customerId;

                try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO customer (name, email, age) VALUES (?, ?, ?)", RETURN_GENERATED_KEYS)) {
                    stmt.setString(1, "Maria");
                    stmt.setString(2, "maria@email.com");
                    stmt.setInt(3, 30);
                    stmt.executeUpdate();

                    try (ResultSet rs = stmt.getGeneratedKeys()){
                        rs.next();
                        customerId = rs.getInt(1);
                    }
                }

                try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO phone (customer_id, description, number) VALUES (?, ?, ?)")) {
                    stmt.setInt(1, customerId); // erro causado para testar consequencia do insert sem transação, valor original customerId no lugar de 9999
                    stmt.setString(2, "Celular");
                    stmt.setString(3, "(21) 3498-49389");
                    stmt.executeUpdate();
                }

                conn.commit();
        } catch (Exception e) {
                conn.rollback();
                throw e;
            }
        }
    }
}
