using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day9.Inheritance
{
    abstract class Shape
    {
        internal abstract int Area(int l, int b);
        public void Display()
        {
        }

    }

    class Rectangle : Shape
    {
        internal override int Area(int l, int b)
        {
            return l * b;
        }
    }
    class Triangle : Shape
    {
        sealed internal override int Area(int l, int b)
        {
            return (l * b) / 2;
        }
    }
    class MyTriangle : Triangle
    {
        //internal override int Area(int l, int b)
        //{
        //    return (l * b) / 2;
        //}
    }
    //internal class InheritanceDemo4 : Triangle // Invalid
    internal class InheritanceDemo4
    {
        static void Main(string[] args)
        {
            Shape shape = new Rectangle();
            Console.WriteLine(shape.Area(30, 20));
            shape = new Triangle();
            Console.WriteLine(shape.Area(30, 50));
        }
    }
}
