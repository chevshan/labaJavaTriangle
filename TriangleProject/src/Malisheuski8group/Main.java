package Malisheuski8group;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Triangle> triangleEquilateral = new ArrayList<>();
    public static ArrayList<Triangle> triangleIsosceles = new ArrayList<>();
    public static ArrayList<Triangle> triangleRectangular = new ArrayList<>();
    public static ArrayList<Triangle> triangleArbitrary = new ArrayList<>();

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

        System.out.println("Number of equilateral triangles:" + triangleEquilateral.size());
        System.out.println("Number of isosceles triangles:" + triangleIsosceles.size());
        System.out.println("Number of rectangular triangles:" + triangleRectangular.size());
        System.out.println("Number of arbitrary triangles:" + triangleArbitrary.size());
        System.out.println();

        System.out.println("Data on the max/min area (perimeter) of equilateral triangles:");
        if (triangleEquilateral.size() != 0)
        infoTriangle(triangleEquilateral);
        else System.out.println("There are no triangles in this group\n");
        System.out.println("Data on the max/min area (perimeter) of isosceles triangles:");
        if (triangleIsosceles.size() != 0)
            infoTriangle(triangleIsosceles);
        else System.out.println("There are no triangles in this group\n");
        System.out.println("Data on the max/min area (perimeter) of rectangular triangles:");
        if (triangleRectangular.size() != 0)
            infoTriangle(triangleRectangular);
        else System.out.println("There are no triangles in this group\n");
        System.out.println("Data on the max/min area (perimeter) of arbitrary triangles:");
        if (triangleArbitrary.size() != 0)
            infoTriangle(triangleArbitrary);
        else System.out.println("There are no triangles in this group\n");
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
            TypeOfTriangles typeOfTriangle = triangle.typeOfTriangle();
            getTypeOfTriangle(typeOfTriangle, triangle);
            System.out.println("--------------------------------------------");
        }
    }

    public static void getTypeOfTriangle(TypeOfTriangles typeOfTriangle, Triangle triangle) {
        switch (typeOfTriangle) {
            case EQUILATERAL: {
                System.out.println("This type of triangle is equilateral");
                triangleEquilateral.add(triangle);
                break;
            }
            case ISOSCELES: {
                System.out.println("This type of triangle is isosceles");
                triangleIsosceles.add(triangle);
                break;
            }
            case RECTANGULAR: {
                System.out.println("This type of triangle is rectangular");
                triangleRectangular.add(triangle);
                break;
            }
            case ARBITRARY: {
                System.out.println("This type of triangle is arbitrary");
                triangleArbitrary.add(triangle);
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
