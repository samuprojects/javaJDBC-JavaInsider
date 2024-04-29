package theory;

@SuppressWarnings("ALL")
public class InputParse {

    /*
    * Realizar alteração no método nextCommand da classe UI porque está retornando diretamente o que o usuário
    * digita no console.
    *
    * É necessário processar essa informação e transformar isso em um Command (sendo o tipo de retorno do método)
    *
    * Para isso for alterado o nextLine para incluir um split com o objetivo de quebrar a string digitada pelo usuário
    * e os delimitadores são os espaços em branco.
    * Ou seja, vamos utilizar um Array de Strings que na primeira posição terá o comando, na segunda posição o
    * primeiro parâmetro, na terceira posição o segundo parâmetro.
    *
    * Para facilitar o trabalho o Array foi convertido em uma lista com um asList passando o Array como parâmetro
    * e armazenando tudo numa lista de Strings.
    *
    * Como sabemos que na primeira posição dessa lista temos uma Action, criamos ela e chamando um fromString e passando a lista com
    * índice 0.
    *
    * Depois criado uma lista de String para abrigar os parâmetros realizando antes validações para verificar
    * o conteúdo do que foi digitado
    * O ponto de atenção é que os espaços em branco que separam os parâmetros não podem ser confundidos com os
    * espaços em branco do texto digitado
    *
    * Por isso foi adotado a lógica de assumir que do segundo parâmetro para frente tudo é parâmetro.
    * Utilizando uma sublista para conter todos os elementos menos os dois primeiros, começando pelo índice 2
    * que é o terceiro e vai até o tamanho da lista de tokens que é representado chamando o .size().
    *
    * Como não é possível adicionar uma sublista de Strings dentro de uma lista de Strings precisamos
    * pegar todos os tokens juntá-los novamente, ignorando os primeiros, por meio do método String.join passando a coleção que
    * será delimitada.
    * No final utilizamos um trim() para eliminar espaços em branco das pontas e retornar um Command passando action e parâmetros.
    *
    * Devido alteração na assinatura do método o start na classe Main de TaskApp deixou de funcionar corrigido conforme nova configuração
    * e passamos um toString do command por meio do show().
    *
    * Em seguida foi alterado para incluir esse código no main num loop do while(true) para testar diversas possibilidades
    *
    * Verificado que lógica (de UI) utilizada consegue entender o que o usuário está digitando dentro do escopo previsto, sendo
    * a próxima etapa tomar ações com base nas actions e parâmetros fornecidos ao console.
    *
    *
    *
    *
    * */
}
