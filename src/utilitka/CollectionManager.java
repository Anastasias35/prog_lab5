package utilitka;

import data.Position;
import data.Worker;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Класс управления коллекцией
 */
//работа с коллекциями: получение времени, размера, создание нового id, добавление элемента
public class CollectionManager{
      private LinkedHashSet<Worker> workerCollection =new LinkedHashSet<>();
      private List<Worker> sortWorkerBySalary= new ArrayList<>();

      private LocalDateTime lastIntTime;
      private FileManager fileManager;

      public CollectionManager(FileManager fileManager){
          this.fileManager=fileManager;
          this.lastIntTime=null;
          loadCollection();
      }


      public void loadCollection(){
          workerCollection=fileManager.readCollection();
          lastIntTime=LocalDateTime.now();
      }
    /**
     * @return Время инициализации
     */
    public LocalDateTime getLastIntTime(){
          return lastIntTime;
      }

    /**
     * @return Количество элементов в коллекции
     */
    public int sizeCollection(){
          return workerCollection.size();
    }

    /**
     * Очищение коллекции
     */
    public void clearCollection(){
          workerCollection.clear();
    }

    /**
     * Сохранение коллекции в файл
     */
    public void saveCollection(){
          fileManager.writeCollection(workerCollection);
    }

    /**
     * Проверка, есть ли элемент с таким же id
     * @param id
     * @return наличие элемента коллекции с таким же id
     */
    public boolean comparingId(Long id){
          boolean checkException=true;
          for (Worker worker1:workerCollection){
              if (id.equals(worker1.getId())) {
                  checkException=false;
                  return true;

              }
          }
          if (checkException==true) throw new NullPointerException();
          return false;
    }

    /**
     * Удаление элемент,если у его id совпадает с параметром
     * @param id
     */
    public void removeItem(Long id){
          workerCollection.removeIf(worker1 -> id.equals(worker1.getId()));
    }


    /**
     * Добавление элемента в коллекцию
     * @param worker
     */
    public void addToCollection(Worker worker){
          workerCollection.add(worker);
          System.out.println("Worker успешно создан");
    }

    /**
     * Генерация id для нового элемента
     * @return
     */
    public Long nextId(){
         if (workerCollection.isEmpty()) return 1L;
         else{
            return workerCollection.iterator().next().getId() + 1;
         }
    }

    /**
     *Считает, сколько элементов в коллекции имеют такую же профессию
     * @param position
     * @return Количество элементов с такой же профессией
     */
    public int filterByPosition(Position position){
         int count=0;
         for (Worker worker1:workerCollection){
             System.out.println(worker1.getPosition() + " "+position);
              if(worker1.getPosition().compareTo(position)<0) {
                  count ++;
              }
         }
         return count;
    }

    /**
     * Проверка, найдется ли среди элементов коллекции такой,чья зарплата больше введенной
     * @param salary
     * @return истинности на максимальность введенной зарплаты относительно всех элементов коллекции
     */
    public boolean maxSalary(Long salary){
          for(Worker worker1:workerCollection){
              if(salary.compareTo(worker1.getSalary())<=0){
                  return  false;
              }
          }
          return true;
    }

    /**
     * Проверка, найдется ли среди элементов коллекции такой,чья зарплата меньше введенной
     * @param salary
     * @return истинности на минимальность введенной зарплаты относительно всех элементов коллекции
     */
    public boolean minSalary(Long salary){
        for(Worker worker1:workerCollection){
            if(salary.compareTo(worker1.getSalary())>=0){
                return  false;
            }
        }
        return true;
    }

    /**
     * Удаление элемента, если его зарплата меньше введенной
     * @param salary
     */
    public void deleteIfLower(Long salary){
          for(Worker worker1:workerCollection){
              if(salary.compareTo(worker1.getSalary())>0){
                  workerCollection.remove(worker1);
              }
          }
    }

      //!!! maybe

    /**
     * Сортировка элементов по возрастанию зарплаты
     */
    public void sortSalary(){
          sortWorkerBySalary.addAll(workerCollection);
          Collections.sort(sortWorkerBySalary);
          for(Worker worker1:sortWorkerBySalary){
              System.out.println(worker1.getSalary());

          }
          sortWorkerBySalary.clear();
    }

    /**
     * Сортировка элементов по убыванию зарплаты
     */
    public void reverseSort(){
          sortWorkerBySalary.addAll(workerCollection);
          Collections.reverse(sortWorkerBySalary);
          for(Worker worker1:sortWorkerBySalary){
              System.out.println(worker1);
          }
    }


    public void stringCollection(){
        if (workerCollection.isEmpty()) {
            System.out.println("Коллекция пуста");
            return ;
        }
        for(Worker worker1:workerCollection){
            System.out.println(worker1.toString());
        }
    }

}
