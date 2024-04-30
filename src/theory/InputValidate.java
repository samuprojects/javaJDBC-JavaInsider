package theory;

@SuppressWarnings("ALL")
public class InputValidate {

    /*
    * O nextCommand da classe UI não está preparado para responder a solicitações diferentes das ações previstas
    *
    * Para validar o que é fornecido pelo usuário vamos começar criando uma classe de exceção para representar
    * um comando inválido.
    *
    * Como desejamos uma classe de exceção que seja tratada vamos herdá-la de Exception com um construtor
    * vazio apenas lançando uma exceção.
    *
    * Em seguida incluímos no método nextCommand o lançamento desse tipo de exceção criada.
    *
    * Seguindo para classe UI método nextCommand foi incluído um try/catch, pela Code da IDE, da linha da List até antes do return
    * para que em qualquer tipo de exceção lançar a InvalidCommandException
    *
    * Consequentemente foi ajustado o TaskApp e ao teste a digitação de qualquer outra coisa fora do previsto não encerrará
    * a aplicação pois já é tratado informando o problema ao usuário.
    *
    * */
}
