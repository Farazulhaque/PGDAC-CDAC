using System;
namespace ConsoleDemoApp.Day4.ClassWork
{
    internal class Point
    {
        int x;
        int y;
        public Point()
        {
            this.x = 20;
            this.y = 30;
        }

        public Point(int x = 50, int y = 40)
        {
            this.x = x;
            this.y = y;
        }
        public override string ToString()
        {
            return $"Point({x}, {y})";
        }

        // during overloading, operator function should be public and static
        // if you are overloading any unary operator, the operator function will accept one input parameter of that class type 
        // if you are overloading any binary operator, the operator will accept two input parameter
        public static Point operator +(Point p1, Point p2)
        {
            Point p = new Point();
            p.x = p1.x + p2.x;
            p.y = p1.y + p2.y;
            return p;
        }
        public static Point operator -(Point p1, Point p2)
        {
            Point p = new Point();
            p.x = p1.x - p2.x;
            p.y = p1.y - p2.y;
            return p;
        }

        public static Point operator *(Point p1, Point p2)
        {
            Point p = new Point();
            p.x = p1.x * p2.x;
            p.y = p1.y * p2.y;
            return p;
        }

        // Destructor 
        // invoked after coming out of the scope where the object is created
        ~Point()
        {
            Console.WriteLine("Point destructor Called");
        }
    }
    class PointMain
    {
        static void Main(string[] args)
        {
            Point p1 = new Point();
            Console.WriteLine(p1);

            Point p2 = new Point(x: 40, y: 30);
            Console.WriteLine(p2);

            /*
            Point p3 = new Point(70);
            Console.WriteLine(p3);

            Point p4 = new Point(y: 60);
            Console.WriteLine(p4);

            Point p5 = new Point(y: 80, x: 20);
            Console.WriteLine(p5);
            */
            Point p6 = p1 + p2;
            Console.WriteLine(p6);
            //GC.Collect(0);
            Console.WriteLine(p1 - p2);

            Console.WriteLine(p1 * p2);



        }
    }
}
