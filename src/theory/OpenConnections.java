package theory;

@SuppressWarnings("ALL")
public class OpenConnections {

    /*
    * Para criar conexão com o banco foi criado a classe ConnectionFactory
    *
    * As informações necessárias à conexão (usuário, senha, url) não devem ficar explícitas no código
    * porque em eventual mudança será preciso alterar o código, recompilar, republicar para voltar ao funcionamento.
    *
    * O interessante é externalizar deixando em um arquivo de configuração.
    *
    * Para isso o professor instruiu na IDE Intellij, File / Project Structure... / Modules]
    * Na raiz do projeto com o botão direito do menu, New Directory e dar o nome de resources.
    * (poderia colocar o arquivo dentro do código fonte (src) mas o professor optou por deixar fora)
    * Definir a pasta como Resources caso a IDE não tenha feito automaticamente, de modo que
    * do lado direito tenha a descrição
    * Source folders
    * src..................
    *
    * Resource folders
    * resources............
    *
    * Se não fizer isso a JVM não encontrará o conteúdo da pasta resources.
    * Depois realizou um apply e ok.
    *
    *
    * Dentro da pasta resources criado arquivo de configuração em branco com nome db.properties
    * para colocar as informações de conexão e através de um objeto Properties do Java fazer
    * o carregamento dos dados
    *
    * Voltando a classe ConnectionFactory, é importante que tenha um método estático que ao ser
    * chamado retorne uma conexão (ele que terá toda a lógica de ir até o DB, conectar
    * utilizando as informações do arquivo de configuração , realizar o acesso,
    * criar o objeto DBConn e retornar).
    *
    * Como essa classe terá apenas esse método estático exposto, foi alterado a classe como final
    * para que não possa ser herdada.
    * Além disso foi criado um construtor vazio e privado.
    * Dessa forma ninguém fora de ConnectionFactory instanciará essa classe.
    *
    * Para inicializar as informações de bd.properties geralmente executa-se apenas uma vez.
    * (A não ser que o arquivo de configuração seja mutante e queira recarregar as informações
    * em tempo de execução, o que obriga a levar outros pontos, não citados pelo professor,
    * em consideração).
    * O normal é deixar em memória, após o carregamento, para otimizar um pouco mais.
    *
    * Como o getConnection é um método estático foi criado um bloco static para fazer a inicialização
    * Dentro dele foi utilizado um objeto Properties do pacote java.util, uma coleção antiga do Java,
    * que apesar de quase não ser utilizada (por se assemelhar ao Map), é aproveitada nesse contexto,
    * por exemplo, porque tem uma particularidade que é o método load().
    * O load() permite carregar as propriedades da conexão com base em uma InputStream ou Reader,
    * que por meio de sua lógica interna lê e realiza o parse das informações, trazendo para dentro da coleção.
    *
    * No load() passamos a ConnectionFactory chamando class, a fim de acessar o objeto class de ConnectionFactory,
    * seguido do getResourceAsStream para obter um recurso do class loader (como uma classe, ou um arquivo de configuração)
    * que esteja no class path (no caso na raiz do projeto, dentro da pasta resources) e transformar isso no InputStream
    * Não esquecer que a / no caminho é necessário porque o arquivo está na raiz do projeto.
    *
    * Como load() lança uma IO Exception foi realizado um try/catch relançando-a como uma RuntimeException
    * (porque não é possível declarar um throws no bloco static. Essa estratégia permite lançar uma exceção
    * e trabalhar com uma checked exception ao mesmo tempo. Ou seja, fazemos um catch da checked exception e
    * relança como unchecked exception).
    *
    * Com isso as informaão serão carregadas para dentro da classe e poderão ser armazenadas em atributos estáticos e final
    * para url, username e password.
    *
    * Depois é feito um match de cada propriedade com o atributo por meio do getProperty.
    *
    * o bloco static é garantido que será executado a primeira vez que a classe ConnectionFactory for acessada.
    *
    * Após isso basta seguir com a implementação do método getConnection chamando um return e chamando o JDBC com o DriverManager
    * e passando os atributos no getConnection.
    * Como isso é retornado no objeto DBConn criado, utilizamos o new passando os dados no construtor desse objeto.
    *
    * Como o método getConnection lança uma SQL Exception foi realizado um try/catch para relançar como uma DAOException
    * em mensagem específica e depois com a causa do problema.
    *
    * Assim termina a criação de uma Classe ConnectionFactory capaz de criar conexões.
    *
    * Após isso foi realizado teste apresentando a forma anterior de conexão,
    * que passavam os dados diretamente na getConnection, seguido de uma mensagem para indicar que deu certo e
    * por último fechar a conexão.
    *
    * Para transformar o método antigo e utilizar o ConnectionFactory basta trocar o DriverManager pela classe de conexão
    * que criamos, deixando os dados de conexão internalizados no getConnection.
    *
    * DBConn dbConn = ConnectionFactory.getConnection();
    * System.out.println("Connected successfully!");
    * dbConn.close();
    *
    * Professor simplificou ainda mais com o try-with-resources e ainda realizando o import
    * estático de ConnectionFactory deixando o código mais conciso e interessante, além
    * de poder ser reaproveitado em vários lugares sem precisar repetir os dados de conexão.
    *
    * */
}
