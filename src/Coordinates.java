import java.util.Objects;

public class Coordinates {
    private double x; //Максимальное значение поля: 59
    public void setX(double x) {
        this.x = x;
    }
    public double getX() {
        return x;
    }
    public void setY(Long y) {
        this.y = y;
    }
    public Long getY() {
        return y;
    }
    private Long y; //Поле не может быть null
    Coordinates(double x,long y) {
        setX(x);
        setY(y);
    }

    @Override
    public String toString() {
        return x+";"+y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Double.compare(that.x, x) == 0 &&
                y.equals(that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}