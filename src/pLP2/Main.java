package pLP2;

import java.io.*;
import java.util.Scanner;


public class Main {
	/*
	 * This code Orchestrates the execution of quadtree operations based on commands in an input file.
	 * 
	 * Arg: String[] args: Command-line arguments passed to the program. 
	 * The first argument (args[0]) is expected to be the path to a file containing commands.
	 * 
	 * Returns: None
	 * 
	 * */
    public static void main(String[] args) {
        // Check if a command file path is provided
        if (args.length != 1) {
            System.out.println("Usage: java Main <command-file>");
            return;
        }

        String commandFilePath = args[0];
        Quadtree quadtree = new Quadtree();

        // Read and process the command file
        try (Scanner fileScanner = new Scanner(new File(commandFilePath))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;  // Skip empty lines
                }

                // Split the command by spaces
                String[] parts = line.split("\\s+");
                String command = parts[0].toLowerCase();

                switch (command) {
                /*
            	 * This code Creates a Rectangle object and inserts it into the quadtree.
            	 * 
            	 * Arg: X, Y: Coordinates of the rectangle's bottom-left corner.
					L, W: Length (width) and height of the rectangle.
            	 * 
            	 * Returns: None
            	 * 
            	 * */
                case "insert":
                        // Command: Insert X Y L W
                        if (parts.length != 5) {
                            System.out.println("Invalid Insert command format: " + line);
                            break;
                        }
                        try {
                            double x = Double.parseDouble(parts[1]);
                            double y = Double.parseDouble(parts[2]);
                            double length = Double.parseDouble(parts[3]);
                            double width = Double.parseDouble(parts[4]);
                            quadtree.insert(new Rectangle(x, y, length, width));
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format in Insert command: " + line);
                        }
                        break;
                       
                        /*
                    	 * This code Deletes a rectangle located at the specified coordinates.
                    	 * 
                    	 * Arg: X, Y: Coordinates of the rectangle to be deleted.
                    	 * 
                    	 * Returns: None
                    	 * 
                    	 * */
                    case "delete":
                        // Command: Delete X Y
                        if (parts.length != 3) {
                            System.out.println("Invalid Delete command format: " + line);
                            break;
                        }
                        try {
                            double deleteX = Double.parseDouble(parts[1]);
                            double deleteY = Double.parseDouble(parts[2]);
                            quadtree.delete(deleteX, deleteY);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format in Delete command: " + line);
                        }
                        break;
                        /*
                    	 * This code Searches for a rectangle at the specified coordinates.

                    	 * 
                    	 * Arg: X, Y: Coordinates of the rectangle to be found.
                    	 * 
                    	 * Returns: Outputs the rectangle's details if found, or a message indicating no rectangle exists at the specified coordinates.
                    	 * 
                    	 * */
                    case "find":
                        // Command: Find X Y
                        if (parts.length != 3) {
                            System.out.println("Invalid Find command format: " + line);
                            break;
                        }
                        try {
                            double findX = Double.parseDouble(parts[1]);
                            double findY = Double.parseDouble(parts[2]);
                            Rectangle foundRect = quadtree.find(findX, findY);
                            if (foundRect != null) {
                                System.out.println("Rectangle at [" + findX + ", " + findY + "]: " +
                                        foundRect.width + "x" + foundRect.height);
                            } else {
                                System.out.println("Nothing is at [" + findX + ", " + findY + "].");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format in Find command: " + line);
                        }
                        break;
                        /*
                    	 * This code Updates the dimensions of a rectangle at the specified coordinates.
                    	 * 
                    	 * Arg: X, Y: Coordinates of the rectangle to be updated.
								L, W: New length (width) and height for the rectangle.
                    	 * 
                    	 * Returns: None
                    	 * 
                    	 * */
                    case "update":
                        // Command: Update X Y L W
                        if (parts.length != 5) {
                            System.out.println("Invalid Update command format: " + line);
                            break;
                        }
                        try {
                            double updateX = Double.parseDouble(parts[1]);
                            double updateY = Double.parseDouble(parts[2]);
                            double newLength = Double.parseDouble(parts[3]);
                            double newWidth = Double.parseDouble(parts[4]);
                            quadtree.update(updateX, updateY, newLength, newWidth);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format in Update command: " + line);
                        }
                        break;
                        /*
                    	 * This code Displays the current state of the quadtree, including nodes and rectangles.
                    	 * 
                    	 * Arg: None
                    	 * 
                    	 * Returns: Outputs the structure of the quadtree.
                    	 * 
                    	 * */
                    case "dump":
                        // Command: Dump
                        quadtree.dump();
                        break;

                    default:
                        System.out.println("Unknown command: " + line);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: The command file could not be found: " + commandFilePath);
        }
    }
}



