package jdbc.dao.core;

/*
* Agora que temos uma ConnectionFactory que cria um DBConn, que é a conexão, vamos utilizar a conexão
* para fazer alguma coisa no banco de dados.
*
* Para isso criamos a classe DAO, que abstrata, não terá instância diretamente, isso porque teremos classes
* que vão herdá-la para adicionar os comportamentos de cada uma (inserção, exclusão, listagem, etc).
*
* Ela servirá como uma classe base, com algumas operações, com especializações nas subclasses.
*
* Utilizará um tipo genérico para funcionar com qualquer tipo de classe que venha herdá-la,
* foi inserido depois mais um tipo para receber o ID.
*
* Depois criado um tributo com objeto da conexão utilizando a visibilidade protected
* para que o DAO e as subclasses tenha acesso à conexão.
*
* Após criação do construtor com objeto da conexão inserido operações que podem ser
* sobrescritas pelas subclasses.
*
* Exemplos:
* Procurar pelo ID
*
* Foi utilizado nesse método o lançamento de uma UnsupportedOperationException()
* utilizada para indicar que uma operação não é suportada.
* Ou seja, se tentar chamar o método num DAO que não implementa ele vai chamar
*  a implementação da superclasse que fará o lançamento da exceção. O intuito disso
* é forçar as subclasses a implementar alguma coisa se querem utilizar esse método.
*
* Esse método retornaria uma entidade T, porém, como pode não ter registros na tabela
* a forma mais recomendada é o uso do Optional. Que funcionará como um container
* permitindo que tenha (ou não) algo dentro dele, evitando retornar null.
*
* Outro Exemplo:
* Operação de listagem
*
* O professor explicou que não definiu esses métodos como abstrato, e com uma implementação, porque isso obrigaria
* a subclasse a implementar o método, e às vezes não tem essa necessidade, porque não usaria o método.
* Essa é uma estratégia que se pode usar em situações onde se deseja que as subclasses implementem apenas o que ela precisa.
*
* Assim foram criadas classes (ConnectionFactory, DAO, DAOException, DBConn) totalmente genéricas, ou seja, que não dependem
* de uma aplicação específica, podendo ser reaproveitado em qualquer tipo de persistência em banco de dados.
*
*
* */

import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
public class DAO <T, ID> {

    protected final DBConn conn;

    public DAO(DBConn conn) {
        this.conn = conn;
    }

    public Optional<T> findById(ID id) {
        throw new UnsupportedOperationException();
    }

    public List<T> list() {
        throw new UnsupportedOperationException();
    }

    public void insert (T obj) {
        throw new UnsupportedOperationException();
    }

    public void deleteById (ID id) {
        throw new UnsupportedOperationException();
    }

    public void update(T obj) {
        throw new UnsupportedOperationException();
    }

    public List<T> select(String sql) {
        throw new UnsupportedOperationException();
    }
}
