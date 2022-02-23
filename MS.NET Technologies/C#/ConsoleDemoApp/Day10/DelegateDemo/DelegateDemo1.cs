using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day10.DelegateDemo
{
    public delegate void MyDelegate(int x, int y);

    class Test1
    {

        public void Add(int a, int b)
        {
            Console.WriteLine($"Sum is:{a + b}");
        }

        public static void Subtract(int a, int b)
        {
            Console.WriteLine($"Difference is:{a - b}");
        }
    }
    class Test2
    {

        public void Multiply(int a, int b)
        {
            Console.WriteLine($"Multiplication is:{a * b}");
        }

        public static void Divide(int a, int b)
        {
            Console.WriteLine($"Division is:{a / b}");
        }
    }

    internal class DelegateDemo1
    {
        static void Main(string[] args)
        {
            // MyDelegate myDelegate = new MyDelegate(Test1.Subtract);//instantiation

            // myDelegate(50, 20);//invocation
            // Test1 t1 = new Test1();
            // MyDelegate myDelegate = new MyDelegate(t1.Add);

            MyDelegate myDelegate = new MyDelegate(new Test1().Add);//instance method
            myDelegate.Invoke(50, 40);
            myDelegate += Test1.Subtract;//static
            myDelegate.Invoke(500, 20);
            myDelegate += Test2.Divide;//static
            myDelegate += new Test2().Multiply;//instance method

            //myDelegate(50, 20);
            myDelegate.Invoke(50, 20);
        }
    }
}
