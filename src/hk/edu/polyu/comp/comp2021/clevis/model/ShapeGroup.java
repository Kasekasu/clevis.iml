package hk.edu.polyu.comp.comp2021.clevis.model;

import java.util.ArrayList;

public class ShapeGroup extends Shape{
    private ArrayList<Shape> shapes;
    private BoundingBox groupBoundingBox;
    public ShapeGroup(String name,Shape[] shapesList){
        super(name, 0,0);
        this.shapes = new ArrayList<>();
        for(Shape s: shapesList){
            this.shapes.add(s);
        }
        updateBoundingBox();
    }

    public void updateBoundingBox(){
        if (shapes.isEmpty()){
            groupBoundingBox = new BoundingBox(0,0,0,0);
            return;
        }
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (Shape s : shapes){
            BoundingBox bb = s.getBoundingBox();
            minX =  Math.min(minX,bb.getX());
            minY =  Math.min(minY,bb.getY());
            maxX = Math.max(maxX,bb.getX() + bb.getWidth());
            maxY = Math.max(maxY,bb.getY() + bb.getHeight());
        }
        int width = maxX - minX;
        int height = maxY - minY;
        groupBoundingBox = new BoundingBox(minX,minY,width,height);
    }
    @Override
    public BoundingBox getBoundingBox() {return groupBoundingBox;}
}
