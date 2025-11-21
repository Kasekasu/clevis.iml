package hk.edu.polyu.comp.comp2021.clevis.model;

public class Circle extends Shape{
    private double radius,x,y;

    public Circle(String name, int x, int y, int radius){
        super(name);
        this.x = x;
        this.y = y;
        this.radius = radius;
        updateBoundingBox();
    }

    public void updateBoundingBox(){
        boundingBox = new BoundingBox(x-radius, y-radius, radius*2, radius*2);
    }

    public boolean covers(double px, double py){
        double dx =  Math.abs(x-px);
        double dy = Math.abs(y-py);
        double distanceToCenter = Math.sqrt(dx*dx+dy*dy);
        double distanceToOutline = Math.abs(distanceToCenter - radius);

        return distanceToOutline < 0.05;
    }
    public void move(double dx,double dy){
        this.x += dx;
        this.y += dy;
        updateBoundingBox();
    }
    public String list(){
        return String.format("Name = %s\tCenter = (%f,%f)\tRadius = %f",name,x,y,radius);
    }
}
