package shape;

public class Triangle extends Shape{

    private int width;
    private int height;

    public Triangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public Triangle(int x, int y) {
        super(x, y);
    }

    @Override
    public double getArea() {
        return 0.5 * width * height;
    }

    @Override
    public double getCircum() {
        return width + height +Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "width=" + width +
                ", height=" + height +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
