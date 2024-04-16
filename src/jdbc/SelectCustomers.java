package jdbc;

/*
* Aula 08
* As instruções SELECT não alteram o banco de dados, basicamente trazem os dados que estão lá
* para dentro da aplicação.
*
* Lista dos customers cadastrados
*
* Utilizado o executeQuery() que retorna um ResultSet (utilizar try-with-resources)
*
* Geralmente se utiliza while para iterar enquanto existirem registros
*
* */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectCustomers {

    public static void main(String[] args) throws Exception {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "admin")) {
            System.out.println("Connected successfully!");

            try (PreparedStatement stmt = conn.prepareStatement("SELECT id, name, email, age FROM customer ORDER BY name")) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) { // next avança no caso do primeiro, e nos demais valida se o próximo é verdadeiro ou falso.
                        int id = rs.getInt("id"); // índice começa com 1, mas o melhor é utilizar o nome da coluna
                        String name = rs.getString("name");
                        String email = rs.getString("email");
                        int age = rs.getInt("age");

                        System.out.format("ID = %d, name = %s, email = %s, age = %d\n", id, name, email, age);
                    }
                }
            }

        }
    }
}
