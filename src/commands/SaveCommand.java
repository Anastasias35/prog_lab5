package commands;

import exceptions.IncorrectArgumentException;
import utilitka.CollectionManager;

/**
 * Команда "save" сохраняет коллекцию в файл
 */
public class SaveCommand extends AbstractCommand {

    private String name;
    private String description;
    private CollectionManager collectionManager;

    public SaveCommand(CollectionManager collectionManager){
        super("save", "сохранить коллекцию в файл");
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
            collectionManager.saveCollection();
            return true;
        } catch (IncorrectArgumentException exception){
            System.out.println("Команда " + getName() + " не имеет параметров");
            return false;
        }
    }
}
