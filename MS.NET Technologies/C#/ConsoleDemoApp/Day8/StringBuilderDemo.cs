using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleDemoApp.Day8
{
    internal class StringBuilderDemo
    {
        static void Main(string[] args)
        {
            StringBuilder sb = new StringBuilder(30);
            Console.WriteLine(sb.Length);
            Console.WriteLine(sb.Capacity);
            Console.WriteLine(sb.MaxCapacity);
            Console.WriteLine(sb);

            sb.AppendFormat("C Sharp is {0}", "object oriented programming language");
            Console.WriteLine(sb.Length);
            Console.WriteLine(sb.Capacity);
            Console.WriteLine(sb.MaxCapacity);
            Console.WriteLine(sb);

            sb.AppendLine();
            sb.AppendLine("It's case sensitive");
            Console.WriteLine(sb.Length);
            Console.WriteLine(sb.Capacity);
            Console.WriteLine(sb.MaxCapacity);
            Console.WriteLine(sb);
            sb.Insert(0, "Java and ", 1);
            Console.WriteLine(sb);
            sb.Insert(sb.Length, "It is also event-driven language.", 2);
            Console.WriteLine(sb);
        }
    }
}
