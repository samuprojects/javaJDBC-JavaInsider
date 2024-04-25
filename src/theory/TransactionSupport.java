package theory;

@SuppressWarnings("ALL")
public class TransactionSupport {

    /*
    * Para adicionar suporte ao uso de transações no framework é necessário alterar a classe DBConn
    * porque é ela quem encapsula o objeto Connection do JDBC. É ele que posssui os métodos necessários
    * para trabalhar com transações, como o setAutoCommit, commit e o rollback.
    *
    * Para isso vamos expor as operações através de um método que chama o setAutoCommit
    * passando false, necessário para abrir uma transação JDBC, e relançando a exceção
    * desse método para o DAOException.
    *
    * Depois copiado esse código para o commit e para o rollback.
    *
    * Voltando a classe ProcessCustomer4 inserido o método criado para iniciar a transação, logo após
    * as informações da conexão, e no fim o método para dar o commit.
    *
    * Após o teste tudo funcionou como esperado, os dados quando devidamente corretos e sem a presença de erros foram
    * lançados no DB e qualquer outro problema o rollback foi automaticamente realizado mantendo a consistencia do banco.
    *
    * Assim encerra-se a construção de um framework para ser utilizado em qualquer sistema com banco de dados por meio do JDBC
    *
    * */
}
