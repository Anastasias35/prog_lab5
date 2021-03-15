package commands;

import exceptions.IncorrectArgumentException;
import utilitka.CollectionManager;

/**
 * Команда "clear" очищает  коллекцию
 */
public class ClearCommand extends AbstractCommand {

    private String name;
    private String description;
    CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager){
        super("clear", "очистить коллекцию");
        this.collectionManager=collectionManager;
    }

    /**
     * Выполнение команды
     * @param argument
     * @return состояние выполнения команды
     */
    @Override
    public boolean execute(String argument){
        try{
            if(!argument.isEmpty()) throw new IncorrectArgumentException();
            collectionManager.clearCollection();
            System.out.println("Коллекция очищена");
            return true;
        }catch (IncorrectArgumentException exception){
            System.out.println("Команда " + getName() + " не имеет параметров");
            return false;
        }
    }

}
