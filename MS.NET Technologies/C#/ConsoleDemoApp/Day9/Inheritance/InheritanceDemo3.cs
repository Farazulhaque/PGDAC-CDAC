using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day9.Inheritance
{
    class MyBase3
    {

        int id;
        public MyBase3(int id)
        {
            this.id = id;
            Console.WriteLine($"Constr from MyBase,ID:{this.id}");
        }
        //static MyBase3() {
        //    Console.WriteLine("Static Constr from MyBase");
        //}
        //~MyBase3() {
        //    Console.WriteLine("Destructor from MyBase");
        //}
        public void Display()
        {
            Console.WriteLine("Display from MyBase-3");
        }
    }

    class Derive1 : MyBase3
    {
        string name;
        public Derive1(int id, string name) : base(id)
        {
            //super()
            this.name = name;
            Console.WriteLine($"Constr from Derive1,Name:{this.name}");

            this.Display();//calling of current class display method
            base.Display();//calling of base class display method
        }
        //static Derive1()        {
        //    Console.WriteLine("Static Constr from Derive1");
        //}
        //~Derive1()        {
        //    Console.WriteLine("Destructor from Derive1");
        //}
        public void Display()
        {
            Console.WriteLine("Display from Derive-1");
        }
    }

    class Derive2 : Derive1
    {
        float salary;
        public Derive2(int id, string name, float salary) : base(id, name)
        {
            this.salary = salary;
            Console.WriteLine($"Constr from Derive2,Salary:{this.salary}");
            this.Display();
            base.Display();//Derive-1
        }
        //static Derive2()
        //{
        //    Console.WriteLine("Static Constr from Derive2");
        //}
        //~Derive2()
        //{
        //    Console.WriteLine("Destructor from Derive2");
        //}
        public void Display()
        {
            Console.WriteLine("Display from Derive-2");
        }
    }
    internal class InheritanceDemo3
    {
        static void Main(string[] args)
        {

            //Derive1 derive = new Derive1();
            //MyBase3 ob = new MyBase3();
            Derive2 derive2 = new Derive2(1000, "Rahul", 34500.0f);
        }
    }
}
