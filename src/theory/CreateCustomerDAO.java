package theory;

@SuppressWarnings("ALL")
public class CreateCustomerDAO {

    /*
    * Para organizar o código professor incluiu as classes
    * ConnectionFactory, DAO, DAOException e DBConn num pacote core
    *
    * e o teste da conexão em example onde será acrescido outros códigos
    *
    * Foi criado uma classe para representar o Customer do DB dentro da aplicação
    * utilizando record.
    * Professor aproveitou para relembrar que a utilização das classes wrappers em
    * cenários onde pode existir valores nulos (DB) é interessante e geralmente utilizado.
    * Serve também para diferenciar a falta de valor de um valor específico.
    *
    * Por exemplo: se colocar a idade como int, como presentar a falta da idade?
    *
    * Por isso não é muito utilizado os tipos primitivos nas classes que mapeiam
    * para as tabelas de bancos de dados.
    *
    *
    * Em seguida foi criado a classe CustomerDAO herdando de DAO e passando 2 tipos parametrizados
    * o primeiro é o tipo que será gerenciado pelo DAO que é o Customer, o segundo é o tipo da chave primária
    * que no nosso caso é Integer.
    * Ao fazer isso torna-se obrigatório implementar o construtor de DAO passando a conexão.
    * Depois sobrescrever os métodos que precisar conforme demonstrado no código da classe.
    *
    * Ao chamar a conexão em uma nova classe criada para teste, a IDE informou que a exceção lançada pelo
    * AutoCloseable da classe DBConn não foi tratada.
    * Para correção no método close da classe que representa a conexão foi removido o lançamento com o throws
    * para tratamento com try/catch.
    *
    * Na criação do Customer foi lembrado que o id é gerado pelo banco, por isso para corrigir, foi incluído um construtor
    * no record para receber só o name, email e age e passar para o super essa informações.
    *
    * Depois foi criado o CustomerDAO passando a conexão e depois chamando o insert passando o customer.
    *
    *
    *
    * */
}
