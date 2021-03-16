package commands;

import data.Worker;
import exceptions.EmptyCollection;
import exceptions.IncorrectArgumentException;
import utilitka.Creator;
import utilitka.CollectionManager;

import java.time.Instant;
import java.util.Date;


/**
 * Команда "add_if_min" добавляет элемент в коллекцию,если он меньше минимального в коллекции
 */
public class AddIfMinCommand extends AbstractCommand {

    private String name;
    private String description;
    private CollectionManager collectionManager;
    private Creator creator;
    private RemoveByIdCommand removeByIdCommand;


    public AddIfMinCommand(CollectionManager collectionManager, Creator creator){
        super("add_if_min {element}", "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n");
        this.collectionManager=collectionManager;
        this.creator=creator;
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
            Instant instant= Instant.now();

            Worker worker=new Worker(collectionManager.nextId(),
                    creator.inputName(),
                    creator.inputCoordinates(),
                    Date.from(instant),
                    creator.inputSalary(),
                    creator.inputStartDate(),
                    creator.inputEndDate(),
                    creator.inputPosition(),
                    creator.inputPerson());

            if(collectionManager.minSalary(worker.getSalary())) {
                    collectionManager.addToCollection(worker);
                    System.out.println("Worker добавлен в коллекцию");
            }
            return true;
        }catch (IncorrectArgumentException exception){
            System.out.println("Команда "+ getName() + " не должна иметь аргументы");
            return false;
        }catch (EmptyCollection exception){
            System.out.println("Коллекция пуста");
            return false;
        }
    }
}
