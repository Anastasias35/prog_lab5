package commands;

import exceptions.IncorrectArgumentException;

import java.io.FileNotFoundException;

/**
 * Команда "execute_script" считывает и исполняет скрипт из файла
 */
public class ExecuteScriptCommand extends AbstractCommand {

    private String name;
    private String description;

    public ExecuteScriptCommand(){
        super("execute_script file_name", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    /**
     * Выполнение команды
     * @param argument
     * @return состояние выполнения команды
     */
    @Override
    public boolean execute(String argument) {
        try{
            if(argument.isEmpty()) throw new IncorrectArgumentException();
            return  true;
        } catch (IncorrectArgumentException exception){
            System.out.println("Команда " + getName() + "должна имеет параметр");
            return false;
        }
    }
}
