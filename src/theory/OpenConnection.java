package theory;

@SuppressWarnings("ALL")
public class OpenConnection {

    /*
    *
    * Aula 03
    *
    * Para prosseguir com a integração com o banco é necessário baixar o driver no site do mysql
    * que possui o nome Connector/J (professou acessou na aula em
    * https://dev.mysql.com/downloads/connector/j/ )
    * foi selecionado Plataform Independent, mas explicou que poderia selecionar qualquer outro
    * correspondente ao seu sistema operacional em uso.
    * E optou por baixar o ZIP, sendo a outra opção um TAR.
    * Após extração localizou o arquivo JAR do conector para copiar e colar no classpath
    * da aplicação na IDE, fazendo com que seja enxergado pela aplicação.
    *
    * Dentro do Intellij criou uma pasta chamada (directory) libs e colou o JAR do conector.
    *
    * Para indicar que esse JAR fará parte do classpath da aplicação, com o botão direito do menu no JAR
    * inserido selecionar a opção Add as Library..., não mudou nada nas telas seguintes (mantendo como project).
    *
    * Vale lembrar que a partir daí a aplicação não fará interação diretamente com o driver my sql e sim com o JDBC.
    * É o JDBC que conversará com o Driver e este com o banco de dados.
    * Isso permite que somente trocando o driver e ajustando a configuração sua aplicação possa conversar com outro banco de dados.
    * Desde que utilize instruções SQL que são suportadas no outro banco de dados. Isso porque existe um conjunto de instruções SQL
    * que são suportadas em alguns bancos, mas não são suportadas em outros.
    * Se manter a utilização apenas das intruções que fazem parte do SQL ANSI, todos os bancos de dados vão suportar facilitando a troca.
    *
    * Em seguida foi criado uma classe de teste para checar o funcionamento da interação com o banco.
    *
    * Chamado a classe DriveManager que faz parte do pacote java.sql (tudo dentro desse pacote é JDBC) com getConnection e passando
    * a url de conexão com o banco de dados.
    * Uma URL de conexão é como cada driver vai especificar uma forma para se conectar com ele.
    * No MySQL o formato para indicar onde está o servidor, qual a porta e qual o banco que será conectado.
    * Em seguida passou usuário e senha que tem acesso ao banco.
    *
    * O método getConnection vai retornar um objeto Connection, foi optado lançar exceção para fora nesse momento.
    *
    * Ficar atento para fazer o import do Connection correto para não ter problemas de compilação.
    *
    * Após configurar uma mensagem e fechar a conexão para um teste positivo da conexão, o professor foi alterando alguns dados da senha,
    * usuário, porta, etc, para mostrar os erros comuns que podem surgir quando alguma coisa não funciona.
    *
    *
    * */
}
