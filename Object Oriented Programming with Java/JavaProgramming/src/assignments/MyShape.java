package assignments;

abstract class Shape {
}

abstract class Shape2D extends Shape {
    // Abstract methods
    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract void display();
}

abstract class Shape3D extends Shape {
    // Abstract methods
    public abstract double getVolume();

    public abstract double getSurfaceArea();

    public abstract void display();
}

// A Rectangle Class, Which Inherits from the Shape2D Class
class Rectangle extends Shape2D {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    // Provide an implementation for inherited abstract getArea() method
    public double getArea() {
        return length * breadth;
    }

    // Provide an implementation for inherited abstract getPerimeter() method
    public double getPerimeter() {
        return 2.0 * (length + breadth);
    }

    public void display() {
        System.out.println("**************** Rectangle ****************");
        System.out.printf("%-10s: %.2f", "Length", this.length);
        System.out.printf("\n%-10s: %.2f", "Breadth", this.breadth);
        System.out.println("\n-----------------");
        System.out.printf("%-30s: %.2f", "Area of Rectangle", this.getArea());
        System.out.printf("\n%-30s: %.2f", "Perimeter of Rectangle", this.getPerimeter());
        System.out.println("\n===========================================\n");
    }
}

// A Circle Class, Which Inherits from Shape2D Class
class Circle extends Shape2D {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // Provide an implementation for inherited abstract getArea() method
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Provide an implementation for inherited abstract getPerimeter() method
    public double getPerimeter() {
        return 2.0 * Math.PI * radius;
    }

    public void display() {
        System.out.println("***************** Circle ******************");
        System.out.printf("%-10s: %.2f", "Radius", this.radius);
        System.out.println("\n-----------------");
        System.out.printf("%-30s: %.2f", "Area of Circle", this.getArea());
        System.out.printf("\n%-30s: %.2f", "Perimeter of Circle", this.getPerimeter());
        System.out.println("\n===========================================\n");
    }
}

class Sphere extends Shape3D {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double getVolume() {
        return 4 / 3 * Math.PI * radius * radius * radius;
    }

    public double getSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    public void display() {
        System.out.println("***************** Sphere ******************");
        System.out.printf("%-10s: %.2f", "Radius", this.radius);
        System.out.println("\n-----------------");
        System.out.printf("%-30s: %.2f", "Volume of Sphere", this.getVolume());
        System.out.printf("\n%-30s: %.2f", "Surface Area of Sphere", this.getSurfaceArea());
        System.out.println("\n===========================================\n");
    }
}

class Cuboid extends Shape3D {
    private double length;
    private double breadth;
    private double height;

    public Cuboid(double length, double breadth, double height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    public double getVolume() {
        return length * breadth * height;
    }

    public double getSurfaceArea() {
        return 2 * height * (length + breadth);
    }

    public void display() {
        System.out.println("***************** Cuboid ******************");
        System.out.printf("%-10s: %.2f", "Length", this.length);
        System.out.printf("\n%-10s: %.2f", "Breadth", this.breadth);
        System.out.printf("\n%-10s: %.2f", "Height", this.height);
        System.out.println("\n-----------------");
        System.out.printf("%-30s: %.2f", "Volume of Cuboid", this.getVolume());
        System.out.printf("\n%-30s: %.2f", "Surface Area of Cuboid", this.getSurfaceArea());
        System.out.println("\n===========================================\n");
    }
}

public class MyShape {
    public static void main(String[] args) {
        double l = 10;
        double b = 15;
        Rectangle rec = new Rectangle(l, b);
        rec.display();
        double r = 15;
        Circle cir = new Circle(r);
        cir.display();
        r = 25;
        Sphere sph = new Sphere(r);
        sph.display();
        l = 10;
        b = 15;
        double h = 12;
        Cuboid cub = new Cuboid(l, b, h);
        cub.display();
    }
}