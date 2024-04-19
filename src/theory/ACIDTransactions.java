package theory;

@SuppressWarnings("ALL")
public class ACIDTransactions {

    /*
    *  Todas as transações devem possuir as 4 características a seguir:
    *
    * A -> atomicity = atomicidade = transação deve ser atômica = ou tudo ou nada executa, não pode ser parcial
    * C -> consistency = consistência = garantir que o sistema não seja quebrado e não entregue o que foi projetado
    * I -> isolation = isolamento = exemplo sistema web várias pessoas alterando o mesmo DB, as transações devem ser independentes uma da outra, ou seja, não pode interferir em outra.
    * D -> durability = duração = persistir = colocar em um meio durável de gravação (exemplo disco do servidor do DB) para que possam ser acessados esses dados por outras transações
    *
    * Quando trabalha com transações ACID em JDBC não é necessário se preocupar muito com algumas coisas.
    *
    * O próprio banco de dados cuida muito da consistência e da durabilidade, porém, quanto a atomicidade já precisa de ajuda.
    * É preciso indicar ao escrever as queries, quais operações fazem parte de determinada transação.
    * Ao delimitar o escopo da transação o banco de dados vai cuidar de manter as coisas consistentes, duráveis e isoladas.
    *
    * Quanto ao isolamento é possível ajudar o banco de dados compreendendo que existem diversos tipos de níveis
    * de isolamento que podem ser configurados no DB para determinar a forma como as transações se comportarão
    * diante desse conceito.
    *
    * Quando temos muitos acessos ao mesmo banco podemos resolver algumas coisas pelo nível de isolamento, porém,
    * professor salientou que o isolamento total implica em menos performance.
    *
    * Por isso vai chegar na avaliação da balança entre performance da aplicação x consistência necessária, que varia
    * em cada caso.
    *
    * No curso será focado a parte de atomicidade, que é a parte que mais envolve o programador, utilizando o JDBC com
    * as operações de commit e rollback
    *
    *
    * */
}
