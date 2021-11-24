package assignments;

public class ShapeArray {
    public static void main(String[] args) {
        Shape[] shp = new Shape[4];
        double l = 4;
        double b = 6;

        shp[0] = new Rectangle(l, b);
        Rectangle r1 = (Rectangle) shp[0];
        r1.display();
        
        double r = 15;
        shp[1] = new Circle(r);
        Circle c1 = (Circle) shp[1];
        c1.display();
        
        r = 25;
        shp[2] = new Sphere(r);
        Sphere s1 = (Sphere) shp[2];
        s1.display();
        
        l = 10;
        b = 15;
        double h = 12;
        shp[3] = new Cuboid(l, b, h);
        Cuboid cu1 = (Cuboid) shp[3];
        cu1.display();
    }
}