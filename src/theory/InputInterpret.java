package theory;

@SuppressWarnings("ALL")
public class InputInterpret {

    /*
    *
    * Além de ler os dados do usuário é necessário interpretar isso através de uma classe que será definida como
    * CommandInterpreter com apenas um método que vai retornar o texto na tela.
    *
    * Quem chama esse método é o loop da classe executável (TaskApp) através de um novo atributo que criamos
    * junto com um método vinculado, que foi incluído antes do loop, mas chamando o atributo que é chamado primeiro pelo
    * método dentro do loop e no parâmetro do método passando o comando, para retornar a String com texto que tem que ser
    * escrito na tela.
    *
    * Em seguido esse texto é passado no método show logo na sequencia do código. Como já foi visto, se passar null
    * esse método de UI já está preparado para ignorar essa entrada.
    *
    * No text ao digitar o comando correto já retorna um texto genérico para todos os comandos, e qualquer outra coisa
    * não prevista informa comando inválido.
    *
    * Agora é necessário implementar uma lógica de interpretação para cada comando.
    *
    * Para isso o professor optou por utilizar uma estrutura switch passando o método action de Command que referencia as ações do enum
    * Action para implementar a lógica com cada case.
    *
    * O professor optou por utilizar métodos privados para cada case conforme código na classe CommanInterpreter.
    * No list bão recebeu parâmetros
    * No quit semelhante
    * No insert incluímos para receber um parâmetro, que nesse caso a assinatura foi usando uma lista params a fim de aproveitar a
    * responsabilidade do método insert de extrair os parâmetros de dentro e fazer a validação
    * No delete semelhante ao anterior
    * e por fim, no update, o mesmo esquema, seguindo depois com o preenchimento dos case para cada método privado.
    *
    * Foi criado um var params para receber os parâmetros nos case insert, delete, update.
    *
    * Na sequência o professor optou por utilizar um recurso (sintaxe) mais novo do Java que consiste em usar o switch como uma expression
    * de forma que o retorno dos métodos é feito pelo switch, por isso incluído um return no switch.
    *
    * No test vai retornar as ações genéricas que depois serão implementadas.
    *
    * */
}
