using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day8
{
    class Employee
    {
        long[] MobileNo;
        public Employee(int size = 5)
        {
            MobileNo = new long[size];
        }

        //To define indexer
        //Indexer to read/write MobileNo Array Value
        //In general there should be only 1 indexer
        //we can achieve this by overloading indexer
        public long this[int i]
        {
            get { return MobileNo[i]; }
            set { MobileNo[i] = value; }
        }

        //public long this[int row, int col]
        //{
        //    get { return MobileNo[i]; }
        //    set { MobileNo[i] = value; }
        //}

        // Readonly property to return MobileNo array length
        public int ArrayLength
        {
            get => MobileNo.Length;
        }
        public void DisplayMobileNos()
        {
            Console.WriteLine("Mobile Numbers are: ");
            foreach (var item in MobileNo)
            {
                Console.WriteLine(item);
            }
        }
    }
    internal class IndexersDemo
    {
        static void Main(string[] args)
        {
            Employee emp = new Employee();
            emp[0] = 9876543210;        // Indexer set accessor will be called
            Console.WriteLine(emp[0]);  // Indexer get accessor will be called
            emp[4] = 01234567890;
            emp.DisplayMobileNos();

            Console.WriteLine("Reading all data using indexer: ");
            for (int i = 0; i < emp.ArrayLength; i++)
            {
                Console.WriteLine(emp[i]);
            }
        }
    }
}
