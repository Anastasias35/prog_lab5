package commands;

import exceptions.EmptyCollection;
import exceptions.IncorrectArgumentException;
import utilitka.CollectionManager;


/**
 * Команда "print_descending" выводит элементы коллекции в порядке убывания
 */
public class PrintDescendingCommand extends AbstractCommand {

    private String name;
    private String description;
    private CollectionManager collectionManager;

    public PrintDescendingCommand(CollectionManager collectionManager){
        super("print_descending", "вывести элементы коллекции в порядке убывания");
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
            if(collectionManager.sizeCollection()==0) throw new EmptyCollection();
            if(!argument.isEmpty()) throw new IncorrectArgumentException();
            collectionManager.reverseSort();
            return true;
        } catch (IncorrectArgumentException exception){
            System.out.println("Команда "+ getName() + " не имеет параметров");
            return false;
        } catch (EmptyCollection exception){
            System.out.println("Коллекция пуста");
            return false;
        }
    }
}
