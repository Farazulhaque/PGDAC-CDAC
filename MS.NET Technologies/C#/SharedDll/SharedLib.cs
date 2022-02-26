using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SharedDll
{
    public class SharedLib
    {
        public void Display()
        {
            Console.WriteLine("Display from SharedLib Version - 1");
        }
        public void Show()
        {
            Console.WriteLine("Display from SharedLib Version - 2");
        }
    }
    public class Calculator
    {
        public int Add(int x, int y, int z)
        {
            return x + y + z;
        }
        public int Multiply(int x, int y, int z)
        {
            return x * y * z;
        }
    }
}
