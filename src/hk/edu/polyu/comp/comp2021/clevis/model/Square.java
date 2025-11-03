package hk.edu.polyu.comp.comp2021.clevis.model;

public class Square extends Shape {
    private int height; // height = side length
    public Square(String name, int x, int y, int height) {
        super(name,x,y, new BoundingBox(x,y,height,height));
        this.height = height;
    }
}
