package jdbc;

/*
* O banco de dados é um recurso finito, limitado, que deve ser
* utilizado com muito cuidado. Muitas das vezes serão realizados
* muitos acessos na aplicação. Se não estiver utilizando a conexão
* deve fechá-la ou deixá-la disponível para outra requisição
* fazer uso dessa conexão.
*
* A forma mais interessante que o Java oferece para fechar recursos
* é através da estrutura try-with-resources. Ele dá a vantagem de
* fechar a conexão pela JVM automaticamente mesmo na presença
* de exceção.
*
* Esse processo feito manualmente pode, por exemplo, em caso de exceção
* a conexão ficar aberta porque não chegou a rodar o close.
*
* O mesmo deve ser feito para a interface Statement.
*
* Temos alguns tipos de executeUpdate() que deve ser utilizado para
* INSERT, UPDATE e DELETE
*
* O retorno do executeUpdate() é um inteiro que determina quantos registros
* foram modificados.
*
* Ele sempre realiza mudanças na tabela.
*
* Para os SELECT deve utilizar o executeQuery que vai retornar um ResultSet
*
* Se executar o INSERT mais de uma vez observado no workbench que foi repetido
* com o id 2 conforme parametrizado no banco o autoincrement do id
*
*
* */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertCustomers {

    public static void main(String[] args) throws Exception {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "admin")) {
            System.out.println("Connected successfully!");

            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("INSERT INTO customer (name, email, age) VALUES ('Pedro', 'pedro@email.com', 20)");
            }

            System.out.println("Customer inserted!");
        }
    }
}
