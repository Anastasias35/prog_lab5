import commands.*;
import utilitka.*;

import java.util.Scanner;

/**
 * Главный класс, в котором запускается и выполняется программа
 */
public class Main {
    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Введите имя файла, с которого хотите прочесть данные");
        String fileName=scanner.nextLine().trim();

        FileManager fileManager=new FileManager(fileName);
        CollectionManager collectionManager=new CollectionManager(fileManager);
        Creator creator=new Creator(scanner);

        CommandManager commandManager=new CommandManager( new HelpCommand(),
                                                          new InfoCommand(collectionManager),
                                                          new ExitCommand(),
                                                          new ShowCommand(collectionManager),
                                                          new ClearCommand(collectionManager),
                                                          new SaveCommand(collectionManager),
                                                          new AddCommand(collectionManager,creator),
                                                          new RemoveByIdCommand(collectionManager),
                                                          new PrintFieldAscendingSalaryCommand(collectionManager),
                                                          new CountLessThanPositionCommand(collectionManager),
                                                          new UpdateCommand(collectionManager, creator),
                                                          new AddIfMaxCommand(collectionManager, creator),
                                                          new AddIfMinCommand(collectionManager,creator),
                                                          new RemoveLowerCommand(collectionManager,creator),
                                                          new PrintDescendingCommand(collectionManager),
                                                          new ExecuteScriptCommand());

        Console console=new Console(scanner,creator, commandManager);
        console.actMode();
    }
}
