using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.LinqExp
{
    internal class ArrayListDemo2
    {
        static void Main(string[] args)
        {
            ArrayList list = new ArrayList() { 10, 15, 20, 30, 45, 60, 75, 90 };

            Console.WriteLine("List data using normal for loop");
            for (int i = 0; i < list.Count; i++)
            {
                Console.WriteLine(list[i]);
            }

            Console.WriteLine("List data using foreach loop");
            foreach (int i in list)
            {
                Console.WriteLine(i);
            }

            Console.WriteLine("List data using Iterator");
            IEnumerator iterator = list.GetEnumerator();
            while (iterator.MoveNext())
            {
                Console.WriteLine(iterator.Current);
            }

            int thirddata = (int)list[2]; //boxing
            Console.WriteLine(thirddata);
        }
    }
}
