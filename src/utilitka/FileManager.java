package utilitka;

import data.Worker;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import exceptions.CanNotReadException;
import exceptions.CanNotWriteException;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.NoSuchElementException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.lang.reflect.Type;


/**
 * Класс, работающий с загрузкой и чтением коллекции из файла
 */
public class FileManager {
    private Gson gson=new Gson();
    private String fileName;
    private File file;

    public FileManager(String fileName){
        this.fileName=fileName;
        try{
            this.file=new File(fileName);
        }catch(NullPointerException exception){
            System.err.println("Нужно ввести имя файла");
        }
    }


    /**
     * Запись коллекции в файл
     * @param collection
     */
    public void writeCollection(LinkedHashSet<Worker> collection){
            try (PrintWriter printWriter = new PrintWriter(new File(this.fileName))) {
                if (!file.canWrite()) throw new CanNotWriteException();
                printWriter.print(gson.toJson(collection));
                System.out.println("Коллекция успешно загружена");
            }catch (CanNotWriteException exception){
                System.err.println("Нет прав на запись");
            } catch (Exception exception) {
                System.out.println(); // добавить что именно выводит
            }
    }


    /**
     * Чтение коллекции из файла
     * @return Коллекция, которая хранилась в файле
     */
     public LinkedHashSet<Worker> readCollection(){

         try (Scanner collectionFileScanner = new Scanner(new File(this.fileName))) {

             if (!file.canRead()) throw new CanNotReadException();
             //   LinkedHashSet<Worker> workerCollection;
             Type collectionType = new TypeToken<LinkedHashSet<Worker>>() {}.getType();
             LinkedHashSet<Worker> workerCollection = gson.fromJson(collectionFileScanner.nextLine().trim(), collectionType);
             System.out.println("Коллекция успешна загружена!");
             return workerCollection;
         }catch (CanNotReadException exception) {
             System.err.println("Нет прав на чтение");
         }
           catch (FileNotFoundException exception){ //не робит
            System.err.println("файл с таким именем не найден");
        }catch(NoSuchElementException exception){
            System.err.println("файл пуст");
        }catch (JsonParseException exception){
            System.err.println("Необходимая коллекция не найдена");
        }catch(Exception exception){
             System.out.println();
         }
         return new LinkedHashSet<>();
     }

     @Override
     public String toString() {
        return "FileManager{" +
                "gson=" + gson +
                ", fileName='" + fileName + '\'' +
                '}';
     }
}
