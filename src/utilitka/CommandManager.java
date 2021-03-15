package utilitka;

import commands.AbstractCommand;

import java.util.ArrayList;
import java.util.List;

// запуск команд


// добавлять сюда  команды сразу после их создания для обработки
//добавить аннотацию для javadoc

/**
 * Класс для запуска команд
 */
public class CommandManager {

    private List<AbstractCommand> command= new ArrayList<>();
    private AbstractCommand helpCommand;
    private AbstractCommand infoCommand;
    private AbstractCommand exitCommand;
    private AbstractCommand showCommand;
    private AbstractCommand clearCommand;
    private AbstractCommand saveCommand;
    private AbstractCommand addCommand;
    private AbstractCommand removeByIdCommand;
    private AbstractCommand printFieldAscendingSalaryCommand;
    private AbstractCommand countLessThanPositionCommand;
    private AbstractCommand updateCommand;
    private AbstractCommand addIfMaxCommand;
    private AbstractCommand addIfMinCommand;
    private AbstractCommand removeLowerCommand;
    private AbstractCommand printDescendingCommand;
    private AbstractCommand executeScriptCommand;

    public CommandManager(AbstractCommand helpCommand,AbstractCommand infoCommand,AbstractCommand exitCommand, AbstractCommand showCommand,AbstractCommand clearCommand,
                          AbstractCommand saveCommand,AbstractCommand addCommand,AbstractCommand removeByIdCommand, AbstractCommand printFieldAscendingSalaryCommand,
                          AbstractCommand countLessThanPositionCommand, AbstractCommand updateCommand, AbstractCommand addIfMaxCommand, AbstractCommand addIfMinCommand,
                          AbstractCommand removeLowerCommand, AbstractCommand printDescendingCommand,AbstractCommand executeScriptCommand ){
                          //AbstractCommand executeScriptCommand

        this.helpCommand=helpCommand;
        this.infoCommand=infoCommand;
        this.exitCommand=exitCommand;
        this.showCommand=showCommand;
        this.clearCommand=clearCommand;
        this.saveCommand=saveCommand;
        this.addCommand=addCommand;
        this.removeByIdCommand=removeByIdCommand;
        this.printFieldAscendingSalaryCommand=printFieldAscendingSalaryCommand;
        this.countLessThanPositionCommand=countLessThanPositionCommand;
        this.updateCommand=updateCommand;
        this.addIfMaxCommand=addIfMaxCommand;
        this.addIfMinCommand=addIfMinCommand;
        this.removeLowerCommand=removeLowerCommand;
        this.printDescendingCommand=printDescendingCommand;
        this.executeScriptCommand=executeScriptCommand;


        command.add(helpCommand);
        command.add(infoCommand);
        command.add(exitCommand);
        command.add(showCommand);
        command.add(clearCommand);
        command.add(saveCommand);
        command.add(addCommand);
        command.add(removeByIdCommand);
        command.add(printFieldAscendingSalaryCommand);
        command.add(countLessThanPositionCommand);
        command.add(updateCommand);
        command.add(addIfMaxCommand);
        command.add(addIfMinCommand);
        command.add(removeLowerCommand);
        command.add(printDescendingCommand);
        command.add(executeScriptCommand);
    }


    /**
     * Выводит все возможные команды с их описанием
     * @param argument
     * @return состояние работы команды
     */
    public boolean help(String argument){
      if(helpCommand.execute(argument)){
          for (AbstractCommand command1:command){
                System.out.println(command1.getName() + ": " + command1.getDescription());
          }
          return true;
      }
      else {
          return false;
      }
    }

    /**
     * Запускает команду информации о коллекции
     * @param argument
     * @return состояние работы коллекции
     */
    public boolean info(String argument){
        return infoCommand.execute(argument);
    }

    /**
     * Запускает команду выхода из программы
     * @param argument
     * @return состояние работы программы
     */
    public boolean exit(String argument){
        return exitCommand.execute(argument);
    }

    /**
     * Запускает команду очистки коллекции
     * @param argument
     * @return состояние работы программы
     */
    public boolean clear(String argument){
        return  clearCommand.execute(argument);
    }

    /**
     * Запускает команду сохранения коллекции в файл
     * @param argument
     * @return состояние работы программы
     */
    public boolean save(String argument){
        return saveCommand.execute(argument);
    }

    /**
     * Запускает команду добавления элемента в коллекцию
     * @param argument
     * @return состояние работы программы
     */
    public boolean add(String argument){
        return addCommand.execute(argument);
    }

    /**
     * Запускает команду удаления элемента из коллекции по его id
     * @param argument
     * @return состояние работы команды
     */
    public boolean removeById(String argument){
        return removeByIdCommand.execute(argument);
    }

    /**
     * Запускает команду вывода всех элементов из коллекции
     * @param argument
     * @return состояние работы программы
     */
    public boolean show(String argument){
        return showCommand.execute(argument);
    }

    /**
     * Запускает команду вычисление количества элементов, значения поля position которых меньше заданного
     * @param argument
     * @return состояние работы программы
     */
    public boolean countLessThanPosition(String argument){
        return  countLessThanPositionCommand.execute(argument);
    }

    /**
     * Запускает программу вывода поля salary
     * @param argument
     * @return состояние работы команды
     */
    public boolean printFieldAscendingSalary(String argument){
        return printFieldAscendingSalaryCommand.execute(argument);
    }

    /**
     * Запускает программу обновление элемента по его id
     * @param argument
     * @return состояние работы программы
     */
    public boolean update(String argument){
        return updateCommand.execute(argument);
    }

    /**
     * Запускает программу добавления элемента,если он больше
     * @param argument
     * @return состояние работы программы
     */
    public boolean addIfMax(String argument){
        return addIfMaxCommand.execute(argument);
    }

    /**
     * Запускает программу добавления элемента,если он меньше
     * @param argument
     * @return состояние работы программы
     */
    public boolean addIfMin(String argument) {
        return addIfMinCommand.execute(argument);
    }

    /**
     * Запускает команду удаления всех элементов, меньших, чем заданный
     * @param argument
     * @return состояние работы программы
     */
    public boolean removeLower(String argument){
        return removeLowerCommand.execute(argument);
    }

    /*public boolean executeScript(String argument) {
        return executeScriptCommand.execute(argument);
    }

     */

    /**
     * Запускает команду вывода элементов из коллекции в порядке убывания
     * @param argument
     * @return состояние работы программы
     */
    public boolean printDescending(String argument) {
        return printDescendingCommand.execute(argument);
    }

    public boolean executeScript(String argument){
        return executeScriptCommand.execute(argument);

    }

}


