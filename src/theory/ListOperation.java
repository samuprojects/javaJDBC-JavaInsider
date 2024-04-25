package theory;

@SuppressWarnings("ALL")
public class ListOperation {

    /*
    *
    * Implementando a operação de List para retornar todos os registros
    *
    * A assinatura do método não recebe parâmetros e retorna uma lista de customers
    * Após abrir a conexão com uma instrução select, incluiu um catch para capturar
    * uma DAOException, porque na assnatura não lança checked Exceptions
    *
    * Na sequencia chamamos o executeQuery() que retornará um ResultSet (onde colocamos
    * num try-with-resources).
    * Agora é necessário extrair do ResultSet a informação das colunas.
    *
    * Para isso foi criado um método auxiliar para ajudar nessa extração e
    * que retorna um Customer com as informações das colunas.
    * Nesse método passamos um ResultSet como parâmetro para que a informação possa
    * ser extraída e acrescentamos um lançamento para fora de SQLException para ser capturado mais poara o final da implementação.
    *
    * Seguindo com um get para cada tipo de dado das coluna informamos o seus índices.
    * No retorno informamos as colunas que precisamos para o objeto Customer a ser retornado
    * return new Customer(id, name, email, age);
    * Dessa forma concluímos a extração dos dados de um ResultSet transformando-os num objeto Customer.
    *
    * Voltando a implementação do List para cada um dos registros do ResultSet chamamos um next() com
    * auxílio de um while para ir repetindo as chamadas.
    * Incluímos essas informações numa Lista , que começa vazia, de Customers, adicionando os customers
    * a cada iteração do while por meio do add passando o método de extração auxiliar que criamos e dentro
    * dele passamos a variável do ResultSet que chamou o next().
    *
    * Dessa forma é possível retornar os customers.
    *
    * Para testar a operação foi criado uma nova classe ProcessCustomer2 com
    * as informações de conexão e com um CustomerDAO.
    * Nele foi chamado o método list recém implementado que já retornará a lista pronta.
    * Para trazer cada um já com a impressão na tela foi aproveitado a StreamAPI para um
    * forEach passando um method reference para println
    * customerDAO.list().forEach(System.out::println);
    *
    * Enfim, ficou mais simples trabalhar com o framework depois de encapsular
    * todas as coisas dentro do DAO, fica centralizado e simplificado o uso.
    *
    *
    * */
}
