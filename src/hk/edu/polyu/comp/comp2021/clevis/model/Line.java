package hk.edu.polyu.comp.comp2021.clevis.model;

public class Line extends Shape{
    private double x1,x2,y1,y2;
    public Line(String name, int x1, int y1, int x2, int y2) {
        super(name);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        updateBoundingBox();
    }

    public void  updateBoundingBox() {
        double minX = Math.min(x1, x2);
        double minY = Math.min(y1, y2);
        boundingBox = new BoundingBox(
                minX,
                minY,
                Math.abs(x1 - x2),
                Math.abs(y1 - y2)
        );
    }

    public boolean covers(double x, double y){
        double dx = x2 - x1;
        double dy = y2 - y1;

        if (dx == 0 && dy == 0){
            return Math.hypot(x-x1, y-y1) < 0.05;
        }

        // formula for shortest distance from a point to a line segment

        double t = ((x - x1) * dx + (y - y1) * dy) / (dx * dx + dy * dy);
        t = Math.max(0, Math.min(1, t));
        double closestX = x1 + t * dx;
        double closestY = y1 + t * dy;
        return Math.hypot(x - closestX, y - closestY) < 0.05;

    }
    public void move (double dx, double dy){
        this.x1 += dx;
        this.y1 += dy;
        this.x2 += dx;
        this.y2 += dy;
        updateBoundingBox();
    }
    public String list(){
        return String.format("Name = %s\tStarting Point = (%f,%f)\tEnd Point = (%f,%f)",name,x1,y1,x2,y2);
    }
}
