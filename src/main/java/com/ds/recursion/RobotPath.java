package com.ds.recursion;

import java.util.ArrayList;

/**
 * Created by Mahbub on 10/30/2016.
 */

class Grid {
    int[][] grid;
    public Grid(int m, int n) {
        grid = new int[m][n];
    }

    public void markUnavailable(int x, int y) {
        grid[x][y] = -1;
    }

    public boolean isFree(int x, int y) {
        return grid[x][y] == -1 ? false : true;
    }

    public void printGrid() {
        System.out.println("======== PRINTING GRID ========");
        for (int i=0; i<grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == -1)
                    System.out.print("X ");
                else
                    System.out.print("_ ");
            }
            System.out.print("\n");
        }
    }

    public void printPath(ArrayList<Point> path) {
        System.out.println("======== PRINTING PATH ========");
        for (int i=0; i<grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == -1)
                    System.out.print("X ");
                else if (path.contains(new Point(i, j)))
                    System.out.print("* ");
                else
                    System.out.print("_ ");
            }
            System.out.print("\n");
        }
    }
}

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object that) {
        Point other = (Point) that;
        if (this.x == other.x && this.y == other.y)
            return true;
        else
            return false;
    }
}

public class RobotPath {

    public static boolean findPath(int x, int y, ArrayList<Point> path, Grid testGrd) {
        if (x == 0 && y == 0)
            return true;

        boolean found = false;
        Point p = new Point(x, y);

        if (x>=1 && testGrd.isFree(x-1, y))
            found = findPath(x-1, y, path, testGrd);

        if (!found && y>=1 && testGrd.isFree(x, y-1))
            found = findPath(x, y-1, path, testGrd);

        if (found)
            path.add(p);

        return found;
    }

    public static void main(String[] args) {
        Grid test = new Grid(5, 4);
        test.markUnavailable(1, 1);
        test.markUnavailable(1, 2);
        test.markUnavailable(3, 0);
        test.markUnavailable(3, 1);
        test.markUnavailable(3, 3);
        test.markUnavailable(0, 3);

        test.printGrid();

        ArrayList<Point> path = new ArrayList<Point>();
        if (findPath(4, 3, path, test)) {
            test.printPath(path);
        } else
            System.out.println("No path found");
    }

}
