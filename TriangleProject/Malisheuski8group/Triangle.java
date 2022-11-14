package Malisheuski8group;

import java.util.ArrayList;

public class Triangle {

    private final Dot A;
    private final Dot B;
    private final Dot C;

    private double AB;
    private double BC;
    private double AC;

    public Triangle(Dot A, Dot B, Dot C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public double getSideSize(Dot first, Dot second) {
        return Math.sqrt(Math.pow(second.getX() - first.getX(), 2) + Math.pow(second.getY() - first.getY(), 2));
    }

    public void getSides() {
        this.AB = getSideSize(this.A, this.B);
        this.BC = getSideSize(this.B, this.C);
        this.AC = getSideSize(this.A, this.C);
    }

    public double getPerimeter() {
        getSides();
        return this.AB + this.BC + this.AC;
    }

    public double getArea() {
        getSides();
        double p = (getPerimeter() / 2);
        return Math.sqrt(p * (p - this.AB) * (p - this.BC) * (p - this.AC));
    }

    public TypeOfTriangles typeOfTriangle() {
        getSides();
        if (this.AB == this.BC && this.BC == this.AC && this.AC == this.AB) {

            return TypeOfTriangles.EQUILATERAL;
        }
        if ((this.AB == this.AC && this.AB != this.BC) || (this.AB == this.BC && this.AB != this.AC))
            return TypeOfTriangles.ISOSCELES;
        if (this.AB == Math.sqrt(Math.pow(this.BC, 2) + Math.pow(this.AC, 2))
                 || this.BC == Math.sqrt(Math.pow(this.AB, 2) + Math.pow(this.AC, 2))
                 || this.AC == Math.sqrt(Math.pow(this.AB, 2) + Math.pow(this.BC, 2)))
            return TypeOfTriangles.RECTANGULAR;
        else return TypeOfTriangles.ARBITRARY;
    }

    @Override
    public String toString()
    {
        return "Triangle: A" + A +
                ", B" + B +
                ", C" + C;
    }
}
