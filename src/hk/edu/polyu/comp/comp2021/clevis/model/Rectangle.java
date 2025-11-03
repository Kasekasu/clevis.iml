package hk.edu.polyu.comp.comp2021.clevis.model;

public class Rectangle extends Shape {
    private int width;
    private int height;
    public Rectangle(String name, int x, int y, int width, int height) {
        super(name,x,y, new BoundingBox(x, y, width, height));
        this.width = width;
        this.height = height;
    }
}
