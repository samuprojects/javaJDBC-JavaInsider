package theory;

@SuppressWarnings("ALL")
public class ReturningID {

    /*
    * Até o momento, ao gravar no banco, não houve comunicação retornando esse ID
    *
    * Para o JDBC retornar essa informação, quando chamamos o executeUpdate, e existe
    * a geração automatica de chaves, pode ser recuperado pelo método
    * getGeneratedKeys() do PreparedStatement. Ele retorna um ResultSet que colocamos
    * num try-with-resources para fechar adequadamente, e um next para ir ao próximo registro.
    * Depois chamamos um getInt(1) para retornar o inteiro da primeira coluna gerado no banco de dados.
    *
    * Para retornar essa possibilidade de comunicação entre o DB e o framework foi realizado as seguintes alterações no DAO:
    *
    * no insert ao invés de void vai retornar a chave do tipo ID gerado pelo banco. Se não gerar nada vai retornar o que já existe.
    * alterado a classe DAO e CustomerDAO, além do ProcessCustomer.
    *
    * Após as alterações e execução deu o erro Generated keys not requested.
    * O professor explicou que o JDBC só permite que receba a informação da chave se passar a flag
    * indicada na exceção (Statement.RETURN_GENERATED_KEYS) no executeUpdate() (ou executeLargeUpdate())
    * O professor orientou passar essa constante no retorno do prepareStatement na classe de conexão DBConn
    * inclusive utilizando import estático para reduzir o código.
    * Dessa forma estará habilitando a questão da geração das chaves para todos os inserts, updates, enfim,
    * habilitando a comunicação do DB com a aplicação Java sobre a informação da chave gerada.
    *
    * Após isso o novo insert retornou automaticamente o ID gerado pelo DB
    *
    *
    *
    *
    * */
}
