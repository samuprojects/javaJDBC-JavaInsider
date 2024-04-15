package theory;

@SuppressWarnings("ALL")
public class JDBCConcept {

    /*
    *
    * Grande parte dos sistemas trabalham com dados que devem ser armazenados em algum lugar.
    * Uma das soluções existentes para isso a utilização de banco de dados.
    * Nessa categoria existem os banco de dados relacionais com seus diversos fabricantes.
    * Quando construímos uma aplicação é necessário interagir com o banco de dados.
    * Como cada banco de dados internamente tem sua própria forma de funcionamento na prática ninguém
    * cria aplicações em contato direto com determinado banco, pois, em caso de mudança do banco seria
    * necessário readequar toda a aplicação para o novo formato de banco escolhido.
    *
    *       ---APLICACAO---
    *      /   /    \      \
    *     /   /      \      \
    * MySQL Oracle SQLServer Entre outros...
    *
    *
    * Cada banco de dados possui uma implementação chamada de Driver criada por seu fabricante
    * Um Driver é uma interface de comunicação com o meio externo, ele abstrai algumas coisas,
    * deixando mais alto nível, para quem integrar com aquele componente possa despreocupar-se com as
    * questões de baixo nível.
    *
    * No contexto do Java e integração com o banco de dados envolve os JDBC Drivers
    * Que significa Java DataBase Connectivity (Conexão à banco de dados usando Java)
    * O JDBC nada mais é do que uma camada que "mora" entre o banco de dados e sua aplicação.
    * Ou seja, sua função é basicamente abstrair as coisas.
    *
    * Quando temos uma implementação do driver JDBC do MySQL a aplicação, basicamente, vai interagir com a API do JDBC
    * e não mais diretamente com o banco de dados. Internamente o JDBC interage com o Driver do MySQL, que sabe conversar
    * com esse banco.
    * A mesma coisa pode ocorrer com o banco de dados da Oracle, SQLServer, ou qualquer outro.
    *
    * Por ser o JDBC uma API independente do banco de dados o que está por trás dele, para a aplicação, não interessa.
    * A aplicação precisará somente executar duas coisas: configurar o driver (explicar para o driver como
    * chegar no banco de dados, relativo à conexão, senha do usuário, etc), e enviar instruções SQL
    * de Insert, Update, Delete e Select.
    *
    *       ---APLICACAO---
    *             |   SQL
    *             V
    *   _________________________
    *  |_________________________\ JDBC
     *      /   /    \      \
     *     /   /      \      \
     *    D   D        D      D
     * MySQL Oracle SQLServer Entre outros...
    *
    *
    * */
}
