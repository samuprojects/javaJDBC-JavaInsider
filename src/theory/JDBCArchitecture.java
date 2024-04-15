package theory;

@SuppressWarnings("ALL")
public class JDBCArchitecture {

    /*
    *
    * Aula 04
    *
    * Breve descrição do funcionamento interno do JDBC
    *
    * No desenho abaixo no nível mais inferior temos os bancos de dados.
    * Cada um deles possui a implementação de um driver JDBC liberado
    * pelo seu fabricante (pois há um interesse deles que aplicações
    * Java possam se comunicar com seus bancos).
    *
    * Quem interage com o driver é um componente chamado DriverManager
    * do qual o utilizamos a classe chamando o método getConnection
    * para obter a conexão.
    *
    * DriverManager.getConnection internamente vai buscar o driver necessário
    * para retornar uma Connection que é um objeto de conexão
    *
    * O objeto Connection é a porta de entrada para qualquer coisa que se deseja
    * fazer no banco de dados (representa a conexão).
    *
    * No contexto da conexão estabelecida vamos utilizar as interfaces dentro da aplicação
    * onde o tipo Statement permite executar uma instrução SQL que no caso de um SELECT
    * vai retornar dentro de um tipo de interface chamado ResultSet (que é um conjunto
    * de resultados), assim como PreparedStatement também retorna um ResultSet.
    *
    * Dentro do ResultSet estarão os dados retornados do banco de dados para utilização
    * na aplicação.
    *
    * -----------------------------------------------------------------
    * |    ResultSet                        ResultSet                |
    * |       ^              App               ^                     |
    * |       |                                |                     |
    * |    Statement                        PreparedStatement        |
    * |       ^                                ^                     |
    * |       |                                |                     |
    * |       |----------2-Connection----------|                     |
    * |                        ^                                     |
    * ----------------------------------------------------------------
    *                         |
    *                         |
    *        -----------1-DriverManager--------     getConnecton()
    *        |                |               |
    *        |                |               |
    *        V                V               V
    *   Oracle Driver     ODBC Driver    MySQL Driver
    *        |                |               |
    *        V                V               V
    *      Oracle            ODBC            MySQL
    *     Database         Database        Database
    *
    *
    *
    * */
}
