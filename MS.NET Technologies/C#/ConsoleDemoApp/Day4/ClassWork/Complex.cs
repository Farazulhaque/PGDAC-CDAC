using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day4.ClassWork
{
    internal class Complex
    {
        int a;
        int b;
        public override string ToString()
        {
            if (b < 0)
            {
                return $" {a} - {-b}i";
            }
            else
                return $" {a} + {b}i";
        }
        public Complex(int a = 1, int b = 1)
        {
            this.a = a;
            this.b = b;
        }
        public static Complex operator +(Complex c1, Complex c2)
        {
            Complex c = new Complex();
            c.a = c1.a + c2.a;
            c.b = c1.b + c2.b;
            return c;
        }
        public static Complex operator -(Complex c1, Complex c2)
        {
            Complex c = new Complex();
            c.a = c1.a - c2.a;
            c.b = c1.b - c2.b;
            return c;
        }
    }
    class ComplexMain
    {
        static void Main(string[] args)
        {
            Complex c1 = new Complex(2, -3);
            Complex c2 = new Complex(4, 6);
            Complex c = c1 + c2;
            Console.WriteLine(c1);
            Console.WriteLine(c2);
            Console.WriteLine("----------");
            Console.WriteLine("+");
            Console.WriteLine(c);
        }
    }
}
