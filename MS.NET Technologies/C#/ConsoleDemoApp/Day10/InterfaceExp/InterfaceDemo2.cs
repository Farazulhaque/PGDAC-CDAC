using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day10.InterfaceExp
{
    interface ICalc3
    {
        int Add(int x, int y);//public and abstract
        int Subtract(int x, int y);
    }

    interface ICalc4
    {
        int Subtract(int x, int y);
    }

    //Multiple inheritance like implementaion
    class Calculator2 : ICalc3, ICalc4
    {
        public int Add(int x, int y)
        {
            return x + y;
        }
        //Explicit Interface method implementation
        int ICalc3.Subtract(int x, int y)
        {
            return x - y;
        }
        int ICalc4.Subtract(int x, int y)
        {
            return x + ~y + 1;
        }
    }
    internal class Interfacedemo2
    {
        static void Main(string[] args)
        {
            Calculator2 calc2 = new Calculator2();
            Console.WriteLine("sum" + calc2.Add(20, 40));
            // Console.WriteLine("difference:"+calc2.Subtract(40,20));//invalid

            ICalc3 icalc3 = calc2;
            Console.WriteLine("Difference:" + icalc3.Subtract(50, 20));
            ICalc4 icalc4 = calc2;
            Console.WriteLine("Difference:" + icalc4.Subtract(50, 20));
        }
    }
}
