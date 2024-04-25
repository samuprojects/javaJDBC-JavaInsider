package theory;

@SuppressWarnings("ALL")
public class TaskRegistration {

    /*
    * Para treinar a integração com banco utilizando JDBC e o uso do framework baseado no design pattern DAO
    * será criado uma aplicação de linha de comando para cadastro de tarefas.
    *
    * Para isso será criado uma classe para encapsular a integração com o console que deverá ter um método
    * para exibir texto na tela e outro para para capturar uma informação digitada pelo usuário.
    *
    * Criando a classe UI para representar a interface do usuário (parte gráfica), com métodos estáticos, por isso
    * definida como final para não ser estendida, e com construtor privado para não ser instanciada de fora. Assim
    * fica acessível apenas os métodos estáticos públicos dela.
    *
    * O primeiro método solicita para o usuário o próximo comando, para isso é necessário ler o que o usuário digita.
    * Incluído um sinal gráfico para representar um prompt, seguido de um scanner passando a Stream de entrada padrão do Java,
    * que está atrelada ao console (System.in).
    *
    * Depois utilizado nextLine para fazer a leitura do que o usuário digitou (esse método bloqueia e fica aguardando o usuário
    * digitar ENTER para prosseguir), seguido de um trim() para cortar os espaços, inicial e final que o usuário colocou, retornado
    * direto. (Esse método retorna uma string)
    *
    * Na sequencia criamos um outro método (void) para fazer o contrário, que é exibir dados na tela, passando o texto a ser mostrado na tela.
    * Vai contar o texto em ixibição com uma quebra de linha. Além disso o método ficará sem efeito se o texto for nulo.
    * Isso será útil quando for necessário exibir algo nulo e desejar que seja ignorado essa situação.
    *
    * Depois criado a classe TasksApp para testar se a classe UI está funcionando. Nela foi instanciado um objeto da própria classe chamando
    * um método start criado para literalmente indicar onde tudo vai começar.
    *
    * No método start() o professor explicou um procedimento chamado de eco utilizado apenas para testar se a classe UI está funcionando. Nele foi
    * chamado um nextCommand armazenado numa variável string, seguido da exibição na tela por meio do método show passando essa variável.
    *
    * Finalizando assim a parte gráfica da aplicação de linha de commando.
    * */
}
