package commands;

import exceptions.IncorrectArgumentException;

/**
 * Команда "exit" завершает программу
 */
public class ExitCommand extends AbstractCommand {
    private String name;
    private String description;

    public ExitCommand(){
        super("exit "," завершить программу (без сохранения в файл)");
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
            return true;
        }catch (IncorrectArgumentException exception){
            System.out.println("Команда "+getName() + " не имеет параметров" );
            return false;
        }
    }
}
