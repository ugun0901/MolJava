package shape;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public Rectangle(int x, int y) {
        super(x, y);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getCircum() {
        return 2 * (width+height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
