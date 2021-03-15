package commands;

import exceptions.IncorrectArgumentException;

//import  utility.Console;

/**
 * Команда "help" выдает все информацию по всем доступным команднам
 */
public class HelpCommand extends AbstractCommand{

      public HelpCommand(){
          super("help", "вывести справку по доступным командам");
      }

    /**
     * Выполнение команды
     * @param arguments
     * @return состояние выполнения команды
     */
    @Override
      public boolean execute(String arguments){
          try{
              if(!arguments.isEmpty()) throw new IncorrectArgumentException();
              return  true;
          }catch(IncorrectArgumentException exception){
              System.out.println("У этой команды нет параметров");
              return  false;
          }
      }
}
