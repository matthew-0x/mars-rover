package com.marsRover;

/**
 * Created by mv on 1/12/2016.
 */
public class Rover {

    public Plateau mars;
    private int positionX;
    private int positionY;
    private int directionIndex;
    private String roverDirection;
    private String[] directions= {"n", "e", "s", "w"};

    public Rover(int x, int y, String direction, String instruction, Plateau plateau){

         this.setDirection(direction);
         this.setPositionX(x);
         this.setPositionY(y);
         mars=plateau;
         this.commandCentre(instruction.toLowerCase());
    }

    public void commandCentre(String commands) {

        for ( char c : commands.toCharArray()  ) {
            if (c == 'l') {
                turnLeft();
            } else if ( c == 'r') {
                turnRight();
            } else if ( c == 'm') {
                move();
            } else {
                throw new IllegalArgumentException("Unknown Instruction Received!");
            }

        }

    }

    public void setDirection( String direction ){
        if( direction.equals("n")) {
            roverDirection = directions[0];
        }else if ( direction.equals("e")) {
            roverDirection = directions[1];
            directionIndex = 1;
        }else if (direction.equals("s")) {
            roverDirection = directions[2];
            directionIndex = 2;
        }else if (direction.equals("w")) {
            roverDirection = directions[3];
            directionIndex = 3;
        }
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setPosition(int x, int y){

        setPositionX(x);
        setPositionY(y);
    }

    public void getPosition(){

        System.out.println("x:" + getPositionX()+ " y:"+ getPositionY()+ " direction:" + roverDirection);
    }

    public void turnRight(){
        directionIndex++;
        if( directionIndex >= directions.length )
            directionIndex = 0;
        roverDirection = directions[directionIndex];
    }

    public void turnLeft(){
        directionIndex--;
        if( directionIndex < 0 )
            directionIndex = 3;
        roverDirection = directions[directionIndex];
    }

    public void move(){

        switch (roverDirection){
            case "n" : positionY++;
                       if ( positionY > mars.getyBorder()) {
                            System.out.println("can't move, change direction");
                            positionY--;
                       }
                       break;

            case "e" : positionX++;
                       if( positionX > mars.getxBorder() ){
                           System.out.println("can't move, change direction");
                           positionX--;
                       }
                       break;

            case "s" : positionY--;
                       if( positionY < 0 ){
                           System.out.println("can't move, change direction");
                           positionY++;
                       }
                       break;

            case "w" : positionX--;
                       if( positionX < 0 ){
                           System.out.println("can't move, change direction");
                           positionX++;
                       }
                       break;
        } // end of Switch

    }

}
