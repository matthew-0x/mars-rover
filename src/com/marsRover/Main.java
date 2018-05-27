package com.marsRover;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        int xBorder;
        int yBorder;
        int roverPositionX;
        int roverPositionY;
        String roverDirection;
        String roverInstruction;
        File dataFile = null;
        ArrayList<Rover> rovers = new ArrayList<>();

        try {
          if ( 0 < args.length ) {
             dataFile = new File(args[0]);
          } else {
             System.err.println("Invalid arguments count:" + args.length);
             System.exit(0);
          }

            BufferedReader readBuffer = new BufferedReader(new FileReader(dataFile));
            String strLine = readBuffer.readLine();
            xBorder = Character.getNumericValue( strLine.charAt(0));
            yBorder = Character.getNumericValue( strLine.charAt(2));
            Plateau mars = new Plateau( xBorder, yBorder );
            while ((strLine = readBuffer.readLine())!= null) {
                 roverPositionX = Character.getNumericValue(strLine.charAt(0));
                 roverPositionY = Character.getNumericValue(strLine.charAt(2));
                 roverDirection = String.valueOf(strLine.charAt(4));
                 roverInstruction = strLine.substring(6);
                 Rover rover = new Rover (roverPositionX, roverPositionY, roverDirection, roverInstruction, mars);
                 rovers.add(rover);
            }

            for (Rover rover : rovers) {
                rover.getPosition();
            }

        } catch (FileNotFoundException e) {
            System.err.print("File Not Found!");
        } catch (IOException e){
            System.err.print("Unknown Error!");
        }

    } //end of main()
} // end of class

