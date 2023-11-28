package rip;

import java.util.Arrays;

class Robot {

    int width;
    int height;
    int[] pos;
    String direction;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        pos = new int[]{0, 0};
        direction = "East";
    }

    public void step(int num) {

        for (int i = 0; i < num; i++) {
            move();
        }
    }

    public void move() {
        int[] nextMove = getNextPos();
        if (isvalid(nextMove)) {
            pos = nextMove;
        } else {
            turnNext();
            move();
        }
    }

    public int[] getNextPos() {
        int[] nextPos = pos.clone();
        switch (direction) {
            case "North":
                nextPos[1]++;
                break;
            case "East":
                nextPos[0]++;
                break;
            case "South":
                nextPos[1]--;
                break;
            case "West":
                nextPos[0]--;
                break;
        }
        return nextPos;
    }

    private boolean isvalid(int[] dir) {
        int x = dir[0];
        int y = dir[1];
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    private void turnNext() {
        // change to counterclockwise
        // E -> N
        // N -> W
        // W -> S
        // S -> E
        switch (direction) {
            case "East":
                direction = "North";
                break;

            case "West":
                direction = "South";
                break;

            case "North":
                direction = "West";
                break;

            case "South":
                direction = "East";
                break;
        }

    }

    public int[] getPos() {
        return pos;
    }

    public String getDir() {
        // is moving x++ -> North
        // is moving x-- -> South
        // is moving y-- -> West
        // is moving y++ -> East

        return direction;

    }

    public static void main(String[] args) {

        Robot robot = new Robot(6, 3); // Initialize the grid and the robot at (0, 0) facing East.
        robot.step(2);  // It moves two steps East to (2, 0), and faces East.
        robot.step(2);  // It moves two steps East to (4, 0), and faces East.
        System.out.println(Arrays.toString(robot.getPos())); // return [4, 0]
        System.out.println(robot.getDir()); // return "East"
        robot.step(2);  // It moves one step East to (5, 0), and faces East.
        // Moving the next step East would be out of bounds, so it turns and faces North.
        // Then, it moves one step North to (5, 1), and faces North.
        robot.step(1);  // It moves one step North to (5, 2), and faces North (not West).
        robot.step(4);  // Moving the next step North would be out of bounds, so it turns and faces West.
        // Then, it moves four steps West to (1, 2), and faces West.
        robot.getPos(); // return [1, 2]
        System.out.println(robot.getDir()); // return "West"

    }
}