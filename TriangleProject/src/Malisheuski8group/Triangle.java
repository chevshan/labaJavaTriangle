package Malisheuski8group;

public class Triangle {

    private Dot A;
    private Dot B;
    private Dot C;

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

    public int typeOfTriangle() {
        getSides();
        if (this.AB == this.BC && this.BC == this.AC && this.AC == this.AB)
            return 1;
        if ((this.AB == this.AC && this.AB != this.BC) || (this.AB == this.BC && this.AB != this.AC))
            return 2;
        if (this.AB == Math.sqrt(Math.pow(this.BC, 2) + Math.pow(this.AC, 2))
                 || this.BC == Math.sqrt(Math.pow(this.AB, 2) + Math.pow(this.AC, 2))
                 || this.AC == Math.sqrt(Math.pow(this.AB, 2) + Math.pow(this.BC, 2)))
            return 3;
        else return 4;
    }

    @Override
    public String toString()
    {
        return "Triangle: A" + A +
                ", B" + B +
                ", C" + C;
    }
}
