package hk.edu.polyu.comp.comp2021.clevis.model;

public abstract class Shape {

    protected String name;
    protected BoundingBox boundingBox;
    protected int z;
    public static int currentZ = 0;

    public Shape(String name) {
        this.name = name;
        this.z = ++currentZ;
        updateBoundingBox();
    }

    public String getName() {return name;}
    public BoundingBox getBoundingBox() {
        updateBoundingBox();
        return boundingBox;
    }
    protected abstract void updateBoundingBox();

    public BoundingBox getBoundingBox(BoundingBox boundingBox){return this.boundingBox;}
    public String outputBoundingBox(){
        return boundingBox.getX() + " " + boundingBox.getY() + " " + boundingBox.getWidth() + " " + boundingBox.getHeight();
    }

    protected abstract boolean covers(double x, double y);
    protected abstract void move(double dx,double dy);
    protected abstract String list();
}
