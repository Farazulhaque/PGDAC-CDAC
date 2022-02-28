using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.MultiThreading
{
    internal class PrallelForEachDemo
    {
        static void Main(string[] args)
        {
            List<int> list = Enumerable.Range(10, 20).ToList();
            Console.WriteLine("Using Foreach: ");
            foreach (var item in list)
            {
                Console.WriteLine(item);
            }
            Console.WriteLine("Using parallel foreach");
            Parallel.ForEach(list, item =>
            {
                Console.WriteLine(item);
            });

            //Interlocked class
            //async
            //await

        }
    }
}
