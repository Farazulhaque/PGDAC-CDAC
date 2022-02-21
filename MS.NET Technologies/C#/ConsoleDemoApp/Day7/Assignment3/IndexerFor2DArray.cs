using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day7.Assignment3
{
    class Employee
    {
        string[,] FullName;
        public Employee(int size = 5)
        {
            FullName = new string[size, 2];
        }
        public string this[int r, int c]
        {
            get { return FullName[r, c]; }
            set { FullName[r, c] = value; }
        }
        public int ArrayLength
        {
            get => FullName.GetLength(0);
        }
        public void DisplayEmployees()
        {
            Console.WriteLine("Employee names are: ");
            foreach (var item in FullName)
            {
                Console.WriteLine(item[0] + "\t" + item[1]);
            }
        }
    }
    internal class IndexerFor2DArray
    {
        static void Main(string[] args)
        {
            Employee emp = new Employee();
            emp[0, 0] = "Faraz";
            emp[0, 1] = "Haque";
            emp[1, 0] = "Arisha";
            emp[1, 1] = "Aftab";
            emp[2, 0] = "Syeda";
            emp[2, 1] = "Kashaf";
            Console.WriteLine("Reading all data using indexer: ");
            Console.WriteLine(emp.ArrayLength);

            for (int i = 0; i < emp.ArrayLength; i++)
            {
                Console.WriteLine(emp[i, 0] + "\t" + emp[i, 1]);
            }


        }
    }
}
