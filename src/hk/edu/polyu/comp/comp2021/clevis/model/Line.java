package hk.edu.polyu.comp.comp2021.clevis.model;

public class Line extends Shape{
    private int x2;
    private int y2;
    public Line(String name, int x1, int y1, int x2, int y2) {
        super(name,x1,y1,new BoundingBox(Math.min(x1, x2), Math.max(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2)));
        this.x2 = x2;
        this.y2 = y2;
    }
}
