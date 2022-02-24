using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day10.DelegateDemo
{
    //delegate defn
    //public delegate void MyDelegate(int x, int y);
    public delegate int MyDelegate(int x, int y);

    class Test1
    {

        //public void Add(int a, int b)
        public int Add(int a, int b)
        {
            // Console.WriteLine($"Sum is:{a+b}");
            return a + b;
        }

        //public static void Subtract(int a, int b)
        public static int Subtract(int a, int b)
        {
            //Console.WriteLine($"Difference is:{a - b}");
            return a - b;
        }
    }
    class Test2
    {

        //public void Multiply(int a, int b)
        public int Multiply(int a, int b)
        {
            // Console.WriteLine($"Multiplication is:{a * b}");
            return a * b;
        }

        // public static void  Divide(int a, int b)
        public static int Divide(int a, int b)
        {
            // Console.WriteLine($"Division is:{a / b}");
            return a / b;

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

            //MyDelegate myDelegate = new MyDelegate(new Test1().Add);//instance method
            //int res;
            //// res= myDelegate.Invoke(50, 40);
            //// Console.WriteLine("result:"+res);//90
            //myDelegate += Test1.Subtract;//static
            ////res=myDelegate.Invoke(500, 20);
            ////Console.WriteLine("result:" + res);//480
            //myDelegate += Test2.Divide;//static
            //Test2 t2 = new Test2();
            //// myDelegate += new Test2().Multiply;//instance method
            //myDelegate += t2.Multiply;
            ////myDelegate(50, 20);
            //res=myDelegate.Invoke(50, 20);//
            //Console.WriteLine("result:" + res);//1000

            //myDelegate-= t2.Multiply;
            //res = myDelegate.Invoke(50, 20);//
            //Console.WriteLine("result:" + res);//1000
        }
    }
}