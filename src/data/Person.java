package data;

import java.util.Objects;

/**
 * Класс Person для создания Worker
 */
public class Person {
    private double weight;
    private Color eyecolor;
    private Color haircolor;
    private Country nationality;
    public Person(double weight, Color eyecolor, Color haircolor, Country nationality){
        this.weight=weight;
        this.eyecolor=eyecolor;
        this.haircolor=haircolor;
        this.nationality=nationality;
    }

    /**
      * @return вес человека
     */
   public double getWeight(){
        return  weight;
   }

    /**
     * @return цвета глаз человека
     */
   public Color getEyecolor(){
        return eyecolor;
   }

    /**
     * @return цвета волос человека
     */
   public Color getHaircolor(){
        return haircolor;
   }

    /**
     * @return национальности человека
     */
   public Country getNationality(){
        return nationality;
   }

    @Override
    public String toString() {
        return "Person" +
                "weight=" + weight + "\n"+
                "eyecolor=" + eyecolor + "\n"+
                "haircolor=" + haircolor + "\n"+
                "nationality=" + nationality ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(person.weight, weight) == 0 &&
                eyecolor == person.eyecolor &&
                haircolor == person.haircolor &&
                nationality == person.nationality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, eyecolor, haircolor, nationality);
    }
}
