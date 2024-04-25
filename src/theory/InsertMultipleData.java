package theory;

@SuppressWarnings("ALL")
public class InsertMultipleData {

    /*
    * Conforme o modelo de dados do nosso banco podemos aproveitar para inserir
    * em uma única transação via aplicação dados de customer e phone nas
    * respectivas tabelas utilizando o framework criado.
    *
    * Para isso foi criado um novo ProcessCustomer4 apenas com o objeto da conexão
    *
    * Em seguida foi criado uma nova classe para representar essa tabela phone do banco no mundo da
    * orientação a objeto (pois até o momento só havíamos criado o customer). A criação seguiu
    * os mesmos moldes de Customer utilizando um record.
    *
    * Na sequencia foi criado o PhoneDAO para que a classe Phone possa se comunicar com o DB pelo DAO,
    * seguido do construtor com objeto de conexão e a sobrescrita dos métodos que desejados.
    *
    * Nesse momento será a operação de inserção (copiado a mesma lógica utilizada no CustomerDAO).
    * Alterando conforme os campos da tabela e a instrução SQL foi realizado teste no ProcessCustomer4
    *
    * Depois de instanciado um novo CustomerDAO passando a conexão,
    * inserido informações de Customer seguido do insert que retornará o id gerado no banco,
    * por isso armazenado em um Integer.
    *
    * Na sequencia instanciado o PhoneDAO passando a mesma conexão, depois
    * a criação do objeto phone com os atributos pegando a variável do tipo Integer
    * que foi retornada no insert do Customer, além das outras informações da tabela phone.
    *
    * Em seguida realizado insert passando o objeto phone.
    *
    * Obs.: na primeira vez que o código do professor foi executado deu um erro porque
    * na instrução SQL havia colocado uma das colunas com escrita no modelo comum do Java
    * customerId, em Camel Case, não podemos esquecer que no banco o comum é utilizar o
    * underscore, que após alteração para customer_id rodou normalmente.
    *
    * Esse erro serviu para mostrar que a primeira operação foi executada inserindo apenas os
    * dados de customer.
    * A após a correção foi inserido outro customer incluindo os dados de phone.
    * Isso ocorreu porque a inserção AINDA é feita em duas partes e NÃO está dentro de uma transação.
    *
    * Para isso precisamos adicionar o suporte à abertura e fechamento de transações dentro
    * do nosso framework.
    *
    *
    *
    *
    *
    * */
}
