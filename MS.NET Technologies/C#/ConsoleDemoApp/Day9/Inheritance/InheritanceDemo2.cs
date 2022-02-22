using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day9.Inheritance
{
    class MyBase2
    {
        public virtual void Display()
        {

            Console.WriteLine("Display from MyBase");
        }
    }
    class MyDerive2 : MyBase2
    {
        //Method overriding
        public override void Display()
        {

            Console.WriteLine("Display from My Derive-2");
        }
    }

    internal class InheritanceDemo2
    {
        static void Main(string[] args)
        {
            MyDerive2 derive2 = new MyDerive2();
            derive2.Display();
            MyBase2 myBase2 = derive2;
            myBase2.Display();
        }
    }
}
