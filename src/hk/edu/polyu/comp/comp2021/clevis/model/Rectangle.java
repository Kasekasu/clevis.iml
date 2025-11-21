package hk.edu.polyu.comp.comp2021.clevis.model;

public class Rectangle extends Shape {
    private double x,y,width,height;
    public Rectangle(String name, int x, int y, int width, int height) {
        super(name);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        updateBoundingBox();
    }

    public void updateBoundingBox(){
        boundingBox = new BoundingBox(x,y,width,height);
    }

    public boolean covers(double x, double y){
        BoundingBox bb = this.boundingBox;
        double left = bb.getX();
        double right = left + bb.getWidth();
        double top = bb.getY();
        double bottom = top + bb.getHeight();

        double dx = Math.min(Math.abs(x - left),Math.abs(x-right)); // check if it is within the x range of the shape
        double dy = Math.min(Math.abs(y-top),Math.abs(y-bottom)); // check if it is within the y range of the shape

        boolean nearHorizontal = left >= dx && dx >= right && (Math.abs(y-top) < 0.05 || Math.abs(y-bottom) < 0.05);
        boolean nearVertical = top >= dy && dy >= bottom && (Math.abs(x-left) < 0.05 || Math.abs(x-right) < 0.05);

        return nearHorizontal || nearVertical;
    }

    public void move(double dx, double dy){
        this.x += dx;
        this.y += dy;
        updateBoundingBox();
    }
    public String list(){
        return String.format("Name = %s\tTop-Left Corner = (%f,%f)\tWidth = %f\tHeight = %f",name,x,y,width,height);
    }
}
