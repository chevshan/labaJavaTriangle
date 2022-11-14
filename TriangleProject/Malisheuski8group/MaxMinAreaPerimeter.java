package Malisheuski8group;

import java.util.ArrayList;

public class MaxMinAreaPerimeter {
    public static void getTypeOfTriangle(TypeOfTriangles typeOfTriangle, Triangle triangle) {
        switch (typeOfTriangle) {
            case EQUILATERAL: {
                System.out.println("This type of triangle is equilateral");
                Main.triangleEquilateral.add(triangle);
                break;
            }
            case ISOSCELES: {
                System.out.println("This type of triangle is isosceles");
                Main.triangleIsosceles.add(triangle);
                break;
            }
            case RECTANGULAR: {
                System.out.println("This type of triangle is rectangular");
                Main.triangleRectangular.add(triangle);
                break;
            }
            case ARBITRARY: {
                System.out.println("This type of triangle is arbitrary");
                Main.triangleArbitrary.add(triangle);
            }
        }
    }

    public static void getMaxArea(ArrayList<Triangle> triangleType) {
        Triangle maxAreaTriangle = triangleType.get(0);
        double maxArea = triangleType.get(0).getArea();
        for (int i = 0; i < triangleType.size(); i++) {
            if(maxArea < triangleType.get(i).getArea()) {
                maxArea = triangleType.get(i).getArea();
                maxAreaTriangle = triangleType.get(i);
            }
        }
        System.out.println("The largest area: " + maxArea + " of the " + maxAreaTriangle);
    }

    public static void getMinArea(ArrayList<Triangle> triangleType) {
        Triangle minAreaTriangle = triangleType.get(0);
        double minArea = triangleType.get(0).getArea();
        for (int i = 0; i < triangleType.size(); i++) {
            if(minArea > triangleType.get(i).getArea()) {
                minArea = triangleType.get(i).getArea();
                minAreaTriangle = triangleType.get(i);
            }
        }
        System.out.println("The smallest area: " + minArea + " of the " + minAreaTriangle);
    }

    public static void getMaxPerimeter(ArrayList<Triangle> triangleType) {
        Triangle maxPerimeterTriangle = triangleType.get(0);
        double maxPerimeter = triangleType.get(0).getArea();
        for (int i = 0; i < triangleType.size(); i++) {
            if(maxPerimeter < triangleType.get(i).getArea()) {
                maxPerimeter = triangleType.get(i).getArea();
                maxPerimeterTriangle = triangleType.get(i);
            }
        }
        System.out.println("The largest perimeter: " + maxPerimeter + " of the " + maxPerimeterTriangle);
    }

    public static void getMinPerimeter(ArrayList<Triangle> triangleType) {
        Triangle minPerimeterTriangle = triangleType.get(0);
        double minPerimeter = triangleType.get(0).getArea();
        for (int i = 0; i < triangleType.size(); i++) {
            if(minPerimeter > triangleType.get(i).getArea()) {
                minPerimeter = triangleType.get(i).getArea();
                minPerimeterTriangle = triangleType.get(i);
            }
        }
        System.out.println("The smallest perimeter: " + minPerimeter + " of the " + minPerimeterTriangle);
    }

    public static void infoTriangle(ArrayList<Triangle> triangleType) {
        getMaxArea(triangleType);
        getMinArea(triangleType);
        getMaxPerimeter(triangleType);
        getMaxPerimeter(triangleType);
        System.out.println();
    }
}
