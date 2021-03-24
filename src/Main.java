import commands.*;
import utilitka.*;

import java.util.Scanner;

/**
 * Главный класс, в котором запускается и выполняется программа
 */
public class Main {


    public static void main(String[] args) {
        String fileName="";
        Scanner scanner=new Scanner(System.in);

        try {
            fileName=args[0];

        }catch (ArrayIndexOutOfBoundsException exception){
            System.out.println("Вы не ввели имя файла в аргументе командной строки");


        }finally {
            FileManager fileManager = new FileManager(fileName);
            Creator creator = new Creator(scanner);
            CollectionManager collectionManager=new CollectionManager(fileManager,creator);


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
}
