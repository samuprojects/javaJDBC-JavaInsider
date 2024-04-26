package theory;

@SuppressWarnings("ALL")
public class UserActions {

    /*
    * As ações (comandos) que o usuário pode praticar na aplicação são:
    * list para fazer uma listagem
    * quit para encerrar e sair da aplicação
    * insert para inserir uma tarefa por meio de um parâmetro que é a tarefa
    * update passando um id e a tarefa
    * delete passando um id
    *
    * Para modelar isso e fazer o parse (a partir do texto digitado pelo usuário fazer a quebra
    * dessa informação, identificar o que é pra ser feito, jogar pra tarefa que tem de ser realizado
    * e validar se o que digitou é válido) da linha de comando vamos representar essas ações
    * utilizando um Enum.
    *
    * O Enum Action vai conter as ações possíveis.
    *
    * Para evitar problemas com letras digitadas maiúsculas ou minúsculas foi criado dentro do enum um
    * método estático para recerber esse array com os valores de Action.
    * Foi utilizado stream e aplicado filtros para comparar com a lista do enum e ignorando o tamanho da letra,
    * depois pega o primeiro registro e caso o registro não exista lança um ElseThrow
    *
    * Obs.: utilizar o value.of do Enum não ajuda porque ele faz diferenciação do Case e não encontraria valores corretamente.
    *
    * Em seguido foi criado uma classe Command (em record) para servir de agrupamento da ação e informações extras (parâmetros).
    * Os comandos escolhidos pelo usuário poderão ter nenhum parâmetro (no caso do list ou quit), ou um parâmetro (no caso do delete), ou pode
    * ter dois parâmetros (no caso do update). Por isso foi escolhido a estrutura de lista para abrigar essas informações.
    *
    *
    * */
}
