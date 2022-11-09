package Malisheuski8group;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int countEquilateral;
    public static int countIsosceles;
    public static int countRectangular;
    public static int countArbitrary;

     static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Triangle> triangleList = new ArrayList<>();
        System.out.print("Enter the number of triangles: ");
        try {
            int number = scanner.nextInt();
            if (number == 0 || number < 0)
                throw new RuntimeException();
            createTriangles(triangleList, number);
        }
        catch (RuntimeException e) {
            System.out.println("The number cannot be zero, contain letters, or be negative. Try again.");
        }

        System.out.println("Number of equilateral triangles:" + countEquilateral);
        System.out.println("Number of isosceles triangles:" + countIsosceles);
        System.out.println("Number of rectangular triangles:" + countRectangular);
        System.out.println("Number of arbitrary triangles:" + countArbitrary);

        getMaxArea(triangleList);
        getMinArea(triangleList);
        getMaxPerimeter(triangleList);
        getMinPerimeter(triangleList);
    }

    public static ArrayList<Double> getTrianglesValues() {

        ArrayList<Double> values = new ArrayList<>();
        try {
            System.out.print("Enter a Ax: ");
            double Ax = scanner.nextDouble();
            values.add(Ax);
            System.out.print("Enter a Ay: ");
            double Ay = scanner.nextDouble();
            values.add(Ay);
            System.out.print("Enter a Bx: ");
            double Bx = scanner.nextDouble();
            values.add(Bx);
            System.out.print("Enter a By: ");
            double By = scanner.nextDouble();
            values.add(By);
            System.out.print("Enter a Cx: ");
            double Cx = scanner.nextDouble();
            values.add(Cx);
            System.out.print("Enter a Cy: ");
            double Cy = scanner.nextDouble();
            values.add(Cy);
        }
        catch (Exception e) {
            System.out.println("There can't be a character in the coordinate");
        }
        return values;
    }

    public static void createTriangles(ArrayList<Triangle> triangleList, int number) {
        for (int i = 0; i < number; i++) {
            ArrayList<Double> values = getTrianglesValues();
            Dot A = new Dot(values.get(0), values.get(1));
            Dot B = new Dot(values.get(2), values.get(3));
            Dot C = new Dot(values.get(4), values.get(5));
            Triangle triangle = new Triangle(A, B, C);
            triangleList.add(triangle);

            System.out.println("--------------------------------------------");
            System.out.println("№" + (i + 1) + " " + triangle.toString());
            System.out.println("Perimeter = " + triangle.getPerimeter());
            System.out.println("Area = " + triangle.getArea());

            int temp = triangle.typeOfTriangle();
            switch (temp) {
                case 1: {
                    System.out.println("The type of triangle is equilateral");
                    countEquilateral++;
                    break;
                }
                case 2: {
                    System.out.println("The type of triangle is isosceles");
                    countIsosceles++;
                    break;
                }
                case 3: {
                    System.out.println("The type of triangle is rectangular");
                    countRectangular++;
                    break;
                }
                case 4: {
                    System.out.println("The type of triangle is arbitrary");
                    countArbitrary++;
                    break;
                }
                default:
                    System.out.println("Oh, something happened");
            }
            System.out.println("--------------------------------------------");
        }
    }

    public static void getMaxArea(ArrayList<Triangle> triangleList) {
        Triangle maxAreaTriangle = triangleList.get(0);
        double maxArea = triangleList.get(0).getArea();
        for (int i = 0; i < triangleList.size(); i++) {
            if(maxArea < triangleList.get(i).getArea()) {
                maxArea = triangleList.get(i).getArea();
                maxAreaTriangle = triangleList.get(i);
            }
        }
        System.out.println("The largest area: " + maxArea + " of the " + maxAreaTriangle);
    }

    public static void getMinArea(ArrayList<Triangle> triangleList) {
        Triangle minAreaTriangle = triangleList.get(0);
        double minArea = triangleList.get(0).getArea();
        for (int i = 0; i < triangleList.size(); i++) {
            if(minArea > triangleList.get(i).getArea()) {
                minArea = triangleList.get(i).getArea();
                minAreaTriangle = triangleList.get(i);
            }
        }
        System.out.println("The smallest area: " + minArea + " of the " + minAreaTriangle);
    }

    public static void getMaxPerimeter(ArrayList<Triangle> triangleList) {
        Triangle maxPerimeterTriangle = triangleList.get(0);
        double maxPerimeter = triangleList.get(0).getArea();
        for (int i = 0; i < triangleList.size(); i++) {
            if(maxPerimeter < triangleList.get(i).getArea()) {
                maxPerimeter = triangleList.get(i).getArea();
                maxPerimeterTriangle = triangleList.get(i);
            }
        }
        System.out.println("The largest perimeter: " + maxPerimeter + " of the " + maxPerimeterTriangle);
    }

    public static void getMinPerimeter(ArrayList<Triangle> triangleList) {
        Triangle minPerimeterTriangle = triangleList.get(0);
        double minPerimeter = triangleList.get(0).getArea();
        for (int i = 0; i < triangleList.size(); i++) {
            if(minPerimeter > triangleList.get(i).getArea()) {
                minPerimeter = triangleList.get(i).getArea();
                minPerimeterTriangle = triangleList.get(i);
            }
        }
        System.out.println("The smallest perimeter: " + minPerimeter + " of the " + minPerimeterTriangle);
    }
}
