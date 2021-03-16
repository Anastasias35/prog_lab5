package commands;
import data.Worker;
import exceptions.EmptyCollection;
import exceptions.IncorrectArgumentException;
import utilitka.CollectionManager;
import utilitka.Creator;

import java.time.Instant;
import java.util.Date;

public class RemoveLowerCommand extends AbstractCommand {

    private String name;
    private String discription;
    private CollectionManager collectionManager;
    private Worker worker;
    private Creator creator;

    public RemoveLowerCommand(CollectionManager collectionManager, Creator creator){
        super("remove_lower {element}", "удалить из коллекции все элементы, меньшие, чем заданный");
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
            collectionManager.deleteIfLower(worker.getSalary());
            return true;
        }catch (IncorrectArgumentException exception){
            System.out.println("Команда " + getName() + " не имеет параметров ");
            return false;
        }catch (EmptyCollection exception){
            System.out.println("Коллекция пуста");
            return false;
        }
    }
}
