package commands;

import exceptions.EmptyCollection;
import exceptions.IncorrectArgumentException;
import utilitka.CollectionManager;

/**
 * Команда "remove_by_id" удаляет элемент из коллекции по его id
 */
public class RemoveByIdCommand extends AbstractCommand {

    private String name;
    private String description;
    private CollectionManager collectionManager;
    private Long id;

    public RemoveByIdCommand(CollectionManager collectionManager){
        super("remove_by_id id", "удалить элемент из коллекции по его id");
        this.collectionManager=collectionManager;
    }


    //добавить ошибку на пустую коллекцию

    /**
     * Выполнение команды
     * @param argument
     * @return состояние выполнения команды
     */
    @Override
    public boolean execute(String argument) {
        try {
            if(collectionManager.sizeCollection()==0) throw new EmptyCollection();
            if (argument.isEmpty()) throw new IncorrectArgumentException();
            id = Long.parseLong(argument);
            if (collectionManager.comparingId(id)) { //!!! подумкать
                collectionManager.removeItem(id);
            } else {
                System.out.println("Worker c таким id не найден :(");
            }
            return true;
        } catch (IncorrectArgumentException exception) {
            System.out.println("Команда " + getName() + " имеет параметры");
            return false;
        } catch (NumberFormatException exception) {
            System.out.println("id должен быть целым числом");
            return false;
        }catch (EmptyCollection exception){
            System.out.println("Коллекция пуста");
            return false;
        }
    }
}
