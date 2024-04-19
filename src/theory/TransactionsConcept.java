package theory;

@SuppressWarnings("ALL")
public class TransactionsConcept {

    /*
    *
    * Uma transação é algo atômico, ou tudo executa ou nada executa.
    *
    * Exemplo da conta bancária que em uma operação temos duas sub operações    *
    *
    * Conta Bancária       Transferência      Conta Bancária
    *       A                 R$200                B
    *     -200      ------------------------->   +200
    *
    * Conforme cenário exemplo, caso no ponto 1, que foi a subtração de 200, ao
    * chegar no ponto 2 a soma deu um problema (erro de sistema, erro de rede, etc)
    * se não estiver utilizando o conceito de transação haverá uma operação parcialmente realizada.
    * O dinheiro saiu da conta A mas nunca chegou ao seu destino.
    * Imaginar que isso está ocorrendo em um sistema bancário pode demonstrar a confusão que seria com os clientes.
    *
    * Para resolver isso colocamos tudo dentro de uma operação de transação onde você diz:
    * sai 200 da conta A, entra 200 na conta B, se ocorrer qualquer tipo de falha,
    * no meio do caminho, acontece uma operação chamada de rollback.
    * O Rollback consiste em voltar ao estado inicial antes da operação iniciar, ou seja,
    * no cenário bancário hipotético significa devolver os 200 para a conta A, cancelando
    * a primeira operação, deixando o estado exatamente como estava no sistema.
    *
    * O conceito de rollback se junta a um outro conceito que é o commit.
    * O commit ocorre quando finaliza as operações da transação, ou seja,
    * você diz para o banco de dados que o final da transação foi atingido e
    * agora pode proceder com todas as alterações necessárias para persistir
    * esses dados e deixar tudo consistente.
    *
    * Rollback para desfazer a operação
    * Commit para efetivar o que foi executado
    *
    * */
}
