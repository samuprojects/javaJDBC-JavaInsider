package theory;

@SuppressWarnings("ALL")
public class ListingFunctionality {

    /*
    *
    * Para o interpreter realizar o trabalho será necessário acesso ao banco de dados, por isso foi criado uma classe DAO para representar o interpreter
    * Em seguida foi criado um record para representar a tarefa e utilizando um construtor que utiliza a geração do id pelo banco de dados
    * Na sequencia criado uma classe TaskDAO para trabalhar com o banco de dados.
    * Na classe principal da aplicação foi inserido em setup uma conexão com o banco de dados passando isso para a classe DAO criada.
    * Após isso foi necessário passar um parâmetro em CommandInterpreter para realizar as ações no banco via DAO.
    * Depois foi implementado os métodos que estavam incompletos começando pelo list no CommandInterpreter e sobrescrito na classe DAO.
    * No mysql foi criado a tabela task
    * CREATE TABLE `customerdb`.`task` (
         `id` INT NOT NULL AUTO_INCREMENT COMMENT '	',
         `description` VARCHAR(30) NULL,
         PRIMARY KEY (`id`));

    * e inserido alguns valores
    *
    * INSERT INTO `customerdb`.`task` (`description`) VALUES ('Task 1');
      INSERT INTO `customerdb`.`task` (`description`) VALUES ('Task 2');
      INSERT INTO `customerdb`.`task` (`description`) VALUES ('Task 3');

    *
    * para teste da listagem na aplicação
    *
    *
    *
    * */
}
