public class Human {
    private int height; //Значение поля должно быть больше 0

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
    Human(int height){
        setHeight(height);
    }
}