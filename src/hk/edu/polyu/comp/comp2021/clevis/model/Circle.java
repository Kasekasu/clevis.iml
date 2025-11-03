package hk.edu.polyu.comp.comp2021.clevis.model;

public class Circle extends Shape{
    private int radius;

    public Circle(String name, int x, int y, int radius){
        super(name,x,y, new BoundingBox(x-radius, y-radius, x+radius, y+radius));
        this.radius = radius;
    }
}
