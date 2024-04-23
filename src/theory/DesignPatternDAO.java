package theory;

@SuppressWarnings("ALL")
public class DesignPatternDAO {

    /*
    *
    * Existe um problema em você várias partes da aplicação dependendo do banco de dados
    * porque ao alterar alguma coisa no banco pode ser que tenha que varrer o código
    * para revisar o que foi alterado.
    *
    * Para resolver isso nasceu um Design Pattern (Padrão de projeto) com uma proposta de
    * solução para esse problema conhecido.
    * Esses padrões não estão atrelados a uma linguagem de programação específica, pois,
    * visam resolver um problema específico independente da tecnologia empregada.
    *
    * Cabe ao programador Java implementar de acordo com suas especificações.
    *
    * Um Design Pattern muito famoso quando se trabalha com acessos ao banco de dados é o DAO.
    * O Data Access Object (Objeto de Acesso a Dados) consiste em ter um ponto central de comunicação
    * com o banco de dados.
    *
    * Ou seja, para conversar com o banco as partes da aplicação vdeverão passar por uma camada de DAO.
    *
    * Atrelado a isso existe um componente chamado Connection Factory responsável por criar uma conexão com o
    * banco de dados.
    *
    * O DAO conversa com a ConnFactory para obter uma conexão e os conceitos da aplicação que serão persistidos
    * podem ser organizados em classes específicas de acordo com as tabelas do banco de dados.
    * Por exemplo, uma tabela com os dados de usuários podem ser representados na aplicação por uma classe User
    * e também ter o equivalente a um UserDAO como a classe para implementar as operações de banco de
    * dados referentes a esse usuário.
    * Outro exemplo, ter um Customer e um CustomerDAO, e assim por diante.
    *
    * Esse mapeamento de 1 para 1 visa organizar o código de forma que as classes DAO sejam uma
    * especialização do DAO e, na criação de coisas novas, haja a implementação das operações
    * sobre essa novidade em específico sem alterar a estrutura de conexão composta por ConnFactory + DAO + DB.
    *
    * Enfim, o objetivo é deixar simples com apenas um ponto único de acesso ao DB com um conjunto de classes
    * para abstrair esse acesso, reduzindo as dependências na criação de novas coisas da aplicação quanto
    * a parte de abrir conexão, fechar conexão, trabalhar com transações e etc.
    *
    * Os conceitos a frente serão para criar um framework DAO a fim de dar suporte à integração de aplicações Java
    * com o banco de dados e que pode ser reaproveitado em outros projetos.
    *
    *       sem DAO                          com DAO
    *                          |
    * APP             APP      |                    ConnFactory
    *   \             /        |                       ^
    *    \          /          |                       |
    *     \       /            |                      DAO  --------> DB
    *      |     /             |         User          ^
    *     |->DB<-|             |          |         ___|
    *      ^  ^  ^             |          |       /
    *     /   |  \             |          V     /
    *   App   |   \            |        UserDAO
    *         |    \           |
    *         App   \         |
    *                App       |
    *                          |
    *
    * */
}
