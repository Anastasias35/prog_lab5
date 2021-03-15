package commands;

import exceptions.IncorrectArgumentException;
import utilitka.CollectionManager;

/**
 * Команда "info" выдает информацию о коллекции
 */
public class InfoCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    public InfoCommand(CollectionManager collectionManager){
        super("info","Вывести информацию о коллекции");
        this.collectionManager=collectionManager;
    }

    /**
     * Выполнение команды
     * @param argument
     * @return состояние выполнения команды
     */
    @Override
    public boolean execute(String argument) {
        try{
            if(!argument.isEmpty()) throw new IncorrectArgumentException();
            System.out.println("Инофрмация о коллекции");
            System.out.println("Тип" + collectionManager.getClass().getName());
            if(collectionManager.getLastIntTime()==null ) {
                System.out.println("Коллекция не инициализирована");
            }
            else {
                System.out.println("Дата инициализации" + collectionManager.getLastIntTime());
            }
            System.out.println(collectionManager.sizeCollection());
            return true;
        }catch(IncorrectArgumentException exception){
            System.out.println("Команда не имеет параметров");
            return false;
        }
    }


}
