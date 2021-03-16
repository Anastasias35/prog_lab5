package utilitka;

import exceptions.CanNotReadException;
import exceptions.RecursionException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
 //считывание команды с консоли

/**
 * Класс для работы с консолью
 */
public class Console {
    private Scanner scanner;
    private Creator creator;
    private CommandManager commandManager;
    private ArrayList<String> scriptName= new ArrayList<>();

    public Console(Scanner scanner, Creator creator, CommandManager commandManager){
        this.scanner=scanner;
        this.creator=creator;
        this.commandManager=commandManager;
    }

    /**
     * Метод, работающий с вводом пользовательских команд
     */
    public void actMode(){
        String[] userCommand={"",""};
        int commandStatus=0;
        try {
            do {
                System.out.println();
                System.out.println("Введите желаемую команду");
                userCommand = (scanner.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                commandStatus = choiceCommand(userCommand); //проблема здесь !!! с exit
            } while (commandStatus != 2);
        }catch (NoSuchElementException exception){
            System.out.println("Программа завершились");
        }
    }

    /**
     * Выполнение скрипта
     * @param file
     */
    public void actScript(String file){ //exit выполняется вне зависимости от содержания
        System.out.println("file");
        String[] userCommand1={"",""};
        scriptName.add(file);
        File file1=new File(file); //даже здесь срабатывает

        try(Scanner scanner1=new Scanner(file1)) {
             if (!file1.canRead()) {
                 System.out.println("Нет прав на чтение");
                 System.exit(0);
             }
             if (!scanner1.hasNext()) throw new NoSuchElementException();
             int commandStatus = 0;
             Scanner scanner = creator.getScanner();
             creator.setScanner(scanner1);
                 do {
                     userCommand1 = (scanner1.nextLine().trim() + " ").split(" ", 2);
                     System.out.println("Выполняется команда " + userCommand1[0]);
                     userCommand1[1]=userCommand1[1].trim();
                    if (userCommand1[0].equals("execute_script")) {
                         for (String name : scriptName) {
                             if (userCommand1[1].equals(name)) {
                                 throw new RecursionException();
                             }
                         }
                     }
                    commandStatus = choiceCommand(userCommand1);
                    System.out.println(userCommand1[0]);
                 } while (scanner1.hasNextLine() && commandStatus != 2);
             creator.setScanner(scanner);
         }catch (FileNotFoundException exception) {
             System.out.println("Файл с таким  именем не найден");
         }catch (NoSuchElementException exception){
             System.out.println("Файл пуст");
         } catch (RecursionException exception){
             System.out.println("Скрипты не могут вызываться рекурсивно");
         }


    }

    /**
     * Метод, отвечающий за выбор команды и ее запуск
     * @param userCommand
     * @return
     */
    public int choiceCommand(String[] userCommand){
        switch (userCommand[0]){

            case "":
                break;
            case "help":
                if (!commandManager.help(userCommand[1])) return 0;
                break;
            case "info":
                if (!commandManager.info(userCommand[1]))return 0;
                break;
            case "show":
                if (!commandManager.show(userCommand[1])) return 0;
                break;
            case "add":
                if (!commandManager.add(userCommand[1])) return 0;
                break;
            case "update":
                if(!commandManager.update(userCommand[1])) return 0;
                break;
            case "remove_by_id":
                if (!commandManager.removeById(userCommand[1])) return 0;
                break;
            case "clear":
                if (!commandManager.clear(userCommand[1])) return 0;
                break;
            case "save":
                if (!commandManager.save(userCommand[1])) return 0;
                break;
            case "execute_script":
                if(!commandManager.executeScript(userCommand[1])) return 0;
                else actScript(userCommand[1]);
                break;
            case "exit":
                if (!commandManager.exit(userCommand[1])) return 0;
                else return 2;
            case "add_if_max":
                if(!commandManager.addIfMax(userCommand[1])) return 0;
                break;
            case "add_if_min":
                if(!commandManager.addIfMin(userCommand[1])) return 0;
                break;
            case "remove_lower":
                if (!commandManager.removeLower(userCommand[1])) return 0; //надо пофиксить
                break;
            case "count_less_than_position":
                if(!commandManager.countLessThanPosition(userCommand[1])) return 0;
                break;
            case "print_descending":
                if(!commandManager.printDescending(userCommand[1])) return 0;
                break;
            case "print_field_ascending_salary":
                if (!commandManager.printFieldAscendingSalary(userCommand[1]))return 0;
                break;
            default:
                System.out.println(userCommand[0] + "не найдена");
                System.out.println("Введите help для справки");
                return 0;
        }
        return  0;
    }
}
