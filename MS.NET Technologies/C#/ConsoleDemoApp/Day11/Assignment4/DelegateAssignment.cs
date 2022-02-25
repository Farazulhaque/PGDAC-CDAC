using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day11.Assignment4
{
    public delegate void AddDelegate(int x, int y, int z);
    public delegate void SubDelecate(int x, int y);
    internal class DelegateAssignment
    {
        static void Add(int x, int y, int z)
        {
            Console.WriteLine($"{x} + {y} + {z} = {x + y + z}");
        }
        static void Sub(int x, int y)
        {
            Console.WriteLine($"{x} - {y} = {x - y}");
        }

        static void Main(string[] args)
        {
            // By using user defined delegates
            AddDelegate addDelegate = DelegateAssignment.Add;
            addDelegate(1, 2, 3);

            SubDelecate subDelecate = DelegateAssignment.Sub;
            subDelecate(10, 5);

            // By using pre-defined delegates
            Action<int, int, int> Add3Numbers = DelegateAssignment.Add;
            Add3Numbers(5, 10, 15);

            Action<int, int> Subtract2Numbers = DelegateAssignment.Sub;
            Subtract2Numbers(50, 10);
        }
    }
}
