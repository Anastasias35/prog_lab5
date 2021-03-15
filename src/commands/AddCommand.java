package commands;

import data.Worker;
import exceptions.IncorrectArgumentException;
import utilitka.CollectionManager;
import utilitka.Creator;

import java.time.Instant;
import java.util.Date;

/**
 * Команда "add" добавляет элемент в коллекцию
 */
public class AddCommand extends AbstractCommand {

    private String name;
    private String desciption;
    private Creator creator;
    private CollectionManager collectionManager;

    public AddCommand(CollectionManager collectionManager, Creator creator){
        super("add {element}","добавить новый элемент в коллекцию");
        this.collectionManager=collectionManager;
        this.creator=creator;
    }

    /**
     * Выполнение команды
     * @param argument
     * @return состояние выполнения команды
     */
    @Override
    public boolean execute(String argument){
        try{
            if (!argument.isEmpty()) throw new IncorrectArgumentException();
            Instant instant=Instant.now();
            Worker worker=new Worker(collectionManager.nextId(), creator.inputName(), creator.inputCoordinates(), Date.from(instant), creator.inputSalary(), creator.inputStartDate(),
                       creator.inputEndDate(), creator.inputPosition(), creator.inputPerson());
            collectionManager.addToCollection(worker);


            return  true;
        } catch (IncorrectArgumentException incorrectArgumentException){
            System.out.println("Команда " + getName() + " не имеет параметров");
            return false;
        }
    }
}
