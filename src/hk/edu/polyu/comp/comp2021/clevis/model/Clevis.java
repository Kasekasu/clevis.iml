package hk.edu.polyu.comp.comp2021.clevis.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

public class Clevis {
    public HashMap<String,Shape> shapesHashMap;
    public String txtPath, htmlPath;
    public Clevis(){
        shapesHashMap = new HashMap<>();
    }
    public Clevis(String txtPath, String htmlPath){
        this();
        this.txtPath = txtPath;
        this.htmlPath = htmlPath;
    }
	public void run() throws IOException {
        System.out.println("Welcome to clevis");
        System.out.println("Please type 'quit' to exit the program");
        ClevisLogger log = new ClevisLogger(txtPath,htmlPath);
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.print("Enter command for graphic creation: ");
            String command = input.nextLine();
            if (command.isEmpty()) continue;
            log.log(command);
            String[] c = command.split(" "); // "commands", used "c" for easier reading
            String shape = c[0];
            switch (shape){
                case "rectangle":
                    if (c.length < 6) {
                        System.out.println("Invalid number of inputs, please try again");
                        break;
                    }
                    if (shapesHashMap.containsKey(c[1])) {
                        System.out.println("Shape with same name already exists, please try again");
                        break;
                    }
                    Rectangle rec1 = new Rectangle(c[1],Integer.parseInt(c[2]),Integer.parseInt(c[3]),Integer.parseInt(c[4]),Integer.parseInt(c[5]));
                    shapesHashMap.put(c[1],rec1);
                    System.out.println("Successfully added rectangle");
                    break;
                case "line":
                    if (c.length < 6) {
                        System.out.println("Invalid number of inputs, please try again");
                        break;
                    }
                    if (shapesHashMap.containsKey(c[1])) {
                        System.out.println("Shape with same name already exists, please try again");
                        break;
                    }
                    Line line1 = new Line(c[1],Integer.parseInt(c[2]),Integer.parseInt(c[3]),Integer.parseInt(c[4]),Integer.parseInt(c[5]));
                    shapesHashMap.put(c[1],line1);
                    System.out.println("Successfully added line");
                    break;
                case "circle":
                    if (c.length < 5) {
                        System.out.println("Invalid number of inputs, please try again");
                        break;
                    }
                    if (shapesHashMap.containsKey(c[1])) {
                        System.out.println("Shape with same name already exists, please try again");
                        break;
                    }
                    Circle circle = new Circle(c[1],Integer.parseInt(c[2]),Integer.parseInt(c[3]),Integer.parseInt(c[4]));
                    shapesHashMap.put(c[1],circle);
                    System.out.println("Successfully added circle");
                    break;
                case "square":
                    if (c.length < 5) {
                        System.out.println("Invalid number of inputs, please try again");
                        break;
                    }
                    if (shapesHashMap.containsKey(c[1])) {
                        System.out.println("Shape with same name already exists, please try again");
                        break;
                    }
                    Square square = new Square(c[1],Integer.parseInt(c[2]),Integer.parseInt(c[3]),Integer.parseInt(c[4]));
                    shapesHashMap.put(c[1],square);
                    System.out.println("Successfully added square");
                    break;
                case "group":
                    if (c.length < 2) {
                        System.out.println("Invalid number of inputs, please try again");
                        break;
                    }
                    if (shapesHashMap.containsKey(c[1])) {
                        System.out.println("Shape with same name already exists, please try again");
                        break;
                    }
                    if (c.length < 3) {
                        System.out.println("Please enter shapes to group");
                        break;
                    }
                    Shape[] shapes = new Shape[c.length-2];
                    for (int i = 2; i < c.length; i++) {
                        Shape tempShape = shapesHashMap.get(c[i]);
                        if(tempShape == null){
                            System.out.println("Error: Shape "+c[i]+" not found");
                            break;
                        }
                        for (int j = i + 1; j < c.length; j++) {
                            if (tempShape.getName().equals(c[j])) {
                                System.out.println("Error: Duplicate shape name '" + tempShape.getName() + "' in group command");
                                break;
                            }
                        }
                        shapesHashMap.remove(c[i]);
                        shapes[i-2] = tempShape;
                    }
                    break;
                case "ungroup":
                    if (c.length < 2){
                        System.out.println("Invalid number of inputs, please try again");
                        break;
                    }
                    if (!shapesHashMap.containsKey(c[1])){
                        System.out.println("Group not found please try again");
                        break;
                    }
                    ShapeGroup group = (ShapeGroup) shapesHashMap.get(c[1]);
                    for (Shape childShape : group.getShapes()){
                        shapesHashMap.put(childShape.name,childShape);
                    }
                    shapesHashMap.remove(c[1]);
                    break;
                case "delete":
                    if(c.length < 2){
                        System.out.println("Invalid number of inputs, please try again");
                        break;
                    }
                    if (!shapesHashMap.containsKey(c[1])) {
                        System.out.println("Error: Shape "+c[1]+" not found");
                        break;
                    }
                    shapesHashMap.remove(c[1]);
                    System.out.println("Successfully removed shape");
                    break;
                case "boundingbox":
                    if (c.length < 2) {
                        System.out.println("Invalid number of inputs, please try again");
                        break;
                    }
                    if (!shapesHashMap.containsKey(c[1])) {
                        System.out.println("Error: Shape "+c[1]+" not found");
                        break;
                    }
                    shapesHashMap.get(c[1]).outputBoundingBox();
                    break;
                case "move":
                    if  (c.length < 4) {
                        System.out.println("Invalid number of inputs, please try again");
                        break;
                    }
                    if (!shapesHashMap.containsKey(c[1])) {
                        System.out.println("Error: Shape with name " + c[1] + " not found");
                        break;
                    }
                    Shape moveShape =  shapesHashMap.get(c[1]);
                    double moveX  = Double.parseDouble(c[2]);
                    double moveY  = Double.parseDouble(c[3]);
                    moveShape.move(moveX,moveY);
                    break;
                case "shapeAt":
                    if (c.length < 3) {
                        System.out.println("Invalid number of inputs, please try again");
                        break;
                    }
                    double x = Double.parseDouble(c[1]);
                    double y = Double.parseDouble(c[2]);
                    Shape res = null;
                    for (Shape s : shapesHashMap.values()){
                        if (s.covers(x,y)){
                            if (res == null || s.z > res.z){
                                res = s;
                            }
                        }
                    }
                    if (res != null) System.out.println(res.name);
                    else System.out.println("Error: No shape covering " + x + " " + y + " found");
                    break;
                case "intersect":
                    if (c.length < 3) {
                        System.out.println("Invalid number of inputs, please try again");
                    }
                    String n1 = c[1], n2 = c[2];
                    Shape shape1 = shapesHashMap.get(n1);
                    Shape shape2 = shapesHashMap.get(n2);
                    if (shape1 == null || shape2 == null) {
                        System.out.println("Error: Shape "+n1+" or "+n2+" not found");
                    }
                    boolean intersects = shape1.getBoundingBox().overlaps(shape2.getBoundingBox());
                    if (!intersects) {
                        System.out.println("The shape " + c[1] + "and " + c[2] + " does not intersect");
                    }
                    else {
                        System.out.println("The shape " + c[1] + "and " + c[2] + " does intersect");
                    }
                    break;
                case "list":
                    if (c.length < 2) {
                        System.out.println("Invalid number of inputs, please try again");
                        break;
                    }
                    if (!shapesHashMap.containsKey(c[1])) {
                        System.out.println("Error: Shape "+c[1]+" not found");
                        break;
                    }
                    System.out.println(shapesHashMap.get(c[1]).list());
                    break;
                case "listAll":
                    List<Shape> allShapes =  new ArrayList<>(shapesHashMap.values());
                    allShapes.sort((a,b) -> b.z - a.z);
                    for (Shape s : allShapes){
                        System.out.println(s.list());
                    }
                case "quit":
                    System.out.println("Thank you for using CLEVIS");
                    log.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid shape");
                    break;
            }
        }
    }
}
