package com.cool.fun.stuff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the main class which will receive the file path 
 * and then instantiate the Maze class through the parseMaze method.
 * @author lChrios
 * 
 */
public class SolveTheMaze {
    
    /**
     * The main function will receive the filepath through the command line interface.
     * This path will be passed into the parser which will convert it 
     * into a Maze object and then start the simulation.
     * 
     * @param args      String[] contains at the 0 position the file path to the puzzle file
     */
    public static void main(String[] args) {
        
        //String filePath = args[0];
        String[] paths = {"C:\\Users\\marco\\OneDrive\\Documentos\\SolveTheMaze\\ExamplePuzzleSmall.txt",
        "C:\\Users\\marco\\OneDrive\\Documentos\\SolveTheMaze\\ExamplePuzzleBig.txt",
        "C:\\Users\\marco\\OneDrive\\Documentos\\SolveTheMaze\\ExamplePuzzleHuge.txt"};

        String filePath = paths[1];

        // Filepath empty validation
        if (filePath == null || filePath.trim().isEmpty()) {
            System.out.println("Please specify a file path.");
            return ;
        }

        // Parse file and create the Maze object
        Maze maze = parseMaze(filePath);
        
        maze.solve();

        return;
    }

    /**
     * Returns the Maze that results from the given file
     * 
     * @param filePath      String contains path to  the puzzle file
     * @return              The Maze instance representing the puzzle read from the file     
     */
    public static Maze parseMaze(String filePath) {

        List<List<Cell>> map = new ArrayList<>();
        Integer endH = 0;

        try {
            
            // Read it through a BR
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            Integer y = 0;

            while((line = br.readLine()) != null) {

                List<Cell> row = new ArrayList<>();
                // Split row into characters
                char[] c = line.toCharArray();
                
                //  Convert each character to a new Cell object
                for (int x = 0; x < c.length; x++) {
                    // Is space, end or start of the maze
                    if (c[x] == ' ' || c[x] == 'B' || c[x] == 'E') 
                        row.add(new Cell(x, y, false));
                    // Is wall
                    else if (c[x] == 'X') 
                        row.add(new Cell(x, y, true));
                    
                    if (c[x] == 'E') endH = y; // Save height of the exit
                }

                map.add(row); // Save row
                y++;
            }

            br.close();
        } catch (Exception e) {
            System.err.println("The file was not found.");
        }

        // Return the object
        return new Maze(map, endH);
    }

}
