package rip.special;

import java.util.HashMap;
import java.util.Stack;

//Problem
//        We want to build a very basic app that let artists draw shapes on a blank canvas.
//        Think of this app like the most rudimentary version of Microsoft Paint or Adobe Photoshop.
//        We want this app to eventually support the following operations:
//
//        add shapes to the canvas
//
//        move shapes around the canvas.
//
//        Part 1
//        create a MxN blank canvas
//
//        display the canvas to the user
//
//        Example:
//        A canvas of 10x25 would look like this. String “0” means a white space.
//
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//
//        Part 2
//        draw a rectangle of size LxW and place it at some coordinate (i, j)
//
//        supports multiple shapes where the shapes can be overlapping. If they are overlapping, then the last shape that was drawn gets displayed
//
//        Example:
//
//        Drawing the shapes ‘a', ‘b’ and 'c’ where
//
//        'a' is 4x6 at (0,0)
//
//        'b' is 6x4 at (4,21)
//
//        'c' is 5x5 at (2,5)
//
//        Notice ‘c' is overlapping with ‘a’ and since ‘c’ was added last, we show ‘c’ on top of 'a’
//
//        a a a a a a 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        a a a a a a 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        a a a a a c c c c c 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        a a a a a c c c c c 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 c c c c c 0 0 0 0 0 0 0 0 0 0 0 b b b b
//        0 0 0 0 0 c c c c c 0 0 0 0 0 0 0 0 0 0 0 b b b b
//        0 0 0 0 0 c c c c c 0 0 0 0 0 0 0 0 0 0 0 b b b b
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 b b b b
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 b b b b
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 b b b b
//
//        Part 3
//        Move the shape to any new location within the canvas.
//
//        Example:
//        Moving the shape ‘c' to (2, 7). Notice how 'a’ is being displayed to the user.
//
//        a a a a a a 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        a a a a a a 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//        a a a a a a 0 c c c c c 0 0 0 0 0 0 0 0 0 0 0 0 0
//        a a a a a a 0 c c c c c 0 0 0 0 0 0 0 0 0 0 0 0 0
//        0 0 0 0 0 0 0 c c c c c 0 0 0 0 0 0 0 0 0 b b b b
//        0 0 0 0 0 0 0 c c c c c 0 0 0 0 0 0 0 0 0 b b b b
//        0 0 0 0 0 0 0 c c c c c 0 0 0 0 0 0 0 0 0 b b b b
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 b b b b
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 b b b b
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 b b b b
//
//        [ . ]
//        [ a a a a ]
//        [ a b a a ]
//        [ a ]
//        [ . b . ]
//        [ b ]
//        [ c ]
//
//        move c out of canvas
//        [ b ]
//
//        move b out of canvas
//        [ a ]


public class Painter {

    class Pair {
        int startX;
        int startY;
        int sizeX;
        int sizeY;

        Pair(int startX, int startY, int sizeX, int sizeY) {
            this.startX = startX;
            this.startY = startY;
            this.sizeX = sizeX;
            this.sizeY = sizeY;
        }
    }

    Stack<Character>[][] canvas;

    HashMap<Character, Pair> location;
    int n;
    int m;

    Painter(int n, int m) {
        this.n = n;
        this.m = m;
        canvas = new Stack[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                canvas[i][j] = new Stack<>();
            }
        }
        location = new HashMap<>();
    }

    private void display() {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (!canvas[i][j].isEmpty()) {
                    System.out.print(canvas[i][j].peek() + " ");
                } else {
                    System.out.print("ø ");
                }
            }
            System.out.println();
        }
    }

    private void draw(char c, int posX, int posY, int sizeX, int sizeY) {
        location.put(c, new Pair(posX, posY, sizeX, sizeY));
        for (int a = posX; a < posX + sizeX; a++) {
            for (int b = posY; b < posY + sizeY; b++) {
                if (isValidLocation(a, b)) {
                    canvas[a][b].push(c);
                }
            }
        }
    }

    private void move(char c, int newposX, int newposY) {

        Pair loc = location.get(c);

        for (int i = loc.startX; i < loc.startX + loc.sizeX; i++) {
            for (int j = loc.startY; j < loc.startY + loc.sizeY; j++) {
                canvas[i][j].pop();
            }
        }

        draw(c, newposX, newposY, loc.sizeX, loc.sizeY);
    }

    private boolean isValidLocation(int x, int y) {
        if (x > 0 && x < canvas.length && y > 0 && y < canvas[0].length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        // part 1
        Painter p = new Painter(10, 25);


//        Drawing the shapes ‘a', ‘b’ and 'c’ where
//
//        'a' is 4x6 at (0,0)
//
//        'b' is 6x4 at (4,21)
//
//        'c' is 5x5 at (2,5)

        // part 2
        p.draw('a', 0, 0, 4, 6);

        p.draw('b', 2, 21, 6, 4);

        p.draw('c', 2, 5, 5, 5);

        p.draw('x', 5, 22, 7, 5);

        // part 3

        p.display();

//        Moving the shape ‘c' to (2, 7). Notice how 'a’ is being displayed to the user.

        System.out.println("---------------------");

        p.move('c', 2, 7);

        p.display();

    }

}
