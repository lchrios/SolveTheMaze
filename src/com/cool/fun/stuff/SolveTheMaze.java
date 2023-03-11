package com.cool.fun.stuff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SolveTheMaze {
    
    public static void main(String[] args) {
        
        String filePath = args[0];

        // File validation
        if (filePath == null || filePath.trim().isEmpty()) {
            System.out.println("Please specify a file path.");
            return ;
        }

        Maze maze = parseMaze(filePath);
        
        maze.solve();

        return;
    }

    public static Maze parseMaze(String filePath) {

        List<List<Cell>> map = new ArrayList<>();
        Integer endH = 0;

        try {
            
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            Integer y = 0;

            while((line = br.readLine()) != null) {

                List<Cell> row = new ArrayList<>();
                char[] c = line.toCharArray();
                
                for (int x = 0; x < c.length; x++) {
                    if (c[x] == ' ' || c[x] == 'B' || c[x] == 'E') 
                        row.add(new Cell(x, y, false));
                    else if (c[x] == 'X') 
                        row.add(new Cell(x, y, true));
                    
                    if (c[x] == 'E') endH = y; 
                }

                y++;
            }

            br.close();
        } catch (Exception e) {
            System.err.println("The file was not found.");
        }

        return new Maze(map, endH);
    }

}
