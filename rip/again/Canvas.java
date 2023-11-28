package rip.again;

//import java.util.*;

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

import java.util.HashMap;
import java.util.Stack;

public class Canvas {

    private final Stack[][] canvas;
    private final HashMap<Character, Node> storage;
    private final int m;
    private final int n;

    public Canvas(int m, int n) {
        this.m = m;
        this.n = n;
        this.canvas = new Stack[m][n];
        this.storage = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                canvas[i][j] = new Stack<>();
            }
        }

        this.draw('0', m, n, 0, 0);
    }

    class Node {
        char val;
        int ogx;
        int ogy;
        int sizex;
        int sizey;

        Node(char val, int ogx, int ogy, int sizex, int sizey) {
            this.val = val;
            this.ogx = ogx;
            this.ogy = ogy;
            this.sizex = sizex;
            this.sizey = sizey;
        }
    }


    public void draw(char c, int sizex, int sizey, int x, int y) {

        storage.put(c, new Node(c, x, y, sizex, sizey));

        for (int i = x; i < x + sizex; i++) {
            for (int j = y; j < y + sizey; j++) {
                if (validPos(i, j)) {
                    canvas[i][j].push(c);
                }
            }
        }

    }

    public void move(char c, int newx, int newy) {

        if (!storage.containsKey(c)) {
            System.out.println("VALUE DOES NO EXIST.");
            return;
        }


        Node infoOfChar = storage.get(c);

        for (int i = infoOfChar.ogx; i < infoOfChar.ogx + infoOfChar.sizex; i++) {
            for (int j = infoOfChar.ogy; j < infoOfChar.ogy + infoOfChar.sizey; j++) {
                if (validPos(i, j)) {
                    canvas[i][j].pop();
                }
            }
        }

        draw(c, infoOfChar.sizex, infoOfChar.sizey, newx, newy);

    }

    private boolean validPos(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public void display() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(canvas[i][j].peek() + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Canvas c = new Canvas(10, 25);

        c.display();

        System.out.println("--------------------------------");

        c.draw('a', 4, 6, 0, 0);

        c.draw('b', 6, 4, 4, 21);
        c.draw('c', 5, 5, 2, 5);

        c.display();

        System.out.println("--------------------------------");

        c.move('c', 2, 7);

        c.display();

        System.out.println("--------------------------------");


    }
}
