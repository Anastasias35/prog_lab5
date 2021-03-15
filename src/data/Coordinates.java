package data;

import java.util.Objects;

/**
 * X-Y координаты
 */
public class Coordinates {
    private  int x;
    private Double y;
    public Coordinates(int x, Double y){
        this.x=x;
        this.y=y;
    }

    /**
     * @return координата X
     */
    public int getX(){
        return x;
    }

    /**
     * @return координата Y
     */
    public Double getY(){
        return y;
    }

   @Override
    public String toString() {
        return "Coordinates:" +
                "x=" + x + "\n"+
                "y=" + y + "\n" ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x &&
                Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}