package commands;

import data.Position;
import exceptions.EmptyCollection;
import exceptions.IncorrectArgumentException;
import exceptions.IncorrectVariableException;
import utilitka.CollectionManager;

/**
 * Команда "count_less_than_position position" выводит количество элементов,значение поля position которых меньше заданного
 */
public class CountLessThanPositionCommand extends AbstractCommand{

    private String name;
    private String description;
    private CollectionManager collectionManager;
    private Position position;

    public CountLessThanPositionCommand(CollectionManager collectionManager){
        super("count_less_than_position position", "вывести количество элементов, значение поля position которых меньше заданного");
        this.collectionManager=collectionManager;
    }

    //добавить исключение на то что, это может быть не position

    /**
     * Выполнение команды
     * @param argument
     * @return состояние выполнения команды
     */
    @Override
    public boolean execute(String argument) {
        Position argument1 = null;
        boolean checkposition=false;
        try{
            if(argument.isEmpty()) throw new IncorrectArgumentException();
            if(collectionManager.sizeCollection()==0) throw new EmptyCollection();
            for (Position position1:position.values()){
                if (argument.equals(position1.name())){
                    argument1=Position.valueOf(position1.name());
                    checkposition=true;
                }
            }
            if (!checkposition) throw new IncorrectVariableException();
            System.out.println(collectionManager.filterByPosition(argument1));
            return true;
        }catch (IncorrectArgumentException exception) {
            System.out.println("Команда " + getName() + " должна иметь параметр Position");
            return false;
        }catch (IncorrectVariableException exception){
                System.out.println("аргумент должен быть типом Position");
                return false;
        }catch (EmptyCollection exception){
            System.out.println("Коллекция пуста");
            return false;
        }
    }
}
