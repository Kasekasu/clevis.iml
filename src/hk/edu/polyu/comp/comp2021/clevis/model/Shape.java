package hk.edu.polyu.comp.comp2021.clevis.model;

public class Shape {
    private String name;
    private int x;
    private int y;
    private BoundingBox boundingBox;
    private int z;

    public Shape(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Shape(String name, int x, int y, BoundingBox boundingBox){
        this(name,x,y);
        this.boundingBox = boundingBox;
    }
    public String getName() {return name;}
    public int getX() {return x;}
    public int getY() {return y;}
    public BoundingBox getBoundingBox() {return boundingBox;}
    public String outputBoundingBox(){
        return boundingBox.getX() + " " + boundingBox.getY() + " " + boundingBox.getWidth() + " " + boundingBox.getHeight();
    }
}
