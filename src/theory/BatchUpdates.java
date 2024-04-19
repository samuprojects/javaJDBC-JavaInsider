package theory;

@SuppressWarnings("ALL")
public class BatchUpdates {

    /*
    * Para fazer múltiplos inserts em uma tabela no banco de dados (ou qualquer outro tipo de update),
    * exemplo de 1 milhão de registros, pode-se recorrer a uma atualização em massa chamada de Batch Update.
    * Ele permite agrupar as requisições e enviar de uma vez só para o banco de dados.
    * Apesar de ter um volume de dados maior será apenas uma chamada de Rede.
    * Isso porque quando se fala de Rede é um recurso mais lento e por vezes sujeito a falhas. Ainda que o
    * PreparedStatement tenha uma certa otimização em relação ao Statement (que é 1 a 1), dependendo da
    * quantidade de requisições pode reduzir drasticamente o desempenho da aplicação.
    * É preferível enviar mais dados em menos chamadas do que fazer mais chamadas e enviar menos dados.
    * O processo de abertura de requisição (abrir canal de comunicação, enviar, fechar canal) tem um custo.
    *
    * Será visto como tirar proveito do JDBC na utilização do Batch Update.
    *
    *          PreparedStatement("...")
    *        ------------------->     |
    * APP    ------------------->     |  DB       |
    *        ------------------->     |           V
    *                                 |          |:(
    *                           ?     V
    *   _______                       Network
    *  |Batch |                       (TCP/IP)
    *  |Update|
    *  |______|
    *
    * */
}
