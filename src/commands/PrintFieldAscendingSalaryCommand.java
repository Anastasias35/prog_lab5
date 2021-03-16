package commands;

import exceptions.EmptyCollection;
import exceptions.IncorrectArgumentException;
import utilitka.CollectionManager;

/**
 * Команда "print_field_ascending_salary" выведит значения поля salary всех элементов в порядке возрастания
 */
public class PrintFieldAscendingSalaryCommand extends AbstractCommand {

    private String name;
    private String description;
    private CollectionManager collectionManager;

    public PrintFieldAscendingSalaryCommand(CollectionManager collectionManager){
        super("print_field_ascending_salary","вывести значения поля salary всех элементов в порядке возрастания");
        this.collectionManager=collectionManager;
    }

    /**
     * Выполнение команды
     * @param argument
     * @return состояние выполнение команды
     */
    @Override
    public boolean execute(String argument){
        try{
            if(collectionManager.sizeCollection()==0) throw new EmptyCollection();
            if(!argument.isEmpty()) throw new IncorrectArgumentException();
            collectionManager.sortSalary();
            return true;
        }catch (IncorrectArgumentException exception){
            System.out.println("Команда "+ getName() + " не имеет параметров");
            return false;
        }catch(EmptyCollection exception){
            System.out.println("Коллекция пуста");
            return false;
        }
    }
}
