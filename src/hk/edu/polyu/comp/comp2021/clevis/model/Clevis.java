package hk.edu.polyu.comp.comp2021.clevis.model;

import java.util.Scanner;
import java.util.HashMap;

public class Clevis {
    public HashMap<String,Shape> shapesHashMap;
    public Clevis(){
        shapesHashMap = new HashMap<>();
    }
	public void run(){
        System.out.println("Welcome to clevis");
        System.out.println("Please type 'quit' to exit the program");
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.print("Enter command for graphic creation: ");
            String command = input.nextLine();
            if (command.isEmpty()) continue;
            String[] c = command.split(" "); // "commands", used "c" for easier reading
            String shape = c[0];
            switch (shape){
                case "rectangle":
                    if (c.length < 6) {
                        System.out.println("Invalid number of inputs, please try again");
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
                    Line line1 = new Line(c[1],Integer.parseInt(c[2]),Integer.parseInt(c[3]),Integer.parseInt(c[4]),Integer.parseInt(c[5]));
                    shapesHashMap.put(c[1],line1);
                    System.out.println("Successfully added line");
                    break;
                case "circle":
                    if (c.length < 5) {
                        System.out.println("Invalid number of inputs, please try again");
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
                    Square square = new Square(c[1],Integer.parseInt(c[2]),Integer.parseInt(c[3]),Integer.parseInt(c[4]));
                    shapesHashMap.put(c[1],square);
                    System.out.println("Successfully added square");
                    break;
                case "group":
                    if (c.length < 2) {
                        System.out.println("Invalid number of inputs, please try again");
                        break;
                    }
                    Shape[] shapes = new Shape[c.length-2];
                    for (int i = 2; i < c.length; i++) {
                        Shape tempShape = shapesHashMap.get(c[i]);
                        if(tempShape == null){
                            System.out.println("Error: Shape "+c[i]+" not found");
                            return;
                        }
                        for (int j = i + 1; j < c.length; j++) {
                            if (tempShape.getName().equals(c[j])) {
                                System.out.println("Error: Duplicate shape name '" + tempShape.getName() + "' in group command");
                                return;
                            }
                        }
                        shapesHashMap.remove(c[i]);
                        shapes[i-2] = tempShape;
                    }
                    break;
                case "quit":
                    System.out.println("Thank you for using CLEVIS");
                    System.exit(0);
                default:
                    System.out.println("Invalid shape");
                    break;
            }
        }
    }
}
