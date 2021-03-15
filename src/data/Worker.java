package data;
import  java.util.Date;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Класс Worker, который хранится в коллекции
 */
public class Worker  implements Comparable<Worker>{

    private Long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name;  //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long salary; //Поле может быть null, Значение поля должно быть больше 0
    private LocalDateTime startDate; //Поле не может быть null
    private ZonedDateTime endDate; //Поле может быть null
    private Position position; //Поле может быть null
    private Person person; //Поле может быть null

    public Worker(long id, String name, Coordinates coordinates, java.util.Date creationDate,Long salary, java.time.LocalDateTime startDate, java.time.ZonedDateTime endDate, Position position, Person person){
        this.id=id;
        this.name=name;
        this.coordinates=coordinates;
        this.creationDate=creationDate;
        this.salary=salary;
        this.startDate=startDate;
        this.endDate=endDate;
        this.position=position;
        this.person=person;
    }

    /**
     * @return id работника
     */
    public long getId(){
        return id;
    }

    /**
     * @return имя работника
     */
    public String getName(){
        return name;
    }

    /**
     * @return x-y координаты работника
     */
    public Coordinates getCoordinates(){
        return coordinates;
    }

    /**
     * @return дата занесения в протокол
     */
    public Date getCreationDate(){
        return creationDate;
    }

    /**
     *
     * @return зарплата работника
     */
    public Long getSalary(){
        return salary;
    }

    /**
     * @return дата начала работы работника
     */
    public LocalDateTime getStartDate(){
        return startDate;
    }

    /**
     * @return дата окончания работы работника
     */
    public ZonedDateTime getEndDate(){
        return endDate;
    }

    /**
     * @return профессия работника
     */
    public Position getPosition(){
        return position;
    }

    /**
     * @return личность работника
     */
    public Person getPerson(){
        return person;
    }


    @Override
    public String toString() {
        return "Worker:" +
                "id=" + id + "\n" +
                "name=" + name + '\n' +
                "coordinates=" + coordinates + "\n" +
                "creationDate=" + creationDate + "\n" +
                "salary=" + salary + "\n" +
                "startDate=" + startDate + "\n" +
                "endDate=" + endDate + "\n" +
                "position=" + position + "\n" +
                "person=" + person + "\n" ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return id == worker.id &&
                Objects.equals(name, worker.name) &&
                Objects.equals(coordinates, worker.coordinates) &&
                Objects.equals(creationDate, worker.creationDate) &&
                Objects.equals(salary, worker.salary) &&
                Objects.equals(startDate, worker.startDate) &&
                Objects.equals(endDate, worker.endDate) &&
                position == worker.position &&
                Objects.equals(person, worker.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, salary, startDate, endDate, position, person);
    }


    @Override
    public int compareTo(Worker worker) {
        return (salary.compareTo(worker.getSalary()));
    }


}
