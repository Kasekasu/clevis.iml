package hk.edu.polyu.comp.comp2021.clevis.model;

import java.util.ArrayList;

public class ShapeGroup extends Shape{

    private ArrayList<Shape> shapes;

    public ShapeGroup(String name,Shape[] shapesList){
        super(name);
        this.shapes = new ArrayList<>();
        for(Shape s: shapesList){
            this.shapes.add(s);
        }
        updateBoundingBox();
    }

    protected void updateBoundingBox() {
        if (shapes.isEmpty()) {
            boundingBox = new BoundingBox(0, 0, 0, 0);
            return;
        }
        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;

        for (Shape s : shapes) {
            BoundingBox bb = s.getBoundingBox();
            minX = Math.min(minX, bb.getX());
            minY = Math.min(minY, bb.getY());
            maxX = Math.max(maxX, bb.getX() + bb.getWidth());
            maxY = Math.max(maxY, bb.getY() + bb.getHeight());
        }

    }
    public ArrayList<Shape> getShapes() {return this.shapes;}
    public BoundingBox getBoundingBox() {return boundingBox;}
    public void move(double dx, double dy){
        for (Shape s : shapes){
            s.move(dx,dy);
        }
        this.updateBoundingBox();
    }
    public boolean covers(double x, double y){
        for (Shape s : shapes){
            if (s.covers(x, y)){
                return true;
            }
        }
        return false;
    }
    public String list() {
        return listHelper();
    }

    private String listHelper() {
        StringBuilder res = new StringBuilder(this.name); // start with the group name
        for (Shape s : shapes) {
            res.append("\t"); // tab before each child
            if (s instanceof ShapeGroup) {
                // recursively append children
                res.append(((ShapeGroup) s).listHelper());
            } else {
                res.append(s.name);
            }
        }
        return res.toString();
    }
}
