package jdbc.transaction;

/*
* Gerado um erro de foreign key, ao tentar inserir um registro referenciando outro
* da tabela customer que não existe
*
* Como as operações são atômicas e separadas por si só, o primeiro insert foi realizado e o segundo deu erro.
*
* Com isso no workbench a tabela de telefone não recebeu o telefone para a outra "maria" inserida.
*
* Considerando um cenário em que os usuários inseridos precisam, obrigatoriamente, de um telefone associado, a
* aplicação tornou-se inconsistente.
*
* Por isso a importância de executá-las em uma única transação.
*
* */

import java.sql.*;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

@SuppressWarnings("ALL")
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
                    customerId = rs.getInt(1);
                }
            }

            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO phone (customer_id, description, number) VALUES (?, ?, ?)")) {
                stmt.setInt(1, 9999); // erro causado para testar consequencia do insert sem transação, valor original customerId no lugar de 9999
                stmt.setString(2, "Celular");
                stmt.setString(3, "(21) 3498-49389");
                stmt.executeUpdate();
            }
        }
    }
}
