package org.nbicocchi.basics;

/**
 * Write a class that has two overloaded static methods for calculating the
 * areas of the following geometric shapes:
 * <p>
 * circles, rectangles
 *
 * @author Justin Musgrove
 */
public class Area {

    /**
     * Method should calculate the area of a circle
     *
     * @param radius radius of a circle
     * @return area of a circle
     */
    public static double getArea(double radius) {
        return Math.PI * radius * radius;
    }

    /**
     * Method should calculate the area of a rectangle
     *
     * @param length length of the rectangle
     * @param width  width of the rectangle
     * @return area of a rectangle
     */
    public static double getArea(int length, int width) {
        return length * width;
    }

    public static void main(String[] args) {
        // Area of a circle
        System.out.printf("The area of a circle with a " + "radius of 10.0 is %6.2f\n", Area.getArea(10.0));

        // Area of a rectangle
        System.out.printf("The area of a rectangle with a " + "length of 15 and a width of 25 is %6.2f\n",
                Area.getArea(15, 25));
    }
}
