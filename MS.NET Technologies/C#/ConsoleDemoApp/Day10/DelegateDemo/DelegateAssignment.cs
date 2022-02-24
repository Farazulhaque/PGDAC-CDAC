using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day10.DelegateDemo
{
    public delegate int MyDelegate1(int x, int y);
    class Test3
    {
        static int sum = 0;
        public int Add(int a, int b)
        {
            //Console.WriteLine($"Sum is:{a + b}");
            return a + b;
        }
        public static int Subtract(int a, int b)
        {
            //Console.WriteLine($"Difference is:{a - b}");
            return a - b;
        }
    }
    class Test4
    {
        public int Multiply(int a, int b)
        {
            //Console.WriteLine($"Multiplication is:{a * b}");
            return a * b;
        }
        public static int Divide(int a, int b)
        {
            //Console.WriteLine($"Division is:{a / b}");
            return (a / b);
        }
    }

    internal class DelegateAssignment
    {
        static void Main(string[] args)
        {
            // MyDelegate myDelegate = new MyDelegate(Test1.Subtract);//instantiation

            // myDelegate(50, 20);//invocation
            // Test1 t1 = new Test1();
            // MyDelegate myDelegate = new MyDelegate(t1.Add);

            MyDelegate1 myDelegate1 = new MyDelegate1(new Test3().Add);//instance method
            int res = myDelegate1.Invoke(50, 40);

            Console.WriteLine(res);

            myDelegate1 += Test3.Subtract;//static
            Console.WriteLine(myDelegate1);
            Console.WriteLine(myDelegate1.Invoke(500, 20));

            myDelegate1 += Test4.Divide;//static
            myDelegate1 += new Test4().Multiply;//instance method

            //myDelegate(50, 20);
            Console.WriteLine(myDelegate1.Invoke(50, 20));

            myDelegate1 -= new Test4().Multiply;
            Console.WriteLine(myDelegate1.Invoke(50, 20));

        }
    }
}
