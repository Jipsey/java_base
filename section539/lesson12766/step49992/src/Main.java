class Main {
    public static void moveRobot(Robot robot, int toX, int toY) {
        int xMove = Math.abs(robot.getX()-toX);
        int yMove = Math.abs(robot.getY()-toY);

        switch (robot.getDirection()){
            case  UP: robot.turnRight();
                robot.turnRight();
                break;
            case DOWN: // исходное направление робота вниз, то вращать его не надо и все ОК :)
                break;
            case LEFT: robot.turnLeft();
                break;
            case RIGHT: robot.turnRight();
                break;}



        if (xMove!=0){
            if (toX>robot.getX()){
                robot.turnLeft();
                for (int i=0; i < xMove ;i++){robot.stepForward(); }
                robot.turnRight();// в исходное положение, робот смотрит вниз
            }
            if (toX<robot.getX()){
                robot.turnRight();
                for (int i=0; i < xMove ;i++){robot.stepForward(); }
                robot.turnLeft();// в исходное положение, робот смотрит вниз
            }
        }
        if (yMove!=0){
            if (toY>robot.getY()){
                robot.turnLeft(); robot.turnLeft();
                for (int i=0; i < yMove ;i++){robot.stepForward();}
                robot.turnLeft(); // в исходное положение, робот смотрит вниз
                robot.turnLeft();
            }
            else {
                for (int i=0; i < yMove ;i++){robot.stepForward();}
            }
        }
    }
}
