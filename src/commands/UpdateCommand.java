package commands;

import data.Worker;
import exceptions.EmptyCollection;
import exceptions.IncorrectArgumentException;
import utilitka.CollectionManager;
import utilitka.Creator;

import java.time.Instant;
import java.util.Date;

public class UpdateCommand extends  AbstractCommand{

    private  String name;
    private  String description;
    private CollectionManager collectionManager;
    private Creator creator;
    private RemoveByIdCommand removeByIdCommand;

    public UpdateCommand(CollectionManager collectionManager, Creator creator){
        super("update id {element}" , "обновить значение элемента коллекции, id которого равен заданному");
        this.collectionManager=collectionManager;
        this.creator=creator;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(collectionManager.sizeCollection()==0) throw new EmptyCollection();
            if(argument.isEmpty()) throw new IncorrectArgumentException();
            Long id1=Long.parseLong(argument);
            Instant instant=Instant.now();
            if (collectionManager.comparingId(id1)) {
                collectionManager.removeItem(id1);
                Worker worker = new Worker(id1,creator.inputName(), creator.inputCoordinates(), Date.from(instant), creator.inputSalary(), creator.inputStartDate(),
                        creator.inputEndDate(), creator.inputPosition(), creator.inputPerson());
                collectionManager.addToCollection(worker);
            }
            return true;
        }catch (IncorrectArgumentException exception){
            System.err.println("Команда "+ getName() +" должна иметь параметр id");
            return false;
        }catch (NullPointerException exception){
            System.err.println("Элемент с таким id не найден");
            return false;
        }catch (NumberFormatException exception){
            System.err.println("id должен быть целым числом");
            return false;
        }catch (EmptyCollection exception){
            System.err.println("Коллекция пуста");
            return false;
        }
    }
}
