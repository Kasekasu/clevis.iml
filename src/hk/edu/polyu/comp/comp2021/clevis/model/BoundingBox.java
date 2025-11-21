package hk.edu.polyu.comp.comp2021.clevis.model;

public class BoundingBox {
    private double x;
    private double y;
    private double width;
    private double height;

    public BoundingBox(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public boolean overlaps(BoundingBox other){
        double left = x;
        double right = x + width;
        double top = y;
        double bottom = y + height;

        double otherLeft = other.getX();
        double otherRight = other.getX() + other.getWidth();
        double otherTop = other.getY();
        double otherBottom = other.getY() + other.getHeight();

        return !(right < otherLeft || left > otherRight ||
                bottom < otherTop || top > otherBottom);
    }
}
